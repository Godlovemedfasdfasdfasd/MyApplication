package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

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
            }
            else {
                button.setText("ALL ON");
                checkBoxled1.setChecked(false);
                checkBoxled2.setChecked(false);
                checkBoxled3.setChecked(false);
                checkBoxled4.setChecked(false);
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
                }
                else{
                    Toast.makeText(getApplicationContext(), "LED1 off", Toast.LENGTH_SHORT).show();// 显示时间较短
                }
                break;
            case R.id.LED2:
                if (checked) {
                    Toast.makeText(getApplicationContext(), "LED2 on", Toast.LENGTH_SHORT).show();// 显示时间较短
                }
                else{
                    Toast.makeText(getApplicationContext(), "LED2 off", Toast.LENGTH_SHORT).show();// 显示时间较短
                }
                break;
            case R.id.LED3:
                if (checked) {
                    Toast.makeText(getApplicationContext(), "LED3 on", Toast.LENGTH_SHORT).show();// 显示时间较短
                }
                else{
                    Toast.makeText(getApplicationContext(), "LED3 off", Toast.LENGTH_SHORT).show();// 显示时间较短
                }
                break;
            case R.id.LED4:
                if (checked) {
                    Toast.makeText(getApplicationContext(), "LED4 on", Toast.LENGTH_SHORT).show();// 显示时间较短
                }
                else{
                    Toast.makeText(getApplicationContext(), "LED4 off", Toast.LENGTH_SHORT).show();// 显示时间较短
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
