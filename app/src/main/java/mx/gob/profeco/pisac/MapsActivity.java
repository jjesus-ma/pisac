package mx.gob.profeco.pisac;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import mx.gob.profeco.pisac.login.LoginActivity;
import mx.gob.profeco.pisac.utils.CircleTransform;

public class MapsActivity extends AppCompatActivity
        implements OnMapReadyCallback, NavigationView.OnNavigationItemSelectedListener {

   private final static String TAG = "MapsActivity";
   private GoogleMap mMap;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);

      DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
      ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
              this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
      drawer.setDrawerListener(toggle);
      toggle.syncState();

      NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
      navigationView.setNavigationItemSelectedListener(this);

      // Obtain the SupportMapFragment and get notified when the map is ready to be used.
      SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
              .findFragmentById(R.id.map);
      mapFragment.getMapAsync(this);

      View headerContainer = navigationView.getHeaderView(0); // This returns the container layout in nav_drawer_header.xml (e.g., your RelativeLayout or LinearLayout)
      ImageView avatar = (ImageView) headerContainer.findViewById(R.id.avatar_image);
      Picasso.with(this).load(R.mipmap.user_avatar).transform(new CircleTransform()).into(avatar);
   }

   @Override
   public void onMapReady(GoogleMap googleMap) {
      mMap = googleMap;

      // Add a marker in Sydney and move the camera
      LatLng cdmx = new LatLng(19.4315079, -99.1339532);
      //mMap.addMarker(new MarkerOptions().position(cdmx).title("Ciudad de México"));
      mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cdmx, 15));
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
               mMap.addMarker(new MarkerOptions().icon(markerOk).draggable(false).position(new LatLng(location.getLatitude()-0.003, location.getLongitude()+ 0.003)));
               mMap.addMarker(new MarkerOptions().icon(markerOk).draggable(false).position(new LatLng(location.getLatitude()+0.003, location.getLongitude()+ 0.003)));
               mMap.addMarker(new MarkerOptions().icon(markerOk).draggable(false).position(new LatLng(location.getLatitude()-0.003, location.getLongitude()- 0.003)));
               mMap.addMarker(new MarkerOptions().icon(markerErr).draggable(false).position(new LatLng(location.getLatitude()+0.002, location.getLongitude()+ 0.001)));
               mMap.addMarker(new MarkerOptions().icon(markerErr).draggable(false).position(new LatLng(location.getLatitude()+0.004, location.getLongitude()+ 0.001)));
               mMap.addMarker(new MarkerOptions().icon(markerErr).draggable(false).position(new LatLng(location.getLatitude()-0.002, location.getLongitude()- 0.004)));
            }
         });
      //}
   }

   @Override
   public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
      //TODO:
      /*if (requestCode == MY_LOCATION_REQUEST_CODE) {
         if (permissions.length == 1 &&
                 permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION &&
                 grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
         } else {
            // Permission was denied. Display an error message.
         }
      }
      */
   }

   @Override
   public void onBackPressed() {
      DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
      if (drawer.isDrawerOpen(GravityCompat.START)) {
         drawer.closeDrawer(GravityCompat.START);
      } else {
         super.onBackPressed();
      }
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      //getMenuInflater().inflate(R.menu.main, menu);
      return false;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      // Handle action bar item clicks here. The action bar will
      // automatically handle clicks on the Home/Up button, so long
      // as you specify a parent activity in AndroidManifest.xml.
      int id = item.getItemId();

      //noinspection SimplifiableIfStatement
      if (id == R.id.action_settings) {
         return true;
      }

      return super.onOptionsItemSelected(item);
   }

   @SuppressWarnings("StatementWithEmptyBody")
   @Override
   public boolean onNavigationItemSelected(MenuItem item) {
      // Handle navigation view item clicks here.
      int id = item.getItemId();

      if (id == R.id.nav_camera) {
         // Handle the camera action
      } else if (id == R.id.nav_gallery) {

      } else if (id == R.id.nav_slideshow) {

      } else if (id == R.id.nav_manage) {

      } else if (id == R.id.nav_share) {

      } else if (id == R.id.nav_send) {

      }

      DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
      drawer.closeDrawer(GravityCompat.START);
      return true;
   }

   public void checkIn(View v) {

      Intent i = new Intent(this, CommercesActivity.class);
      i.putExtra("pending",false);
      startActivity(i);
   }

   public void pendings(View v){

      Intent i = new Intent(this, CommercesActivity.class);
      i.putExtra("pending",true);
      startActivity(i);
   }
}
