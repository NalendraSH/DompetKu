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

public class FormKTPActivity extends AppCompatActivity {
    private Button btnSimpan;
    private Button btnBatal;
    private Toolbar toolbar;
    private EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7,
            editText8, editText9, editText10, editText11, editText12, editText13, editText14, editText15;
    private String data;
    private String nama;
    private String nik;
    private String tempatLahir;
    private String tglLahir;
    private String bulanLahir;
    private String tahunLahir;
    private String jenisKelamin;
    private String golDar;
    private String alamat;
    private String agama;
    private String pekerjaan;
    private String tglBerlaku;
    private String blnBerlaku;
    private String tahunBerlaku;
    private String kewarganegaraan;

    private boolean isEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_ktp);

        toolbar = (Toolbar)findViewById(R.id.ktpForm_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Form KTP");

        btnSimpan = (Button)findViewById(R.id.btn_SimpanKTP);
        btnBatal = (Button)findViewById(R.id.btn_BatalKTP);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataKTP = makeData();
                isEmpty = false;
                if (editText1.getText().toString().trim().equalsIgnoreCase("")) {
                    editText1.setError("Nama tidak boleh kosong"); isEmpty = true;
                }
                if (editText2.getText().toString().trim().equalsIgnoreCase("")) {
                    editText2.setError("NIK tidak boleh kosong"); isEmpty = true;
                }
                if (editText3.getText().toString().trim().equalsIgnoreCase("")) {
                    editText3.setError("Tempat Lahir tidak boleh kosong"); isEmpty = true;
                }
                if (editText4.getText().toString().trim().equalsIgnoreCase("")) {
                    editText4.setError("Tanggal Lahir tidak boleh kosong"); isEmpty = true;
                }
                if (editText5.getText().toString().trim().equalsIgnoreCase("")) {
                    editText5.setError("Bulan Lahir tidak boleh kosong"); isEmpty = true;
                }
                if (editText6.getText().toString().trim().equalsIgnoreCase("")) {
                    editText6.setError("Tahun Lahir tidak boleh kosong"); isEmpty = true;
                }
                if (editText7.getText().toString().trim().equalsIgnoreCase("")) {
                    editText7.setError("Jenis Kelamin tidak boleh kosong"); isEmpty = true;
                }
                if (editText8.getText().toString().trim().equalsIgnoreCase("")) {
                    editText8.setError("Golongan Darah tidak boleh kosong"); isEmpty = true;
                }
                if (editText9.getText().toString().trim().equalsIgnoreCase("")) {
                    editText9.setError("Alamat tidak boleh kosong"); isEmpty = true;
                }
                if (editText10.getText().toString().trim().equalsIgnoreCase("")) {
                    editText10.setError("Agama tidak boleh kosong"); isEmpty = true;
                }
                if (editText11.getText().toString().trim().equalsIgnoreCase("")) {
                    editText11.setError("Pekerjaan tidak boleh kosong"); isEmpty = true;
                }
                if (editText12.getText().toString().trim().equalsIgnoreCase("")) {
                    editText12.setError("Tanggal Berlaku tidak boleh kosong"); isEmpty = true;
                }
                if (editText13.getText().toString().trim().equalsIgnoreCase("")) {
                    editText13.setError("Bulan Berlaku tidak boleh kosong"); isEmpty = true;
                }
                if (editText14.getText().toString().trim().equalsIgnoreCase("")) {
                    editText14.setError("Tahun Berlaku tidak boleh kosong"); isEmpty = true;
                }
                if (editText15.getText().toString().trim().equalsIgnoreCase("")) {
                    editText15.setError("Kewarganegaraan tidak boleh kosong"); isEmpty = true;
                }
                if(!isEmpty){
                    try {
                        FileOutputStream fos = openFileOutput("formKTP", MODE_PRIVATE);
                        fos.write(dataKTP.getBytes());
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

        editText1 = (EditText)findViewById(R.id.txt_NamaKTP);
        nama = editText1.getText().toString();
        editText2 = (EditText)findViewById(R.id.txt_NIKKTP);
        nik = editText2.getText().toString();
        editText3 = (EditText)findViewById(R.id.tempat_LahirKTP);
        tempatLahir = editText3.getText().toString();
        editText4 = (EditText)findViewById(R.id.tglKTP);
        tglLahir = editText4.getText().toString();
        editText5 = (EditText)findViewById(R.id.bulanKTP);
        bulanLahir = editText5.getText().toString();
        editText6 = (EditText)findViewById(R.id.tahunKTP);
        tahunLahir = editText6.getText().toString();
        editText7 = (EditText)findViewById(R.id.txt_jenKelKTP);
        jenisKelamin = editText7.getText().toString();
        editText8 = (EditText)findViewById(R.id.txt_golDarKTP);
        golDar = editText8.getText().toString();
        editText9 = (EditText)findViewById(R.id.txt_alamatKTP);
        alamat = editText9.getText().toString();
        editText10 = (EditText)findViewById(R.id.txt_agamaKTP);
        agama = editText10.getText().toString();
        editText11 = (EditText)findViewById(R.id.txt_pekerjaanKTP);
        pekerjaan = editText11.getText().toString();
        editText12 = (EditText)findViewById(R.id.tglBerlakuKTP);
        tglBerlaku = editText12.getText().toString();
        editText13 = (EditText)findViewById(R.id.bulanBerlakuKTP);
        blnBerlaku = editText13.getText().toString();
        editText14 = (EditText)findViewById(R.id.tahunBerlakuKTP);
        tahunBerlaku = editText14.getText().toString();
        editText15 = (EditText)findViewById(R.id.txt_kewarganegaraanKTP);
        kewarganegaraan = editText15.getText().toString();

        data = nama+
                "\n"+nik+
                "\n"+tempatLahir+", "+tglLahir+"-"+bulanLahir+"-"+tahunLahir+
                "\n"+jenisKelamin+
                "\n"+golDar+
                "\n"+alamat+
                "\n"+agama+
                "\n"+pekerjaan+
                "\n"+tglBerlaku+"-"+blnBerlaku+"-"+tahunBerlaku+
                "\n"+kewarganegaraan;
        return data;
    }
}
