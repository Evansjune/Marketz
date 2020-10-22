package com.example.marketz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "RegisterActivity";
    //views
    ImageView appIcon;
    EditText emailEntry, passwordEntry, passwordConfirmation;
    Button button_register;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        appIcon = findViewById(R.id.appIcon);
        emailEntry = findViewById(R.id.emailEntry);
        passwordEntry = findViewById(R.id.passwordEntry);
        passwordConfirmation = findViewById(R.id.passwordConfirmation);
        button_register = findViewById(R.id.button_register);
        progressBar = findViewById(R.id.register_progressBar);
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: attempting to register.");
                //check for null valued EditText fields
                if (!isEmpty(emailEntry.getText().toString())
                        && !isEmpty(passwordEntry.getText().toString())
                        && !isEmpty(passwordConfirmation.getText().toString())) {

                    //check if passwords match
                    if (doStringsMatch(passwordEntry.getText().toString(),
                            passwordConfirmation.getText().toString())) {

                        //Initiate registration task
                        createAccount(emailEntry.getText().toString(),
                                passwordEntry.getText().toString());
                    } else {
                        Toast.makeText(RegisterActivity.this,
                                "Passwords do not Match", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(RegisterActivity.this,
                            "You must fill out all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
        hideSoftKeyboard();

    }

    private void createAccount(final String email, final String password) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        if (task.isSuccessful()) {
                            Log.d(TAG, "onComplete: AuthState: " + FirebaseAuth.getInstance()
                                    .getCurrentUser().getUid());

                            //send email verification
                            sendVerificationEmail();

                            FirebaseAuth.getInstance().signOut();

                            //redirect the user to the login screen
                            redirectLoginScreen();
                        }
                        if (!task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Unable to Register",
                                    Toast.LENGTH_SHORT).show();
                        }
                        hideDialog();
                    }
                });

    }


    private void sendVerificationEmail() {
        showDialog();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            user.sendEmailVerification()
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(RegisterActivity.this,
                                        "Sent Verification Email", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(RegisterActivity.this,
                                        "Couldn't Verification Send Email",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    private void redirectLoginScreen() {
        Log.d(TAG, "redirectLoginScreen: redirecting to login screen.");

        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private boolean isEmpty(String string) {
        return string.equals("");
    }


    private void showDialog() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideDialog() {
        if (progressBar.getVisibility() == View.VISIBLE) {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    private void hideSoftKeyboard() {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    private boolean doStringsMatch(String s1, String s2) {
        return s1.equals(s2);
    }
}