package com.example.middleware.utils;

import java.util.HashMap;
import java.util.Map;

public class ParamsUtils {

	public static HashMap<String, String> transformMapToHashMap(Map<String,String> allParams){
		HashMap<String, String> hashMap = new HashMap<>(allParams);
		return hashMap;
	}
}
