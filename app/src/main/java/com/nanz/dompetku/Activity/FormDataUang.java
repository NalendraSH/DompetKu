package com.nanz.dompetku.Activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nanz.dompetku.Fragments.UangFragment;
import com.nanz.dompetku.R;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FormDataUang extends AppCompatActivity {
    private EditText editText;
    private int dataUang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_data_uang);

        Toolbar toolbar = (Toolbar)findViewById(R.id.dataUangForm_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Form Data Uang");

        Button btnSimpan = (Button)findViewById(R.id.btn_SimpanDataUang);
        Button btnBatal = (Button)findViewById(R.id.btn_BatalDataUang);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream fosDetail = openFileOutput("dataDetailUang", MODE_PRIVATE);
                    FileOutputStream fosUang = openFileOutput("dataUang", MODE_PRIVATE);
                    String data = makeDetailData();
                    fosDetail.write(data.getBytes());
                    String dataUangString = String.valueOf(dataUang);
                    fosUang.write(dataUangString.getBytes());
                    Toast.makeText(getApplicationContext(), "Form Tersimpan", Toast.LENGTH_LONG).show();
                    fosDetail.close();
                    fosUang.close();
                }catch (FileNotFoundException e){
                    Toast.makeText(getApplicationContext(), "File not found!", Toast.LENGTH_LONG).show();
                }catch (IOException e){
                    Toast.makeText(getApplicationContext(), "IO Error!", Toast.LENGTH_LONG).show();
                }
                //new UangFragment().loadData();
                //UangFragment uangFragment = (UangFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentUang);
                //uangFragment.loadData();

                /*
                getSupportFragmentManager().beginTransaction().add(R.id.fragmentUang, new UangFragment(), "uangFragment").commit();
                //getSupportFragmentManager().beginTransaction().commit();

                UangFragment uangFragment = (UangFragment)getSupportFragmentManager().findFragmentByTag("uangFragment");
                uangFragment.loadData();
                */

                Intent intent = new Intent();
                intent.putExtra("result", true);
                setResult(RESULT_OK, intent);

                finish();
            }
        });
        btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private String makeDetailData(){
        editText = (EditText)findViewById(R.id.pecahan_100);
        int pecahan100 = Integer.parseInt(editText.getText().toString());
        editText = (EditText)findViewById(R.id.pecahan_200);
        int pecahan200= Integer.parseInt(editText.getText().toString());
        editText = (EditText)findViewById(R.id.pecahan_500);
        int pecahan500 = Integer.parseInt(editText.getText().toString());
        editText = (EditText)findViewById(R.id.pecahan_1000);
        int pecahan1000 = Integer.parseInt(editText.getText().toString());
        editText = (EditText)findViewById(R.id.pecahan_2000);
        int pecahan2000 = Integer.parseInt(editText.getText().toString());
        editText = (EditText)findViewById(R.id.pecahan_5000);
        int pecahan5000 = Integer.parseInt(editText.getText().toString());
        editText = (EditText)findViewById(R.id.pecahan_10000);
        int pecahan10000 = Integer.parseInt(editText.getText().toString());
        editText = (EditText)findViewById(R.id.pecahan_20000);
        int pecahan20000 = Integer.parseInt(editText.getText().toString());
        editText = (EditText)findViewById(R.id.pecahan_50000);
        int pecahan50000 = Integer.parseInt(editText.getText().toString());
        editText = (EditText)findViewById(R.id.pecahan_100000);
        int pecahan100000 = Integer.parseInt(editText.getText().toString());
        String data = "Rp. 100,-\t\t\tX\t"+pecahan100+
                "\nRp. 200,-\t\t\tX\t"+pecahan200+
                "\nRp. 500,-\t\t\tX\t"+pecahan500+
                "\nRp. 1000,-\t\tX\t"+pecahan1000+
                "\nRp. 2000,-\t\tX\t"+pecahan2000+
                "\nRp. 5000,-\t\tX\t"+pecahan5000+
                "\nRp. 10000,-\t\tX\t"+pecahan10000+
                "\nRp. 20000,-\t\tX\t"+pecahan20000+
                "\nRp. 50000,-\t\tX\t"+pecahan50000+
                "\nRp. 100000,-\tX\t"+pecahan100000;
        int totalUang = (100*pecahan100)+(200*pecahan200)+
                (500*pecahan500)+(1000*pecahan1000)+
                (2000*pecahan2000)+(5000*pecahan5000)+
                (10000*pecahan10000)+(20000*pecahan20000)+
                (50000*pecahan50000)+(100000*pecahan100000);
        dataUang = totalUang;
        return data;
    }
}
