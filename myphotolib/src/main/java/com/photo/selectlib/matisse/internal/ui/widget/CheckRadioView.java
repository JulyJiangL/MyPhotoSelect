package com.photo.selectlib.matisse.internal.ui.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.core.content.res.ResourcesCompat;
import androidx.appcompat.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.photo.selectlib.R;

public class CheckRadioView extends AppCompatImageView {

    private Drawable mDrawable;

    private int selectedColor;
    private int unSelectedColor;

    public CheckRadioView(Context context) {
        super(context);
        init();
    }



    public CheckRadioView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        selectedColor = ResourcesCompat.getColor(
                getResources(), R.color.zhihu_item_checkCircle_backgroundColor,
                getContext().getTheme());
        unSelectedColor = ResourcesCompat.getColor(
                getResources(), R.color.zhihu_check_original_radio_disable,
                getContext().getTheme());
        setChecked(false);
    }

    public void setChecked(boolean enable){
        if(enable){
            setImageResource(R.drawable.ic_preview_radio_on);
            mDrawable=getDrawable();
            mDrawable.setColorFilter(selectedColor, PorterDuff.Mode.SRC_IN);
        }else {
            setImageResource(R.drawable.ic_preview_radio_off);
            mDrawable=getDrawable();
            mDrawable.setColorFilter(unSelectedColor, PorterDuff.Mode.SRC_IN);
        }
    }


    public void setColor(int color){
        if (mDrawable == null) {
            mDrawable=getDrawable();
        }
        mDrawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
    }
}
