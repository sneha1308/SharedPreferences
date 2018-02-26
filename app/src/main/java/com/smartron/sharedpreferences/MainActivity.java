package com.smartron.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText username_et, email_et;
    TextView username_tv, email_tv;
    Button save_btn, retrieve_btn;
    String username, email;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // To Save the details
        username_et = findViewById(R.id.username_et);
        email_et = findViewById(R.id.email_et);
        save_btn = findViewById(R.id.save_btn);
        save_btn.setOnClickListener(this);
        username_tv = findViewById(R.id.username_tv);
        email_tv = findViewById(R.id.email_tv);
        retrieve_btn = findViewById(R.id.retrieve_btn);
        retrieve_btn.setOnClickListener(this);

        sharedPreferences = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_btn:
                username = username_et.getText().toString();
                email = email_et.getText().toString();
                editor.putString("name", username);
                editor.putString("emailID", email);
                editor.commit();
                username_et.setText("");
                email_et.setText("");
                break;
            case R.id.retrieve_btn:
               String username_ret = sharedPreferences.getString("name","");
               String email_ret = sharedPreferences.getString("emailID","");
                username_tv.setText(username_ret);
                email_tv.setText(email_ret);
              break;
        }

    }
}
