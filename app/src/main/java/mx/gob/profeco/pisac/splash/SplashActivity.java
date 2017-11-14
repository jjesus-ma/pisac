package mx.gob.profeco.pisac.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import mx.gob.profeco.pisac.R;
import mx.gob.profeco.pisac.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

   private static final String TAG = "SplashActivity";

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_splash);
   }

   public void onLoginClick(View v){
      Log.i(TAG, "Login click");

      Intent i = new Intent(this, LoginActivity.class);
      startActivity(i);
      finish();
   }
}
