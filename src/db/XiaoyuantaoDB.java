package db;

import java.util.ArrayList;
import java.util.List;

import model.Goods;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class XiaoyuantaoDB {
	public static final String DB_NAME = "goods_db";//数据库名
	
	public static final int VERSION = 1;//数据库版本
	
	private static XiaoyuantaoDB xiaoyuantaoDB;
	
	private SQLiteDatabase db;
private XiaoyuantaoDB(Context context){
	XiaoyuantaoOpenHelper dbHelper = new XiaoyuantaoOpenHelper(context,
			DB_NAME, null, VERSION);
	db = dbHelper.getWritableDatabase();
}
public synchronized static XiaoyuantaoDB getInstance(Context context){
	if(xiaoyuantaoDB == null){
		xiaoyuantaoDB = new XiaoyuantaoDB(context);
	}
	return xiaoyuantaoDB;
}
public void saveGoods(Goods goods){
	if(goods !=null){
		ContentValues values = new ContentValues();
		values.put("goods_name", goods.getName());
		values.put("goods_price", goods.getPrice());
		values.put("goods_describe", goods.getDescribe());
		db.insert("Goods", null, values);
	}
}
//从数据库中读取数据
public List<Goods> loadGoods(){
	List<Goods> list = new ArrayList<Goods>();
	Cursor cursor = db
			.query("Goods", null, null, null, null, null, null);
	if(cursor.moveToFirst()){
		do{
			Goods goods = new Goods();
			goods.setId(cursor.getInt(cursor.getColumnIndex("id")));
			goods.setName(cursor.getString(cursor.
					getColumnIndex("goods_name")));
			goods.setPrice(cursor.getInt(cursor.
					getColumnIndex("goods_price")));
			goods.setDescribe(cursor.getString(cursor.
					getColumnIndex("goods_describe")));
			list.add(goods);
		} while (cursor.moveToNext());
	}
	if(cursor !=null){
		cursor.close();
	}
	return list;
}
}
