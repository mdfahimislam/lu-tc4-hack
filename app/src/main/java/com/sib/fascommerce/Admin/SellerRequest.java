package com.sib.fascommerce.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.sib.fascommerce.R;

public class SellerRequest extends AppCompatActivity {

    ListView l;
    String tutorials[]
            = {
            "Fahim",
            "Abid",
            "Sabit",
            "Tawsif",
            "Siam",
            "Sajid",
            "Anindo",
            "Suyayeb",
            "Navid"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_request);

        l = findViewById(R.id.seller_request_list);
        ArrayAdapter<String> arr;
        arr
                = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                tutorials);
        l.setAdapter(arr);


        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(), arr.getItem(position), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), CustomerVerify.class);
                intent.putExtra("CUSTOMER_NAME", arr.getItem(position).toString());
                intent.putExtra("SELLER", true);
                startActivity(intent);

            }

        });
    }
}