package com.lapism.searchview;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.lapism.searchview.dto.Family;
import com.lapism.searchview.dto.Personal;
import com.lapism.searchview.dto.User;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class DBManager {
	private DBHelper helper;
	private SQLiteDatabase db;

	public DBManager(Context context) {
		helper = new DBHelper(context);
		db = helper.getWritableDatabase();
	}

	/**
	 * add persons
	 * 
	 * @param persons
	 */


	public void addPersonal(List<Personal> personals) {
		db.beginTransaction(); // ��ʼ����
		try {
			for (Personal personal : personals) {
				// 14���ֶ�
				db.execSQL("REPLACE INTO personal VALUES(?, ?,?,?,?,?,   ?,?,?,?,?  ,?,?,?,?,?  ,?,?)",
						new Object[] { personal.getEdit_gmcfzh(), null, personal.getEdit_cbrxm(),
								personal.getEdit_zjlx(), personal.getEdit_gmcfzh(), personal.getEdit_mz(),
								personal.getEdit_xb(), personal.getEdit_csrq(), personal.getEdit_cbrylb(),
								personal.getEdit_cbrq(), personal.getEdit_yhzgx(), personal.getEdit_lxdh(),
								personal.getEdit_xxjzdz(), personal.getEdit_hkxz(), personal.getEdit_jf(),
								personal.getHZSFZ(), personal.getIsEdit(), personal.getIsUpload() });
			}
			db.setTransactionSuccessful(); // ��������ɹ����
		} finally {
			db.endTransaction(); // ��������
		}
	}

	public void addFamily(List<Family> familys) {
		db.beginTransaction(); // ��ʼ����
		try {
			// 9���ֶ�
			for (Family family : familys) {
				db.execSQL("REPLACE INTO family VALUES(?, ?,?,?,?,?   ,?,?,?,?,?,  ?,?)",
						new Object[] { family.getEdit_gmcfzh(), null, family.getEdit_hzxm(), family.getEdit_jhzzjlx(),
								family.getEdit_gmcfzh(), null, family.getEdit_cjqtbxrs(), family.getEdit_lxdh(),
								family.getEdit_hkxxdz(), family.getEdit_djrq(), family.getIsEdit(), family.isUpload,
								family.xzqh });
			}
			db.setTransactionSuccessful(); // ��������ɹ����
		} finally {
			db.endTransaction(); // ��������
		}
	}

	/**
	 * update family
	 * 
	 * @param family
	 */

	/*
	 * public void updateFamily(Family family) { ContentValues cv = new
	 * ContentValues(); cv.put("AAB400", family.getEdit_hzxm());
	 * cv.put("AAE135", family.getEdit_gmcfzh()); cv.put("AAC058",
	 * family.getEdit_jhzzjlx()); cv.put("BAB041", family.getEdit_cjqtbxrs());
	 * cv.put("AAE005", family.getEdit_lxdh()); cv.put("AAE006",
	 * family.getEdit_hkxxdz()); cv.put("AAB050", family.getEdit_djrq());
	 * 
	 * cv.put("ISEDIT", family.getIsEdit()); cv.put("ISUPLOAD",
	 * family.getIsUpload());
	 * 
	 * db.update("family", cv, "_id = ?", new String[] {
	 * String.valueOf(family.getId()) }); }
	 */

	/**
	 * update personal
	 * 
	 * @param personal
	 */
	public void updatePersonal(Personal personal) {
		ContentValues cv = new ContentValues();
		cv.put("AAC003", personal.getEdit_cbrxm());
		cv.put("AAE135", personal.getEdit_gmcfzh());
		cv.put("AAC005", personal.getEdit_mz());
		cv.put("AAC004", personal.getEdit_xb());
		cv.put("AAC006", personal.getEdit_csrq());
		cv.put("BAC067", personal.getEdit_cbrylb());

		cv.put("AAC030", personal.getEdit_cbrq());
		cv.put("AAC069", personal.getEdit_yhzgx());
		cv.put("AAE006", personal.getEdit_xxjzdz());
		cv.put("AAC009", personal.getEdit_hkxz());
		cv.put("HZSFZ", personal.getHZSFZ());

		cv.put("AAC058", personal.getEdit_zjlx());
		cv.put("AAE005", personal.getEdit_lxdh());

		cv.put("JFBZ", personal.getEdit_jf());

		cv.put("ISEDIT", personal.getIsEdit());
		cv.put("ISUPLOAD", personal.getIsUpload());

		db.update("personal", cv, "_id = ?", new String[] { String.valueOf(personal.getId()) });
	}

	/**
	 * delete old family
	 * 
	 * @param family
	 */
	public void deleteFamily(Family family) {
		db.delete("family", "_id = ?", new String[] { family.id });
	}

	/**
	 * delete old personal
	 * 
	 * @param personal
	 */
	public void deletePersonal(Personal personal) {
		db.delete("personal", "_id = ?", new String[] { personal.id });
	}

	/*
	 * ��ͥ��Ϣ ��� �ֶ����� ���� ���� ���� �ǿ� ��ע AAB999 ��ͥ��� Varchar2 16 Ϊ�մ����µǼǼ�ͥ
	 * getEdit_hzxm AAB400 �������� Varchar2 50 �� AAC058 ����֤������ Varchar2 3 �� �������
	 * getEdit_gmcfzh AAE135 ����֤������ Varchar2 20 �� AAB401 ������� Varchar2 20
	 * getEdit_cjqtbxrs BAB041 �α����� number 3 getEdit_lxdh AAE005 ��ϵ�绰 Varchar2
	 * 50 getEdit_hkxxdz AAE006 סַ Varchar2 100 getEdit_djrq AAB050 �Ǽ�����
	 * Varchar2 10 �� ��ʽ��yyyymmdd
	 * 
	 * ��Ա��Ϣ ��� �ֶ����� ���� ���� ���� �ǿ� ��ע AAC999 ���˱�� Varchar2 16 Ϊ�մ����µǼ���Ա
	 * getEdit_cbrxm AAC003 ���� Varchar2 50 �� AAC058 ֤������ Varchar2 3 �� �������
	 * getEdit_gmcfzh AAE135 ������ݺ��� Varchar2 20 �� getEdit_mz AAC005 ���� Varchar2
	 * 3 �� �������
	 * 
	 * getEdit_xb AAC004 �Ա� Varchar2 3 �� ������� getEdit_csrq AAC006 �������� Varchar2
	 * 10 �� ��ʽ��yyyymmdd getEdit_cbrylb BAC067 �α���Ա��� Varchar2 3 �� �������
	 * getEdit_cbrq AAC030 �Ǽ����� Varchar2 10 �� ��ʽ��yyyymmdd getEdit_yhzgx AAC069
	 * �뻧����ϵ Varchar2 3 �������
	 * 
	 * AAE005 ��ϵ�绰 Varchar2 50 getEdit_xxjzdz AAE006 סַ Varchar2 100
	 * getEdit_hkxz AAC009 �������� Varchar2 3 ������� getHZSFZ HZSFZ ������ݺ��� Varchar2
	 * 20 ��
	 */
	/**
	 * query all persons, return list
	 * 
	 * @return List<Person>
	 */
	public List<User> queryUser() {
		ArrayList<User> users = new ArrayList<User>();
		Cursor c = queryTheCursor("user");
		while (c.moveToNext()) {
			User user = new User();
			user._id = c.getInt(c.getColumnIndex("_id"));
			user.username = c.getString(c.getColumnIndex("username"));
			user.password = c.getString(c.getColumnIndex("password"));
			users.add(user);
		}
		c.close();
		return users;
	}

	public ArrayList<Family> queryFamily() {
		ArrayList<Family> familys = new ArrayList<Family>();
		Cursor c = queryTheCursor("family");
		while (c.moveToNext()) {
			Family family = new Family();
			family.id = c.getString(c.getColumnIndex("_id"));
			family.edit_jtbh = c.getString(c.getColumnIndex("AAB999"));
			family.edit_hzxm = c.getString(c.getColumnIndex("AAB400"));
			family.edit_gmcfzh = c.getString(c.getColumnIndex("AAE135"));
			family.edit_jhzzjlx = c.getString(c.getColumnIndex("AAC058"));
			family.edit_hjbh = c.getString(c.getColumnIndex("AAB401"));
			family.edit_cjqtbxrs = c.getString(c.getColumnIndex("BAB041"));
			family.edit_lxdh = c.getString(c.getColumnIndex("AAE005"));
			family.edit_hkxxdz = c.getString(c.getColumnIndex("AAE006"));
			family.edit_djrq = c.getString(c.getColumnIndex("AAB050"));
			family.xzqh = c.getString(c.getColumnIndex("XZQH"));
			family.isEdit = c.getString(c.getColumnIndex("ISEDIT"));
			family.isUpload = c.getString(c.getColumnIndex("ISUPLOAD"));
			familys.add(family);
		}
		c.close();
		return familys;
	}
	
	public ArrayList<SearchItem> querySearchItem() {
		ArrayList<SearchItem> familys = new ArrayList<SearchItem>();
		String sql = "Select AAE135 from family";
		Cursor c = db.rawQuery(sql, null);
		while (c.moveToNext()) {
			SearchItem family = new SearchItem();
			//户主为0
			family.set_icon(R.drawable.yezhu);
			family.set_text(c.getString(c.getColumnIndex("AAE135")));
			familys.add(family);
		}
		c.close();
		return familys;
	}
	
	public ArrayList<Family> queryFamily(String XZQH) {
		ArrayList<Family> familys = new ArrayList<Family>();
		String sql = " Select * from family where XZQH='" + XZQH + "'";
		Cursor c = db.rawQuery(sql, null);
		while (c.moveToNext()) {
			Family family = new Family();
			family.id = c.getString(c.getColumnIndex("_id"));
			family.edit_jtbh = c.getString(c.getColumnIndex("AAB999"));
			family.edit_hzxm = c.getString(c.getColumnIndex("AAB400"));
			family.edit_gmcfzh = c.getString(c.getColumnIndex("AAE135"));
			family.edit_jhzzjlx = c.getString(c.getColumnIndex("AAC058"));
			family.edit_hjbh = c.getString(c.getColumnIndex("AAB401"));
			family.edit_cjqtbxrs = c.getString(c.getColumnIndex("BAB041"));
			family.edit_lxdh = c.getString(c.getColumnIndex("AAE005"));
			family.edit_hkxxdz = c.getString(c.getColumnIndex("AAE006"));
			family.edit_djrq = c.getString(c.getColumnIndex("AAB050"));
			family.xzqh = c.getString(c.getColumnIndex("XZQH"));
			family.isEdit = c.getString(c.getColumnIndex("ISEDIT"));
			family.isUpload = c.getString(c.getColumnIndex("ISUPLOAD"));
			familys.add(family);
		}
		c.close();
		return familys;
	}
	
	

	/*
	 * ��Ա��Ϣ ��� �ֶ����� ���� ���� ���� �ǿ� ��ע AAC999 ���˱�� Varchar2 16 Ϊ�մ����µǼ���Ա
	 * getEdit_cbrxm AAC003 ���� Varchar2 50 �� AAC058 ֤������ Varchar2 3 �� �������
	 * getEdit_gmcfzh AAE135 ������ݺ��� Varchar2 20 �� getEdit_mz AAC005 ���� Varchar2
	 * 3 �� �������
	 * 
	 * getEdit_xb AAC004 �Ա� Varchar2 3 �� ������� getEdit_csrq AAC006 �������� Varchar2
	 * 10 �� ��ʽ��yyyymmdd getEdit_cbrylb BAC067 �α���Ա��� Varchar2 3 �� �������
	 * getEdit_cbrq AAC030 �Ǽ����� Varchar2 10 �� ��ʽ��yyyymmdd getEdit_yhzgx AAC069
	 * �뻧����ϵ Varchar2 3 �������
	 * 
	 * AAE005 ��ϵ�绰 Varchar2 50 getEdit_xxjzdz AAE006 סַ Varchar2 100
	 * getEdit_hkxz AAC009 �������� Varchar2 3 ������� getHZSFZ HZSFZ ������ݺ��� Varchar2
	 * 20 ��
	 */
	public ArrayList<Personal> queryPersonal() {
		ArrayList<Personal> personals = new ArrayList<Personal>();
		Cursor c = queryTheCursor("personal");
		if (c != null) {
			while (c.moveToNext()) {
				Personal personal = new Personal();
				personal.id = c.getString(c.getColumnIndex("_id"));
				personal.edit_cbrxm = c.getString(c.getColumnIndex("AAC003"));
				personal.edit_gmcfzh = c.getString(c.getColumnIndex("AAE135"));
				personal.edit_mz = c.getString(c.getColumnIndex("AAC005"));
				personal.edit_xb = c.getString(c.getColumnIndex("AAC004"));
				personal.edit_csrq = c.getString(c.getColumnIndex("AAC006"));
				personal.edit_cbrylb = c.getString(c.getColumnIndex("BAC067"));
				personal.edit_cbrq = c.getString(c.getColumnIndex("AAC030"));
				personal.edit_yhzgx = c.getString(c.getColumnIndex("AAC069"));
				personal.edit_xxjzdz = c.getString(c.getColumnIndex("AAE006"));
				personal.edit_hkxz = c.getString(c.getColumnIndex("AAC009"));
				personal.edit_jf = c.getString(c.getColumnIndex("JFBZ"));

				personal.HZSFZ = c.getString(c.getColumnIndex("HZSFZ"));

				personal.edit_zjlx = c.getString(c.getColumnIndex("AAC058"));
				personal.edit_lxdh = c.getString(c.getColumnIndex("AAE005"));
				personals.add(personal);
			}
			c.close();
		}

		return personals;
	}

	public ArrayList<Personal> queryPersonal(String HZSFZ) {
		ArrayList<Personal> personals = new ArrayList<Personal>();
		String sql = " Select * from personal where HZSFZ='" + HZSFZ + "'";
		Cursor c = db.rawQuery(sql, null);
		if (c != null) {
			while (c.moveToNext()) {
				Personal personal = new Personal();
				personal.id = c.getString(c.getColumnIndex("_id"));
				personal.edit_cbrxm = c.getString(c.getColumnIndex("AAC003"));
				personal.edit_gmcfzh = c.getString(c.getColumnIndex("AAE135"));
				personal.edit_mz = c.getString(c.getColumnIndex("AAC005"));
				personal.edit_xb = c.getString(c.getColumnIndex("AAC004"));
				personal.edit_csrq = c.getString(c.getColumnIndex("AAC006"));
				personal.edit_cbrylb = c.getString(c.getColumnIndex("BAC067"));
				personal.edit_cbrq = c.getString(c.getColumnIndex("AAC030"));
				personal.edit_yhzgx = c.getString(c.getColumnIndex("AAC069"));
				personal.edit_xxjzdz = c.getString(c.getColumnIndex("AAE006"));
				personal.edit_hkxz = c.getString(c.getColumnIndex("AAC009"));
				personal.edit_jf = c.getString(c.getColumnIndex("JFBZ"));

				personal.HZSFZ = c.getString(c.getColumnIndex("HZSFZ"));

				personal.edit_zjlx = c.getString(c.getColumnIndex("AAC058"));
				personal.edit_lxdh = c.getString(c.getColumnIndex("AAE005"));
				personals.add(personal);
			}
			c.close();
		}

		return personals;
	}

	// ��ѯ�����ֶ�2016��10��13��17:36:11
	public String query_usern(Context context, String biaoming) {
		String userName = "";
		String sql = " Select * from user where username='" + biaoming + "'";

		Cursor c = db.rawQuery(sql, null);
		if (c != null) {
			while (c.moveToNext()) {
				userName = c.getString(c.getColumnIndex("username"));
			}
			c.close();
		}

		return userName;

	}

	/**
	 * query all persons, return cursor
	 * 
	 * @return Cursor
	 */
	public Cursor queryTheCursor(String name) {
		Cursor c = null;
		switch (name) {
		case "user":
			c = db.rawQuery("SELECT * FROM user", null);
			break;
		case "family":
			c = db.rawQuery("SELECT * FROM family", null);
			break;
		case "personal":
			c = db.rawQuery("SELECT * FROM personal", null);
			break;
		default:
			System.out.println("Cursor error");
		}

		return c;
	}

	/**
	 * close database
	 */
	public void closeDB() {
		db.close();
	}

}
