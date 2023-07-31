package jp.s22018.bmicalculators018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import jp.s22018.bmicalculators018.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("BMICalculatorS030", "Main onCreate(),called.");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btCalc);
        button.setOnClickListener(new ButtonClickListener());
        Button button2 = findViewById(R.id.btClear);
        button2.setOnClickListener(new ButtonClickListener());
    }

    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            EditText input1 = findViewById(R.id.etAge);
            EditText input2 = findViewById(R.id.etHeight);
            EditText input3 = findViewById(R.id.etWeight);
            TextView output = findViewById(R.id.tvOutput);

            int id = view.getId();

            if (id == R.id.btCalc) {

                int a = Integer.valueOf(input1.getText().toString()).intValue();

                if (a < 16) {
                    AgeDialog dialogFrament = new AgeDialog();
                    dialogFrament.show(getSupportFragmentManager(),"AgeDialogFragment");
                }

                float h = Float.parseFloat(input2.getText().toString());
                float w = Float.parseFloat(input3.getText().toString());
                h /= 100.0;

                float BMI = w / (h * h);
                String result;

                if (BMI < 18.5) {
                    result = "低体重";
                } else if (BMI < 25.0) {
                    result = "普通体重";
                } else if (BMI < 30.0) {
                    result = "肥満(１度)";
                } else if (BMI < 35.0) {
                    result = "肥満(２度)";
                } else if (BMI < 40.0) {
                    result = "肥満(３度)";
                } else {
                    result = "肥満(４度)";
                }

                float sui = h * h * 22;

                output.setText("あなたのBMI判定結果は\n   " + result + "です。\nあなたの適正体重は\n   " + sui + "kgです。\n");
            }
            else if (id == R.id.btClear) {
                input1.setText("");
                input2.setText("");
                input3.setText("");
                output.setText("");
            }

        }

    }
}