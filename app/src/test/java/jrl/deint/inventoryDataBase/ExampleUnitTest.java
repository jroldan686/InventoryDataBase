package jrl.deint.inventoryDataBase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import jrl.deint.inventoryDataBase.data.db.model.User;
import jrl.deint.inventoryDataBase.repository.UserRepository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private ArrayList<User> users;

    @Mock   // Notación Mock para que esté compartido por los tests (si no, da NullPointerException)
    private UserRepository userRepository = mock(UserRepository.class);

    @Before // Este decorador hace que se ejecute antes de cualquier método de prueba
    public void initialice() {
        users = new ArrayList<>();
        users.add(new User(1, "Moronlu", "12345678", "Lourdes Rodriguez","moronlu18@gmail.com", true,true));
        users.add(new User(2, "EMoreno", "87654321", "Eliseo Moreno","eliseo.moreno@gmail.com", true, false));
        users.add(new User(3, "Sebas", "abcdefgh", "Sebastían Millán","sebas_millan@yahoo.es", false, true));
        users.add(new User(4, "PacoG", "malaga2017", "Paco García","pacog@hotmail.com", false, false));
    }

    // 3. El usuario existe en la base de datos (Repository)
    // Para realizar esta prueba se tiene que comprarar dos objetos User

    @Test
    public void isUserExists_isCorrect() {
        // Añadimos el objeto virtual
        UserRepository userRepository = mock(UserRepository.class);
        // Cuando se llame al método isUserExists(), devuelva un valor predeterminado.
        when(userRepository.isUserExists(users.get(0))).thenReturn(true);
        assertTrue(userRepository.isUserExists(users.get(0)));
    }

    @Test
    public void getUsers_isCorrect() {
        when(userRepository.getUsers()).thenReturn(users);
        assertEquals(users.get(0), userRepository.getUsers().get(0));
    }

    // 4. La contraseña es correcta (Repository)

    @Test
    public void password_isCorrect() {
        when(userRepository.getUsers()).thenReturn(users);
        assertEquals(users.get(0).getPassword(), userRepository.getUsers().get(0).getPassword());
    }

    @Test
    public void signIn_isCorrect() throws Exception {

    }

    // 7. El usuario no existe en la base de datos (Repository)

    // 8. El email no existe en la base de datos (Repository)

    /**
     * Ejemplo de prueba donde se ve el conjunto de pruebas posibles.
     */
    @Test
    public void testAssertions() {
        // Compara si dos objetos son iguales
        User user1 = new User(1, "Moronlu", "12345678", "Lourdes Rodriguez","moronlu18@gmail.com", true,true);
        assertEquals(user1, users.get(0));
        // Compara si un objeto es nulo
        User user2 = null;
        User user3 = user1;
        assertNull(user2);
        // Un objeto no es nulo
        assertNotNull(user1);
        // Dos objetos apuntan a la misma referencia
        assertSame(user1, user3);
        // Falta assertTrue() y otros

    }
}