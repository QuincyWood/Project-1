package com.example.qwooda2_project1;

import android.content.Intent;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class Activity_2 extends AppCompatActivity {

    // public static final String EXTRA_TEXT =".Activity_2";
    protected TextView text_view;
    protected EditText edit_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        edit_txt = findViewById(R.id.Input);// My editText
        text_view = findViewById(R.id.put_Name);// My viewText

        edit_txt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    String userName = edit_txt.getText().toString().trim();// variable take in what the user types

                    Intent intent = new Intent();

                    intent.putExtra("key", userName); //
                    // sequence of alphabetical characters and separated
                    //by one or more space characters
                    if (userName.matches("[a-zA-Z ]+")) {
                        setResult(RESULT_OK, intent);
                        Toast.makeText(Activity_2.this, "Send " + userName, Toast.LENGTH_LONG).show();
                        finish();
                    }
                    else {

                        setResult(RESULT_CANCELED, intent);
                        Toast.makeText(Activity_2.this, "Incorrect name " + userName, Toast.LENGTH_LONG).show();
                        finish();
                    }

                }


                return false;
            }
        });
    }
}