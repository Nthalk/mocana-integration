package net.fulcrum.cats.android.mocana.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import net.fulcrum.cats.android.mocana.R;

public class LoginTestActivity extends Activity {

    private LinearLayout log;
    private EditText urlInput;
    private ViewGroup.LayoutParams logLayout = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_test);
        log = (LinearLayout) findViewById(R.id.activity_login_log);
        urlInput = (EditText) findViewById(R.id.activity_login_url);
        Button updateUrlButton = (Button) findViewById(R.id.activity_login_update_url);
        updateUrlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log.removeAllViews();
                String url = urlInput.getText().toString();
                addLog("URL: " + url);
                addLog("Cookie: \n" + CookieManager.getInstance().getCookie(url));
            }
        });
    }

    private void addLog(String message) {
        TextView textView = new TextView(this);
        textView.setLayoutParams(logLayout);
        textView.setText(message);
        log.addView(textView);
    }
}
