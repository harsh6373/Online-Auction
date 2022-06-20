package com.example.online_auction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class
MainActivity extends AppCompatActivity {


    public Button button;
    public TextView textView, fpass;
    public EditText email1, password1 ;
    FirebaseAuth mAuth;
    FirebaseUser user;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fpass = (TextView) findViewById(R.id.forgotpassword);
        button = (Button) findViewById(R.id.btnlogin);
        textView = (TextView) findViewById(R.id.txt);
        email1 = (EditText) findViewById(R.id.etemail);
        password1 = (EditText) findViewById(R.id.mypass);
        mAuth = FirebaseAuth.getInstance();


        fpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText resetMail = new EditText(view.getContext());
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(view.getContext());
                passwordResetDialog.setTitle("Reset Password ?");
                passwordResetDialog.setMessage("Enter Your Email To Received Reset Link. ");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // extract the mail and reset link
                        String mail = resetMail.getText().toString();
                        mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(MainActivity.this, "Reset Link Sent To Your Email.", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Eroor ! Link is Not Sent" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // close the dialog
                    }
                });

                passwordResetDialog.create().show();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
            @Override
            public void onClick(View v) {
                String email = email1.getText().toString().trim();
                String password = password1.getText().toString().trim();

            if (email.isEmpty()) {
                    email1.setError("Email is empty");
                    email1.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    email1.setError("Enter the valid email");
                    email1.requestFocus();
                    return;
                }
                if (password.isEmpty()) {
                    password1.setError("Password is empty");
                    password1.requestFocus();
                    return;
                }
                if (password.length() < 6) {
                    password1.setError("Length of password is more than 6");
                    password1.requestFocus();
                    return;
                }

                 user = mAuth.getCurrentUser();
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                    if(user.isEmailVerified()) {
                        if (task.isSuccessful()) {

                            Toast.makeText(MainActivity.this, "You are Login Sucessfully to Online Auction", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(getApplicationContext(), User_Info.class));
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    "Please Check Your login Credentials",
                                    Toast.LENGTH_SHORT).show();
                        }


                    }else{
                        Toast.makeText(MainActivity.this, "Email Is not Verifyed ! ", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });



        textView.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SignUp_new.class);
            startActivity(intent);

        });
    }
}