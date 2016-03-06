package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class XiaoyuantaoOpenHelper extends SQLiteOpenHelper {

	public static final String CREATE_GOODS = "create table Goods("
    		+"id integer primary key autoincrement,"
    		+"goods_name text,"
    		+"goods_price integer,"
    		+"goods_describe text)";
    //可再添加商品图片
	public XiaoyuantaoOpenHelper(Context context, String name, CursorFactory
			 factory, int version){
		super(context, name, factory, version);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_GOODS);//创建商品表

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
    
}
