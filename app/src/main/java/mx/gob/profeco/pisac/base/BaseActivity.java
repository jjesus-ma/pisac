package mx.gob.profeco.pisac.base;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by jjesus on 11/15/17.
 */

public class BaseActivity extends AppCompatActivity {

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()) {
         case android.R.id.home:
            onBackPressed();
            return true;

         default:
            return super.onOptionsItemSelected(item);
      }
   }
}
