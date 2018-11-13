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

public class FormSIMActivity extends AppCompatActivity {
    private EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7,
            editText8, editText9, editText10, editText11, editText12;
    private String data;

    private boolean isEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_sim);

        Toolbar toolbar = (Toolbar)findViewById(R.id.simForm_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Form SIM");

        Button btnSimpan = (Button)findViewById(R.id.btn_SimpanSIM);
        Button btnBatal = (Button)findViewById(R.id.btn_BatalSIM);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataSIM = makeData();
                isEmpty = false;
                if (editText1.getText().toString().trim().equalsIgnoreCase("")) {
                    editText1.setError("Nama tidak boleh kosong"); isEmpty = true;
                }
                if (editText2.getText().toString().trim().equalsIgnoreCase("")) {
                    editText2.setError("No SIM tidak boleh kosong"); isEmpty = true;
                }
                if (editText3.getText().toString().trim().equalsIgnoreCase("")) {
                    editText3.setError("Tinggi Badan tidak boleh kosong"); isEmpty = true;
                }
                if (editText4.getText().toString().trim().equalsIgnoreCase("")) {
                    editText4.setError("Tempat Lahir tidak boleh kosong"); isEmpty = true;
                }
                if (editText5.getText().toString().trim().equalsIgnoreCase("")) {
                    editText5.setError("Tanggal Lahir tidak boleh kosong"); isEmpty = true;
                }
                if (editText6.getText().toString().trim().equalsIgnoreCase("")) {
                    editText6.setError("Bulan Lahir tidak boleh kosong"); isEmpty = true;
                }
                if (editText7.getText().toString().trim().equalsIgnoreCase("")) {
                    editText7.setError("Tahun Lahir tidak boleh kosong"); isEmpty = true;
                }
                if (editText8.getText().toString().trim().equalsIgnoreCase("")) {
                    editText8.setError("Alamat tidak boleh kosong"); isEmpty = true;
                }
                if (editText9.getText().toString().trim().equalsIgnoreCase("")) {
                    editText9.setError("Pekerjaan tidak boleh kosong"); isEmpty = true;
                }
                if (editText10.getText().toString().trim().equalsIgnoreCase("")) {
                    editText10.setError("Tanggal Berlaku tidak boleh kosong"); isEmpty = true;
                }
                if (editText11.getText().toString().trim().equalsIgnoreCase("")) {
                    editText11.setError("Bulan Berlaku tidak boleh kosong"); isEmpty = true;
                }
                if (editText12.getText().toString().trim().equalsIgnoreCase("")) {
                    editText12.setError("Tahun Berlaku tidak boleh kosong"); isEmpty = true;
                }
                if(!isEmpty) {
                    try {
                        FileOutputStream fos = openFileOutput("formSIM", MODE_PRIVATE);
                        fos.write(dataSIM.getBytes());
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
        editText1 = (EditText)findViewById(R.id.txt_NamaSIM);
        String nama = editText1.getText().toString();
        editText2 = (EditText)findViewById(R.id.txt_NoSIM);
        String NoSim = editText2.getText().toString();
        editText3 = (EditText)findViewById(R.id.txt_TinggiSIM);
        String Tinggi = editText3.getText().toString();
        editText4 = (EditText)findViewById(R.id.tempat_LahirSIM);
        String tempatLahir = editText4.getText().toString();
        editText5 = (EditText)findViewById(R.id.tgl_LahirSIM);
        String tglLahir = editText5.getText().toString();
        editText6 = (EditText)findViewById(R.id.bulan_LahirSIM);
        String bulanLahir = editText6.getText().toString();
        editText7 = (EditText)findViewById(R.id.tahun_LahirSIM);
        String tahunLahir = editText7.getText().toString();
        editText8 = (EditText)findViewById(R.id.txt_alamatSIM);
        String alamat = editText8.getText().toString();
        editText9 = (EditText)findViewById(R.id.txt_pekerjaanSIM);
        String pekerjaan = editText9.getText().toString();
        editText10 = (EditText)findViewById(R.id.tglBerlakuSIM);
        String tglBerlaku = editText10.getText().toString();
        editText11 = (EditText)findViewById(R.id.bulanBerlakuSIM);
        String blnBerlaku = editText11.getText().toString();
        editText12 = (EditText)findViewById(R.id.tahunBerlakuSIM);
        String tahunBerlaku = editText12.getText().toString();
        data = nama+
                "\n"+tempatLahir+", "+tglLahir+"-"+bulanLahir+"-"+tahunLahir+
                "\n"+alamat+
                "\n"+Tinggi+
                "\n"+pekerjaan+
                "\n"+NoSim+
                "\n"+tglBerlaku+"-"+blnBerlaku+"-"+tahunBerlaku;
        return data;
    }
}
