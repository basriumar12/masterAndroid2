package id.co.imastudio.santri.datakaryawan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Server on 01/08/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
   //deklarasai konstanta2 yang digunakan pada DB
    public static final String TABLE_NAME ="dataInventori";
    public static final String COLUMN_ID ="_id";
    public static final String COLUMN_NAME ="nama_karyawan";
    public static final String COLUMN_JK = "jenis_kelamin";
    public static final String COLUMN_UMUR = "umur";
    public static final String db_name ="inventori1.db";
    public static final int db_version=1;

    //perintah membuat tabel
    private static final String db_create = "create table "
            + TABLE_NAME + "("
            + COLUMN_ID +" integer primary key autoincrement, "
            + COLUMN_NAME+ " varchar(50) not null, "
            + COLUMN_JK+ " varchar(50) not null, "
            + COLUMN_UMUR+ " varchar(50) not null);";

    public DBHelper(Context context) {
        super(context, db_name, null, db_version);
    }
    //mengeksekusi perintah sql
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(db_create);
    }
        //dijalankan apabilia ingin updgrade database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBHelper.class.getName(),"Upgrading database from version " + oldVersion + "to"
        +newVersion+ ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS" +TABLE_NAME);
        onCreate(db);

    }
}
