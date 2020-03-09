package com.example.myapplication;

import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.util.Log;
import android.os.Handler;
//import java.util.logging.Handler;
//import java.util.logging.LogRecord;


public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private final String TAG = "MessageTest";
    private int ButtonCount;
    private Thread myThread;
    private MyThread myThread2;
    private Handler mHandler;
    private int mMessageCount = 0;

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
        private Looper mLooper;
        @Override
        public void run() {
            super.run();
            Looper.prepare();
            synchronized (this) {
                mLooper = Looper.myLooper();
                notifyAll();
            }
            Looper.loop();
        }

        public Looper getLooper(){
            if (!isAlive()) {
                return null;
            }

            // If the thread has been started, wait until the looper has been created.
            synchronized (this) {
                while (isAlive() && mLooper == null) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
            return mLooper;
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
                Message msg = new Message();
                mHandler.sendMessage(msg);
            }
        });
        myThread = new Thread(new MyRunnable(),"MessageTestThread");
        myThread.start();

        myThread2 = new MyThread();
        myThread2.start();

        mHandler = new Handler(myThread2.getLooper(),new Handler.Callback(){
            @Override
            public boolean handleMessage(Message msg) {
                Log.d(TAG,"get Message "+ mMessageCount);
                mMessageCount++;
                return false;
            }
        });
    }
}
