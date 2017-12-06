package com.example.jkosterman6222.assignment1;

        import android.arch.persistence.room.Entity;
        import android.arch.persistence.room.ForeignKey;
        import android.arch.persistence.room.Index;
        import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "preferences",
        foreignKeys = {
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "id",
                        childColumns = "userId",
                        onDelete = ForeignKey.CASCADE
                )},
        indices = { @Index(value = "id")}
)
public class Preferences {

    @PrimaryKey(autoGenerate = true)
    long id;

    public long userId;
    String emailString;
    boolean pettyCash;

    public Preferences(long userId, String emailString, Boolean pettyCash) {
        this.userId = userId;
        this.emailString = emailString;
        this.pettyCash = pettyCash;
    }
}