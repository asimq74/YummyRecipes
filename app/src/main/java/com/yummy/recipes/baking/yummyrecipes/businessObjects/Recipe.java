package com.yummy.recipes.baking.yummyrecipes.businessObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

/**
 * Created by U1C306 on 11/10/2017.
 */

public class Recipe {

	private Integer id;
	private String image;
	private List<Ingredient> ingredients = new ArrayList<>();
	private String name;
	private Integer servings;
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
