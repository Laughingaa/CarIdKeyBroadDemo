package com.mx.caridkeybroaddemo;

import android.inputmethodservice.KeyboardView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mx.caridkeybroaddemo.keybrod.CustomKeyBroadView;
import com.mx.caridkeybroaddemo.keybrod.CustomKeyBrod;
import com.mx.caridkeybroaddemo.keybrod.KeyBroadManager;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println(firstChar.length);
        for (String str: keyWorlds){
            aChar =  str.toCharArray()[0];
            anInt = aChar;
            Log.i("MainActivity","  <Key android:codes=\""+anInt+"\" android:keyLabel=\""+aChar+"\"/>");
        }

       /* CustomKeyBrod customKeyBrod = new CustomKeyBrod(this,R.xml.behind_keybroad);
        CustomKeyBroadView keyboardView = findViewById(R.id.keybroadview);
        keyboardView.setKeyboard(customKeyBrod);
        keyboardView.setOnKeyboardActionListener(customKeyBrod);*/
        KeyBroadManager keyBroadManager = new KeyBroadManager(this);
    }
}
