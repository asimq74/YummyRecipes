package com.yummy.recipes.baking.yummyrecipes.businessObjects;

/**
 * Created by U1C306 on 11/10/2017.
 */

public class Ingredient {

	private String ingredient;
	private String measure;
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