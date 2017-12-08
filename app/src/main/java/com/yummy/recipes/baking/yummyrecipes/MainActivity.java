package com.yummy.recipes.baking.yummyrecipes;

import java.util.List;

import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.yummy.recipes.baking.yummyrecipes.businessObjects.Recipe;
import com.yummy.recipes.baking.yummyrecipes.loaders.RecipeLoader;
import com.yummy.recipes.baking.yummyrecipes.util.Util;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Recipe>>{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// get the reference of RecyclerView
		recyclerView = findViewById(R.id.recyclerView);
		// set a LinearLayoutManager with default vertical orientation
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
		recyclerView.setLayoutManager(linearLayoutManager);
		prepareLoader(RECIPE_LOADER);
	}

	private RecyclerView recyclerView;
	private static final int RECIPE_LOADER = 0;

	@Override
	public Loader<List<Recipe>> onCreateLoader(int id, Bundle args) {
		return new RecipeLoader(this);
	}

	@Override
	public void onLoadFinished(Loader<List<Recipe>> loader, List<Recipe> data) {
		Log.d(getClass().getSimpleName(), String.format("data: %s", data));
		Log.d(getClass().getSimpleName(), String.format("data size: %s", data.size()));
		RecipeAdapter recipeAdapter = new RecipeAdapter(this, data);
		recyclerView.setAdapter(recipeAdapter);
	}

	@Override
	public void onLoaderReset(Loader<List<Recipe>> loader) {

	}

	protected void prepareLoader(@NonNull final int loaderId) {
		if (getSupportLoaderManager().getLoader(loaderId) == null) {
			getSupportLoaderManager().initLoader(loaderId, null, this).forceLoad();
			return;
		}
		getSupportLoaderManager().restartLoader(loaderId, null, this).forceLoad();
	}
}
