package mx.gob.profeco.pisac.login;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import mx.gob.profeco.pisac.MapsActivity;
import mx.gob.profeco.pisac.R;
import mx.gob.profeco.pisac.base.BaseActivity;
import mx.gob.profeco.pisac.camera.QRScannerActivity;
import mx.gob.profeco.pisac.utils.Utils;

public class LoginActivity extends BaseActivity {

   private static final String TAG = "LoginActivity";

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_login);
   }

   public void login(View v){
      Log.i(TAG, "Login click");

      Intent i = new Intent(this, MapsActivity.class);
      startActivity(i);
      finish();
   }

   public void scan(View v){
      Intent scanIntent = new Intent(this, QRScannerActivity.class);
      startActivityForResult(scanIntent,1);
   }
}
