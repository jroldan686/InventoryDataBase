package jrl.deint.inventoryFragments.data.db.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by usuario on 30/10/17.
 */

public class Section implements Parcelable {
    private int _ID;
    private String name;
    private String shortname;
    private String description;
    private int dependencyId;
    private boolean enabled;
    private boolean _default;
    public static final String TAG = "section";

    public Section(int _ID, String name, String shortname, String description, int dependencyId, boolean enabled, boolean _default) {
        this._ID = _ID;
        this.name = name;
        this.shortname = shortname;
        this.description = description;
        this.dependencyId = dependencyId;
        this.enabled = enabled;
        this._default = _default;
    }

    protected Section(Parcel in) {
        _ID = in.readInt();
        name = in.readString();
        shortname = in.readString();
        description = in.readString();
        dependencyId = in.readInt();
        enabled = in.readByte() != 0;
        _default = in.readByte() != 0;
    }

    public static final Creator<Section> CREATOR = new Creator<Section>() {
        @Override
        public Section createFromParcel(Parcel in) {
            return new Section(in);
        }

        @Override
        public Section[] newArray(int size) {
            return new Section[size];
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

    public int getDependencyId() {
        return dependencyId;
    }

    public void setDependencyId(int dependencyId) {
        this.dependencyId = dependencyId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isDefault() {
        return _default;
    }

    public void setDefault(boolean _default) {
        this._default = _default;
    }

    @Override
    public String toString() {
        return getShortname();
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
        dest.writeInt(dependencyId);
        //dest.writeByte(enabled);
        //dest.writeByte(_default);
    }
}
