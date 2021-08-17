package offline_1.sdlab.com.fifaalarm.Database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import android.R.integer;
import android.R.string;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import offline_1.sdlab.com.fifaalarm.Time;


public class DatabaseHandler extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="TimeManager";
    private static final String TABLE_NAME="alarm_time";
    private static final String KEY_ID="id";
    private static final String KEY_YEAR="year";
    private static final String KEY_MONTH="month";
    private static final String KEY_DAY="day";
    private static final String KEY_HOUR="hour";
    private static final String KEY_MINUTE="minute";

    public DatabaseHandler(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        // TODO Auto-generated constructor stub

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        //Log.v("db created", "yes");
        String CREATE_TIME_TABLE="CREATE TABLE "+ TABLE_NAME +"("
                + KEY_ID +" INTEGER PRIMARY KEY,"
                + KEY_YEAR +" TEXT,"+ KEY_MONTH +" TEXT,"+ KEY_DAY +" TEXT,"+ KEY_HOUR +" TEXT,"
                + KEY_MINUTE +" TEXT" +")";
        db.execSQL(CREATE_TIME_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        String sql = "DROP TABLE IF EXISTS Contact";
        db.execSQL(sql);
        onCreate(db);
    }
    public void addTime(Time _time)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "INSERT INTO ALARM_TIME(YEAR,MONTH,DAY,HOUR,MINUTE)" +
                "VALUES('"+_time.getYear()+"','"+_time.getMonth()+"','"+_time.getDay()+"','"+_time.getHour()+"','"+_time.getMinute()+"')";

        //String qry = "INSERT INTO CONTACT(NAME,PHONENO)VALUES('XYZ','016')";
        //db.execSQL(query);

        db.execSQL(query);
        db.close();

    }


    public List<Time> getAllTime()
    {
        List<Time> myTimeList=new ArrayList<Time>();

        String selectquery="SELECT * FROM "+ TABLE_NAME;// where phoneno LIKE '017%'";

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(selectquery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                Time time= new Time(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
                myTimeList.add(time);
            }while(cursor.moveToNext());
        }

        return myTimeList;
    }

    public Cursor getSingleTime()
	{
		SQLiteDatabase db = this.getReadableDatabase();
       // String query = "SELECT ID,NAME,PHONENO FROM CONTACT WHERE ID = "+number;

        String query = "SELECT ID,YEAR,MONTH,DAY,HOUR,MINUTE FROM ALARM_TIME";
		Cursor cursor = db.rawQuery(query, null);
		//Cursor cursor = db.query(TABLE_NAME, new String[] {KEY_ID,KEY_NAME,KEY_CONTACTNO}, "Id=?",new String[]{String.valueOf(id)} ,null, null,null, null);
		//Time myTime = null;
		//if(cursor.moveToFirst())
		//{
          //   myTime= new Time(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
		//}

		//return myTime;
        return cursor;
	}

    public void deleteAll() {
        SQLiteDatabase db=this.getWritableDatabase();
        String query = "DELETE from ALARM_TIME";
        db.execSQL(query);
        db.close();
    }
    public Time  getTime(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT ID,YEAR,MONTH,DAY,HOUR,MINUTE FROM ALARM_TIME WHERE ID = "+id;
        Cursor cursor = db.rawQuery(query, null);
        //Cursor cursor = db.query(TABLE_NAME, new String[] {KEY_ID,KEY_NAME,KEY_CONTACTNO}, "Id=?",new String[]{String.valueOf(id)} ,null, null,null, null);
        Time myTime = null;
        if(cursor.moveToFirst())
        {
            myTime=   new Time(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));  }

        return myTime;
        //return cursor;
    }


     public String getTableName()
        {
            return this.TABLE_NAME;
        }

}

