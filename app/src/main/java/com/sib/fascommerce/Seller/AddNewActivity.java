package com.sib.fascommerce.Seller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.sib.fascommerce.DataModels.ProductModel;
import com.sib.fascommerce.R;
import com.sib.fascommerce.databinding.ActivityAddNewBinding;
import com.zfdang.multiple_images_selector.ImagesSelectorActivity;
import com.zfdang.multiple_images_selector.SelectorSettings;

import java.util.ArrayList;
import java.util.Calendar;

public class AddNewActivity extends AppCompatActivity {
private ActivityAddNewBinding binding;
private static final int REQUEST_CODE = 123;
private Calendar c;
private DatePickerDialog datePicker;
private int y,m,d;
private ArrayList<String> mResults = new ArrayList<>();
private ProductModel productModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddNewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.materialToolbarAN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Fresco.initialize(getApplicationContext());


    }

    public void takePhotos(View view) {


// start multiple photos selector
        Intent intent = new Intent(AddNewActivity.this, ImagesSelectorActivity.class);
// max number of images to be selected
        intent.putExtra(SelectorSettings.SELECTOR_MAX_IMAGE_NUMBER, 5);
// min size of image which will be shown; to filter tiny images (mainly icons)
        intent.putExtra(SelectorSettings.SELECTOR_MIN_IMAGE_SIZE, 100000);
// show camera or not
        intent.putExtra(SelectorSettings.SELECTOR_SHOW_CAMERA, true);
// pass current selected images as the initial value
        intent.putStringArrayListExtra(SelectorSettings.SELECTOR_INITIAL_SELECTED_LIST, mResults);
// start the selector
        startActivityForResult(intent, REQUEST_CODE);




    }

    public void setDate(View view) {
        c= Calendar.getInstance();
        y=c.get(Calendar.YEAR);
        m=c.get(Calendar.MONTH);
        d=c.get(Calendar.DAY_OF_MONTH);
        datePicker=new DatePickerDialog(this, (view1, year, month, dayOfMonth) -> {
            binding.dateAN.setText(dayOfMonth+"-"+month+"-"+year);
        },y,m,d);
        datePicker.show();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // get selected images from selector
        if(requestCode == REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                mResults = data.getStringArrayListExtra(SelectorSettings.SELECTOR_RESULTS);
                assert mResults != null;

                // show results in textview
                StringBuffer sb = new StringBuffer();
                sb.append(String.format("Totally %d images selected:", mResults.size())).append("\n");
                for(String result : mResults) {
                    sb.append(result).append("\n");
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void addNew(View view) {
        String title = binding.titleAN.getText().toString().trim();
        String category = binding.categoryAN.getText().toString().trim();
        String description = binding.descriptionAN.getText().toString().trim();
        int price = Integer.parseInt(binding.priceAN.getText().toString().trim());
        String winOption = binding.optionAN.getText().toString();
        String date = binding.dateAN.getText().toString().trim();

        if(title.isEmpty()||category.isEmpty()||description.isEmpty()||winOption.isEmpty()||date.isEmpty()||mResults.size()==0||price==1)
        {
            Toast.makeText(this, "Any field cannot be empty", Toast.LENGTH_SHORT).show();
        }
        else
        {

        }
    }
}