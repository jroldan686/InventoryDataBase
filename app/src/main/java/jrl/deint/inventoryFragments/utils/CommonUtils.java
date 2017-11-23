package jrl.deint.inventoryFragments.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
}
