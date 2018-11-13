package com.nanz.dompetku.Fragments;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.nanz.dompetku.Activity.FormDataUang;
import com.nanz.dompetku.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A simple {@link Fragment} subclass.
 */
public class UangFragment extends Fragment {
    public TextView tampilUang;
    //private TextView tampilDetailUang;
    //private Button btnDetail;
    //private Button btnEdit;
    //private ImageButton btnRefresh;

    private ImageButton btn_Deposit;
    private ImageButton btn_Withdraw;
    private ImageButton btn_History;

    private String tampil;
    private boolean isPressed;
    BufferedReader bufferedReader;

    public UangFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_uang, container, false);
        tampilUang = (TextView)view.findViewById(R.id.rpTampil);

        btn_Deposit = (ImageButton)view.findViewById(R.id.btn_Deposit);
        btn_Withdraw = (ImageButton)view.findViewById(R.id.btn_Withdraw);
        btn_History = (ImageButton)view.findViewById(R.id.btn_History);

        /*
        tampilDetailUang = (TextView)view.findViewById(R.id.tampilDetailUang);
        btnDetail = (Button)view.findViewById(R.id.detailUang);
        btnEdit = (Button)view.findViewById(R.id.editUang);
        btnRefresh = (ImageButton)view.findViewById(R.id.btnRefresh);
        */
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        loadData();

        btn_Deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        /*if(btn_Deposit.isPressed()){
            btn_Deposit.setBackgroundResource(R.drawable.deposit2);
        }else {
            btn_Deposit.setBackgroundResource(R.drawable.deposit);
        }*/

        /*
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadData();
            }
        });

        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isPressed = !isPressed;

                //loadData();

                if(isPressed){
                    btnDetail.setText("Hide");

                    try {
                        FileInputStream fileInputStream = getContext().openFileInput("dataDetailUang");
                        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuffer stringBuffer = new StringBuffer();
                        while ((tampil = bufferedReader.readLine()) != null){
                            stringBuffer.append(tampil + "\n");
                        }
                        tampilDetailUang.setText(stringBuffer.toString());
                    }catch (FileNotFoundException e){
                        tampilDetailUang.setText("");
                    }catch (IOException e){
                        Toast.makeText(getContext(), "IO Error!", Toast.LENGTH_LONG).show();
                    }

                    tampilDetailUang.setVisibility(View.VISIBLE);
                }else {
                    btnDetail.setText("Show");
                    tampilDetailUang.setVisibility(View.GONE);
                }
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), FormDataUang.class);
                startActivityForResult(intent, 1);
            }
        });
        */
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        loadData();
    }

    protected void loadData(){
        try {
            FileInputStream fileInputStream = getContext().openFileInput("dataUang");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            tampilUang.setText(bufferedReader.readLine()+",-");
        }catch (FileNotFoundException e){
            tampilUang.setText("0,-");
        }catch (IOException e){
            Toast.makeText(getContext(), "IO Error!", Toast.LENGTH_LONG).show();
        }
    }
}
