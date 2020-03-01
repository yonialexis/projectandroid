
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
     Button register;
     Intent intent;
     EditText fname;
     TextView back;
    EditText username;
    EditText email;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register=findViewById(R.id.submit_reg);
        fname=findViewById(R.id.fn_reg);
        username=findViewById(R.id.pass_reg);
        email=findViewById(R.id.email_reg);
        password=findViewById(R.id.pass_reg);
        uid=findViewById(R.id.uid);
        back=findViewById(R.id.back_reg);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    public void Add_User(View view)
    {
        db_adapter=new DB_Adapter(getBaseContext());
        String id=uid.getText().toString();
        String fn=fname.getText().toString();
        String usr=username.getText().toString();
        String em=email.getText().toString();
        String psw=password.getText().toString();
        String m=male.getText().toString();
        String f=female.getText().toString();
        User user=new User(id,fn,usr,m,em,psw);
        if (id.isEmpty() && fn.isEmpty()&& usr.isEmpty()&& m.isEmpty()&& em.isEmpty()&& psw.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"some field is empty",Toast.LENGTH_SHORT).show();
        }
        else
        {
            long result=db_adapter.Insert(user);
            if (result<=0)
            {
               
            }
            else {
                //Toast.makeText(getApplicationContext(),""+user.getEmail(),Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"Insertion successfull",Toast.LENGTH_SHORT).show();
                intent=new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
            }
        }
    }
}
