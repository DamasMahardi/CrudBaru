package com.example.crudbaru.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.crudbaru.model.Karyawan;

import java.util.ArrayList;
import java.util.List;

public class DataHelper extends SQLiteOpenHelper {
    SQLiteDatabase database;
    private static final String DATABASE_NAME = "db_karyawan";
    private static final String TABLE_KARYAWAN = "tbl_karyawan";
    private static final int DATABASE_VERSION = 1;
    private static final String STD_ID = "id";
    private static final String NAME = "name";
    private static final String JABATAN = "jabatan";
    private static final String ALAMAT = "alamat";
    private static final String EMAIL = "email";
    private static final String TELEPHONE = "telephone";
    private static final String queryCreateTable = "CREATE TABLE " + TABLE_KARYAWAN + "(" + STD_ID + " INTEGER PRIMARY KEY," + NAME + "TEXT," + JABATAN + "TEXT," + ALAMAT + "TEXT," + EMAIL + "TEXT," + TELEPHONE + "INTEGER" + ")";


    public DataHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,  null,DATABASE_VERSION);
    }

    public DataHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(queryCreateTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +NAME);
        onCreate(db);

    }
    public void createKaryawan(Karyawan karyawan){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(STD_ID, karyawan.getId());
        values.put(NAME, karyawan.getName());
        values.put(JABATAN, karyawan.getJabatan());
        values.put(ALAMAT,karyawan.getAlamat());
        values.put(EMAIL, karyawan.getEmail());
        values.put(TELEPHONE, karyawan.getTelephone());

        database.insert(TABLE_KARYAWAN, null,values);
        database.close();
    }

    public void updateKaryawan( long l,String name, String  jabatan, String alamat, String email, String telephone ){
        database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(JABATAN, jabatan);
        values.put(ALAMAT, alamat);
        values.put(EMAIL, email);
        values.put(TELEPHONE, telephone);
        database.update(TABLE_KARYAWAN, values, STD_ID+" = "+ l , null);
        database.close();
    }

    public int deleteKaryawan(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete(TABLE_KARYAWAN, STD_ID+" = ? ", new String[] {id});
    }

    public List<Karyawan> readDataKaryawan(){
        List<Karyawan> list = new ArrayList<Karyawan>();
        String selectQuery = "SELECT * FROM " +TABLE_KARYAWAN;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                Karyawan karyawan = new Karyawan();
                karyawan.setId(cursor.getString(0));
                karyawan.setName(cursor.getString(1));
                karyawan.setJabatan(cursor.getString(2));
                karyawan.setAlamat(cursor.getString(3));
                karyawan.setEmail(cursor.getString(4));
                karyawan.setJabatan(cursor.getString(5));
            }while (cursor.moveToNext());
        }
        database.close();
        return list;

    }

    public  String getName(long l){
        database = this.getReadableDatabase();
        String[] columns = new String[]{STD_ID, NAME,JABATAN,ALAMAT,EMAIL,TELEPHONE};
        Cursor cursor = database.query(TABLE_KARYAWAN, columns, STD_ID+ "="+l, null,null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
            String name = cursor.getString(1);
            return name;
        }
        return null;

    }

    public String getJabatan(long l){
        database = this.getReadableDatabase();
        String [] columns = new String[]{STD_ID, NAME, JABATAN,ALAMAT, EMAIL,TELEPHONE};
        Cursor cursor = database.query(TABLE_KARYAWAN, columns, STD_ID+ "=" +l , null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
            String jabatan = cursor.getString( 2);
            return  jabatan;
        }
        return  null;
    }

    public  String getAlamat(long l){
        database = this.getReadableDatabase();
        String [] columns = new String[]{STD_ID, NAME, JABATAN, ALAMAT, EMAIL,TELEPHONE};
        Cursor cursor = database.query(TABLE_KARYAWAN, columns, STD_ID+"="+l, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
            String alamat = cursor.getString(3);
            return  alamat;
        }
        return  null;
    }

    public  String getEmail(long l){
        database = this.getReadableDatabase();
        String[] columns = new String[]{STD_ID, NAME, JABATAN,ALAMAT,EMAIL, TELEPHONE};
        Cursor cursor = database.query(TABLE_KARYAWAN,columns, STD_ID+ "="+l, null, null,null,null);
        if (cursor !=null){
            cursor.moveToFirst();
            String email = cursor.getString(4);
            return  email;
        }
        return null;
    }
    public String getTelephone(long l){
        database = this.getReadableDatabase();
        String[] columns = new String[] {STD_ID, NAME, JABATAN,ALAMAT,EMAIL,TELEPHONE};
        Cursor cursor = database.query(TABLE_KARYAWAN, columns, STD_ID+"="+l, null, null,null,null);
        if (cursor != null){
            cursor.moveToFirst();
            String telephone = cursor.getString(5);
            return  telephone;

        }
        return null;
    }



}
