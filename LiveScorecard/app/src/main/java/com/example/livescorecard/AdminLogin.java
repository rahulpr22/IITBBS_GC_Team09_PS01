package com.example.livescorecard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
        EditText uid,pwd;
        TextView b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        uid= findViewById(R.id.uid);
        pwd= findViewById(R.id.pwd);
        b= findViewById(R.id.signIn);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(uid.getText().toString().equals("admin123@gmail.com") && pwd.getText().toString().equals("12345"))
                {
                    Intent i = new Intent(AdminLogin.this,AdminDashboard.class);
                    startActivity(i);
                    finish();
                }
                else {
                    Toast.makeText(AdminLogin.this,"Invalid Credentials !!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}