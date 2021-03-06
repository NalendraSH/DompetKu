package com.nanz.dompetku.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.nanz.dompetku.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class TampilKTM extends AppCompatActivity {
    private String tampil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_ktm);

        Toolbar toolbar = (Toolbar)findViewById(R.id.ktmForm_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Data KTM Anda");

        TextView textView = (TextView)findViewById(R.id.tampil_KTM);
        try {
            FileInputStream fileInputStream = openFileInput("formKTM");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            while ((tampil = bufferedReader.readLine()) != null){
                stringBuffer.append(tampil + "\n");
            }
            textView.setText(stringBuffer.toString());
            //message = bufferedReader.readLine();
            //Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }catch (FileNotFoundException e){
            Toast.makeText(getApplicationContext(), "Anda Belum Memasukkan Data KTM", Toast.LENGTH_LONG).show();
        }catch (IOException e){
            Toast.makeText(getApplicationContext(), "IO Error!", Toast.LENGTH_LONG).show();
        }
    }
}
