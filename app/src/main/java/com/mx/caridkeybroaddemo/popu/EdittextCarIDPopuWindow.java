package com.mx.caridkeybroaddemo.popu;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.mx.caridkeybroaddemo.R;
import com.mx.caridkeybroaddemo.keybrod.CustomKeyBroadView;
import com.mx.caridkeybroaddemo.keybrod.KeyBroadManager;

/**
 * Ceate by Lize on 2018/8/7
 */
public class EdittextCarIDPopuWindow extends PopupWindow {
    KeyBroadManager keyBroadManager;

    public EdittextCarIDPopuWindow(Activity context, EditText editText, ViewGroup rootParent) {

        View root = LayoutInflater.from(context).inflate(R.layout.layout_keybroad_popu,rootParent,false);
        setContentView(root);
        CustomKeyBroadView customKeyBroadView = root.findViewById(R.id.keybroadview);
        keyBroadManager = new KeyBroadManager(context,customKeyBroadView);
        keyBroadManager.bindToEditText(editText);
        setOutsideTouchable(true);
        setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
        setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
    }
}
