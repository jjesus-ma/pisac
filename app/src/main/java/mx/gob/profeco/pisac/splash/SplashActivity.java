package mx.gob.profeco.pisac.splash;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import mx.gob.profeco.pisac.R;
import mx.gob.profeco.pisac.base.BaseActivity;
import mx.gob.profeco.pisac.login.LoginActivity;

public class SplashActivity extends BaseActivity {

   private static final String TAG = "SplashActivity";

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_splash);

      final Handler handler = new Handler();
      handler.postDelayed(new Runnable() {
         @Override
         public void run() {
            Intent i = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
         }
      }, 2000);
   }

   public void onLoginClick(View v){
      Log.i(TAG, "Login click");

      Intent i = new Intent(this, LoginActivity.class);
      startActivity(i);
      finish();
   }
}
