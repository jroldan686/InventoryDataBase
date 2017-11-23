package jrl.deint.inventoryFragments.ui.login;

import android.text.TextUtils;

import jrl.deint.inventoryFragments.repository.UserRepository;
import jrl.deint.inventoryFragments.utils.CommonUtils;

/**
 * Created by usuario on 10/11/17.
 */

public class LoginInteractorImpl {

    // Las clases Interactor no tienen contrato con otras clases y se les pasa una interfaz como parámetro
    public void validateCredentials(String user, String password, LoginInteractor.OnLoginFinishedListener listener) {
        // Realiza todas las comprobaciones
        // Si el password es vacío
        if (TextUtils.isEmpty(password))
            listener.onPasswordEmptyError();
        else if (TextUtils.isEmpty(user))       // Si el usuario es vacío
            listener.onUserEmptyError();
        else if (!CommonUtils.isPasswordValid(password))        // Si la contraseña no es válida
            listener.onPasswordError();
        else if (UserRepository.getInstance().validateCredentials(user, password))      // Si las credenciales son correctas
            listener.onSuccess();
    }
}
