package com.github.conhea.floatingactionbutton.sample;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View parentLayout = findViewById(R.id.coordinator_layout);

        findViewById(R.id.action_b).setOnClickListener(v ->
                Snackbar.make(parentLayout,"Clicked pink Floating Action Button", Snackbar.LENGTH_LONG).show());
        findViewById(R.id.action_c).setOnClickListener(v ->
                Snackbar.make(parentLayout,"Floating Action Button menuitem #2 clicked", Snackbar.LENGTH_LONG).show());
        findViewById(R.id.action_d).setOnClickListener(v ->
                Snackbar.make(parentLayout,"Floating Action Button menuitem #1 clicked", Snackbar.LENGTH_LONG).show());
        findViewById(R.id.multiple_actions_animated_icon).setOnClickListener(v ->
                Snackbar.make(parentLayout,"Animated icon clicked", Snackbar.LENGTH_LONG).show());
    }
}
