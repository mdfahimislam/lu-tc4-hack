package com.sib.fascommerce.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.sib.fascommerce.R;

public class Registration extends AppCompatActivity {

    int SELECT_PICTURE = 200;

    private ImageView nidFrontPage;
    private ImageView nidBackPage;

    int image = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);



        Spinner spinner = (Spinner) findViewById(R.id.login_activity_user_type);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.user_registration, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        // Layout
        nidFrontPage = findViewById(R.id.activity_registration_nid_front_page);
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
    }

}