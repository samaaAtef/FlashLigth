package com.example.sama.flashligth;

import android.graphics.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.lang.reflect.Parameter;
import java.security.Policy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Switch s = (Switch) findViewById(R.id.switchFlash);


        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            android.hardware.Camera cam;
            android.hardware.Camera.Parameters p;

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
// turn off
                if (!b) {
                    if (cam != null) {
                        p.setFlashMode(android.hardware.Camera.Parameters.FLASH_MODE_OFF);

                        cam = null;
                    }
                }
                // turn on
                else {
                    if (cam == null) {
                        try {
                            cam = android.hardware.Camera.open();
                            // Yeah, this could be more specific maybe.
                        } catch (RuntimeException e) {
                            e.printStackTrace();
                            finish();
                            return;
                        }
                        p = cam.getParameters();
                        p.setFlashMode(android.hardware.Camera.Parameters.FLASH_MODE_TORCH);
                     
            }
        }
            }
        });
    }
}