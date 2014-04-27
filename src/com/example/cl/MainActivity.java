package com.example.cl;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ListView listView;
	private ArrayList<ListEntry> entries;
	private MyAdapter myAdapter;

	private int[] drawables = { R.drawable.facebook, R.drawable.google,
			R.drawable.skype, R.drawable.twitter };

	private String[] titles = { "Facebook", "Goolge", "Skype", "twitter" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initailWidget();

		// data
		entries = new ArrayList<ListEntry>();

		// add Data
		for (int i = 0; i < drawables.length; i++) {
			ListEntry listEntry = new ListEntry();
			listEntry.setTitle(titles[i]);
			listEntry.setDrawable(getResources().getDrawable(drawables[i]));
			entries.add(listEntry);
		}
		// setup adapter
		myAdapter = new MyAdapter();
		listView.setAdapter(myAdapter);
	}

	private void initailWidget() {
		listView = (ListView) findViewById(R.id.listView1);
	}

	private class MyAdapter extends BaseAdapter {

		private Holder holder;

		@Override
		public int getCount() {
			return entries.size();
		}

		@Override
		public Object getItem(int arg0) {
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int position, View view, ViewGroup parent) {

			// Create View
			view = LayoutInflater.from(MainActivity.this).inflate(
					R.layout.listview_item, null);

			// View Matching
			holder = new Holder();
			holder.imageView = (ImageView) view.findViewById(R.id.imageView1);
			holder.textView = (TextView) view.findViewById(R.id.textView1);

			// View Setting

			if (entries.get(position).getTitle() != null) {
				holder.textView.setText(entries.get(position).getTitle());
			}
			if (entries.get(position).getDrawable() != null) {
				holder.imageView.setImageDrawable(entries.get(position)
						.getDrawable());
			}

			return view;
		}

		private class Holder {
			public ImageView imageView;
			public TextView textView;
		}

	}
}