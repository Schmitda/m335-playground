package ch.example.playground.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import ch.example.playground.model.UserModel;

public class UserHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "user.db";
    private static final String TABLE_CREATE = "CREATE TABLE user (" +
            " _id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " firstName TEXT NOT NULL," +
            " lastName TEXT NOT NULL," +
            " password TEXT NOT NULL," +
            " comment TEXT NOT NULL," +
            " email TEXT NOT NULL," +
            " username TEXT NOT NULL);";

    public UserHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("User - DB", "Upgrade der Datenbank von Version " +
                oldVersion + "zu" +
                newVersion + "; Alle Daten wurden gelöscht");
    }


    public void save(UserModel user) {
        long rowId = -1;
        try {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("_id", user._id);
            values.put("firstName", user.getFirstName());
            values.put("lastName", user.getLastName());
            values.put("password", user.getPassword());
            values.put("comment", user.getComment());
            values.put("email", user.getEmail());
            values.put("username", user.getUserName());
            db.insert("user", null, values);
        } catch (SQLException e) {
            Log.e("USER", "Insert", e);
        }
    }

}
