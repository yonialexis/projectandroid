

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {
    int version=1;
    String uid="uid";
    public  static  final String db_name="mili_database";
    public  static  final String c1="full_name";
    public  static  final String c2="username";
    public  static  final String c3="email";
    public  static  final String c4="password";
    public  static  final String c5="sex";
    public  static  final String table_name="User";
    String create;
    Context context;

    public DatabaseHelper(Context context) {
        super(context, db_name, null, 1);
        create = "CREATE TABLE"+table_name+"("
                +uid+" VARCHAR(20) primary key,"
                +c1+" VARCHAR(20),"
                +c2+" VARCHAR(20),"
                +c3+" VARCHAR(20),"
                +c4+" VARCHAR(20),"
                +c5+" VARCHAR(20))";
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(create);
                Toast.makeText(context,"DB created Successfull",Toast.LENGTH_SHORT).show();
            }catch (Exception e){e.printStackTrace();
                Toast.makeText(context,"can't create DB",Toast.LENGTH_SHORT).show();}
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
