package com.sib.fascommerce.Authentication;

import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.sib.fascommerce.R;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    Spinner spinner;
    EditText phone;
    Button loginBtn;
    int check = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        spinner = (Spinner) findViewById(R.id.login_activity_user_type);
        phone = findViewById(R.id.login_activity_phone_number);
        loginBtn = findViewById(R.id.login_activity_loginBtn);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.user_registration, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);




        List<String> user_type = new ArrayList<>();
        user_type.add("Customer");
        user_type.add("Seller");
        user_type.add("Admin");


        // Initialize an array adapter
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, user_type);
        mAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        // Data bind the spinner with array adapter items
        spinner.setAdapter(mAdapter);


        // Set an item selection listener for spinner widget
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Get the spinner selected item text
//                String selectedItemText = (String) adapterView.getItemAtPosition(i);
//                // Display the selected item into the TextView
//                phone.setText("Selected : " + selectedItemText + i);
                check = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(phone.getText().toString())) {
                    // when mobile number text field is empty
                    // displaying a toast message.
                    Toast.makeText(Login.this, "Please enter a valid phone number.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), VerificationOTP.class);
                    intent.putExtra("ACCOUNT_TYPE", check);
                    intent.putExtra("PHONE_NUMBER", phone.getText().toString());
                    startActivity(intent);
                }
            }
        });






    }



}