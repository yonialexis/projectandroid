

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity  {
        Button login;
        TextView signup;
        EditText email;
        EditText password;

     SharedPreferenceConf sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=findViewById(R.id.login_login);
        signup=findViewById(R.id.register_login);
        email=findViewById(R.id.email_login);
        password=findViewById(R.id.password_login);
        sharedPreference= new SharedPreferenceConf(getApplicationContext());
        if(sharedPreference.readLogInStatus()) {
            String[] userdata = {"user Name", "password"};
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("log", userdata);
            startActivity(intent);
        }
        final AlertDialog.Builder	myAlertBuilder	=	new AlertDialog.Builder(LoginActivity.this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e=email.getText().toString();
                String p=password.getText().toString();
                if(e.isEmpty() && p.isEmpty())
                {
                    myAlertBuilder.setTitle("Alert");
                    myAlertBuilder.setMessage("please enter email and password");
                    myAlertBuilder.show();
                }
                else
                {
                    if(e.equals("m") && p.equals("0")) {
                        myAlertBuilder.setTitle("Alert");
                        myAlertBuilder.setMessage("Logged successfully");
                        myAlertBuilder.show();
                        String[] userdata = {e, p};
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("log", userdata);
                        startActivity(intent);
                        sharedPreference.writeLogInStatus(true);
                    }
                    else {
                        myAlertBuilder.setTitle("Alert");
                        myAlertBuilder.setMessage("wrong email and password try again"+p+e);
                        myAlertBuilder.show();
                    }
            }}
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });


    }
}      /**  if(email.getText().toString().isEmpty() && password.getText().toString().isEmpty())
        {
        Toast.makeText(getApplicationContext(),"Fill the field",Toast.LENGTH_SHORT).show();
        }
        else {
        if(email.getText().toString()=="mili" && password.getText().toString()=="0000")
        {
**/