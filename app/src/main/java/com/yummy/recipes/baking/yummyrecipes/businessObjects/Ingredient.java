package com.yummy.recipes.baking.yummyrecipes.businessObjects;

import com.google.gson.annotations.SerializedName;

/**
 * Created by U1C306 on 11/10/2017.
 */

public class Ingredient {

	@SerializedName(value ="ingredient")
	private String ingredient;
	@SerializedName(value ="measure")
	private String measure;
	@SerializedName(value ="quantity")
	private Double quantity;

	public String getIngredient() {
		return ingredient;
	}

	public String getMeasure() {
		return measure;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

}