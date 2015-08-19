package com.star.beeradviser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends AppCompatActivity {

    private Spinner mColorSpinner;
    private Button mFindBeerButton;
    private TextView mBrandsTextView;

    private BeerExpert mBeerExpert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);

        mColorSpinner = (Spinner) findViewById(R.id.color);

        mFindBeerButton = (Button) findViewById(R.id.find_beer);
        mFindBeerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String beerType = mColorSpinner.getSelectedItem().toString();

                List<String> brandsList = mBeerExpert.getBrands(beerType);

                StringBuilder brandsFormatted = new StringBuilder();

                for (String brand: brandsList) {
                    brandsFormatted.append(brand).append("\n");
                }

                mBrandsTextView.setText(brandsFormatted);
            }
        });

        mBrandsTextView = (TextView) findViewById(R.id.brands);
    }


}
