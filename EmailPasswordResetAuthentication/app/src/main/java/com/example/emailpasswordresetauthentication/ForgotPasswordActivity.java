package com.example.emailpasswordresetauthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText et_forgot_email;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        et_forgot_email = findViewById(R.id.forgot_emailid);
        mAuth = FirebaseAuth.getInstance();
    }

    public void resetPassword(View view) {
        String emailid = et_forgot_email.getText().toString();
        mAuth.sendPasswordResetEmail(emailid).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(ForgotPasswordActivity.this, "The password reset link has been sent to your email", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(ForgotPasswordActivity.this, "Please enter registered emailid", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}