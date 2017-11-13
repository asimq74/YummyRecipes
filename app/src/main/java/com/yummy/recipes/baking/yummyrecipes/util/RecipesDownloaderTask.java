package com.yummy.recipes.baking.yummyrecipes.util;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.yummy.recipes.baking.yummyrecipes.businessObjects.Ingredient;
import com.yummy.recipes.baking.yummyrecipes.businessObjects.Recipe;
import com.yummy.recipes.baking.yummyrecipes.businessObjects.Step;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by U1C306 on 11/10/2017.
 */

public class RecipesDownloaderTask extends AsyncTask<String, Void, List<Recipe>> {

	@Override
	protected List<Recipe> doInBackground(String... params) {
		String urlString = params[0];
		String fileContentString = "";
		List<Recipe> recipes = new ArrayList<>();
		try {
			fileContentString = run(urlString);
			Gson gson = new Gson();
			Type recipeListType = new TypeToken<List<Recipe>>() {}.getType();
			recipes = gson.fromJson(fileContentString, recipeListType);
			recipes.addAll(recipes);
		} catch (IOException e) {
			Log.e(getClass().getSimpleName(), "caught an exception while downloading file contents ", e);
		}
		return recipes;
	}

	@NonNull
	protected String run(@NonNull final String url) throws IOException {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.url(url)
				.build();

		Response response = client.newCall(request).execute();
		return response.body().string();
	}
}