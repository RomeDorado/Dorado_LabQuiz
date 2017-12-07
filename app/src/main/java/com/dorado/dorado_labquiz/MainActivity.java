package com.dorado.dorado_labquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText etAuthor;
    EditText etQuote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAuthor = (EditText) findViewById(R.id.et_Author);
        etQuote = (EditText) findViewById(R.id.et_Quote);
    }

    public void saveQuote(View view){
        File folder = getCacheDir();
        String Author = etAuthor.getText().toString();
        String Quotation = etQuote.getText().toString();
        File file = new File(folder, "data1.txt");
        String message = Author + " said, \n \n" + "\"" + Quotation + "\"";
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Successfully saved!", Toast.LENGTH_LONG).show();

    }

    public void nextPage(View view){

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }


}
