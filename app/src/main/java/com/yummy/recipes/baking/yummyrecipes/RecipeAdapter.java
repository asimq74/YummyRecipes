package com.yummy.recipes.baking.yummyrecipes;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yummy.recipes.baking.yummyrecipes.RecipeAdapter.RecipeAdapterViewHolder;
import com.yummy.recipes.baking.yummyrecipes.businessObjects.Recipe;

/**
 * Created by U1C306 on 12/8/2017.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapterViewHolder> {

	private final List<Recipe> recipes;
	private final Context context;
	public RecipeAdapter(Context context, List<Recipe> recipes) {
		this.context = context;
		this.recipes = recipes;
	}

	final String TAG = this.getClass().getSimpleName();

	/**
	 * Cache of the children views for a forecast list item.
	 */
	public class RecipeAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

		public final TextView mNameView;

		public RecipeAdapterViewHolder(View view) {
			super(view);
			mNameView = view.findViewById(R.id.name);
			view.setOnClickListener(this);

		}

		@Override
		public void onClick(View v) {
			Log.i(TAG, "clicked me");
		}
	}

	@Override
	public RecipeAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// infalte the item Layout
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item, parent, false);
		// set the view's size, margins, paddings and layout parameters
		RecipeAdapterViewHolder vh = new RecipeAdapterViewHolder(v); // pass the view to View Holder
		return vh;
	}

	@Override
	public void onBindViewHolder(RecipeAdapterViewHolder holder, final int position) {
// set the data in items
		holder.mNameView.setText(recipes.get(position).getName());
		// implement setOnClickListener event on item view.
		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// display a toast with person name on item click
				Toast.makeText(context, recipes.get(position).getName(), Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public int getItemCount() {
		return recipes.size();
	}
}
