package de.ags.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LessonArrayAdapter extends ArrayAdapter<Unterricht> {
	private static final String tag = "LessonArrayAdapter";
	private static final String ASSETS_DIR = "images/";
	private Context context;

	private ImageView countryIcon;
	private TextView countryName;
	private TextView countryAbbrev;
	private List<Unterricht> countries = new ArrayList<Unterricht>();

	public LessonArrayAdapter(Context context, int textViewResourceId,
			List<Unterricht> objects) {
		super(context, textViewResourceId, objects);
		this.context = context;
		this.countries = objects;
	}

	public int getCount() {
		return this.countries.size();
	}

	public Unterricht getItem(int index) {
		return this.countries.get(index);
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		if (row == null) {
			// ROW INFLATION
			Log.d(tag, "Starting XML Row Inflation ... ");
			LayoutInflater inflater = (LayoutInflater) this.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.lesson_detail_view, parent, false);
			Log.d(tag, "Successfully completed XML Row Inflation!");
		}

		// Get item
		Unterricht country = getItem(position);
		countryIcon = (ImageView) row.findViewById(R.id.lesson_icon);
		countryName = (TextView) row.findViewById(R.id.lesson_name);
		countryAbbrev = (TextView) row.findViewById(R.id.lesson_abbrev);

		countryName.setText(country.name);
		String imgFilePath = ASSETS_DIR + country.resourceId;
		try {
			Bitmap bitmap = BitmapFactory.decodeStream(this.context.getResources().getAssets()
					.open(imgFilePath));
			countryIcon.setImageBitmap(bitmap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Log.d(tag, "Image File: " + imgFilePath + " " + "Size: " +
		// bitmap.getHeight());

		countryAbbrev.setText(country.abbreviation);

		return row;
	}
}
