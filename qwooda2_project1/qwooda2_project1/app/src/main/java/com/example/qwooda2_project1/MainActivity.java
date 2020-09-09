package com.example.qwooda2_project1;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    protected  Button button;
    protected  Button button2;

    static final int PICK_CONTACT_REQUEST = 1; // The request code.

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    //Create a new Activity that sends the user when the user click the button
                    Intent intent = new Intent(MainActivity.this, Activity_2.class);
                    //
                    startActivityForResult(intent,+PICK_CONTACT_REQUEST);
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Check which request we're responding to
      //  if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.
                button2 = findViewById(R.id.button2);

                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent grab_data = new Intent(ContactsContract.Intents.Insert.ACTION);
                       grab_data.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                       String user_Name = data.getStringExtra("key");
                       // grab_data.putExtra("keyN", user_Name);
                        Log.i("Name", user_Name);
                        grab_data.putExtra(ContactsContract.Intents.Insert.NAME, user_Name);
                        startActivity(grab_data);



                    }
                });
            }
            else if(resultCode == RESULT_CANCELED){
                // recieve  the words the user types
                String wrong_Input = data.getStringExtra("key");
//                     When user input data that's not in the requirement This text should come with the first
                        // Activity being visible

                Toast.makeText(MainActivity.this, "Incorrect name " + wrong_Input, Toast.LENGTH_LONG).show();
           }
        //}
    }

}
