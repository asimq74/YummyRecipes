package com.yummy.recipes.baking.yummyrecipes.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

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
			JSONArray jsonArray = new JSONArray(fileContentString);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject recipeJson = jsonArray.getJSONObject(i);
				Recipe recipe = new Recipe();
				recipe.setId(recipeJson.getInt("id"));
				recipe.setImage(recipeJson.getString("image"));
				recipe.setName(recipeJson.getString("name"));
				recipe.setServings(recipeJson.getInt("servings"));
				JSONArray ingredientsJSONArray = recipeJson.getJSONArray("ingredients");
				for (int j = 0; j < ingredientsJSONArray.length(); j++) {
					JSONObject ingredientJson = ingredientsJSONArray.getJSONObject(j);
					Ingredient ingredient = new Ingredient();
					ingredient.setQuantity(ingredientJson.getDouble("quantity"));
					ingredient.setMeasure(ingredientJson.getString("measure"));
					ingredient.setIngredient(ingredientJson.getString("ingredient"));
					recipe.getIngredients().add(ingredient);
				}
				JSONArray stepsJSONArray = recipeJson.getJSONArray("steps");
				for (int j = 0; j < stepsJSONArray.length(); j++) {
					JSONObject stepJson = stepsJSONArray.getJSONObject(j);
					Step step = new Step();
					step.setDescription(stepJson.getString("description"));
					step.setShortDescription(stepJson.getString("shortDescription"));
					step.setId(stepJson.getInt("id"));
					step.setThumbnailURL(stepJson.getString("thumbnailURL"));
					step.setVideoURL(stepJson.getString("videoURL"));
					recipe.getSteps().add(step);
				}
				recipes.add(recipe);
			}
		} catch (IOException e) {
			Log.e(getClass().getSimpleName(), "caught an exception while downloading file contents ", e);
		} catch (JSONException e) {
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