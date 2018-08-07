package com.mx.caridkeybroaddemo.keybrod;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;

import com.mx.caridkeybroaddemo.DisplayUtil;
import com.mx.caridkeybroaddemo.R;

import java.security.Key;
import java.util.List;

/**
 * Ceate by Lize on 2018/8/6
 */
public class CustomKeyBroadView extends KeyboardView {

    private Context context;

    public CustomKeyBroadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public CustomKeyBroadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }



    @Override
    public void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        Keyboard keyboard = getKeyboard();
        if (keyboard!=null){

            List<Keyboard.Key> keyList = getKeyboard().getKeys();

            if (keyList!=null && keyList.size()>0){
                Paint paint = new Paint();
                paint.setTextAlign(Paint.Align.CENTER);
                Typeface font = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL);
                paint.setTypeface(font);
                paint.setAntiAlias(true);
                paint.setTextSize(DisplayUtil.sp2px(context,15));
                for (Keyboard.Key key :keyList){
                    if (key.codes[0] >= 65 && key.codes[0]<=90) {
                        Drawable dr = getContext().getResources().getDrawable(R.drawable.abc_selecter_bg);
                        dr.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
                        dr.setState(key.getCurrentDrawableState());//添加这句话，否则选中背景 无效
                        dr.draw(canvas);
                        Rect rect = new Rect(key.x, key.y, key.x + key.width, key.y + key.height);
                        Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
                        int baseline = (rect.bottom + rect.top - fontMetrics.bottom - fontMetrics.top) / 2;
                        // 下面这行是实现水平居中，drawText对应改为传入targetRect.centerX()
                        paint.setTextAlign(Paint.Align.CENTER);
                        canvas.drawText(key.label.toString(), rect.centerX(), baseline, paint);

                    }
                    if (key.codes[0] == -100003 || key.codes[0]==-100004){
                        Drawable dr = getContext().getResources().getDrawable(R.drawable.key_placeholder_bg);
                        dr.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
                        dr.draw(canvas);
                    }
                }
            }
        }

    }
}
