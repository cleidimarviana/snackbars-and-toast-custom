/*
 * Copyright (C) 2015 Cleidimar Viana
 * e-mail:      cleidimarviana@gmail.com
 * linkedin     https://www.linkedin.com/profile/view?id=68052415
 * twitter      @cleidimarviana
 */

package info.cleidimarviana.toastcustom;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import info.cleidimarviana.toastcustom.utils.ToastCustom;

public class MainActivity extends AppCompatActivity {

    String[] fiilliste;
    ArrayAdapter<String> adapter;
    View.OnClickListener mOnClickListener;

    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView vlist = (ListView) findViewById(R.id.list);
        fiilliste = getResources().getStringArray(R.array.fi);


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fiilliste);
        vlist.setAdapter(adapter);

        vlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = fiilliste[position].toString();

                switch (position) {
                    case 0: // toast simple
                        Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast toast = Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
                        toast.show();
                        break;
                    case 2:
                        Toast toast2 = Toast.makeText(MainActivity.this, item, Toast.LENGTH_LONG);
                        toast2.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
                        toast2.show();
                        break;
                    case 3:
                        new ToastCustom().show(MainActivity.this, true, item);
                        break;

                    case 4:
                        snackbar.make(findViewById(android.R.id.content), item, Snackbar.LENGTH_LONG).show();
                        break;

                    case 5:
                        snackbar.make(findViewById(android.R.id.content), item, Snackbar.LENGTH_LONG)
                                .setAction("UNDO", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Snackbar.make(findViewById(android.R.id.content), "Message is restored!", Snackbar.LENGTH_SHORT).show();
                                    }
                                }).show();
                        break;

                    case 6:
                        Snackbar snackbar2 = Snackbar
                                .make(findViewById(android.R.id.content), "No internet connection!", Snackbar.LENGTH_LONG)
                                .setAction("RETRY", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                    }
                                });
                        // Changing action button text color
                        View sbView = snackbar2.getView();
                        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                        textView.setTextColor(Color.YELLOW);
                        snackbar2.show();
                        break;


                    case 7:
                        snackbar.make(findViewById(android.R.id.content), Html.fromHtml("Add <b>BOLD</b> to Snackbar text"), Snackbar.LENGTH_LONG)
                                .setAction("Undo", mOnClickListener)
                                .setActionTextColor(Color.RED)
                                .show();
                        break;
                    case 8:
                        SpannableStringBuilder snackbarText = new SpannableStringBuilder();
                        snackbarText.append("Add ");
                        int boldStart = snackbarText.length();
                        snackbarText.append("bold color");
                        snackbarText.setSpan(new ForegroundColorSpan(0xFFFF0000), boldStart, snackbarText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        snackbarText.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), boldStart, snackbarText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        snackbarText.append(" to Snackbar text");

                        snackbar.make(view, snackbarText, Snackbar.LENGTH_LONG).setAction("Undo", mOnClickListener).show();
                        break;

                    case 9:
                        Snackbar snackbarl = Snackbar
                                .make(findViewById(android.R.id.content), "Snackbars provide lightweight feedback about an operation " +
                                        "by showing a brief message at the bottom of the screen. Snackbars can contain an action.", Snackbar.LENGTH_LONG)
                                .setAction("RETRY", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                    }
                                });
                        // Changing action button text color
                        View sbView3 = snackbarl.getView();
                        TextView textView3 = (TextView) sbView3.findViewById(android.support.design.R.id.snackbar_text);
                        textView3.setTextColor(Color.YELLOW);
                        textView3.setMaxLines(5);  // show multiple line
                        snackbarl.show();

                        break;



                }
            }
        });

        mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
    }
}
