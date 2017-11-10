package com.yummy.recipes.baking.yummyrecipes.businessObjects;

/**
 * Created by U1C306 on 11/10/2017.
 */

public class Step {

	private String description;
	private Integer id;
	private String shortDescription;
	private String thumbnailURL;
	private String videoURL;

	public String getDescription() {
		return description;
	}

	public Integer getId() {
		return id;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public String getThumbnailURL() {
		return thumbnailURL;
	}

	public String getVideoURL() {
		return videoURL;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public void setThumbnailURL(String thumbnailURL) {
		this.thumbnailURL = thumbnailURL;
	}

	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}

}
