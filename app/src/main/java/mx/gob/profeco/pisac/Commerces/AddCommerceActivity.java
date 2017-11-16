package mx.gob.profeco.pisac.Commerces;

import android.content.Intent;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import mx.gob.profeco.pisac.R;
import mx.gob.profeco.pisac.base.BaseActivity;
import mx.gob.profeco.pisac.login.LoginActivity;
import mx.gob.profeco.pisac.splash.SplashActivity;

public class AddCommerceActivity extends BaseActivity implements OnMapReadyCallback {

   private GoogleMap mMap;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_add_commerce);

      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      toolbar.removeView(toolbar.findViewById(R.id.logo_toolbar));
      setSupportActionBar(toolbar);
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      setTitle("INGRESAR EMPRESA");

      // Obtain the SupportMapFragment and get notified when the map is ready to be used.
      SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
              .findFragmentById(R.id.map);
      mapFragment.getMapAsync(this);
   }

   @Override
   public void onMapReady(GoogleMap googleMap) {
      mMap = googleMap;

      // Add a marker in Sydney and move the camera
      //LatLng cdmx = new LatLng(19.4315079, -99.1339532);
      //mMap.addMarker(new MarkerOptions().position(cdmx).title("Ciudad de México"));
     // mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cdmx, 15));
      //TODO:
      //if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
      mMap.setMyLocationEnabled(true);
      mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
         @Override
         public void onMyLocationChange(Location location) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(),location.getLongitude()), 15));
            mMap.setOnMyLocationChangeListener(null);

            BitmapDescriptor markerOk = BitmapDescriptorFactory.fromResource(R.mipmap.ic_marker_ok);
            BitmapDescriptor markerErr = BitmapDescriptorFactory.fromResource(R.mipmap.ic_marker_err);
            mMap.addMarker(new MarkerOptions().icon(markerOk).draggable(true).position(new LatLng(location.getLatitude()-0.0001, location.getLongitude()+ 0.0001)));

         }
      });
   }

   public void next(View v){
      Intent i = new Intent(this, ReviewCommerceActivity.class);
      startActivity(i);
   }
}
