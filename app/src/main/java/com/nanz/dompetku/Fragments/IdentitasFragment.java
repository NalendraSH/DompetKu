package com.nanz.dompetku.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.nanz.dompetku.Activity.TampilKTM;
import com.nanz.dompetku.Activity.TampilKTP;
import com.nanz.dompetku.Activity.TampilKTPelajar;
import com.nanz.dompetku.Activity.TampilSIM;
import com.nanz.dompetku.Activity.TampilSTNK;
import com.nanz.dompetku.Adapter.GridViewAdapter;
import com.nanz.dompetku.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * A simple {@link Fragment} subclass.
 */
public class IdentitasFragment extends Fragment{
    private GridView gridView;
    private Intent intent;
    private FileInputStream fileInputStream;

    public IdentitasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_identitas, container, false);
        gridView = (GridView)view.findViewById(R.id.gridview);
        gridView.setAdapter(new GridViewAdapter(getContext()));
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        NewIdentityOptionFragments nw = new NewIdentityOptionFragments();
                        nw.show(getFragmentManager(), getTag());
                        break;
                    case 1:
                        try {
                            fileInputStream = getContext().openFileInput("formKTP");
                            intent = new Intent(getContext(), TampilKTP.class);
                            startActivity(intent);
                        }catch (FileNotFoundException e){
                            Toast.makeText(getContext(), "Anda Belum Memasukkan Data KTP", Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 2:
                        try {
                            fileInputStream = getContext().openFileInput("formSIM");
                            intent = new Intent(getContext(), TampilSIM.class);
                            startActivity(intent);
                        }catch (FileNotFoundException e){
                            Toast.makeText(getContext(), "Anda Belum Memasukkan Data SIM", Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 3:
                        try {
                            fileInputStream = getContext().openFileInput("formSTNK");
                            intent = new Intent(getContext(), TampilSTNK.class);
                            startActivity(intent);
                        }catch (FileNotFoundException e){
                            Toast.makeText(getContext(), "Anda Belum Memasukkan Data STNK", Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 4:
                        try {
                            fileInputStream = getContext().openFileInput("formKTM");
                            intent = new Intent(getContext(), TampilKTM.class);
                            startActivity(intent);
                        }catch (FileNotFoundException e){
                            Toast.makeText(getContext(), "Anda Belum Memasukkan Data KTM", Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 5:
                        try {
                            fileInputStream = getContext().openFileInput("formKTPelajar");
                            intent = new Intent(getContext(), TampilKTPelajar.class);
                            startActivity(intent);
                        }catch (FileNotFoundException e){
                            Toast.makeText(getContext(), "Anda Belum Memasukkan Data KTP(Pelajar)", Toast.LENGTH_LONG).show();
                        }
                        break;
                    default:
                        break;
                }
            }
        });

        /*
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getContext(), FormKTPActivity.class);
                //Intent intent = new Intent(getContext(), NewIdentityOptionFragments.class);
                //startActivity(intent);
                NewIdentityOptionFragments optionFragments = new NewIdentityOptionFragments();
                optionFragments.show(getFragmentManager(), getTag());
            }
        });
        btnTampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TampilKTP.class);
                startActivity(intent);

            }
        });
        */

    }
}
