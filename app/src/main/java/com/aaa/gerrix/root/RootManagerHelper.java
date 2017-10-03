package com.aaa.gerrix.root;

import android.util.Log;
import com.chrisplus.rootmanager.RootManager;
import com.chrisplus.rootmanager.container.Result;


public class RootManagerHelper {

    private static final String TAG = "Provera";
    private RootManager rootManager;
    private Result result;


    public Result scanWlan() {
        rootManager = RootManager.getInstance();


        if (rootManager.hasRooted()) {

             result = rootManager.runCommand("ip neigh show");
            Log.d(TAG, result.getMessage());

        } else {

            Log.i(TAG, "App is not rooted");
            rootManager.obtainPermission();

            if (rootManager.hasRooted()) {

                Log.i(TAG, "App is rooted after obtaining permission");

            } else {

                Log.i(TAG, "App is not rooted after obtaining permission");
            }
        }

        return result;
    }

}
