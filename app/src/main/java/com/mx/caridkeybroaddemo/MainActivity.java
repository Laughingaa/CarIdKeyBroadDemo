package com.mx.caridkeybroaddemo;

import android.inputmethodservice.KeyboardView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.mx.caridkeybroaddemo.keybrod.CustomKeyBroadView;
import com.mx.caridkeybroaddemo.keybrod.CustomKeyBrod;
import com.mx.caridkeybroaddemo.keybrod.KeyBroadManager;
import com.mx.caridkeybroaddemo.popu.EdittextCarIDPopuWindow;

public class MainActivity extends AppCompatActivity {
    private String[] firstChar = {"京", "津", "冀", "晋", "蒙", "辽", "吉", "黑", "沪", "苏",
            "浙", "皖", "闽", "赣", "鲁", "豫", "鄂", "湘", "粤", "桂",
            "琼", "渝", "川", "贵", "云", "藏", "陕", "甘", "青",
            "宁", "新", "台", "WJ"};

    private String[] keyWorlds = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F", "G", "H","I" ,"J", "K", "L", "M", "N","O","P", "Q",
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "港",
            "澳", "学", "领", "使", "警", "挂"};
    char aChar;
    int anInt;
    private KeyBroadManager keyBroadManager;
    CustomKeyBroadView customKeyBroadView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println(firstChar.length);
        for (String str: keyWorlds){
            aChar =  str.toCharArray()[0];
            anInt = aChar;
        }
        final EditText editText = findViewById(R.id.edittext);
       /* CustomKeyBrod customKeyBrod = new CustomKeyBrod(this,R.xml.behind_keybroad);
        CustomKeyBroadView keyboardView = findViewById(R.id.keybroadview);
        keyboardView.setKeyboard(customKeyBrod);
        keyboardView.setOnKeyboardActionListener(customKeyBrod);*/
     /*   KeyBroadManager keyBroadManager = new KeyBroadManager(this);

        keyBroadManager.bindToEditText(editText);*/
        final RelativeLayout linearLayout = findViewById(R.id.root);
        customKeyBroadView  = findViewById(R.id.keybroadview);
        final Animation enterAnimation = AnimationUtils.loadAnimation(this,R.anim.pop_enter_anim);
        keyBroadManager = new KeyBroadManager(this,customKeyBroadView);
        keyBroadManager.bindToEditText(editText);
        findViewById(R.id.showpopu_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyBroadManager.showKeyBrod();
            }
        });

        findViewById(R.id.dismisspopu_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyBroadManager.dismissKeyBroad();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy","onDestroy");
    }
}
