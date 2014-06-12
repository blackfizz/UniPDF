package com.unipdf.app.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.unipdf.app.Main;
import com.unipdf.app.vos.LightPDF;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by paul on 15.05.14.
 */
public class Helper {

    public static void convertSparseToArrayList(SparseArray<LightPDF> _Source, ArrayList<LightPDF> _Destination) {
        for(int index = 0; index < _Source.size(); ++index) {
            _Destination.add(_Source.valueAt(index));
        }
    }

    //hideKeyboard----------------------------------------------------------------------------------
    /**
     * hides the current soft keyboard, if it is open.
     */
    public static void hideKeyboard(android.app.Activity _activity)
    {
        InputMethodManager inputManager = (InputMethodManager) _activity.getSystemService(Context.INPUT_METHOD_SERVICE);

        if (_activity.getCurrentFocus() != null)
        {
            inputManager.hideSoftInputFromWindow(_activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
        else
        {
            inputManager.hideSoftInputFromWindow(null, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public static void showKeyboard(Activity _activity) {
        InputMethodManager inputMethodManager=(InputMethodManager)_activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInputFromWindow(_activity.getCurrentFocus().getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
    }

    public static void showKeyboard(Activity _activity, View _view) {
        InputMethodManager inputMethodManager=(InputMethodManager) _activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(_view, 0);
    }

    public static void hideKeyboard(Activity _activity, View _view) {
        InputMethodManager inputMethodManager=(InputMethodManager) _activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(_view.getWindowToken(), 0);
    }

    //showToast-------------------------------------------------------------------------------------
    public static void showToast(Activity _Activity, String _message)
    {
        Toast.makeText(_Activity, _message, Toast.LENGTH_SHORT).show();
    }

    //showToast-------------------------------------------------------------------------------------
    public static void showPositionedToast(Activity _Activity, String _message, int _Gravity)
    {
        Toast toast = Toast.makeText(_Activity, _message, Toast.LENGTH_SHORT);
        toast.setGravity(_Gravity, 0, 120);
        toast.show();
    }

    //dpToPx----------------------------------------------------------------------------------------
    /**
     * Converts density-independent pixel (dp) to pixel (px)
     *
     * @param dp the dp value to convert in pixel
     *
     * @return the converted value in pixels
     */
    public static float dpToPx(float dp)
    {
        return dp * Resources.getSystem().getDisplayMetrics().density;
    }

}
