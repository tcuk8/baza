package com.ispitnizadatakandroid;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database {

	public static final String DB_NAME = "database.db";
	public static final int DB_VERSION = 1;
	public static final String TABLE_NAME = "studenti";

	public static final String STUDENT_ID = "_id";
	public static final String STUDENT_IME = "student_ime";
	public static final String STUDENT_PREZIME = "student_prezime";
	public static final String STUDENT_BROJ_INDEKSA = "student_indeks";
	public static final String STUDENT_GODINA_STUDIJA = "student_godina";

	private Context mContext;
	private SQLiteDatabase db;
	public DbHelper helper;

	public Database(Context context) {

		mContext = context;
		helper = new DbHelper();

	}

	class DbHelper extends SQLiteOpenHelper {

		public DbHelper() {
			super(mContext, DB_NAME, null, DB_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {

			String studentSql = "CREATE TABLE " + TABLE_NAME + " ("
					+ STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ STUDENT_IME + " TEXT, " + STUDENT_PREZIME + " TEXT, "
					+ STUDENT_BROJ_INDEKSA + " TEXT, " + STUDENT_GODINA_STUDIJA
					+ " TEXT );";

			Log.d("msg", "onCreate with" + studentSql);

			db.execSQL(studentSql);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub

			db.execSQL("DROP TABLE IF EXIST" + TABLE_NAME);

		}

		public void insertStudent(Student student) {

			db = helper.getWritableDatabase();

			ContentValues cv = new ContentValues();
			cv.put(STUDENT_IME, student.getIme());
			cv.put(STUDENT_PREZIME, student.getPrezime());
			cv.put(STUDENT_GODINA_STUDIJA, student.getGodinaStudija());
			cv.put(STUDENT_BROJ_INDEKSA, student.getBrojIndexa());
			db.insert(TABLE_NAME, null, cv);
			db.close();
		}

		public ArrayList<Student> getAllStudents() {

			ArrayList<Student> items = new ArrayList<Student>();

			db = helper.getReadableDatabase();

			Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);

			for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {

				Student student = new Student();

				student.setIme(c.getString(c.getColumnIndex(STUDENT_IME)));
				student.setPrezime(c.getString(c
						.getColumnIndex(STUDENT_PREZIME)));
				student.setBrojIndexa(c.getString(c
						.getColumnIndex(STUDENT_BROJ_INDEKSA)));
				student.setGodinaStudija(c.getString(c
						.getColumnIndex(STUDENT_GODINA_STUDIJA)));

				items.add(student);
			}

			return items;
		}
	}
}
