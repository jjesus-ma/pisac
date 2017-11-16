package mx.gob.profeco.pisac.Commerces;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import mx.gob.profeco.pisac.R;
import mx.gob.profeco.pisac.base.BaseActivity;
import mx.gob.profeco.pisac.validate.ValidateActivity;

public class ReviewCommerceActivity extends BaseActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_review_commerce);

      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      toolbar.removeView(toolbar.findViewById(R.id.logo_toolbar));
      setSupportActionBar(toolbar);
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      setTitle("INGRESAR EMPRESA");
   }

   public void moreInfo(View v){
      Intent i = new Intent(this, DetailReviewActivity.class);
      startActivity(i);
   }

   public void finishReview(View view){
      Intent i = new Intent(this, ValidateActivity.class);
      startActivity(i);
      finish();
   }
}
