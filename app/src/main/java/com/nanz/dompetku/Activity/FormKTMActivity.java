package com.nanz.dompetku.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nanz.dompetku.R;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FormKTMActivity extends AppCompatActivity {
    private EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7;
    private String data;

    private boolean isEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_ktm);

        Toolbar toolbar = (Toolbar)findViewById(R.id.ktmForm_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Form KTM");

        Button btnSimpan = (Button)findViewById(R.id.btn_SimpanKTM);
        Button btnBatal = (Button)findViewById(R.id.btn_BatalKTM);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataKTM = makeData();
                isEmpty = false;
                if (editText1.getText().toString().trim().equalsIgnoreCase("")) {
                    editText1.setError("Nama tidak boleh kosong"); isEmpty = true;
                }
                if (editText2.getText().toString().trim().equalsIgnoreCase("")) {
                    editText2.setError("NBI tidak boleh kosong"); isEmpty = true;
                }
                if (editText3.getText().toString().trim().equalsIgnoreCase("")) {
                    editText3.setError("Fakultas tidak boleh kosong"); isEmpty = true;
                }
                if (editText4.getText().toString().trim().equalsIgnoreCase("")) {
                    editText4.setError("Prodi tidak boleh kosong"); isEmpty = true;
                }
                if (editText5.getText().toString().trim().equalsIgnoreCase("")) {
                    editText5.setError("Tanggal Berlaku tidak boleh kosong"); isEmpty = true;
                }
                if (editText6.getText().toString().trim().equalsIgnoreCase("")) {
                    editText6.setError("Bulan Berlaku tidak boleh kosong"); isEmpty = true;
                }
                if (editText7.getText().toString().trim().equalsIgnoreCase("")) {
                    editText7.setError("Tahun Berlaku tidak boleh kosong"); isEmpty = true;
                }
                if(!isEmpty){
                    try {
                        FileOutputStream fos = openFileOutput("formKTM", MODE_PRIVATE);
                        fos.write(dataKTM.getBytes());
                        Toast.makeText(getApplicationContext(), "Form Tersimpan", Toast.LENGTH_LONG).show();
                        fos.close();
                        finish();
                    }catch (FileNotFoundException e){
                        Toast.makeText(getApplicationContext(), "File not found!", Toast.LENGTH_LONG).show();
                    }catch (IOException e){
                        Toast.makeText(getApplicationContext(), "IO Error!", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
        btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private String makeData(){
        editText1 = (EditText)findViewById(R.id.txt_NamaKTM);
        String nama = editText1.getText().toString();
        editText2 = (EditText)findViewById(R.id.txt_NBIKTM);
        String nbi = editText2.getText().toString();
        editText3 = (EditText)findViewById(R.id.txt_FakultasKTM);
        String fakultas = editText3.getText().toString();
        editText4 = (EditText)findViewById(R.id.txt_ProdiKTM);
        String prodi = editText4.getText().toString();
        editText5 = (EditText)findViewById(R.id.tglBerlakuKTM);
        String tglBerlaku = editText5.getText().toString();
        editText6 = (EditText)findViewById(R.id.bulanBerlakuKTM);
        String blnBerlaku = editText6.getText().toString();
        editText7 = (EditText)findViewById(R.id.tahunBerlakuKTM);
        String tahunBerlaku = editText7.getText().toString();
        data = nama+
                "\n"+nbi+
                "\n"+fakultas+
                "\n"+prodi+
                "\n"+tglBerlaku+"-"+blnBerlaku+"-"+tahunBerlaku;
        return data;
    }
}
