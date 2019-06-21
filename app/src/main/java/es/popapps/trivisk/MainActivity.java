package es.popapps.trivisk;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imgLogo;
    Button btnSettings, btnPlay, btnCreate, btnBuy;
    Dialog dialog;
    Typeface lucky;
    TextView tvSound, tvMusic, tvSettings;
    SeekBar seekSound, seekMusic;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSettings = findViewById(R.id.btnSettings);
        btnBuy = findViewById(R.id.btnBuy);
        btnCreate = findViewById(R.id.btnCreate);
        btnPlay = findViewById(R.id.btnPlay);
        imgLogo = findViewById(R.id.imgLogo);

        btnCreate.setOnClickListener(this);
        btnBuy.setOnClickListener(this);
        btnPlay.setOnClickListener(this);

        ((AnimationDrawable) imgLogo.getBackground()).start();

 /*     Esto lo metemos en el switch case

        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PlayActivity.class );
                startActivity(i);
            }
        });
*/
        btnSettings.setOnClickListener(new View.OnClickListener() {
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

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSound.setText(" " + progress + " %");
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

            @SuppressLint("SetTextI18n")
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvMusic.setText(" " + progress + " %");
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


    @Override
    public void onClick(View v) {
        int aver = v.getId();
        switch (aver) {
            case R.id.btnBuy:
                Snackbar.make(v, "hola btnBuy", Snackbar.LENGTH_LONG).show();
            break;
            case R.id.btnCreate:
                Snackbar.make(v, "hola btnCreate", Snackbar.LENGTH_LONG).show();
            break;
            case R.id.btnPlay:
                Snackbar.make(v, "hola btnPlay", Snackbar.LENGTH_LONG).show();
            break;
            default:
    }
}


}
