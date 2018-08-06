package com.mx.caridkeybroaddemo.keybrod;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.Log;

/**
 * Ceate by Lize on 2018/8/6
 */
public class CustomKeyBrod extends Keyboard implements KeyboardView.OnKeyboardActionListener {


    private String[] keyWorlds = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q",
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "港",
            "澳", "学", "领", "使", "警", "挂", ""};

    private String[] firstChar = {"京", "津", "冀", "晋", "蒙", "辽", "吉", "黑", "沪", "苏",
            "浙", "皖", "闽", "赣", "鲁", "豫", "鄂", "湘", "粤", "桂",
            "琼", "渝", "川", "贵", "云", "藏", "陕", "甘", "青", "",
            "宁", "新", "台", "WJ", ""};

    public CustomKeyBrod(Context context, int xmlLayoutResId) {
        super(context, xmlLayoutResId);
    }

    public CustomKeyBrod(Context context, int xmlLayoutResId, int modeId, int width, int height) {
        super(context, xmlLayoutResId, modeId, width, height);
    }

    public CustomKeyBrod(Context context, int xmlLayoutResId, int modeId) {
        super(context, xmlLayoutResId, modeId);
    }

    public CustomKeyBrod(Context context, int layoutTemplateResId, CharSequence characters, int columns, int horizontalPadding) {
        super(context, layoutTemplateResId, characters, columns, horizontalPadding);
    }


    @Override
    public void onPress(int i) {

    }

    @Override
    public void onRelease(int i) {

    }
    //键盘按下
    @Override
    public void onKey(int i, int[] ints) {

        Log.i("CustomKeyBrod",Character.toString((char) i));

    }

    @Override
    public void onText(CharSequence charSequence) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }
}
