package jrl.deint.inventoryFragments.ui.login;

import jrl.deint.inventoryFragments.base.BaseActivity;

/**
 * Created by usuario on 10/11/17.
 */

public class LoginInteractorImpl extends BaseActivity {

    @Override
    public void validateCredentials(String user, String password, LoginInteractor.OnLoginFinishedListener listener) {
        // Realiza todas las comprobaciones
        // Si el password es vacío
        if listener.onPasswordEmptyError();
        if else
            listener.onUserEmptyError();
        if else
            listener.onPasswordError();
        else
            listener.onSuccess();
        // Y es correcto
    }
}
