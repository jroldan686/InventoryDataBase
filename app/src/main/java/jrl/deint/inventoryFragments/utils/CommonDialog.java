package jrl.deint.inventoryFragments.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import jrl.deint.inventoryFragments.R;
import jrl.deint.inventoryFragments.data.db.model.Dependency;

/**
 * Created by usuario on 30/11/17.
 */

public class CommonDialog {

    public static final String MESSAGE = "message";
    public static final String TITLE = "titulo";
    public static final int DELETE_DIALOG = 2;
    public static final String TYPE = "type";

    /*
    // Otra forma
    interface ConfirmationDialog {
        String MESSAGE = "message";
        String TITLE = "titulo";
    }
    */

    /**
     * Cuadro de diálogo genérico que sirve para cualquier Fragment o Presenter.
     * @param bundle
     * @param context
     * @param listener
     * @return
     */
    public static Dialog showConfirmDialog(Bundle bundle, Context context, CommonDialogListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(bundle.getString(CommonDialog.MESSAGE))
               .setTitle(bundle.getString(CommonDialog.TITLE))
               .setPositiveButton(R.string.btnOk, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listener.deleteItem((Dependency) bundle.getParcelable(Dependency.TAG));
                    }
               })
               .setNegativeButton(R.string.btnCancel, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Se debe usar cancel en vez de dismiss, porque dismiss no elimina
                        dialogInterface.cancel();
                    }
               });
        return builder.create();
    }

    public interface CommonDialogListener {

    }
}
