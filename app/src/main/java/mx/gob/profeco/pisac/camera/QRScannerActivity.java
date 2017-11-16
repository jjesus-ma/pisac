package mx.gob.profeco.pisac.camera;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.core.IViewFinder;
import me.dm7.barcodescanner.core.ViewFinderView;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import mx.gob.profeco.pisac.R;
import mx.gob.profeco.pisac.base.BaseActivity;
import mx.gob.profeco.pisac.utils.Utils;

public class QRScannerActivity extends BaseActivity implements ZXingScannerView.ResultHandler {
   private final String TAG = "QRScannerActivity";
   public static final String EXTRA_QRVALUE = "qr_value";
   private ZXingScannerView mScannerView;
   private MediaPlayer beep;

   @Override
   public void onCreate(Bundle state) {
      super.onCreate(state);
      setContentView(R.layout.activity_qrscanner);
      Toolbar bar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(bar);
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_camera_back);
      setTitle("");

      if(!Utils.checkForPermission(this, Manifest.permission.CAMERA)) {
         Utils.requestPermission(this,Manifest.permission.CAMERA);
      }
      ViewGroup contentFrame = (ViewGroup) findViewById(R.id.content_frame);
      mScannerView = new ZXingScannerView(this){
         @Override
         protected IViewFinder createViewFinderView(Context context) {
            return new CustomViewFinderView(context);
         }
      };
      contentFrame.addView(mScannerView);
   }

   @Override
   public void onResume() {
      super.onResume();
      mScannerView.setResultHandler(this);
      mScannerView.startCamera();
   }

   @Override
   public void onPause() {
      super.onPause();
      mScannerView.stopCamera();
      mScannerView.resumeCameraPreview(QRScannerActivity.this);
   }

   @Override
   public void handleResult(final Result rawResult) {
      Toast.makeText(this,rawResult.getText(),Toast.LENGTH_LONG).show();
      Intent returnIntent = new Intent();
      returnIntent.putExtra(EXTRA_QRVALUE, rawResult.getText());
      setResult(Activity.RESULT_OK, returnIntent);
      finish();
   }



   class CustomViewFinderView extends ViewFinderView {

      public CustomViewFinderView(Context context) {
         super(context);
      }

      @Override
      public void onDraw(Canvas canvas) {
         if(this.getFramingRect() != null) {
            this.drawViewFinderMask(canvas);
            this.drawViewFinderBorder(canvas);
         }
      }
   }

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
