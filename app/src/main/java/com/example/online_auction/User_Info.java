package com.example.online_auction;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class User_Info extends AppCompatActivity {

    EditText name,email,address,phoneno;
    Button submit;
    CheckBox terms;
    TextView termss ;
    FirebaseDatabase db;
    DatabaseReference root ;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference ;
    FirebaseUser firebaseUser;
    User user;
    RadioGroup radioGroup;
    RadioButton seller,buyer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__info);

        name = findViewById(R.id.nameuser);
        email = findViewById(R.id.emailuser);
        address = findViewById(R.id.addressuser);
        phoneno = findViewById(R.id.phoneuser);
        submit = findViewById(R.id.submituser);
        terms = (CheckBox) findViewById(R.id.checkBox1);
        termss = (TextView) findViewById(R.id.tc);
        radioGroup = findViewById(R.id.radiogroupinfo);
        seller = findViewById(R.id.seller);
        buyer = findViewById(R.id.buyer);


        user = new User();




        submit.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
            @Override
            public void onClick(View view) {

                validate();

                if(seller.isChecked()){
                    db = FirebaseDatabase.getInstance();
                    root = db.getReference().child("Sellers");
                    firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

                    String u_name = name.getText().toString();
                    String u_email = email.getText().toString();
                    String u_address = address.getText().toString();
                    String u_phoneno = phoneno.getText().toString();




                    addDatatoFirebase(u_name,u_email,u_address,u_phoneno);

                    Intent i = new Intent(getApplicationContext(),Home.class);
                    startActivity(i);

                }
                if (buyer.isChecked()){
                    firebaseDatabase = FirebaseDatabase.getInstance();
                    databaseReference = firebaseDatabase.getReference().child("Buyers");
                    firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

                    String u_name = name.getText().toString();
                    String u_email = email.getText().toString();
                    String u_address = address.getText().toString();
                    String u_phoneno = phoneno.getText().toString();




                    addDatatoFirebasebuyer(u_name,u_email,u_address,u_phoneno);

                    Intent i = new Intent(getApplicationContext(),Home.class);
                    startActivity(i);

                }

            }

            private void addDatatoFirebasebuyer(String u_name, String u_email, String u_address, String u_phoneno) {
                user.setName(u_name);
                user.setEmail(u_email);
                user.setAddress(u_address);
                user.setPhoneno(u_phoneno);

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.child(firebaseUser.getUid()).setValue(user);
                        Toast.makeText(User_Info.this, "Data Inserted Sucessfully", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                        Toast.makeText(User_Info.this, "Error..", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            private void addDatatoFirebase(String u_name, String u_email, String u_address, String u_phoneno) {


                user.setName(u_name);
                user.setEmail(u_email);
                user.setAddress(u_address);
                user.setPhoneno(u_phoneno);

                root.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        root.child(firebaseUser.getUid()).setValue(user);
                        Toast.makeText(User_Info.this, "Data Inserted Sucessfully", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                        Toast.makeText(User_Info.this, "Error..", Toast.LENGTH_SHORT).show();
                    }
                });

            }


        });

        termss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), terms_and_condition.class);
                startActivity(i);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    private void validate() {
        String u_name = name.getText().toString();
        String u_email = email.getText().toString();
        String u_address = address.getText().toString();
        String u_phoneno = phoneno.getText().toString();
        if(u_name.isEmpty())
        {
            name.setError("Name is empty");
            name.requestFocus();
            return;
        }
        if(u_email.isEmpty())
        {
            email.setError("Email is empty");
            email.requestFocus();
            return;
        }
        if(u_address.isEmpty())
        {
            address.setError("Address is empty");
            address.requestFocus();
            return;
        }
        if(u_phoneno.isEmpty())
        {
            phoneno.setError("Phone No. is empty");
            phoneno.requestFocus();
            return;
        }
    }
}