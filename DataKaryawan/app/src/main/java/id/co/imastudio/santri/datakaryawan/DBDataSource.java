package id.co.imastudio.santri.datakaryawan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Server on 01/08/2017.
 */

class DBDataSource  {
    //inisialisai SQLite database
    private SQLiteDatabase database;

    //inisialisasi kelas dbhelper
    private  DBHelper dbHelper;

    //ambil semua kolom
    private String[] allColumns = { DBHelper.COLUMN_ID, DBHelper.COLUMN_NAME,
        DBHelper.COLUMN_JK, DBHelper.COLUMN_UMUR};
    //DBhelper diinstansiasi pada constructor
    public  DBDataSource(Context context){
        dbHelper = new DBHelper(context);
    }

    //membuka atau membuat sambungan baru ke database
    public void open() throws SQLException{
        database = dbHelper.getWritableDatabase();
    }
    //menutup sambungan ke database
    public void close(){
        dbHelper.close();;
    }
    //mengambil semua data barang
    public ArrayList<Barang> getAllBarang() {
        ArrayList<Barang> daftarBarang = new ArrayList<Barang>();

        // select all SQL query
        Cursor cursor = database.query(DBHelper.TABLE_NAME,
                allColumns, null, null, null, null, null);

        // pindah ke data paling pertama
        cursor.moveToFirst();
        // jika masih ada data, masukkan data barang ke
        // daftar barang
        while (!cursor.isAfterLast()) {
            Barang barang = cursorToBarang(cursor);
            daftarBarang.add(barang);
            cursor.moveToNext();
        }
        // Make sure to close the cursor
        cursor.close();
        return daftarBarang;
    }
    //method ambil satu barang sesuai id
    public  Barang getBarang (long id){
        Barang barang = new Barang(); // inisialiasi barang
        //select query
        Cursor cursor = database.query(DBHelper.TABLE_NAME, allColumns,
                "_id = " +id, null, null, null, null);
        //ambil data yg prtama
        cursor.moveToFirst();
        //masukan data cursong ke objek barang
        barang = cursorToBarang(cursor);
        //ttp smbgn
        cursor.close();
        //lembalikan brg
        return barang;

    }
    //method updte brng yg di edit
    public void updateBarang (Barang b){

        //ambil id barang
        String strFilter = "_id=" + b.getId();
        //masukan ke content values
        ContentValues args = new ContentValues();
        //masukan data sesuai dengan kolom database
        args.put(DBHelper.COLUMN_NAME, b.getNama());
        args.put(DBHelper.COLUMN_JK, b.getJk());
        args.put(DBHelper.COLUMN_UMUR, b.getUmur());
        //update query
        database.update(DBHelper.TABLE_NAME, args,strFilter,null);

    }


    //method untuk create/insert barang ke databse
    public Barang createBarang (String nama, String jk, String umur){
        //membuat sebuh contentvalues yang berfungsu
        //untuk memasangkan data dengan nama2
        //kolom pada databse

        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_NAME, nama);
        values.put(DBHelper.COLUMN_JK, jk);
        values.put(DBHelper.COLUMN_UMUR, umur);

        //mengekseskusi perintah sql insert data
        //yang akn mengmbalikan sebuah insertId
        long insertId = database.insert(DBHelper.TABLE_NAME, null,
                values);
        Cursor cursor = database.query(DBHelper.TABLE_NAME,
                allColumns, DBHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);

        //pindah kedata paling pertama
        cursor.moveToFirst();

        //mengubaha objek pada curso pertama
        //ke dalam objek barang

        Barang newBarang = cursorToBarang (cursor);

        //cloe cursor
        cursor.close();

        //mengembar=likan barang baru
        return newBarang;
    }


    private Barang cursorToBarang(Cursor cursor) {
        //buat objek brg baru
        Barang barang = new Barang();
        //debug logcat
        Log.v("info", "the getLong"+cursor.getLong(0));
        Log.v("info", "The setLatLng"+cursor.getString(1)+","+cursor.getString(2));
        //set atribut pada objek barang dengan
        //data kursor yang di ambil dt dtabse
        barang.setId(cursor.getLong(0));
        barang.setNama(cursor.getString(1));
        barang.setJk(cursor.getString(2));
        barang.setUmur(cursor.getString(3));

        return barang;


    }

}
