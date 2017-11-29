package jrl.deint.inventoryFragments.data.db.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Clase POJO que representa la entidad usuario
 * @author Jesús Roldán López
 * @version 1.0
 */

public class User implements Parcelable {
    public int _ID;
    public String user;
    public String password;
    public String name;
    public String email;
    public boolean isRoot;
    public boolean isManagement;
    //private ArrayList<Permission> permissions;
    public static final String TAG = "user";

    public User(int _ID, String user, String password, String name, String email, boolean isRoot, boolean isManagement) {
        this._ID = _ID;
        this.user = user;
        this.password = password;
        this.name = name;
        this.email = email;
        this.isRoot = isRoot;
        this.isManagement = isManagement;
    }

    protected User(Parcel in) {
        _ID = in.readInt();
        user = in.readString();
        password = in.readString();
        name = in.readString();
        email = in.readString();
        isRoot = in.readByte() != 0;
        isManagement = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_ID);
        dest.writeString(user);
        dest.writeString(password);
        dest.writeString(name);
        dest.writeString(email);
        dest.writeByte((byte) (isRoot ? 1 : 0));
        dest.writeByte((byte) (isManagement ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

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
