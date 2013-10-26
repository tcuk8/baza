package com.ispitnizadatakandroid;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomStudentAdapter extends BaseAdapter {

	private Context mContext;

	private ArrayList<Student> mStudents;

	private LayoutInflater mInflater;

	private ViewHolder holder;

	public CustomStudentAdapter(Context context, ArrayList<Student> students) {

		mContext = context;

		mStudents = students;

		mInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return mStudents.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mStudents.get(position);
	}

	@Override
	public long getItemId(int arg0) {

		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup viewGroup) {

		Student currentStudent = mStudents.get(position);

		holder = new ViewHolder();

		convertView = mInflater.inflate(R.layout.list_item, null);

		holder.mImeText = (TextView) convertView.findViewById(R.id.list_ime);
		holder.mPrezimeText = (TextView) convertView
				.findViewById(R.id.list_prezime);
		holder.mBrojIndeksaText = (TextView) convertView
				.findViewById(R.id.list_broj_indeksa);
		holder.mGodinaStudijaText = (TextView) convertView
				.findViewById(R.id.list_godina_studija);

		holder.mImeText.setText(currentStudent.getIme());
		holder.mPrezimeText.setText(currentStudent.getPrezime());
		holder.mBrojIndeksaText.setText(currentStudent.getBrojIndexa());
		holder.mGodinaStudijaText.setText(currentStudent.getGodinaStudija());

		return convertView;
	}

	private class ViewHolder {

		TextView mImeText;
		TextView mPrezimeText;
		TextView mBrojIndeksaText;
		TextView mGodinaStudijaText;

	}
}
