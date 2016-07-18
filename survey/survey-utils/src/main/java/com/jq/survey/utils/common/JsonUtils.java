package com.jq.survey.utils.common;

import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * 
 * @author juqi
 * @version $Id: JsonUtils.java, v 0.1 2016年7月12日 下午3:38:30 juqi Exp $
 */
public class JsonUtils {

	private static Gson gson;

    private JsonUtils() {
    }

    static {
        GsonBuilder gb = new GsonBuilder();
        gb.setDateFormat("yyyy-MM-dd HH:mm:ss");
        // gb.setPrettyPrinting(); // test
        gson = gb.create();
    }

    public static final String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static final <T> T fromJson(final String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static final <T> T fromJson(final String json, Type t) {
        return gson.fromJson(json, t);
    }

    @SuppressWarnings("unchecked")
	public static final Map<String, Object> fromJson(final String json) {
        return fromJson(json, Map.class);
    }
    
}
