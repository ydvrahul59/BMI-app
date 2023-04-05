package com.rahuldroid.firstbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtweight, edtheightFt, edtheightIn;
        Button  btncalculate;
        TextView txtResult;
        LinearLayout llMain;

        edtweight = findViewById(R.id.edtweight);
        edtheightFt = findViewById(R.id.edtheightft);
        edtheightIn = findViewById(R.id.edtheightinch);
        btncalculate = findViewById(R.id.btncalculate);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);


        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int wt = Integer.parseInt(edtweight.getText().toString());
                int ft = Integer.parseInt(edtheightFt.getText().toString());
                int in = Integer.parseInt(edtheightIn.getText().toString());

                int totalIn = ft*12 + in;

                double totalCm = totalIn*2.53;

                double totalM = totalCm/100;

                double bmi = wt/(totalM*totalM);

                if(bmi>25){
                    txtResult.setText("dude tujhe zym jana pdega ,you are overweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorOw));
                } else if (bmi<18) {
                    txtResult.setText("Dude, tumhe khna pdega acchse se you are underweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorUw));

                }else {
                    txtResult.setText("chill dude, you are healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }


            }
        });


    }
}