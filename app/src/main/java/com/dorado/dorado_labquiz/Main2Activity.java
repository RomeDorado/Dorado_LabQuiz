package com.dorado.dorado_labquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    TextView tvQuote;
    FileInputStream fis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvQuote = (TextView) findViewById(R.id.tv_Quote);

        StringBuffer buffer = new StringBuffer();
        int read = 0;

        try{
            fis = new FileInputStream(new File(getCacheDir(), "data1.txt"));
            while((read = fis.read()) != -1){
                buffer.append((char)read);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tvQuote.setText(buffer.toString());

    }

    public void prevPage(View view){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}
