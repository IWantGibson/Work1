package com.example.homework;

import static java.lang.String.format;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edit1;
    EditText edit2;
    TextView jieguo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1=findViewById(R.id.editText1);
        edit2=findViewById(R.id.editText2);
        jieguo=findViewById(R.id.jieguo);
        jieguo.setText("此处显示结果");
        Button BTN=(Button) findViewById(R.id.button);
        BTN.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        try {
            String shengao = edit1.getText().toString();
            double sg = Double.parseDouble(shengao);
            String tizhong = edit2.getText().toString();
            double tz = Double.parseDouble(tizhong);
            double bim3 = tz / (sg * sg);
            double bim = Double.parseDouble(format("%.2f", bim3));
            if (bim <= 18.5) {
                jieguo.setText("您的bim值为" + bim + "，属于偏瘦身材，多吃点！要猛！");
            }
            if ((bim < 25) && (bim > 18.5)) {
                jieguo.setText("您的bim值为" + bim + "，属于标准身材！继续保持");
            }
            if (bim >= 25) {
                jieguo.setText("您的bim值为" + bim + "，属于偏胖身材，少吃点！要猛！");
            }
        }
        catch(NumberFormatException exception){
            jieguo.setText("输入类型错误");
        }
    }
}