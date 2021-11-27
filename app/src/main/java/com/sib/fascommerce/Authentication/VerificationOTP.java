package com.sib.fascommerce.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.sib.fascommerce.R;

import java.util.concurrent.TimeUnit;

public class VerificationOTP extends AppCompatActivity {

    private int accountType;
    private String phoneNumber;
    private TextView smsNumber;

    private String mVerificationId;

    //The edittext to input the code
    private EditText editTextCode;


    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_otp);

        editTextCode = findViewById(R.id.verification_activity_get_opt);
        smsNumber = findViewById(R.id.verification_activity_sms);


        mAuth = FirebaseAuth.getInstance();

        accountType = getIntent().getExtras().getInt("ACCOUNT_TYPE");
        phoneNumber = getIntent().getExtras().getString("PHONE_NUMBER");


        smsNumber.setText("You will get an OPT via SMS \n ++ " + phoneNumber);


    }



}