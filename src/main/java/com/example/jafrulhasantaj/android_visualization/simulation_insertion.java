package com.example.jafrulhasantaj.android_visualization;

import android.content.UriPermission;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.net.URI;
import java.sql.Time;

import static java.lang.Thread.sleep;


public class simulation_insertion extends AppCompatActivity implements View.OnClickListener {

    TextView[] tvBox = new TextView[6];
    TextView[] tvViu = new TextView[6];
    TextView[] tvLine = new TextView[10];
    Button btPause;
    Button btReset;
    int[] oldarray = {7, 4, 1, 9, 5, 2};
    boolean pause = false;
    boolean finished = false;
    boolean reset = false;
    Object lock;
    int size = 6;
    // TextView tv = new TextView(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation_insertion);
        tvBox[0] = (TextView) findViewById(R.id.index1);
        tvBox[1] = (TextView) findViewById(R.id.index2);
        tvBox[2] = (TextView) findViewById(R.id.index3);
        tvBox[3] = (TextView) findViewById(R.id.index4);
        tvBox[4] = (TextView) findViewById(R.id.index5);
        tvBox[5] = (TextView) findViewById(R.id.index6);
        tvViu[0] = (TextView) findViewById(R.id.viu1);
        tvViu[1] = (TextView) findViewById(R.id.viu2);
        tvViu[2] = (TextView) findViewById(R.id.viu3);
        tvViu[3] = (TextView) findViewById(R.id.viu4);
        tvViu[4] = (TextView) findViewById(R.id.viu5);
        tvViu[5] = (TextView) findViewById(R.id.viu6);
        tvLine[0] = (TextView) findViewById(R.id.line1);
        tvLine[1] = (TextView) findViewById(R.id.line2);
        tvLine[2] = (TextView) findViewById(R.id.line3);
        tvLine[3] = (TextView) findViewById(R.id.line4);
        tvLine[4] = (TextView) findViewById(R.id.line5);
        tvLine[5] = (TextView) findViewById(R.id.line6);
        tvLine[6] = (TextView) findViewById(R.id.line7);
        tvLine[7] = (TextView) findViewById(R.id.line8);
        tvLine[8] = (TextView) findViewById(R.id.line9);
        tvLine[9] = (TextView) findViewById(R.id.line10);
        btPause = (Button) findViewById(R.id.btPause);
        btReset = (Button) findViewById(R.id.btReset);
        btPause.setText("PAUSE");
        btPause.setOnClickListener(this);
        btReset.setOnClickListener(this);
        t = new BubbleSortThread();
        t.start();

    }
    BubbleSortThread t;

    class BubbleSortThread extends Thread{

        BubbleSortThread(){
            lock = new Object();
            pause = false;
            finished = false;
        }

        @Override
        public void run() {
            while (!finished){
                finalPause();
                reset = false;if (reset == true) continue;
                int lastIndex = size - 1;
                int[] array = new int[size];
                for (int i = 0; i < size; i++){
                    array[i] = oldarray[i];
                    textboxTextUpdate(i, array[i]);
                    textboxColorUpdate(i, R.color.colorPrimary);
                    textViuSizeUpdate(i, array[i]);
                }if (reset == true) continue;
                textlineColorUpdate(0, R.color.colorAccent); finalPause();if (reset == true) continue;
                waitsec(1);if (reset == true) continue;
                textlineColorUpdate(0, R.color.colorW); //finalPause();
                if (reset == true) continue;
                for (int i = 1; i < size; i++){
                    if (reset == true) break;
                    textlineColorUpdate(1, R.color.colorAccent); finalPause();if (reset == true) break;
                    waitsec(1);if (reset == true) break;

                    int key = array[i];if (reset == true) break;

                    textlineColorUpdate(1, R.color.colorW); //finalPause();
                    if (reset == true) continue;
                    textlineColorUpdate(2, R.color.colorAccent); finalPause();if (reset == true) break;
                    waitsec(1);if (reset == true) break;

                    int j = i - 1;if (reset == true) break;

                    textlineColorUpdate(2, R.color.colorW);if (reset == true) break;
                    textlineColorUpdate(3, R.color.colorAccent); finalPause();if (reset == true) break;
                    waitsec(1);if (reset == true) break;
                    textlineColorUpdate(3, R.color.colorW);if (reset == true) break;

                    while (j >= 0 && array[j] > key){

                        textlineColorUpdate(4, R.color.colorAccent); finalPause();if (reset == true) break;
                        waitsec(1);if (reset == true) break;
                        textlineColorUpdate(4, R.color.colorW); //finalPause();
                        if (reset == true) continue;
                        array[j + 1] = array[j];if (reset == true) break;
                        if (reset == true) break;
                        textlineColorUpdate(5, R.color.colorAccent); finalPause();if (reset == true) break;
                        textboxColorUpdate(j + 1, R.color.colorAccent); finalPause();if (reset == true) break;
                        textboxColorUpdate(j, R.color.colorAccent);finalPause();if (reset == true) break;
                        waitsec(1);if (reset == true) break;

                        textboxTextUpdate(j + 1, array[j]);if (reset == true) break;
                        textViuSizeUpdate(j + 1, array[j]);if (reset == true) break;
                        waitsec(1);if (reset == true) break;
                        textboxColorUpdate(j + 1, R.color.colorPrimary);if (reset == true) break;
                        waitsec(1);if (reset == true) break;
                        textlineColorUpdate(5, R.color.colorW);if (reset == true) break;

                        j--;if (reset == true) break;

                        textlineColorUpdate(6, R.color.colorAccent); finalPause();if (reset == true) break;
                        waitsec(1);if (reset == true) break;
                        textlineColorUpdate(6, R.color.colorW);if (reset == true) break;
                    }if (reset == true) break;
                    textlineColorUpdate(7, R.color.colorAccent); finalPause();if (reset == true) break;
                    waitsec(1);if (reset == true) break;
                    textlineColorUpdate(7, R.color.colorW);if (reset == true) break;

                    array[j + 1] = key;if (reset == true) break;

                    textlineColorUpdate(8, R.color.colorAccent);finalPause();if (reset == true) break;
                    waitsec(1);if (reset == true) break;
                    textboxTextUpdate(j + 1, key);if (reset == true) break;
                    textViuSizeUpdate(j + 1, key);if (reset == true) break;
                    waitsec(1);if (reset == true) break;
                    textboxColorUpdate(j + 1, R.color.colorPrimary);if (reset == true) break;
                    waitsec(1);if (reset == true) break;
                    textlineColorUpdate(8, R.color.colorW);if (reset == true) break;
                    waitsec(1);if (reset == true) break;
                }if (reset == true) continue;
                textlineColorUpdate(9, R.color.colorAccent);finalPause();if (reset == true) continue;
                waitsec(1);if (reset == true) continue;
                textlineColorUpdate(9, R.color.colorW);//finalPause();
                finished = true;if (reset == true) continue;
            }
        }

        void finalPause(){
            synchronized  (lock){
                while (pause){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        void pauseThread(){
            synchronized (lock){
                pause = true;
            }
        }
        void resumeThread(){
            synchronized (lock){
                pause = false;
                lock.notifyAll();
            }
        }

    }
    void swap(int[] array, int i1, int i2){
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }
    void textboxTextUpdate(final int index, final int num){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvBox[index].setText(""+num);
            }
        });
    }
    void textboxColorUpdate(final int index, final int color){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvBox[index].setBackgroundColor(getResources().getColor(color));
            }
        });
    }
    void textlineColorUpdate(final int index, final int color){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvLine[index].setBackgroundColor(getResources().getColor(color));
            }
        });
    }
    void textViuSizeUpdate(final int index, final int size){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvViu[index].requestLayout();
                LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(42, size * 20);
                p.setMargins(10, 2, 2, 2);
                tvViu[index].setLayoutParams(p);
            }
        });
    }
    void waitsec(int t){
        try {
            sleep(t * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void buttonTextUpdate(final int i){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (i == 0)
                    btPause.setText("RESUME");
                else
                    btPause.setText("PAUSE");
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btPause:
                pause = true;
                String str = btPause.getText().toString();
                if (str == "PAUSE"){
                    buttonTextUpdate(0);
                    t.pauseThread();
                    pause = true;

                }
                if (str == "RESUME"){
                    buttonTextUpdate(1);
                    t.resumeThread();
                }
                break;
            case R.id.btReset :
                reset = true;
            default:
                break;
        }
    }

}
