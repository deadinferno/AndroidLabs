package ru.startandroid.lab02v2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class About extends AppCompatActivity {

    public String TAG = "dLog";
    public String actName = "[1]About";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG, actName + "::onCreate()");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView textAboutContent = findViewById(R.id.textViewAboutContent);
        Spanned textFormattedHtml = Html.fromHtml(getResources().getString(R.string.aboutTitleContent));
        textAboutContent.setText(textFormattedHtml);


//        WebView webViewAboutContent = (WebView) findViewById(R.id.webViewAboutContent);
//        String str = getResources().getString(R.string.aboutTitleContent);
//        //webViewAboutContent.getSettings().setJavaScriptEnabled(true);
//        webViewAboutContent.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}

/*
*
* String mystring = getResources().getString(R.string.mystring);
*
* String str="<html><body>A dressy take on classic gingham in a soft, textured weave of stripes
* that resembles twill.  Take a closer look at this one.<ul><li>Trim, tailored fit for a bespoke
* feel</li><li>Medium spread collar, one-button mitered barrel cuffs</li><li>Applied placket with
* genuine mother-of-pearl buttons</li><li>;Split back yoke, rear side pleats</li><li>Made in the
* U.S.A. of 100% imported cotton.</li></ul></body></html>";
*
* webView.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
*
*
* */