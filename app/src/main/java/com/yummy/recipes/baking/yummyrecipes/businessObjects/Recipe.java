package com.yummy.recipes.baking.yummyrecipes.businessObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by U1C306 on 11/10/2017.
 */

public class Recipe extends RealmObject {

	@SerializedName(value = "id")
	@PrimaryKey
	private Integer id;
	@SerializedName(value = "image")
	private String image;
	@SerializedName(value = "ingredients")
	private RealmList<Ingredient> ingredients = new RealmList<>();
	@SerializedName(value = "name")
	private String name;
	@SerializedName(value = "servings")
	private Integer servings;
	@SerializedName(value = "steps")
	private RealmList<Step> steps = new RealmList<>();

	public Recipe() {
	}

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

	public void setIngredients(RealmList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setServings(Integer servings) {
		this.servings = servings;
	}

	public void setSteps(RealmList<Step> steps) {
		this.steps = steps;
	}
}
