package com.sib.fascommerce.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.sib.fascommerce.R;

public class CustomerVerify extends AppCompatActivity {

    private AlertDialog.Builder builder;
    private TextView customerName;
    private TextView customerEmail;
    private Button verifyConfram;
    private boolean check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_verify);


        // Layout activity
        customerName = findViewById(R.id.customer_verification_name);
        customerEmail = findViewById(R.id.customer_verification_email);
        verifyConfram = findViewById(R.id.customer_verificationBtn);

        String Name = getIntent().getExtras().getString("CUSTOMER_NAME");
        check = getIntent().getExtras().getBoolean("SELLER");

        customerName.setText(Name);

        verifyConfram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout(Name);
            }
        });


    }


    private void logout(String name) {
        builder = new AlertDialog.Builder(this);

        builder = new AlertDialog.Builder(this);

        String type;
        if(check){
            type = "Seller";
        }
        else{
            type = "Customer";
        }

        builder.setMessage("Are you sure to add " + name + " as a " + type + " ??")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getApplicationContext(), "added", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();

                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("ADD " + name + "??");
        alert.show();
    }
}