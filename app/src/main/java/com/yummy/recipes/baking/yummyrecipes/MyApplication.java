package com.yummy.recipes.baking.yummyrecipes;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by U1C306 on 11/14/2017.
 */

public class MyApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		Realm.init(this);
		RealmConfiguration config = new RealmConfiguration.Builder().name("myrealm.realm").build();
		Realm.setDefaultConfiguration(config);
	}
}
