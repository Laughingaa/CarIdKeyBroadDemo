package com.mx.caridkeybroaddemo.keybrod;

import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

import com.mx.caridkeybroaddemo.R;

/**
 * Ceate by Lize on 2018/8/6
 */
public class KeyBroadManager  implements KeyboardView.OnKeyboardActionListener {

    private CustomKeyBroadView keyboardView;
    private Keyboard firstKeyBrod;
    private Keyboard behindKeyBrod;
    private Context context;
    private Editable editable ;
    private static  final String TAG = KeyBroadManager.class.getSimpleName();
    private EditText editText;
    private Animation enterAnimation ;
    private Animation exitAnimation ;
    public KeyBroadManager(Context context,CustomKeyBroadView keyboardView) {
        this.context = context;
        this.keyboardView = keyboardView;
        this.keyboardView.setOnKeyboardActionListener(this);
         firstKeyBrod = new Keyboard(context,R.xml.first_keybrod);
        behindKeyBrod = new Keyboard(context,R.xml.behind_keybroad);
        this.keyboardView.setKeyboard(firstKeyBrod);
        this.keyboardView.setPreviewEnabled(true);
        this.keyboardView.setEnabled(true);
        editable = Editable.Factory.getInstance().newEditable("");
        initAnimation(context);
    }
    //初始化进入退出动画
    private void initAnimation(Context context) {
        enterAnimation = AnimationUtils.loadAnimation(context, R.anim.pop_enter_anim);
        exitAnimation = AnimationUtils.loadAnimation(context,R.anim.pop_exit_anim);
        enterAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                KeyBroadManager.this.keyboardView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        exitAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                KeyBroadManager.this.keyboardView.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void bindToEditText(EditText editText){
        this.editText = editText;
    }


    @Override
    public void onPress(int i) {

    }

    @Override
    public void onRelease(int i) {

    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes   ) {
        if (editText!=null){
           int editSelectStart = editText.getSelectionStart();
           Log.i(TAG,"editSelectStart:"+editSelectStart);
            if (primaryCode == -100002){
                Log.i(TAG,"action is delet");
                if (!TextUtils.isEmpty(editable)&& editSelectStart>=1){
                    if (editable.length()>0){
                        editable.delete(editSelectStart-1,editSelectStart);
                    }
                    editSelectStart = editSelectStart -1;
                }
            }else if (primaryCode== -100003 ||primaryCode== -100004){
                return;
            }else {
                String text = Character.toString((char) primaryCode);
                if (primaryCode ==-100||primaryCode ==-200||primaryCode ==-300){
                    text = "WJ";
                }
                if (editable.length()==0 || editable.length() == editSelectStart){
                    editable.append(text);
                    editSelectStart = editable.length();
                }else {
                    editable.insert(editSelectStart,text);
                    editSelectStart = editSelectStart+text.length();
                }
                if (editable.length()>= 1){
                    keyboardView.setKeyboard(behindKeyBrod);
                }
            }
            editText.setText(editable);
            editText.setSelection(editSelectStart);
            if (editSelectStart == 0){
                keyboardView.setKeyboard(firstKeyBrod);
            }
        }else {
            Log.i(TAG,"EditText is null");
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



    public void showKeyBrod(){

        if (keyboardView!=null){
            keyboardView.startAnimation(enterAnimation);
        }else {
            Log.i(TAG,"when showKeyBrod ,keyboardView is null");
        }
    }

    public void dismissKeyBroad(){
        if (keyboardView!=null){
            keyboardView.startAnimation(exitAnimation);
        }else {
            Log.i(TAG,"when dismissKeyBroad ,keyboardView is null");
        }
    }
}
