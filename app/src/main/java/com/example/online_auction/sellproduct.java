package com.example.online_auction;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jaiselrahman.filepicker.activity.FilePickerActivity;
import com.jaiselrahman.filepicker.config.Configurations;
import com.jaiselrahman.filepicker.model.MediaFile;

import java.util.ArrayList;

public class sellproduct extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

        String[] country = { "Select Auction","H Auction", "M Auction", "J Auction", "D Auction"};
    String[] category = {"Select Category","Antiques", "Art", "Books", "Coins And paper money", "Car", "Toys", "Sports", "Watch"};
    Button upload;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellproduct);

            upload = (Button) findViewById(R.id.Uploadimg);
            Spinner spin = (Spinner) findViewById(R.id.auctionselect);
            spin.setOnItemSelectedListener(this);

            //Creating the ArrayAdapter instance having the country list
            ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Setting the ArrayAdapter data on the Spinner
            spin.setAdapter(aa);



            Spinner spin2 = (Spinner) findViewById(R.id.categoryselect);
            spin2.setOnItemSelectedListener(this);

            //Creating the ArrayAdapter instance having the country list
            ArrayAdapter ab = new ArrayAdapter(this,android.R.layout.simple_spinner_item,category);
            ab.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Setting the ArrayAdapter data on the Spinner
            spin2.setAdapter(ab);


            upload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ContextCompat.checkSelfPermission(sellproduct.this,
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {

                        ActivityCompat.requestPermissions(sellproduct.this, new String[]{Manifest.permission.CAMERA}, 1);

                    } else {

                        imagepicker();
                    }
                }
            });

            BottomNavigationView bnv = (BottomNavigationView) findViewById(R.id.bootonnav);
            bnv.setSelectedItemId(R.id.smenu_sellproduct);
            bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @SuppressLint("NonConstantResourceId")
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {

                        case R.id.smenu_home:
                            startActivity(new Intent(getApplicationContext(), sellerhome.class));
                            overridePendingTransition(0, 0);
                            return true;

                        case R.id.smenu_sellproduct:
                            return true;

                        case R.id.smenu_bidrequests:
                            startActivity(new Intent(getApplicationContext(), bidrequests.class));
                            overridePendingTransition(0, 0);
                            return true;

                        case R.id.smenu_profile:
                            startActivity(new Intent(getApplicationContext(), sellerprofile.class));
                            overridePendingTransition(0, 0);
                            return true;


                    }

                    return false;
                }
            });
        }

    private void imagepicker() {
        Intent intent = new Intent(sellproduct.this, FilePickerActivity.class);

        intent.putExtra(FilePickerActivity.CONFIGS, new Configurations.Builder()
                .setCheckPermission(true)
                .setShowImages(true)
                .enableImageCapture(true)
                .setMaxSelection(10)
                .setSkipZeroSizeFiles(true)
                .build());
        startActivityForResult(intent, 101);


    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)){
            if (requestCode == 1){
                imagepicker();
            }
            else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_OK && data != null){

            ArrayList<MediaFile> files = data.getParcelableArrayListExtra(FilePickerActivity.MEDIA_FILES);
            //Do something with files
            String path = files.get(0).getBucketId();
            switch (requestCode){

                case 101:
                    Toast.makeText(this, "Image Uploaded Sucessfully", Toast.LENGTH_SHORT).show();

            }
        }

    }
    
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    //Performing action onItemSelected and onNothing selected
    }
