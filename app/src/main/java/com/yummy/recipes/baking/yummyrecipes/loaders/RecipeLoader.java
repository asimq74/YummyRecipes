package com.yummy.recipes.baking.yummyrecipes.loaders;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yummy.recipes.baking.yummyrecipes.businessObjects.Recipe;
import com.yummy.recipes.baking.yummyrecipes.util.RecipesDownloaderTask;
import com.yummy.recipes.baking.yummyrecipes.util.Util;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by U1C306 on 11/14/2017.
 */

public class RecipeLoader extends AsyncTaskLoader<List<Recipe>> {

	final String TAG = this.getClass().getSimpleName();

	public RecipeLoader(Context context) {
		super(context);
	}

	protected List<Recipe> collectRecipes(String urlString) {
		String fileContentString = "";
		List<Recipe> recipes = new ArrayList<>();
		try {
			fileContentString = run(urlString);
			Gson gson = new Gson();
			Type recipeListType = new TypeToken<List<Recipe>>() {}.getType();
			recipes = gson.fromJson(fileContentString, recipeListType);
			storeRecipes(recipes);
		} catch (IOException e) {
			Log.e(getClass().getSimpleName(), "caught an exception while downloading file contents ", e);
		}
		return recipes;
	}

	public List<Recipe> getRecipes() {
		return collectRecipes("https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json");
	}

	@Override
	public List<Recipe> loadInBackground() {
		final List<Recipe> recipes = new ArrayList<>();
		try (Realm realm = Realm.getDefaultInstance()) {
			realm.executeTransaction(new Realm.Transaction() {
				@Override
				public void execute(Realm realm) {
					RealmQuery<Recipe> query = realm.where(Recipe.class);
					RealmResults<Recipe> results = query.findAll();
					recipes.addAll(realm.copyFromRealm(results));
				}
			});
		} catch (Exception e) {
			Log.e(getClass().getSimpleName(), "caught an exception while storing the recipes ", e);
		}
		if (recipes.isEmpty()) {
			recipes.addAll(getRecipes());
		}
		Log.d(getClass().getSimpleName(), String.format("recipes: %s", recipes));
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

	public void storeRecipes(final List<Recipe> recipes) {
		try (Realm realm = Realm.getDefaultInstance()) {
			realm.executeTransaction(new Realm.Transaction() {
				@Override
				public void execute(Realm realm) {
					realm.insertOrUpdate(recipes);
				}
			});
		} catch (Exception e) {
			Log.e(getClass().getSimpleName(), "caught an exception while storing recipes ", e);
		}
	}

}
