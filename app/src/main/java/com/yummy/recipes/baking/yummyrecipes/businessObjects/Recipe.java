package com.yummy.recipes.baking.yummyrecipes.businessObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

/**
 * Created by U1C306 on 11/10/2017.
 */

public class Recipe {

	@SerializedName(value = "id")
	private Integer id;
	@SerializedName(value = "image")
	private String image;
	@SerializedName(value = "ingredients")
	private List<Ingredient> ingredients = new ArrayList<>();
	@SerializedName(value = "name")
	private String name;
	@SerializedName(value = "servings")
	private Integer servings;
	@SerializedName(value = "steps")
	private List<Step> steps = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public String getName() {
		return name;
	}

	public Integer getServings() {
		return servings;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setServings(Integer servings) {
		this.servings = servings;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}
}
