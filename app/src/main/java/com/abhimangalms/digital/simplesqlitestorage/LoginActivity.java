package com.abhimangalms.digital.simplesqlitestorage;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText uNameEditText,passwordEditText;
    Button button1,button2;
    DatabaseHelper mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mydb = new DatabaseHelper(this);
        uNameEditText = (TextInputEditText)findViewById(R.id.uName);
        passwordEditText = (TextInputEditText)findViewById(R.id.passWord);
        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String s11 = uNameEditText.getText().toString();
               String s22 = passwordEditText.getText().toString();
                Cursor res = mydb.getAllData(s11,s22);

                while (res.moveToNext()) {

                    if (res.getCount()>0) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {

                        Toast.makeText(LoginActivity.this, "username password incorrect", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });
    }
}
