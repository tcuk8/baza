package com.ispitnizadatakandroid;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class DrugiActivity extends Activity {

	private ListView mListView;

	private CustomStudentAdapter mAdapter;

	private ArrayList<Student> mStudents;

	private Database mDatabase;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drugi);

		mDatabase = new Database(this);

		mStudents = mDatabase.helper.getAllStudents();

		mListView = (ListView) findViewById(R.id.drugi_listview);

		mAdapter = new CustomStudentAdapter(this, mStudents);

		mListView.setAdapter(mAdapter);
		
		
	}
	
}
