package com.abhimangalms.digital.simplesqlitestorage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText nameE1,emailE2,uNameE3,pwdE3;
    Button submit;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nameE1=(EditText)findViewById(R.id.editText2);
        emailE2=(EditText)findViewById(R.id.editText3);
        uNameE3=(EditText)findViewById(R.id.editText4);
        pwdE3=(EditText)findViewById(R.id.editText5);
        submit=(Button)findViewById(R.id.button3);

        mydb = new DatabaseHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = mydb.insertData(nameE1.getText().toString(),
                        emailE2.getText().toString(),
                        uNameE3.getText().toString(), pwdE3.getText().toString());
                if (isInserted == true) {
                    Toast.makeText(RegisterActivity.this, "Registered succesfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "can't register", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(RegisterActivity.this, RegisterActivity.class);
                    startActivity(i);
                }
            }



        });
    }
}
