package com.example.covidapp;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.covidapp.databinding.ContentSignUpBindingImpl;
import com.example.covidapp.databinding.FeedbackBindingImpl;
import com.example.covidapp.databinding.OpenClosedBindingImpl;
import com.example.covidapp.databinding.SettingsBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_CONTENTSIGNUP = 1;

  private static final int LAYOUT_FEEDBACK = 2;

  private static final int LAYOUT_OPENCLOSED = 3;

  private static final int LAYOUT_SETTINGS = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.covidapp.R.layout.content_sign__up, LAYOUT_CONTENTSIGNUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.covidapp.R.layout.feedback, LAYOUT_FEEDBACK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.covidapp.R.layout.open_closed, LAYOUT_OPENCLOSED);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.covidapp.R.layout.settings, LAYOUT_SETTINGS);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_CONTENTSIGNUP: {
          if ("layout/content_sign__up_0".equals(tag)) {
            return new ContentSignUpBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for content_sign__up is invalid. Received: " + tag);
        }
        case  LAYOUT_FEEDBACK: {
          if ("layout/feedback_0".equals(tag)) {
            return new FeedbackBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for feedback is invalid. Received: " + tag);
        }
        case  LAYOUT_OPENCLOSED: {
          if ("layout/open_closed_0".equals(tag)) {
            return new OpenClosedBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for open_closed is invalid. Received: " + tag);
        }
        case  LAYOUT_SETTINGS: {
          if ("layout/settings_0".equals(tag)) {
            return new SettingsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for settings is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/content_sign__up_0", com.example.covidapp.R.layout.content_sign__up);
      sKeys.put("layout/feedback_0", com.example.covidapp.R.layout.feedback);
      sKeys.put("layout/open_closed_0", com.example.covidapp.R.layout.open_closed);
      sKeys.put("layout/settings_0", com.example.covidapp.R.layout.settings);
    }
  }
}
