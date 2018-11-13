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

public class FormKTPelajarActivity extends AppCompatActivity {
    private EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7,
            editText8, editText9, editText10, editText11, editText12;
    private String data;

    private boolean isEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_ktpelajar);

        Toolbar toolbar = (Toolbar)findViewById(R.id.pelajarForm_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Form KTP(Pelajar)");

        Button btnSimpan = (Button)findViewById(R.id.btn_SimpanPelajar);
        Button btnBatal = (Button)findViewById(R.id.btn_BatalPelajar);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataPelajar = makeData();
                isEmpty = false;
                if (editText1.getText().toString().trim().equalsIgnoreCase("")) {
                    editText1.setError("Nama tidak boleh kosong"); isEmpty = true;
                }
                if (editText2.getText().toString().trim().equalsIgnoreCase("")) {
                    editText2.setError("No Induk tidak boleh kosong"); isEmpty = true;
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
                    editText7.setError("Alamat tidak boleh kosong"); isEmpty = true;
                }
                if (editText8.getText().toString().trim().equalsIgnoreCase("")) {
                    editText8.setError("Agama tidak boleh kosong"); isEmpty = true;
                }
                if (editText9.getText().toString().trim().equalsIgnoreCase("")) {
                    editText9.setError("Kelas tidak boleh kosong"); isEmpty = true;
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
                if(!isEmpty){
                    try {
                        FileOutputStream fos = openFileOutput("formKTPelajar", MODE_PRIVATE);
                        fos.write(dataPelajar.getBytes());
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
        editText1 = (EditText)findViewById(R.id.txt_NamaPelajar);
        String nama = editText1.getText().toString();
        editText2 = (EditText)findViewById(R.id.txt_NoIndukPelajar);
        String noInduk = editText2.getText().toString();
        editText3 = (EditText)findViewById(R.id.tempat_LahirPelajar);
        String tempatLahir = editText3.getText().toString();
        editText4 = (EditText)findViewById(R.id.tglPelajar);
        String tglLahir = editText4.getText().toString();
        editText5 = (EditText)findViewById(R.id.bulanPelajar);
        String bulanLahir = editText5.getText().toString();
        editText6 = (EditText)findViewById(R.id.tahunPelajar);
        String tahunLahir = editText6.getText().toString();
        editText7 = (EditText)findViewById(R.id.txt_alamatPelajar);
        String alamat = editText7.getText().toString();
        editText8 = (EditText)findViewById(R.id.txt_agamaPelajar);
        String agama = editText8.getText().toString();
        editText9 = (EditText)findViewById(R.id.txt_kelasPelajar);
        String kelas = editText9.getText().toString();
        editText10 = (EditText)findViewById(R.id.tglBerlakuPelajar);
        String tglBerlaku = editText10.getText().toString();
        editText11 = (EditText)findViewById(R.id.bulanBerlakuPelajar);
        String blnBerlaku = editText11.getText().toString();
        editText12 = (EditText)findViewById(R.id.tahunBerlakuPelajar);
        String tahunBerlaku = editText12.getText().toString();
        data = nama+
                "\n"+noInduk+
                "\n"+tempatLahir+", "+tglLahir+"-"+bulanLahir+"-"+tahunLahir+
                "\n"+alamat+
                "\n"+agama+
                "\n"+kelas+
                "\n"+tglBerlaku+"-"+blnBerlaku+"-"+tahunBerlaku;
        return data;
    }
}
