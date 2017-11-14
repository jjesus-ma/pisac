package mx.gob.profeco.pisac.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.View;

/**
 * Created by jjesus on 11/7/17.
 */

public class Utils {

   public static synchronized void requestPermission(final Activity activity, final String permission){
      if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) return;
      int result  = activity.checkCallingOrSelfPermission(permission);
      if (result != PackageManager.PERMISSION_GRANTED) {
         if(activity.shouldShowRequestPermissionRationale(permission)){

         } else {
            activity.requestPermissions(new String[]{permission}, 0);
         }
      }
   }

   public static synchronized boolean checkForPermission(Context context, String permission){
      int result  = context.checkCallingOrSelfPermission(permission);
      return  (result == PackageManager.PERMISSION_GRANTED);
   }


}
