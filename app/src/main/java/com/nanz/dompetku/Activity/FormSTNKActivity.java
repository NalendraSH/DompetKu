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

public class FormSTNKActivity extends AppCompatActivity {
    private EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7,
            editText8, editText9, editText10, editText11, editText12, editText13;
    private String data;

    private boolean isEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_stnk);

        Toolbar toolbar = (Toolbar)findViewById(R.id.stnkForm_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Form STNK");

        Button btnSimpan = (Button)findViewById(R.id.btn_SimpanSTNK);
        Button btnBatal = (Button)findViewById(R.id.btn_BatalSTNK);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataSTNK = makeData();
                isEmpty = false;
                if (editText1.getText().toString().trim().equalsIgnoreCase("")) {
                    editText1.setError("Nama Pemilik tidak boleh kosong"); isEmpty = true;
                }
                if (editText2.getText().toString().trim().equalsIgnoreCase("")) {
                    editText2.setError("No STNK tidak boleh kosong"); isEmpty = true;
                }
                if (editText3.getText().toString().trim().equalsIgnoreCase("")) {
                    editText3.setError("No Registrasi tidak boleh kosong"); isEmpty = true;
                }
                if (editText4.getText().toString().trim().equalsIgnoreCase("")) {
                    editText4.setError("Alamat tidak boleh kosong"); isEmpty = true;
                }
                if (editText5.getText().toString().trim().equalsIgnoreCase("")) {
                    editText5.setError("Merk tidak boleh kosong"); isEmpty = true;
                }
                if (editText6.getText().toString().trim().equalsIgnoreCase("")) {
                    editText6.setError("Jenis tidak boleh kosong"); isEmpty = true;
                }
                if (editText7.getText().toString().trim().equalsIgnoreCase("")) {
                    editText7.setError("Model tidak boleh kosong"); isEmpty = true;
                }
                if (editText8.getText().toString().trim().equalsIgnoreCase("")) {
                    editText8.setError("Tahun Pembuatan tidak boleh kosong"); isEmpty = true;
                }
                if (editText9.getText().toString().trim().equalsIgnoreCase("")) {
                    editText9.setError("Bahan Bakar tidak boleh kosong"); isEmpty = true;
                }
                if (editText10.getText().toString().trim().equalsIgnoreCase("")) {
                    editText10.setError("Warna tidak boleh kosong"); isEmpty = true;
                }
                if (editText11.getText().toString().trim().equalsIgnoreCase("")) {
                    editText11.setError("Tanggal Berlaku tidak boleh kosong"); isEmpty = true;
                }
                if (editText12.getText().toString().trim().equalsIgnoreCase("")) {
                    editText12.setError("Bulan Berlaku tidak boleh kosong"); isEmpty = true;
                }
                if (editText13.getText().toString().trim().equalsIgnoreCase("")) {
                    editText13.setError("Tahun Berlaku tidak boleh kosong"); isEmpty = true;
                }
                if(!isEmpty){
                    try {
                        FileOutputStream fos = openFileOutput("formSTNK", MODE_PRIVATE);
                        fos.write(dataSTNK.getBytes());
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
        editText1 = (EditText)findViewById(R.id.txt_NamaPemilikSTNK);
        String namaPemilik = editText1.getText().toString();
        editText2 = (EditText)findViewById(R.id.txt_NoSTNK);
        String noSTNK = editText2.getText().toString();
        editText3 = (EditText)findViewById(R.id.txt_NoRegistrasiSTNK);
        String NoRegistrasi = editText3.getText().toString();
        editText4 = (EditText)findViewById(R.id.txt_alamatSTNK);
        String alamat = editText4.getText().toString();
        editText5 = (EditText)findViewById(R.id.txt_MerkSTNK);
        String merk = editText5.getText().toString();
        editText6 = (EditText)findViewById(R.id.txt_JenisSTNK);
        String jenis = editText6.getText().toString();
        editText7 = (EditText)findViewById(R.id.txt_ModelSTNK);
        String model = editText7.getText().toString();
        editText8 = (EditText)findViewById(R.id.txt_TahunPembuatanSTNK);
        String tahunPembuatan = editText8.getText().toString();
        editText9 = (EditText)findViewById(R.id.txt_BahanBakarSTNK);
        String bahanBakar = editText9.getText().toString();
        editText10 = (EditText)findViewById(R.id.txt_WarnaSTNK);
        String warna = editText10.getText().toString();
        editText11 = (EditText)findViewById(R.id.tglBerlakuSTNK);
        String tglBerlaku = editText11.getText().toString();
        editText12 = (EditText)findViewById(R.id.bulanBerlakuSTNK);
        String blnBerlaku = editText12.getText().toString();
        editText13 = (EditText)findViewById(R.id.tahunBerlakuSTNK);
        String tahunBerlaku = editText13.getText().toString();
        data = namaPemilik+
                "\n"+NoRegistrasi+
                "\n"+alamat+
                "\n"+noSTNK+
                "\n"+merk+
                "\n"+jenis+
                "\n"+model+
                "\n"+tahunPembuatan+
                "\n"+bahanBakar+
                "\n"+warna+
                "\n"+tglBerlaku+"-"+blnBerlaku+"-"+tahunBerlaku;
        return data;
    }
}
