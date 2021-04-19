package org.brenomachado.notekeeper;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ModuleInfo implements Parcelable{
    private final String mModuleId;
    private final String mTitle;
    private boolean mIsComplete = false;

    public ModuleInfo(String moduleId, String title) {
        this(moduleId, title, false);
    }

    public ModuleInfo(String moduleId, String title, boolean isComplete) {
        mModuleId = moduleId;
        mTitle = title;
        mIsComplete = isComplete;
    }

    private ModuleInfo(Parcel source) {
        mModuleId = source.readString();
        mTitle = source.readString();
        mIsComplete = source.readByte() == 1;
    }

    public String getModuleId() {
        return mModuleId;
    }

    public String getTitle() {
        return mTitle;
    }

    public boolean isComplete() {
        return mIsComplete;
    }

    public void setComplete(boolean complete) {
        mIsComplete = mIsComplete;
    }

    @Override
    public int hashCode() {
        return mModuleId.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        ModuleInfo that = (ModuleInfo) obj;

        return mModuleId.equals(that.mModuleId);
    }

    @NonNull
    @Override
    public String toString() {
        return mTitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mModuleId);
        dest.writeString(mTitle);
        dest.writeByte((byte)(mIsComplete ? 1 : 0));
    }

    public static final Parcelable.Creator<ModuleInfo> CREATOR =
            new Parcelable.Creator<ModuleInfo>() {

                @Override
                public ModuleInfo createFromParcel(Parcel source) {
                    return new ModuleInfo(source);
                }

                @Override
                public ModuleInfo[] newArray(int size) {
                    return new ModuleInfo[size];
                }
            };
}
