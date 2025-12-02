package com.example.teofirstappduytruong;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private EditText etNumber1, etNumber2, etResult;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnModulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        etResult = findViewById(R.id.etResult);

        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnModulo = findViewById(R.id.btnModulo);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });

        btnModulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('%');
            }
        });
    }

    private void calculate(char operator) {
        String str1 = etNumber1.getText().toString();
        String str2 = etNumber2.getText().toString();
        if (str1.isEmpty() || str2.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ 2 số!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double num1 = Double.parseDouble(str1);
            double num2 = Double.parseDouble(str2);
            double result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        Toast.makeText(this, "Không thể chia cho 0!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = num1 / num2;
                    break;
                case '%':
                    if (num2 == 0) {
                        Toast.makeText(this, "Không thể chia cho 0!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = num1 % num2;
                    break;
            }
            etResult.setText(String.valueOf(result));

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }
}