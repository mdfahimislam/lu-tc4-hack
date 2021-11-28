package com.sib.fascommerce.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.firebase.database.FirebaseDatabase;
import com.sib.fascommerce.Admin.AdminHomePage;
import com.sib.fascommerce.Common.SessionManager;
import com.sib.fascommerce.Customer.User_Section1;
import com.sib.fascommerce.R;
import com.sib.fascommerce.Seller.SellerHome;

import java.util.HashMap;

public class Registration extends AppCompatActivity {

   // int SELECT_PICTURE = 200;

     EditText fname,lname,email;
     Button sub;
    String UID,phone,wh,token;
    int image = 0;
    HashMap<String, String> hm1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        try {
            fname = (EditText) findViewById(R.id.fname);
            lname = (EditText) findViewById(R.id.lname);
            email = (EditText) findViewById(R.id.email);
            sub = (Button) findViewById(R.id.sub);

        /*   SessionManager sh = new SessionManager(Registration.this, SessionManager.USERSESSION);
            HashMap<String, String> hm1 = sh.returnData();
            UID = hm1.get(SessionManager.UID);
            phone = hm1.get(SessionManager.PHONE);
            wh = hm1.get(SessionManager.WHAT);
            token = hm1.get(SessionManager.TOKEN);*/


            sub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                 /*   String em = "No";
                    if (!email.getText().toString().isEmpty())
                        em = email.getText().toString();
                    HashMap hm = new HashMap();
                    hm.put("FName", fname.getText().toString());
                    hm.put("LName", lname.getText().toString());
                    hm.put("Email", em);
                    if (wh.contains("to")) {
                        startActivity(new Intent(Registration.this, User_Section1.class));

                    } else if (wh.contains("ll")) {
                        startActivity(new Intent(Registration.this, SellerHome.class));
                    } else {
                        startActivity(new Intent(Registration.this, AdminHomePage.class));
                    }
                //    FirebaseDatabase.getInstance().getReference("Users").child(wh+"s").child(UID).updateChildren(hm);
                    /*SessionManager sh3 = new SessionManager(getApplicationContext(), SessionManager.USERSESSION);
                    sh3.loginSession(fname.getText().toString(), em, phone, "NotGiven", "0", token, UID, wh, "0");*/

                }
            });
        }
        catch (Exception e)
        {
            Log.d("TAG",e.getMessage());
        }
    }
}