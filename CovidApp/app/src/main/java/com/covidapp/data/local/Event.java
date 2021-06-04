package com.example.covidapp.data.local;

import android.os.Parcel;
import android.os.Parcelable;

public class Event implements Parcelable {
    String date, name, description, location;

    protected Event(Parcel in) {
        date = in.readString();
        name = in.readString();
        description = in.readString();
        location = in.readString();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public Event() {

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Event(String date, String name, String description, String location) {
        this.date = date;
        this.name = name;
        this.description = description;
        this.location = location;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.name);
    dest.writeString(this.date);
    dest.writeString(this.location);
    dest.writeString(this.description);

    }
}

