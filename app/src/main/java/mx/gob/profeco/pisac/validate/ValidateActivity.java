package mx.gob.profeco.pisac.validate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mx.gob.profeco.pisac.Commerces.AddCommerceActivity;
import mx.gob.profeco.pisac.MapsActivity;
import mx.gob.profeco.pisac.R;

public class ValidateActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_validate);
   }

   public void terminate(View v){
      Intent i = new Intent(this, MapsActivity.class);
      startActivity(i);
      finish();
   }
}
