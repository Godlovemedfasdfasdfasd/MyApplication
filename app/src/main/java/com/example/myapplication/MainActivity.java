package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private final String TAG = "MessageTest";
    private int ButtonCount;
    private Thread myThread;
    private MyThread myThread2;
    class MyRunnable implements Runnable{
        public void run (){
            int conunt = 0 ;
            for(;;){
                Log.d(TAG,"MyThread "+ conunt);
                conunt++;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            int conunt = 0;
            for(;;){
                Log.d(TAG,"MyThread2 "+ conunt);
                conunt++;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Log.d(TAG,"Send Message "+ ButtonCount);
                ButtonCount++;
            }
        });
        myThread = new Thread(new MyRunnable(),"MessageTestThread");
        myThread.start();

        myThread2 = new MyThread();
        myThread2.start();
    }
}
