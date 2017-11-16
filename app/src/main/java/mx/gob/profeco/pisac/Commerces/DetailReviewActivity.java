package mx.gob.profeco.pisac.Commerces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import mx.gob.profeco.pisac.R;
import mx.gob.profeco.pisac.base.BaseActivity;

public class DetailReviewActivity extends BaseActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_detail_review);

      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      toolbar.removeView(toolbar.findViewById(R.id.logo_toolbar));
      setSupportActionBar(toolbar);
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);

      setTitle("CONDICIONES GENERALES");
   }

   public void saveInfo(View v){
      onBackPressed();
   }

}
