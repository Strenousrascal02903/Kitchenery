package com.example.kitchenery;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseListMakanan{

	@SerializedName("meals")
	private List<Makanan> meals;

	public List<Makanan> getMeals(){
		return meals;
	}


}