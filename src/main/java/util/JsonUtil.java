package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {
	private static final Gson gson = new GsonBuilder()
			.setPrettyPrinting()
			.create();

	public static String toJson(Object obj) {
		return gson.toJson(obj);
	}

	public static <T> T fromJson(String json, Class<T> type){
		return gson.fromJson(json, type);
	}
}
