package com.jvra.material;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS );

        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ) {
            getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        }

        setContentView(R.layout.activity_main);
    }


    public void onClick( View v ){
        Intent intent = new Intent(this,SecondActivity.class);

        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ){
            getWindow().setExitTransition( new Explode() );
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle() );
        }else{
            startActivity(intent);
        }
    }
}
