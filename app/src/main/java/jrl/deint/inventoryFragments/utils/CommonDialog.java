package jrl.deint.inventoryFragments.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import jrl.deint.inventoryFragments.R;

/**
 * Created by usuario on 30/11/17.
 */

public class CommonDialog {

    public static final String MESSAGE = "message";
    public static final String TITLE = "titulo";

    /*
    // Otra forma
    interface ConfirmationDialog {
        String MESSAGE = "message";
        String TITLE = "titulo";
    }
    */

    public static Dialog showConfirmDialog(Bundle bundle, Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(bundle.getString(MESSAGE))
               .setTitle(bundle.getString(TITLE))
               .setPositiveButton(R.string.btnOk, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
               })
               .setNegativeButton(R.string.btnCancel, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
               });
        return builder.create();
    }
}
