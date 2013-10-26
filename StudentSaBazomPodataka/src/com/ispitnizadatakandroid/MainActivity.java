package com.ispitnizadatakandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

	private EditText ime, prezime, brojIndexa, godinaStudija;
	private Button saveButton, viewButton;

	private Database mDatabase;

	private Student newStudent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mDatabase = new Database(this);

		ime = (EditText) findViewById(R.id.ime);
		prezime = (EditText) findViewById(R.id.prezime);
		brojIndexa = (EditText) findViewById(R.id.index);
		godinaStudija = (EditText) findViewById(R.id.godina_studija);

		saveButton = (Button) findViewById(R.id.save_button);
		viewButton = (Button) findViewById(R.id.view_button);

		saveButton.setOnClickListener(this);
		viewButton.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.save_button:

			newStudent = new Student();

			newStudent.setIme(ime.getText().toString());
			newStudent.setPrezime(prezime.getText().toString());
			newStudent.setBrojIndexa(brojIndexa.getText().toString());
			newStudent.setGodinaStudija(godinaStudija.getText().toString());

			mDatabase.helper.insertStudent(newStudent);

			break;
		case R.id.view_button:

			Intent intent = new Intent(MainActivity.this, DrugiActivity.class);
			startActivity(intent);

			break;

		}

	}
}
