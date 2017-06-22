package com.example.am8_adam.test8;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Am8_Adam on 6/2/2017.
 */

public class DatabaseHelper  extends SQLiteOpenHelper{
    private static final int DB_VERSION =1;
    private final static String DB_NAME ="Favourites.db";
    Context mContext ;
    private static  final String Ceate_table="CREATE TABLE " + DatabaseContract.MovieEntry.TABLE_NAME
            + " ("+DatabaseContract.MovieEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ DatabaseContract.MovieEntry.COLUMN_TITLE
            +" VARCHAR(255), " + DatabaseContract.MovieEntry.COLUMN_DESCRIPTION + " VARCHAR(255));";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        //this.mContext=context ;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + DatabaseContract.MovieEntry.TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DatabaseContract.MovieEntry.TABLE_NAME );
        onCreate(sqLiteDatabase);

    }

    public long addFavorite(movie listItem){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
       // values.put(DatabaseContract.MovieEntry.COLUMN_ID, listItem.getId());
        values.put(DatabaseContract.MovieEntry.COLUMN_TITLE, listItem.getHead());
         values.put(DatabaseContract.MovieEntry.COLUMN_DESCRIPTION, listItem.getDescription());
        values.put(DatabaseContract.MovieEntry.COLUMN_RATE, listItem.getDescription());


        long dp=db.insert(DatabaseContract.MovieEntry.TABLE_NAME, null, values);
        return dp;
    }
    public void deleteFavorite(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DatabaseContract.MovieEntry.TABLE_NAME, DatabaseContract.MovieEntry.COLUMN_ID+ "=" + id, null);
    }



}










/*
*    public void addFavorite(movie listItem){
         SQLiteDatabase db = dbhandler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseContract.MovieEntry.COLUMN_ID, listItem.getId());
        values.put(DatabaseContract.MovieEntry.COLUMN_TITLE, listItem.getHead());
        values.put(DatabaseContract.MovieEntry.COLUMN_POSTER, listItem.getImageUrl());
        values.put(DatabaseContract.MovieEntry.COLUMN_DESCRIPTION, listItem.getDescription());
        values.put(DatabaseContract.MovieEntry.COLUMN_RATE, listItem.getVote_average());

        db.insert(DatabaseContract.MovieEntry.TABLE_NAME, null, values);
        db.close();
    }

    public void deleteFavorite(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DatabaseContract.MovieEntry.TABLE_NAME, DatabaseContract.MovieEntry.COLUMN_ID+ "=" + id, null);
    }
*
* */






   /* helper helper;
    public DatabaseHelper(Context context)
    {
        helper =new helper(context);
    }
    public long addFavorite(movie listItem){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseContract.MovieEntry.COLUMN_ID, listItem.getId());
        values.put(DatabaseContract.MovieEntry.COLUMN_TITLE, listItem.getHead());
        values.put(DatabaseContract.MovieEntry.COLUMN_POSTER, listItem.getImageUrl());
        values.put(DatabaseContract.MovieEntry.COLUMN_DESCRIPTION, listItem.getDescription());
        values.put(DatabaseContract.MovieEntry.COLUMN_RATE, listItem.getVote_average());

        long dp=db.insert(DatabaseContract.MovieEntry.TABLE_NAME, null, values);
        return dp;
    }
    public void deleteFavorite(int id){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete(DatabaseContract.MovieEntry.TABLE_NAME, DatabaseContract.MovieEntry.COLUMN_ID+ "=" + id, null);
    }

static class helper extends SQLiteOpenHelper
{


    private static  final String Ceate_table="CREATE TABLE " + DatabaseContract.MovieEntry.TABLE_NAME
            + " ("+DatabaseContract.MovieEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ DatabaseContract.MovieEntry.COLUMN_TITLE
            +" VARCHAR(255), " + DatabaseContract.MovieEntry.COLUMN_DESCRIPTION + " VARCHAR(255));";

    String Create_Table_Movies = "Create Table "+DatabaseContract.MovieEntry.TABLE_NAME
            + "("+DatabaseContract.MovieEntry.COLUMN_ID+" VARCHAR(255) Primary" +
            " Key,"+DatabaseContract.MovieEntry.COLUMN_TITLE+" VARCHAR(255),"+DatabaseContract.MovieEntry.COLUMN_DESCRIPTION+" Varchar(255),"+
            DatabaseContract.MovieEntry.COLUMN_DATE+" VARCHAR(255),"+DatabaseContract.MovieEntry.COLUMN_RATE+" VARCHAR(255),"
            +DatabaseContract.MovieEntry.COLUMN_POSTER+
            " VARCHAR(255));";
    private static final int DB_VERSION =1;
    private final static String DB_NAME ="Favourites.db";
    Context mContext ;


    // SQLiteOpenHelper dbhandler;
    public helper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.mContext=context ;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {



        try {

            sqLiteDatabase.execSQL(Create_Table_Movies);

        }catch (SQLException e)
        {

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {


        try {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.MovieEntry.TABLE_NAME);
            onCreate(sqLiteDatabase);
        }catch (SQLException e)
        {

        }

    }

}

*/












