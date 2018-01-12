package com.example.siva.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  private EditText uname;
  private Button login;
  private EditText pass;
  private TextView status;
  private int count=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname=(EditText)findViewById(R.id.uname);
        pass=(EditText)findViewById(R.id.pass);
        login=(Button)findViewById(R.id.login);
        status=(TextView)findViewById(R.id.status);

        status.setText("No of Attempts"+ String.valueOf(count));
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(uname.getText().toString(),pass.getText().toString());
            }
        });
    }
    private void validate(String userName,String userPassword)
    {
        if((userName.equals("mahi")) && (userPassword.equals("1234")))
        {
            Intent intt=new Intent(MainActivity.this,sec.class);
            startActivity(intt);
        }
        else
        {
            count--;
            status.setText("No of attemts remainig:" + String.valueOf(count));
            if(count==0)
            {
                login.setEnabled(false);
            }
        }
    }
}
