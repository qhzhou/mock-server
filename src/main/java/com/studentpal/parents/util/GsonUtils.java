package com.studentpal.parents.util;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.Reader;
import java.util.List;

public class GsonUtils {

    private static Gson gson = new Gson();

    public static <T> List<T> toList(Reader reader, Class<T> clazz) {
        if (null == reader) {
            return null;
        }
        List<T> result = Lists.newArrayList();
        JsonObject[] jsonObjects = gson.fromJson(reader, JsonObject[].class);
        for (JsonObject jsonObject : jsonObjects) {
            result.add(gson.fromJson(jsonObject, clazz));
        }
        return result;
    }

}
