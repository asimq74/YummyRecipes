package com.yummy.recipes.baking.yummyrecipes.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import android.util.Log;

import com.yummy.recipes.baking.yummyrecipes.businessObjects.Ingredient;
import com.yummy.recipes.baking.yummyrecipes.businessObjects.Recipe;
import com.yummy.recipes.baking.yummyrecipes.businessObjects.Step;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by U1C306 on 11/10/2017.
 */

public class Util {

	private final static String TAG = "Util";

	public static List<Recipe> getRecipes() {
		List<Recipe> recipes = new ArrayList<>();
		try {
			recipes = new RecipesDownloaderTask().execute("https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json").get();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Log.e(TAG, "caught an exception while downloading file contents ", e);
		} finally {
			return recipes;
		}
	}

}
