package mx.gob.profeco.pisac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import mx.gob.profeco.pisac.Commerces.AddCommerceActivity;
import mx.gob.profeco.pisac.Commerces.CommerceDetailActivity;
import mx.gob.profeco.pisac.base.BaseActivity;

public class CommercesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean pendings = (boolean) getIntent().getExtras().get("pending");

        setContentView(pendings ? R.layout.activity_pending_commerces : R.layout.activity_commerces );
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.removeView(toolbar.findViewById(R.id.logo_toolbar));
        setSupportActionBar(toolbar);

        setTitle(pendings ? "REVISIONES PENDIENTES" : "CHECK IN");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    public void addCommerce(View v){
        Log.i("Add", "Commerce *****************");
        Intent i = new Intent(this, AddCommerceActivity.class);
        startActivity(i);
    }

    public void viewCommerce(View v){
        Log.i("View", "Commerce ----------------");
        Intent i = new Intent(this, CommerceDetailActivity.class);
        startActivity(i);
    }
}
