package de.ags.app;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class vplan extends Activity {
	
	
	private List<Unterricht> countryList= new ArrayList<Unterricht>();
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.vertrettungsplan);
	        setTitle("Vertrettungsplan");
	        
        ListView lessonsView = (ListView) findViewById(R.id.lessonsList);
	        
        // Create Parser for raw/countries.xml
		LessonsParser lessonsParser = new LessonsParser();
		InputStream inputStream = getResources().openRawResource(
				R.raw.countries);
        
		// Parse the inputstream
		lessonsParser.parse(inputStream);

		// Get Countries
		List<Unterricht> lessonsList = lessonsParser.getList();
		
		
		// Create a customized ArrayAdapter
		LessonArrayAdapter adapter = new LessonArrayAdapter(
				getApplicationContext(), R.layout.lesson_detail_view, lessonsList);
	        
	    lessonsView.setAdapter(adapter);
	    
	    
	 }
}
