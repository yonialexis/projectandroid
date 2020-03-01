

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    List list;
    Context context;
    User user;


    public UserAdapter(List list,Context context)
    {
        this.list=list;
        this.context=context;
    }
    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=  LayoutInflater.from(context).inflate(R.layout.user,parent,false);


        return new UserViewHolder(view);
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
            user=(User) list.get(position);
           holder.phone.setText(user.getPhone());
           holder.email.setText(user.getEmail());
           holder.username.setText(user.getUsername());
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }
     class  UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView phone;
         TextView username;
         TextView email;
         AlertDialog.Builder	myAlertBuilder	=	new AlertDialog.Builder(context);

        public UserViewHolder(@NonNull View itemView)  {
            super(itemView);
            phone=itemView.findViewById(R.id.phone);
            username=itemView.findViewById(R.id.username);
            email=itemView.findViewById(R.id.email);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);

           // myAlertBuilder.show();


            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    list.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    return  true;
                }
            });
     }

         @Override
         public void onClick(View v) {
              
     }}
