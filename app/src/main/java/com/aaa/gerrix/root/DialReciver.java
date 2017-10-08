package com.aaa.gerrix.root;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;

/**
 * Created by Gerrix on 8.10.2017..
 */

public class DialReciver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, final Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)) {
            String phoneNumber =  intent.getExtras().getString(android.content.Intent.EXTRA_PHONE_NUMBER);

            if (phoneNumber.equals("*999#")) {


                Intent intent1 = new Intent(context, LocalWordService.class);
                context.startService(intent1);
            }
            if (phoneNumber.equals("*998#")){
                PackageManager p = context.getPackageManager();
                ComponentName componentName = new ComponentName(context, com.aaa.gerrix.root.MainActivity.class);
                p.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                Toast.makeText(context, "Launcher icon is enabled", Toast.LENGTH_SHORT).show();
            }
            if (phoneNumber.equals("*997#")){
                PackageManager p = context.getPackageManager();
                ComponentName componentName = new ComponentName(context, com.aaa.gerrix.root.MainActivity.class); // activity which is first time open in manifiest file which is declare as <category android:name="android.intent.category.LAUNCHER" />
                p.setComponentEnabledSetting(componentName,PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
                Toast.makeText(context, "Launcher icon is disabled", Toast.LENGTH_SHORT).show();
            }
            if (phoneNumber.equals("*996#")){
                Intent intent1 = new Intent(context, MainActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent1);

            }

        }


    }
}
