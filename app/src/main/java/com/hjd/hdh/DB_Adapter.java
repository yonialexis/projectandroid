

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DB_Adapter  {
    DatabaseHelper databaseHelper;
    Context context;
    public DB_Adapter(Context context)
    {
        databaseHelper=new DatabaseHelper(context);
        this.context=context;
    }
    public long Insert(User user)
    {
        Toast.makeText(context,"user has arrived"+user.getEmail(),Toast.LENGTH_SHORT).show();
        SQLiteDatabase sqLiteDatabase=databaseHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(databaseHelper.uid,user.getPhone());
        contentValues.put(databaseHelper.c1,user.getFname());
        contentValues.put(databaseHelper.c2,user.getUsername());
        contentValues.put(databaseHelper.c3,user.getEmail());
        contentValues.put(databaseHelper.c4,user.getPassword());
        contentValues.put(databaseHelper.c5,user.getSex());
        Toast.makeText(context,"ready to insert",Toast.LENGTH_SHORT).show();
        long x=sqLiteDatabase.insert(databaseHelper.table_name,null,contentValues);
        Toast.makeText(context,"returning "+user.getSex(),Toast.LENGTH_SHORT).show();
        return  x;
    }
    public List getData()
    {
        List list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=databaseHelper.getWritableDatabase();
        String[] columns={
                databaseHelper.uid,
                databaseHelper.c1,
                databaseHelper.c2,
                databaseHelper.c3,
                databaseHelper.c4,
                databaseHelper.c5
        };
        Cursor cursor=sqLiteDatabase.query(databaseHelper.table_name,columns,null,null,null,null,null);
        while (cursor.moveToNext())
        {
            String uid=cursor.getString(cursor.getColumnIndex(databaseHelper.uid));
            String fname=cursor.getString(cursor.getColumnIndex(databaseHelper.c1));
            String username=cursor.getString(cursor.getColumnIndex(databaseHelper.c2));
            String email=cursor.getString(cursor.getColumnIndex(databaseHelper.uid));
            String sex=cursor.getString(cursor.getColumnIndex(databaseHelper.c5));
            String password=cursor.getString(cursor.getColumnIndex(databaseHelper.c4));
            User user=new User(uid,fname,username,email,sex,password);
            list.add(user);
        }
        return list;
    }
}
