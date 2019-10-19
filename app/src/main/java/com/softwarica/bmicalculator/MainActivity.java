package com.softwarica.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button btnCalculate;
    TextView tvOutput;
    EditText etM, etKg;
    float result;
    float n1,n2;
    String bmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etKg=(EditText)findViewById(R.id.etKg);
        etM=(EditText)findViewById(R.id.etM);
        tvOutput=(TextView)findViewById(R.id.tvOutput);
        btnCalculate=(Button)findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Validation
                if(etKg.getText().toString().matches("") )
                {
                    etKg.setError("Enter weight");
                    return;
                }
                if(etM.getText().toString().matches("") )
                {
                    etM.setError("Enter Height");
                    return;
                }

                emiCalculation();
            }

            public void emiCalculation(){
                n1=Integer.parseInt(etKg.getText().toString());
                n2=Float.parseFloat(etM.getText().toString());
                result=n1/(n2*n2);
                if(result>=25 && result<29.9)
                    bmi="overweight";
                else if(result>=18.5 && result<24.9)
                    bmi="healthy / Normal Weight";
                else if(result>18.5)
                    bmi="Under Weight";
                else
                    bmi="Enter proper weight and height";

                tvOutput.setText("BMI=" + new DecimalFormat("##.##").format(result)+"\n"+bmi);
            }

        });


 }
}

