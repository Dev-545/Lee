package com.example.lee;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class PopUpClass {
    public void showPopupWindow( View view){
        LayoutInflater layoutInflater = (LayoutInflater)view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popupview = layoutInflater.inflate(R.layout.popupscreen,null);
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable=true;

        final PopupWindow popupWindow = new PopupWindow(popupview, width, height,focusable);

        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);

    }
}
