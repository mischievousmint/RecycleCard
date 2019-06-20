package es.popapps.trivisk;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imgPlay;
    Button buttonSettings;
    Dialog dialog;
    Typeface lucky;
    TextView tvSound, tvMusic, tvSettings;
    SeekBar seekSound, seekMusic;

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

        tvSound = dialog.findViewById(R.id.tvSound);
        tvSound.setText("0 %");
        tvMusic = dialog.findViewById(R.id.tvMusic);
        tvMusic.setText("0 %");
        tvSettings = findViewById(R.id.btnSettings);
        tvSettings.setTypeface(lucky);
        seekMusic = dialog.findViewById(R.id.seekMusic);
        seekSound = dialog.findViewById(R.id.seekSound);
        lucky = Typeface.createFromAsset(getAssets(), "fonts/LuckiestGuy-Regular.ttf");

        seekSound.setOnSeekBarChangeListener (new SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSound.setText("" + progress + " %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                    // no tengo muy claro cómo va esto
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Seek bar progress is :" + tvSound,
                        Toast.LENGTH_SHORT).show();
            }
        });


        seekMusic.setOnSeekBarChangeListener (new SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvMusic.setText("" + progress + " %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // no tengo muy claro cómo va esto
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Seek bar progress is :" + tvMusic,
                        Toast.LENGTH_SHORT).show();
            }
        });

            dialog.show();

    }

}
