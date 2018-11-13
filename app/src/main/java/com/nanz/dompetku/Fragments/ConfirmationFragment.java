package com.nanz.dompetku.Fragments;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;

import com.nanz.dompetku.Activity.FormKTMActivity;
import com.nanz.dompetku.Activity.FormKTPActivity;
import com.nanz.dompetku.Activity.FormKTPelajarActivity;
import com.nanz.dompetku.Activity.FormSIMActivity;
import com.nanz.dompetku.Activity.FormSTNKActivity;
import com.nanz.dompetku.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmationFragment extends DialogFragment {
    private Intent intent;
    private int selected;

    public ConfirmationFragment() {
        // Required empty public constructor
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(R.string.confirmationMessage)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        selected = Integer.parseInt(getTag());
                        switch (selected){
                            case 0:
                                intent = new Intent(getContext(), FormKTPActivity.class);
                                startActivity(intent);
                                break;
                            case 1:
                                intent = new Intent(getContext(), FormSIMActivity.class);
                                startActivity(intent);
                                break;
                            case 2:
                                intent = new Intent(getContext(), FormSTNKActivity.class);
                                startActivity(intent);
                                break;
                            case 3:
                                intent = new Intent(getContext(), FormKTMActivity.class);
                                startActivity(intent);
                                break;
                            case 4:
                                intent = new Intent(getContext(), FormKTPelajarActivity.class);
                                startActivity(intent);
                                break;
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return builder.create();
    }
}
