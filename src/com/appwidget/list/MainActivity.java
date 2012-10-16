package com.color.appwidget.list;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {
	@Override
	public void onCreate(Bundle state) {
		super.onCreate(state);

		String word = getIntent().getStringExtra(WidgetProvider.EXTRA_WORD);

		if (word == null) {
			word = "No Word";
		}

		Toast.makeText(this, word, Toast.LENGTH_LONG).show();
		finish();
	}
}