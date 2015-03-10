package com.marshong.packitup.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.marshong.packitup.model.Container;
import com.marshong.packitup.model.Item;

import java.util.Random;

/**
 * Created by martin on 3/10/2015.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String TAG = DBHelper.class.getSimpleName();

    public DBHelper(Context context) {
        super(context, DBContract.DATABASE_NAME, null, DBContract.DB_VERSION);
    }

    //create the tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate " + DBContract.Version1.CREATE_TABLE_LOCATION);
        db.execSQL(DBContract.Version1.CREATE_TABLE_LOCATION);

        Log.d(TAG, "onCreate " + DBContract.Version1.CREATE_TABLE_CONTAINER);
        db.execSQL(DBContract.Version1.CREATE_TABLE_CONTAINER);

        Log.d(TAG, "onCreate " + DBContract.Version1.CREATE_TABLE_ITEM);
        db.execSQL(DBContract.Version1.CREATE_TABLE_ITEM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void insertSampleItems() {
        Log.d(TAG, "inserting sample items");
        for (int i = 0; i < 15; i++) {
            Item item = new Item("itemname" + i, "descr" + i);
            Random rand = new Random();
            String[] locs = new String[]{"Bathroom", "BedRoom", "Living Room", "Backyard", "Frontyard", "Garage", "Kitchen"};
            int containerRef = rand.nextInt(locs.length);
            item.setContainerID(containerRef);
            item.setContainer(locs[containerRef]);
            insertItem(item);
        }
    }

    public void insertItem(Item item) {
        Log.d(TAG, "insertItem " + item);

        SQLiteDatabase db = this.getWritableDatabase();

        //setup the insert values
        ContentValues cv = new ContentValues();
        cv.put(DBContract.Version1.ITEM_NAME, item.getName());
        cv.put(DBContract.Version1.ITEM_DESCR, item.getDescr());
        cv.put(DBContract.Version1.CONTAINER_REF, item.getContainerID());

        //insert the item
        db.insert(DBContract.Version1.ITEM_TABLE, null, cv);

        //close out the DB
        db.close();
    }


    public void insertSampleContainers() {

        Random rand = new Random();
        String[] locs = new String[]{"Bathroom", "BedRoom", "Living Room", "Backyard", "Frontyard", "Garage", "Kitchen"};

        for (int i = 0; i < 10; i++) {
            int locChoice = rand.nextInt(locs.length);
            String location = locs[locChoice];

            Container c = new Container("Container" + i, location, "descr" + i);
            c.setLocationID(locChoice);
            insertContainer(c);
        }
    }

    public void insertContainer(Container container) {
        Log.d(TAG, "insertContainer " + container);

        // get writeable db
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(DBContract.Version1.CONTAINER_NAME, container.getName());
        cv.put(DBContract.Version1.CONTAINER_DESCR, container.getDescr());
        cv.put(DBContract.Version1.CONTAINER_LOCATION, container.getLocation());

        //insert new container
        db.insert(DBContract.Version1.CONTAINER_TABLE, null, cv);

        //close out db
        db.close();
    }


    public void insertSampleLocations() {
        String[] locs = new String[]{"Bathroom", "BedRoom", "Living Room", "Backyard", "Frontyard", "Garage", "Kitchen"};
        for (String str : locs) {
            insertLocation(str);
        }
    }

    public void insertLocation(String location) {
        Log.d(TAG, "insertLocation " + location);

        //get writeable db
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(DBContract.Version1.LOCATION_NAME, location);

        //insert new location
        db.insert(DBContract.Version1.LOCATION_TABLE, null, cv);

        //close
        db.close();
    }


    //-------------------------------------------------------------//
    //these methods below will get a single row from each table
    //-------------------------------------------------------------//

    /*Returns the Unique Item ID from the items table*/
    private int getItemID(Item item) {
        Log.d(TAG, "getItemID " + item);

        int itemID = -1;
        SQLiteDatabase db = this.getReadableDatabase();
        String whereClause = DBContract.Version1.ITEM_NAME + "=?," + DBContract.Version1.CONTAINER_REF + "=?";
        String[] whereArgs = new String[]{item.getName(), Integer.toString(item.getContainerID())};

        Cursor cursor = db.query(DBContract.Version1.ITEM_TABLE, DBContract.Version1.ITEM_PROJECTION, whereClause, whereArgs, null, null, null);
        cursor.moveToFirst();
        itemID = cursor.getInt(0);
        db.close();
        return itemID;
    }

    //returns the unique ID from the location table

    private int getLocationID(String location) {
        Log.d(TAG, "getLocationID " + location);
        int locationID = -1;

        //get the database and setup the query
        SQLiteDatabase db = this.getReadableDatabase();
        String whereClause = DBContract.Version1.LOCATION_NAME + "=?";
        String[] whereArgs = new String[]{location};

        //execute the query and get the location ID from the results
        Cursor cursor = db.query(DBContract.Version1.LOCATION_TABLE, DBContract.Version1.LOCATION_PROJECTION, whereClause, whereArgs, null, null, null);
        cursor.moveToFirst();
        locationID = cursor.getInt(0);  //this should be the Location ID
        db.close();
        return locationID;
    }


    //returns the unique container ID from the container table
    private int getContainerID(Container container) {
        Log.d(TAG, "getContainerID " + container);
        int containerID = -1;

        //get the database and setup the query
        SQLiteDatabase db = this.getReadableDatabase();
        String whereClause = DBContract.Version1.CONTAINER_LOCATION + "=?," +
                DBContract.Version1.CONTAINER_NAME + "=?, " +
                DBContract.Version1.CONTAINER_DESCR + "=?";

        //use the location name to get the unique location ID
        int containerLoc = getLocationID(container.getLocation());
        String[] whereArgs = new String[]{Integer.toString(containerLoc), container.getName(), container.getDescr()};

        //execute the query and get the container ID from the results
        Cursor cursor = db.query(DBContract.Version1.CONTAINER_TABLE, DBContract.Version1.CONTAINER_PROJECTION, whereClause, whereArgs, null, null, null);
        cursor.moveToFirst();
        containerID = cursor.getInt(0); //this should be the container ID

        db.close();
        return containerID;
    }
}
