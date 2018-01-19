package jrl.deint.inventoryDataBase;

import android.support.annotation.StringRes;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import jrl.deint.inventoryDataBase.repository.UserRepository;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.mock;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @author Jesús Roldán López
 * @version 1.0
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 * 1. El usuario introduce usuario/email (Instrumentales)
 * 2. El usuario introduce contraseña (Instrumentales)
 * 3. La contraseña tiene al menos 6 caracteres (Instrumental)
 * 4. Doble comprobación de la contraseña (Instrumental)
 */
@RunWith(AndroidJUnit4.class)
public class LoginInstrumentedTest {

    @Mock
    // Notación Mock para que esté compartido por los tests (si no, da NullPointerException)
    private UserRepository userRepository = mock(UserRepository.class);

    /**
     * Comprueba que el User no es vacío
     */
    @Test
    public void isUserEmpty() {
        onView(withId(R.id.btnSignIn)).perform(click());
        checkSnackBarDisplayByMessage(R.string.errorUserEmpty);
    }

    /**
     * Comprueba que el Email no es vacío
     */
    @Test
    public void isEmailEmpty() {
        onView(withId(R.id.btnSignIn)).perform(click());
        checkSnackBarDisplayByMessage(R.string.errorEmailEmpty);
    }

    /**
     * Comprueba que el Password no es vacío
     */
    @Test
    public void isPasswordEmpty() {
        onView(withId(R.id.btnSignIn)).perform(click());
        checkSnackBarDisplayByMessage(R.string.errorPasswordEmpty);
    }

    /**
     * Comprueba que la longitud de la contraseña es correcta
     */
    @Test
    public void passwordLength() {
        onView(withId(R.id.edtUser)).perform(typeText("lourdes"), closeSoftKeyboard());
        onView(withId(R.id.edtPassword)).perform(typeText("lu"), closeSoftKeyboard());
        onView(withId(R.id.btnSignIn)).perform(click());
        checkSnackBarDisplayByMessage(R.string.errorPasswordLength);
    }

    @Test
    public void passwordDoubleCheck() {

    }

    private void checkSnackBarDisplayByMessage(@StringRes int message) {
        onView(withText(message)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }
}
