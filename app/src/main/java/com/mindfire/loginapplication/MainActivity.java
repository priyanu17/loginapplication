package com.mindfire.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declare parameters to access user data from app
    private EditText inputUsername ;
    private EditText inputPassword ;
    private Button submitButton ;

    private String correctUsername = "anupriya";
    private String correctPassword = "mindfire";

    private boolean isInputValid = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // fetch view using id
        inputUsername = findViewById(R.id.usernameText);
        inputPassword = findViewById(R.id.passwordText);
        submitButton =  findViewById(R.id.submitButton);

        //adding onClick Listener on submitButton
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //fetch data from view
                String username = inputUsername.getText().toString();
                String password = inputPassword.getText().toString();

                //toast in case no data is entered
                if(username.isEmpty() ){
                    Toast.makeText(MainActivity.this, "Username cannot be empty! ", Toast.LENGTH_SHORT).show();
                }else if (password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Password cannot be empty! ", Toast.LENGTH_SHORT).show();
                }else{
                    //no filed is empty
                    isInputValid = validateInput(username, password);

                    //input is invalid
                    if(!isInputValid){
                        Toast.makeText(MainActivity.this, "Invalid Credentials entered!!!", Toast.LENGTH_SHORT).show();
                    }
                    //input is valid
                    else{
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                        //go to new activity
                        Intent activityIntent = new Intent(MainActivity.this, LoginPage.class);
                        startActivity(activityIntent);
                    }

                }
            }
        });//end of onclick listener

    }//end of onCreate method

    private boolean validateInput(String username, String password){
        if(username.equals(correctUsername) && password.equals(correctPassword)) return true;
        return false;
    }

}