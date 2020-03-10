package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import com.example.hardlibary.*;
public class MainActivity extends AppCompatActivity {

    boolean ledon = false;
    private Button button = null;
    private CheckBox checkBoxled1 = null;
    private CheckBox checkBoxled2 = null;
    private CheckBox checkBoxled3 = null;
    private CheckBox checkBoxled4 = null;


    class MyButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            ledon =!ledon;
            if(ledon) {
                button.setText("ALL OFF");
                checkBoxled1.setChecked(true);
                checkBoxled2.setChecked(true);
                checkBoxled3.setChecked(true);
                checkBoxled4.setChecked(true);
                for(int i= 0;i<2;i++)
                    HardControl.ledCtrl(i,1);
            }
            else {
                button.setText("ALL ON");
                checkBoxled1.setChecked(false);
                checkBoxled2.setChecked(false);
                checkBoxled3.setChecked(false);
                checkBoxled4.setChecked(false);
                for(int i= 0;i<2;i++)
                    HardControl.ledCtrl(i,0);
            }
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.LED1:
                if (checked) {
                    Toast.makeText(getApplicationContext(), "LED1 on", Toast.LENGTH_SHORT).show();// 显示时间较短
                    HardControl.ledCtrl(0, 1);
                }
                else{
                    Toast.makeText(getApplicationContext(), "LED1 off", Toast.LENGTH_SHORT).show();// 显示时间较短
                    HardControl.ledCtrl(0, 0);
                }
                break;
            case R.id.LED2:
                if (checked) {
                    Toast.makeText(getApplicationContext(), "LED2 on", Toast.LENGTH_SHORT).show();// 显示时间较短
                    HardControl.ledCtrl(1, 1);
                }
                else{
                    Toast.makeText(getApplicationContext(), "LED2 off", Toast.LENGTH_SHORT).show();// 显示时间较短
                    HardControl.ledCtrl(1, 0);
                }
                break;
            case R.id.LED3:
                if (checked) {
                    Toast.makeText(getApplicationContext(), "LED3 on", Toast.LENGTH_SHORT).show();// 显示时间较短
                    HardControl.ledCtrl(2, 1);
                }
                else{
                    Toast.makeText(getApplicationContext(), "LED3 off", Toast.LENGTH_SHORT).show();// 显示时间较短
                    HardControl.ledCtrl(2, 0);
                }
                break;
            case R.id.LED4:
                if (checked) {
                    Toast.makeText(getApplicationContext(), "LED4 on", Toast.LENGTH_SHORT).show();// 显示时间较短
                    HardControl.ledCtrl(3, 1);
                }
                else{
                    Toast.makeText(getApplicationContext(), "LED4 off", Toast.LENGTH_SHORT).show();// 显示时间较短
                    HardControl.ledCtrl(3, 0);
                }
                break;
            // TODO: Veggie sandwich
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.BUTTON);

        HardControl.ledOpen();  //在入口函数中调用本地方法打开led，为什么可以直接调用呢个，Ctrl+B 跳转到类定义 因为ledopen是static修饰，静态方法不需要实例化对象
        checkBoxled1 = (CheckBox) findViewById(R.id.LED1);
        checkBoxled2 = (CheckBox) findViewById(R.id.LED2);
        checkBoxled3 = (CheckBox) findViewById(R.id.LED3);
        checkBoxled4 = (CheckBox) findViewById(R.id.LED4);

        button.setOnClickListener(new MyButtonListener());
/*

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ledon =!ledon;
                if(ledon)
                    button.setText("ALL OFF");
                else
                    button.setText("ALL ON");
            }
        });*/
    }
}
