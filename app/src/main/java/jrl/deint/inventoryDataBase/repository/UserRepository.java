package jrl.deint.inventoryDataBase.repository;

import java.util.ArrayList;

import jrl.deint.inventoryDataBase.data.db.model.User;

/**
 * Created by usuario on 8/11/17.
 */

public class UserRepository {

    /* Declaración */
    private ArrayList<User> users;
    private static jrl.deint.inventoryDataBase.repository.UserRepository userRepository;

    /* INICIALIZACIÓN */
/* Inicializar todos los atributos de ámbito estático o de clase */
    static {
        userRepository = new jrl.deint.inventoryDataBase.repository.UserRepository();
    }

    /**
     * El método ha de ser privado para garantizar que sólo hay una instanciq de Repository
     */
    private UserRepository() {
        this.users = new ArrayList();
        initialize();
    }

    /* MÉTODOS */
    public void initialize() {
        addUser(new User(1, "Moronlu", "12345678", "Lourdes Rodriguez","moronlu18@gmail.com", true,true));
        addUser(new User(2, "EMoreno", "87654321", "Eliseo Moreno","eliseo.moreno@gmail.com", true, false));
        addUser(new User(3, "Sebas", "abcdefgh", "Sebastían Millán","sebas_millan@yahoo.es", false, true));
        addUser(new User(4, "PacoG", "malaga2017", "Paco García","pacog@hotmail.com", false, false));
    }

    /* Patrón Singletón */
    public static jrl.deint.inventoryDataBase.repository.UserRepository getInstance() {
        if(userRepository == null)
            userRepository = new jrl.deint.inventoryDataBase.repository.UserRepository();
        return userRepository;
    }

    /**
     * Método que añade un usuario
     * @param user
     */
    public void addUser(User user) {
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Método que comprueba si el usuario existe en la base de datos
     * @return
     */
    public boolean isUserExists(User user) {
        return true;
    }

    public boolean validateCredentials(String name, String password) {
        User user = new User(0, name, password, null, null, false, false);
        return users.get(users.indexOf(user)).getPassword().equals(password);
    }
}
