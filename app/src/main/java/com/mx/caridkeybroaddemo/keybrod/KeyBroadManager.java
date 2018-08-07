package com.mx.caridkeybroaddemo.keybrod;

import android.app.Activity;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;

import com.mx.caridkeybroaddemo.R;

/**
 * Ceate by Lize on 2018/8/6
 */
public class KeyBroadManager  implements KeyboardView.OnKeyboardActionListener {
    private CustomKeyBroadView keyboardView;
    private Keyboard firstKeyBrod;
    private Keyboard behindKeyBrod;
    private Activity activity;
    private Editable editable ;
    private static  final String TAG = KeyBroadManager.class.getSimpleName();
    public KeyBroadManager(Activity activity) {
        this.activity = activity;
        keyboardView =  activity.findViewById(R.id.keybroadview);
        keyboardView.setOnKeyboardActionListener(this);
         firstKeyBrod = new Keyboard(activity,R.xml.first_keybrod);
        behindKeyBrod = new Keyboard(activity,R.xml.behind_keybroad);
        keyboardView.setKeyboard(firstKeyBrod);
        keyboardView.setPreviewEnabled(true);
        keyboardView.setEnabled(true);
        editable = Editable.Factory.getInstance().newEditable("");
    }

    @Override
    public void onPress(int i) {

    }

    @Override
    public void onRelease(int i) {

    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes   ) {
        if (primaryCode == -100002){
            Log.i(TAG,"action is delet");
            if (!TextUtils.isEmpty(editable)){
                if (editable.length()>0){
                    editable.delete(editable.length()-1,editable.length());
                    System.out.println(String.valueOf(editable));
                }
                if (editable.length()==0){
                    keyboardView.setKeyboard(firstKeyBrod);
                }
            }
        }else if (primaryCode== -100003 ||primaryCode== -100004){
            return;
        }else {
            editable.append(Character.toString((char) primaryCode));
            if (editable.length()>= 1){
                keyboardView.setKeyboard(behindKeyBrod);
            }
            System.out.println(String.valueOf(editable));
        }

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
