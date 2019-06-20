package es.popapps.trivisk;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgPlay;
    Button buttonSettings;
    Dialog dialog;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPlay = findViewById(R.id.btnPlay);
        buttonSettings = findViewById(R.id.btnSettings);

        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PlayActivity.class );
                startActivity(i);
            }
        });

        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogPreferences();
            }
        });
    }

    private void showDialogPreferences() {
            dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog_preferences);
            dialog.show();

    }
}
