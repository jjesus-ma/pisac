package mx.gob.profeco.pisac.Commerces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import mx.gob.profeco.pisac.R;
import mx.gob.profeco.pisac.utils.CircleTransform;

public class EditCommerceActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_edit_commerce);

      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      toolbar.removeView(toolbar.findViewById(R.id.logo_toolbar));
      setSupportActionBar(toolbar);
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      setTitle("EDITAR");

      ImageView avatar = (ImageView) findViewById(R.id.commerce_logo);
      Picasso.with(this).load(R.drawable.multinegocios).transform(new CircleTransform()).into(avatar);

      ImageView fachada = (ImageView) findViewById(R.id.commerce_fachada);
      Picasso.with(this).load(R.drawable.fachada_1).transform(new CircleTransform()).into(fachada);

   }

   public void save(View V){
      finish();
   }
}
