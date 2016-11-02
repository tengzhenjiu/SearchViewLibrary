package com.lapism.searchview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
��ͥ��Ϣ
���	�ֶ�����	����	����	����	�ǿ�	��ע
	AAB999	��ͥ���	Varchar2	16		Ϊ�մ����µǼǼ�ͥ
	AAB400	��������	Varchar2	50	��	
	AAC058	����֤������	Varchar2	3	��	�������
	AAE135	����֤������	Varchar2	20	��	
	AAB401	�������	Varchar2	20		
	BAB041	�α�����	number	3		
	AAE005	��ϵ�绰	Varchar2	50		
	AAE006	סַ	Varchar2	100		
	AAB050	�Ǽ�����	Varchar2	10	��	��ʽ��yyyymmdd

��Ա��Ϣ
���	�ֶ�����	����	����	����	�ǿ�	��ע
	AAC999	���˱��	Varchar2	16		Ϊ�մ����µǼ���Ա
	AAC003	����	Varchar2	50	��	
	AAC058	֤������	Varchar2	3	��	�������
	AAE135	������ݺ���	Varchar2	20	��	
	AAC005	����	Varchar2	3	��	�������
	AAC004	�Ա�	Varchar2	3	��	�������
	AAC006	��������	Varchar2	10	��	��ʽ��yyyymmdd
	BAC067	�α���Ա���	Varchar2	3	��	�������
	AAC030	�Ǽ�����	Varchar2	10	��	��ʽ��yyyymmdd
	AAC069	�뻧����ϵ	Varchar2	3		�������
	AAE005	��ϵ�绰	Varchar2	50		
	AAE006	סַ	Varchar2	100		
	AAC009	��������	Varchar2	3		�������
	HZSFZ	������ݺ���	Varchar2	20	��	*/

public class DBHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "test.db";
	private static final int DATABASE_VERSION = 11;

	public DBHelper(Context context) {
		// CursorFactory����Ϊnull,ʹ��Ĭ��ֵ
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// ���ݿ��һ�α�����ʱonCreate�ᱻ����
	@Override
	public void onCreate(SQLiteDatabase db) {
		CreatTable(db);
	
	}

	// ���DATABASE_VERSIONֵ����Ϊ2,ϵͳ�����������ݿ�汾��ͬ,�������onUpgrade
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		CreatTable(db);
	}
	
	void CreatTable(SQLiteDatabase db)
	{
		db.execSQL("CREATE TABLE IF NOT EXISTS user"
				+ "(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ " taskid VARCHAR,"
				+ " cjarea VARCHAR,"
				+ "account VARCHAR,"
				+ "city VARCHAR,"
				+ "validcfcburl VARCHAR,"
				+ "sfcl VARCHAR,"
				+ "taskdesc VARCHAR,"
				+ "taskstatus VARCHAR,"
				+ "downloadflag VARCHAR,"
				+ "uploadflag VARCHAR)");

		db.execSQL("CREATE TABLE IF NOT EXISTS family"
				+ "(_id VARCHAR PRIMARY KEY, "
				+ "AAB999 VARCHAR, "
				+ "AAB400 VARCHAR  NOT NULL,"
				+ "AAC058 VARCHAR  NOT NULL, "
				+ "AAE135 VARCHAR  NOT NULL, "
				+ "AAB401 VARCHAR, "
				+ "BAB041 VARCHAR, "
				+ "AAE005 VARCHAR, "
				+ "AAE006 VARCHAR,"
				+ "AAB050 VARCHAR  NOT NULL,"
				+ "ISEDIT VARCHAR NOT��NULL,"
				+ "ISUPLOAD VARCHAR NOT NULL,"
				+ "XZQH VARCHAR��NOT NULL)");

		db.execSQL("CREATE TABLE IF NOT EXISTS personal"
				+ "(_id VARCHAR PRIMARY KEY,"
				+ "AAC999 VARCHAR, "
				+ "AAC003 VARCHAR  NOT NULL, "
				+ "AAC058 VARCHAR  NOT NULL, "
				+ "AAE135 VARCHAR  NOT NULL, "
				+ "AAC005 VARCHAR  NOT NULL, "
				+ "AAC004 VARCHAR  NOT NULL, "
				+ "AAC006 VARCHAR  NOT NULL, "
				+ "BAC067 VARCHAR  NOT NULL, "
				+ "AAC030 VARCHAR  NOT NULL,"
				+ "AAC069 VARCHAR,"
				+ "AAE005 VARCHAR,"
				+ "AAE006 VARCHAR,"
				+ "AAC009 VARCHAR,"
				+ "JFBZ VARCHAR,"
				+ "HZSFZ VARCHAR  NOT NULL,"
				+ "ISEDIT VARCHAR NOT��NULL,"
				+ "ISUPLOAD VARCHAR NOT NULL)");
	}
}
