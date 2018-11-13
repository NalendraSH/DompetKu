package com.nanz.dompetku.Fragments;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nanz.dompetku.Activity.FormKTMActivity;
import com.nanz.dompetku.Activity.FormKTPActivity;
import com.nanz.dompetku.Activity.FormKTPelajarActivity;
import com.nanz.dompetku.Activity.FormSIMActivity;
import com.nanz.dompetku.Activity.FormSTNKActivity;
import com.nanz.dompetku.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class NewIdentityOptionFragments extends DialogFragment {
    public Intent dialogIntent;
    private FileInputStream fileInputStream;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_identity_option_fragments, container, false);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(getContext(), R.style.DialogTheme));
        builder.setTitle(R.string.optionTitle)
                .setItems(R.array.optionResources, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:
                                dialogIntent = new Intent(getContext(), FormKTPActivity.class);
                                try {
                                    fileInputStream = getContext().openFileInput("formKTP");
                                    ConfirmationFragment confimDialog = new ConfirmationFragment();
                                    confimDialog.show(getFragmentManager(), "0");
                                }catch (FileNotFoundException e){
                                    startActivity(dialogIntent);
                                }
                                break;
                            case 1:
                                dialogIntent = new Intent(getContext(), FormSIMActivity.class);
                                try {
                                    fileInputStream = getContext().openFileInput("formSIM");
                                    ConfirmationFragment confimDialog = new ConfirmationFragment();
                                    confimDialog.show(getFragmentManager(), "1");
                                }catch (FileNotFoundException e){
                                    startActivity(dialogIntent);
                                }
                                break;
                            case 2:
                                dialogIntent = new Intent(getContext(), FormSTNKActivity.class);
                                try {
                                    fileInputStream = getContext().openFileInput("formSTNK");
                                    ConfirmationFragment confimDialog = new ConfirmationFragment();
                                    confimDialog.show(getFragmentManager(), "2");
                                }catch (FileNotFoundException e){
                                    startActivity(dialogIntent);
                                }
                                break;
                            case 3:
                                dialogIntent = new Intent(getContext(), FormKTMActivity.class);
                                try {
                                    fileInputStream = getContext().openFileInput("formKTM");
                                    ConfirmationFragment confimDialog = new ConfirmationFragment();
                                    confimDialog.show(getFragmentManager(), "3");
                                }catch (FileNotFoundException e){
                                    startActivity(dialogIntent);
                                }
                                break;
                            case 4:
                                dialogIntent = new Intent(getContext(), FormKTPelajarActivity.class);
                                try {
                                    fileInputStream = getContext().openFileInput("formKTPelajar");
                                    ConfirmationFragment confimDialog = new ConfirmationFragment();
                                    confimDialog.show(getFragmentManager(), "4");
                                }catch (FileNotFoundException e){
                                    startActivity(dialogIntent);
                                }
                                break;
                            default:
                                break;
                        }
                    }
                });
        // Create the AlertDialog object and return it
        //AlertDialog alertDialogObject = builder.create();
        //alertDialogObject.getActionBar().setTitle(R.string.optionTitle);
        //alertDialogObject.getActionBar().setBackgroundDrawable(new ColorDrawable(Color.CYAN));
        //ListView listView = alertDialogObject.getListView();
        //listView.setDivider(new ColorDrawable(Color.LTGRAY));
        //listView.setDividerHeight(2);
        return builder.create();
    }
}
