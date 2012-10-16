package com.color.appwidget.list;

import android.content.Intent;
import android.widget.RemoteViewsService;

public class WidgetService extends RemoteViewsService {
  @Override
  public RemoteViewsFactory onGetViewFactory(Intent intent) {
    return(new AppWidgetViewsFactory(this.getApplicationContext(), intent));
  }
}