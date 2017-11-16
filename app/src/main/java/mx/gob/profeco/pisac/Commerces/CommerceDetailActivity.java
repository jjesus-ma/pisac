package mx.gob.profeco.pisac.Commerces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import mx.gob.profeco.pisac.R;
import mx.gob.profeco.pisac.base.BaseActivity;
import mx.gob.profeco.pisac.utils.CircleTransform;

public class CommerceDetailActivity extends BaseActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_commerce_detail);

      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      toolbar.removeView(toolbar.findViewById(R.id.logo_toolbar));
      setSupportActionBar(toolbar);
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);

      setTitle("DETALLES");

      ImageView avatar = (ImageView) findViewById(R.id.commerce_logo);
      Picasso.with(this).load(R.drawable.multinegocios).transform(new CircleTransform()).into(avatar);
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.commerce_detail, menu);
      return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      // Handle action bar item clicks here. The action bar will
      // automatically handle clicks on the Home/Up button, so long
      // as you specify a parent activity in AndroidManifest.xml.
      int id = item.getItemId();

      //noinspection SimplifiableIfStatement
      if (id == R.id.action_settings) {
         Intent i = new Intent(this, EditCommerceActivity.class);
         startActivity(i);
         return true;
      }

      return super.onOptionsItemSelected(item);
   }
}
