package com.sib.fascommerce.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.firebase.database.FirebaseDatabase;
import com.sib.fascommerce.Common.SessionManager;
import com.sib.fascommerce.R;

import java.util.HashMap;

public class Registration extends AppCompatActivity {

    int SELECT_PICTURE = 200;

     EditText fname,lname,email;
     Button sub;
    String UID,phone,wh,token;
    int image = 0;
    HashMap<String, String> hm1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        fname=(EditText) findViewById(R.id.fname);
        fname=(EditText) findViewById(R.id.lname);
        email=(EditText) findViewById(R.id.email);
        sub=(Button) findViewById(R.id.sub);

        SessionManager sh = new SessionManager(Registration.this, SessionManager.USERSESSION);
        hm1 = sh.returnData();
         UID = hm1.get(SessionManager.UID);
         phone = hm1.get(SessionManager.PHONE);
         wh = hm1.get(SessionManager.WHAT);
         token = hm1.get(SessionManager.TOKEN);
     /*   nidFrontPage = findViewById(R.id.activity_registration_nid_front_page);
        nidBackPage = findViewById(R.id.activity_registration_nid_back_page);


        nidBackPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image = 1;
               imageChooser();
            }
        });

        nidFrontPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image = 2;
                imageChooser();
            }
        });

    }


    void imageChooser() {


        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    if(image == 1){
                        nidBackPage.setImageURI(selectedImageUri);
                    }
                    else if(image == 2){
                        nidFrontPage.setImageURI(selectedImageUri);
                        nidFrontPage.setMaxHeight(100);
                        nidBackPage.setMaxHeight(100);
                    }

                }
            }
        }
    }*/

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em="No";
                if(!email.getText().toString().isEmpty())
                    em=email.getText().toString();
                HashMap hm=new HashMap();
                hm.put("FName",fname.getText().toString());
                hm.put("LName",lname.getText().toString());
                hm.put("Email",em);

                FirebaseDatabase.getInstance().getReference("Users").child("Sellers").child(UID).updateChildren(hm);
                SessionManager sh3 = new SessionManager(getApplicationContext(), SessionManager.USERSESSION);
                sh3.loginSession(fname.getText().toString(),em,phone,"NotGiven","0",token,UID, wh,"0");

            }
        });
    }
}