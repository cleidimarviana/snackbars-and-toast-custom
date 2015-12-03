/*
 * Copyright (C) 2015 Cleidimar Viana
 * e-mail:      cleidimarviana@gmail.com
 * linkedin     https://www.linkedin.com/profile/view?id=68052415
 * twitter      @cleidimarviana
 */

package info.cleidimarviana.toastcustom.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import info.cleidimarviana.toastcustom.R;

public class ToastCustom extends Activity {

    private TextView textView;
    private ImageView imageFeature;

    /**
     * This method displays alert message in toast format.
     *
     * @param context Context of activity
     * @param feature is true or false
     * @param message message displayed
     */
    public void show(Context context, boolean feature, String message) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View customToastroot = inflater.inflate(R.layout.layout_toast_custom, null);

        imageFeature = (ImageView) customToastroot.findViewById(R.id.image_feature);
        int color = Color.parseColor("#ffffff");
        imageFeature.setColorFilter(color);
        if (!feature) {
            imageFeature.setImageResource(R.mipmap.ic_launcher);
        } else {
            imageFeature.setImageResource(R.mipmap.ic_launcher);

            textView = (TextView) customToastroot.findViewById(R.id.tv_message);
            textView.setText(message);

            Toast customtoast = new Toast(context);
            customtoast.setView(customToastroot);
            customtoast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
            customtoast.setDuration(Toast.LENGTH_LONG);
            customtoast.show();
        }
    }
}