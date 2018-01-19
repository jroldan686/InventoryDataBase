package jrl.deint.inventoryDataBase.data.db.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * Created by usuario on 25/10/17.
 */

public class Dependency implements Comparable, Parcelable {
    private int _ID;
    private String name;
    private String shortname;
    private String description;
    public static final String TAG = "dependency";

    // Forma alternativa de declarar los Comparator
    public static final Comparator<Dependency> COMPARATOR_ID = new Comparator<Dependency>() {
        @Override
        public int compare(Dependency dependency, Dependency dependency2) {
            return dependency.get_ID() > dependency2.get_ID() ? 1: -1;
        }
    };
    public static final Comparator<Dependency> COMPARATOR_ID_DESC = new Comparator<Dependency>() {
        @Override
        public int compare(Dependency dependency, Dependency dependency2) {
            return dependency.get_ID() < dependency2.get_ID() ? 1: -1;
        }
    };
    public static final Comparator<Dependency> COMPARATOR_NAME = new Comparator<Dependency>() {
        @Override
        public int compare(Dependency dependency, Dependency dependency2) {
            return dependency.getName().compareToIgnoreCase(dependency2.getName());
        }
    };
    public static final Comparator<Dependency> COMPARATOR_NAME_DESC = new Comparator<Dependency>() {
        @Override
        public int compare(Dependency dependency, Dependency dependency2) {
            return -1 * dependency.getName().compareToIgnoreCase(dependency2.getName());
        }
    };

    public Dependency(int _ID, String name, String shortname, String description) {
        this._ID = _ID;
        this.name = name;
        this.shortname = shortname;
        this.description = description;
    }

    protected Dependency(Parcel in) {
        _ID = in.readInt();
        name = in.readString();
        shortname = in.readString();
        description = in.readString();
    }

    public static final Creator<Dependency> CREATOR = new Creator<Dependency>() {
        @Override
        public Dependency createFromParcel(Parcel in) {
            return new Dependency(in);
        }

        @Override
        public Dependency[] newArray(int size) {
            return new Dependency[size];
        }
    };

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return getShortname();
    }

    @Override
    public boolean equals(Object obj) {
        Dependency dependency = (Dependency) obj;
        boolean result = true;

        if (!name.equals(dependency.getName()))
            result = false;
        else if (!shortname.equals(dependency.getShortname()))
            result = false;

        return result;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        return name.compareTo(((Dependency)o).getName());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_ID);
        dest.writeString(name);
        dest.writeString(shortname);
        dest.writeString(description);
    }

    public static class DependencyOrderByShortName implements Comparator<Dependency> {

        @Override
        public int compare(Dependency d1, Dependency d2) {
            return d1.getShortname().compareTo(d2.getShortname());
        }
    }

    public static class DependencyOrderByName implements Comparator<Dependency> {

        @Override
        public int compare(Dependency o1, Dependency o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    public static class DependencyOrderById implements Comparator<Dependency> {

        @Override
        public int compare(Dependency o1, Dependency o2) {
            //Devuelve positivo si el objeto es mayor que el argumento
            return o1.get_ID() - o2.get_ID() ;
        }
    }

}
