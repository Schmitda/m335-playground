package ch.example.playground;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    private Button submitRegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.submitRegisterButton = findViewById(R.id.submitRegisterButton);
        this.submitRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Was bewirkt dieses Konstrukt?");
            }
        });
    }


    public void onBackClicked(View View) {
        Intent intent = new Intent();
        startActivity(intent);
    }


}
