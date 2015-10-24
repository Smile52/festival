package db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import bean.SendedMsg;

/**
 * Created by 九龙 on 2015/10/19.
 */
public class SmsDbOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="sms.db";
    private static final int DB_VERSION=1;

    private SmsDbOpenHelper(Context context) {
        super(context.getApplicationContext(), DB_NAME, null, DB_VERSION);
    }
    private static  SmsDbOpenHelper mHelper;
    public  static  SmsDbOpenHelper getInstance(Context context){
        if(mHelper==null){
            synchronized (SmsDbOpenHelper.class){
                if (mHelper==null){
                    mHelper=new SmsDbOpenHelper(context);
                }
            }
        }
        return  mHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table "+ SendedMsg.TABLE_NAME+" (" +
                "_id integer primary key autoincrement ,"+
                SendedMsg.COLUMN_DATE + " integer ,"+
                SendedMsg.COLUMN_MSG + " text ,"+
                SendedMsg.COLUMN_NAMES + " text ,"+
                SendedMsg.COLUMN_FESTIVALNAME + " text ,"+
                SendedMsg.COLUMN_NUMBERS + " text "
                +")";
            System.out.println("111111111111111");
            db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
