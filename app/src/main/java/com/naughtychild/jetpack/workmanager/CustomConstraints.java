package com.naughtychild.jetpack.workmanager;

import androidx.work.Constraints;
import androidx.work.NetworkType;

public class CustomConstraints {
    private Constraints constraints;

    private CustomConstraints() {
        constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).setRequiresBatteryNotLow(true).build();
    }

    public static CustomConstraints getInstance() {
        return new CustomConstraints();
    }

}
