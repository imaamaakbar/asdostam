package com.example.trianglearea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtBase, edtHeight;
    private Button btnCalculate;
    private TextView tvResult;
    private static final String STATE_HASIL = "state_hasil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtBase = (EditText) findViewById(R.id.edt_base);
        edtHeight = (EditText) findViewById(R.id.edt_height);
        btnCalculate = (Button) findViewById(R.id.btn_calculate);
        tvResult = (TextView) findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(this);

        if (savedInstanceState != null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tvResult.setText(hasil);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calculate) {
            String base = edtBase.getText().toString().trim();
            String height = edtHeight.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(base)){
                isEmptyFields =true;
                edtBase.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(height)){
                isEmptyFields =true;
                edtHeight.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields){
                double b = Double.parseDouble(base);
                double h = Double.parseDouble(height);
                double area = 0.5 * b * h;
                tvResult.setText(String.valueOf(area));
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putString(STATE_HASIL, tvResult.getText().toString());
        super.onSaveInstanceState(outState);
    }
}