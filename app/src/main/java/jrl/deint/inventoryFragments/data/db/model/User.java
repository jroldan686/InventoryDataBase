package jrl.deint.inventoryFragments.data.db.model;

/**
 * Clase POJO que representa la entidad usuario
 * @author Jesús Roldán López
 * @version 1.0
 */

public class User {
    public int _ID;
    public String user;
    public String password;
    public String name;
    public String email;
    public boolean isRoot;
    public boolean isManagement;
    //private ArrayList<Permission> permissions;

    public User(int _ID, String user, String password, String name, String email, boolean isRoot, boolean isManagement) {
        this._ID = _ID;
        this.user = user;
        this.password = password;
        this.name = name;
        this.email = email;
        this.isRoot = isRoot;
        this.isManagement = isManagement;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }

    public boolean isManagement() {
        return isManagement;
    }

    public void setManagement(boolean management) {
        isManagement = management;
    }

    @Override
    public String toString() {
        return getUser();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user1 = (User) o;

        if (!getUser().equals(user1.getUser())) return false;
        return getEmail().equals(user1.getEmail());
    }

    @Override
    public int hashCode() {
        int result = getUser().hashCode();
        result = 31 * result + getEmail().hashCode();
        return result;
    }
}
