package com.example.myroomdatabase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "workshop")
public class StudentEntity {
    @NonNull
    @ColumnInfo(name = "name")
    String name;
    @PrimaryKey
    @ColumnInfo(name = "rollnumber")
    String rollnumber;
/*right click->generete->getters and setters->select all*/

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(String rollnumber) {
        this.rollnumber = rollnumber;
    }
}
