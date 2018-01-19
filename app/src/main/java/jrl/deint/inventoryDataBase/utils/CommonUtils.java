package jrl.deint.inventoryDataBase.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jrl.deint.inventoryDataBase.R;

/**
 * Created by usuario on 13/11/17.
 */

public final class CommonUtils {

    /**
     * Método que comprueba que la contraseña tenga los siguientes requisitos
     * Debe contener al menos un dígito 0-9
     * Debe contener al menos un carácter en mayúscula
     * Debe contener al menos un carácter en minúscula
     * Y debe tener una longitud de al menos seis caracteres
     * @param password Es la contraseña que se va a comprobar
     * @return Devuelve un booleano que indica si la contraseña es correcta o no
     */
    public static boolean isPasswordValid(String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z]).{6,}$";
        pattern=Pattern.compile(PASSWORD_PATTERN);          // Se compila el patrón y si está mal construido lanza una excepción
        matcher = pattern.matcher(password);                // Busca todas las ocurrencias que coinciden con en el patrón
        return matcher.matches();                           // Verifica si se cumple el patrón establecido
    }

    public static ProgressDialog showLoadDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        if(progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }
/*
    interface ConfirmationDialog {
        String MESSAGE = "message";
        String TITLE = "titulo";
    }

    public static Dialog showConfirmDialog(Bundle bundle, Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(bundle.getString(ConfirmationDialog.MESSAGE))
               .setTitle(bundle.getString(ConfirmationDialog.TITLE))
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
*/
}
