package ch.example.playground;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ch.example.playground.database.UserHandler;
import ch.example.playground.model.UserModel;

public class RegisterActivity extends AppCompatActivity {

    private Button submitRegisterButton;
    private EditText lastName;
    private EditText firstName;
    private EditText userName;
    private EditText eMail;
    private EditText password;
    private EditText repeatPassword;
    private EditText comment;
    private UserHandler userHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.submitRegisterButton = findViewById(R.id.submit);
        this.firstName = findViewById(R.id.firstName);
        this.lastName = findViewById(R.id.lastName);
        this.userName = findViewById(R.id.userName);
        this.eMail = findViewById(R.id.eMail);
        this.password = findViewById(R.id.password);
        this.repeatPassword = findViewById(R.id.repeatPassword);
        this.comment = findViewById(R.id.comment);
        this.submitRegisterButton = findViewById(R.id.submit);
        userHandler = new UserHandler(this);
    }

    public void onClick(View v) {
        System.out.println("Was bewirkt dieses Konstrukt?");
        UserModel userModel = new UserModel(
                this.firstName.getText().toString(),
                this.lastName.getText().toString(),
                this.userName.getText().toString(),
                this.password.getText().toString(),
                this.comment.getText().toString(),
                this.eMail.getText().toString()
        );
        this.userHandler.save(userModel);
    }


    public void onBackClicked(View View) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
