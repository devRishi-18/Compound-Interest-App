package com.example.compoundinterest;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
EditText amt, years, months, days, rate;
TextView compound, Amount;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        amt= findViewById(R.id.amt);
        years= findViewById(R.id.years);
        months= findViewById(R.id.months);
        rate= findViewById(R.id.rate);
        days= findViewById(R.id.days);
        button= findViewById(R.id.button);
        compound=findViewById(R.id.compound);
        Amount=findViewById(R.id.Amount);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double m = Double.parseDouble(months.getText().toString());
                double am = Double.parseDouble(amt.getText().toString());
                double r = Double.parseDouble(rate.getText().toString());
                double d = Double.parseDouble(days.getText().toString());
                double y = Double.parseDouble(years.getText().toString());
                double tot_time = y+(m*0.083)+(d*0.00274);
                double cmp=1+(r/100);
                double cmp2 = Math.pow(cmp,tot_time);
                double cmp3 = (am*cmp2)-am;
                compound.setText(Double.toString(cmp3));
                double tot_amt= am*cmp2;
                Amount.setText(Double.toString(tot_amt));

            }
        });
    }
}