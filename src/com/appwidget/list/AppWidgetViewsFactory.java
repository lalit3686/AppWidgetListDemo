package com.color.appwidget.list;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

public class AppWidgetViewsFactory implements RemoteViewsService.RemoteViewsFactory {
	private Context context = null;
	//private int appWidgetId;
	private ArrayList<String> arrayList = new ArrayList<String>();

	public AppWidgetViewsFactory(Context ctxt, Intent intent) {
		this.context = ctxt;
		/*appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
				AppWidgetManager.INVALID_APPWIDGET_ID);
		Log.e(getClass().getSimpleName(), appWidgetId + "");*/
	}

	@Override
	public void onCreate() {
		arrayList.add("1");
	}

	@Override
	public void onDestroy() {
		// no-op
	}

	@Override
	public int getCount() {
		return (arrayList.size());
	}

	@Override
	public RemoteViews getViewAt(int position) {
		RemoteViews row = new RemoteViews(context.getPackageName(), R.layout.row);

		row.setTextViewText(android.R.id.text1, arrayList.get(position));

		Intent i = new Intent();
		Bundle extras = new Bundle();

		extras.putString(WidgetProvider.EXTRA_WORD, arrayList.get(position));
		i.putExtras(extras);
		row.setOnClickFillInIntent(android.R.id.text1, i);

		return row;
	}

	@Override
	public RemoteViews getLoadingView() {
		return null;
	}

	@Override
	public int getViewTypeCount() {
		return 1;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public void onDataSetChanged() {
		int current_item = Integer.parseInt(arrayList.get(arrayList.size() - 1));
		current_item  = 1 + current_item;
		arrayList.add(current_item+"");
		Log.e(getClass().getSimpleName(), "current_item "+current_item);
	}
}