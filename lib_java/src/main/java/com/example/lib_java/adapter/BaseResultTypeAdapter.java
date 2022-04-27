package com.example.lib_java.adapter;

import com.example.lib_java.bean.BaseResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.bind.TypeAdapters;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * 适配BaseResult
 */
public class BaseResultTypeAdapter implements JsonDeserializer<BaseResult> {

    @Override
    public BaseResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final BaseResult result = new BaseResult();
        JsonObject jsonObject = json.getAsJsonObject();
        result.code = jsonObject.get("code").getAsInt();
        result.message = jsonObject.get("message").getAsString();
        JsonElement dataJsonElement = jsonObject.get("data");

        if (dataJsonElement.isJsonArray() && !dataJsonElement.isJsonNull()) {
            //JSONArray类型
            String mJson = dataJsonElement.toString();
            if (result.code == 1) {
                Type type = ((ParameterizedType) typeOfT).getActualTypeArguments()[0];
                result.data = fromJsonArray(mJson, type);
            }
        } else if (dataJsonElement.isJsonObject() && !dataJsonElement.isJsonNull()) {
            //JSONObject类型
            String mJson = dataJsonElement.toString();
            if (result.code == 1) {
                Type type = ((ParameterizedType) typeOfT).getActualTypeArguments()[0];
                result.data = fromJsonObject(mJson, type);
            }
        } else if (dataJsonElement.isJsonPrimitive() && !dataJsonElement.isJsonNull()) {
            //JSON原始类型
            if (result.code == 1) {
                JsonPrimitive jsonPrimitive = dataJsonElement.getAsJsonPrimitive();
                if (jsonPrimitive.isBoolean()) {
                    result.data = jsonPrimitive.getAsBoolean();
                } else if (jsonPrimitive.isNumber()) {
                    result.data = jsonPrimitive.getAsNumber();
                } else if (jsonPrimitive.isString()) {
                    result.data = jsonPrimitive.getAsString();
                }
            }
        }
        return result;
    }

    private <T> T fromJsonObject(String json, Type type) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(TypeAdapters.newFactory(boolean.class, Boolean.class, new BooleanTypeAdapter()))
                .registerTypeAdapterFactory(TypeAdapters.newFactory(int.class, Integer.class, new IntegerTypeAdapter()))
                .registerTypeAdapterFactory(TypeAdapters.newFactory(long.class, Long.class, new LongTypeAdapter()))
                .registerTypeAdapterFactory(TypeAdapters.newFactory(float.class, Float.class, new FloatTypeAdapter()))
                .registerTypeAdapterFactory(TypeAdapters.newFactory(double.class, Double.class, new DoubleTypeAdapter()))
                .registerTypeAdapterFactory(TypeAdapters.newFactory(String.class, new StringTypeAdapter()))
                .registerTypeAdapterFactory(TypeAdapters.newFactory(BigDecimal.class, new BigDecimalTypeAdapter()))
                .create();
        return gson.fromJson(json, type);
    }

    private <T> ArrayList<T> fromJsonArray(String json, Type type) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(TypeAdapters.newFactory(boolean.class, Boolean.class, new BooleanTypeAdapter()))
                .registerTypeAdapterFactory(TypeAdapters.newFactory(int.class, Integer.class, new IntegerTypeAdapter()))
                .registerTypeAdapterFactory(TypeAdapters.newFactory(long.class, Long.class, new LongTypeAdapter()))
                .registerTypeAdapterFactory(TypeAdapters.newFactory(float.class, Float.class, new FloatTypeAdapter()))
                .registerTypeAdapterFactory(TypeAdapters.newFactory(double.class, Double.class, new DoubleTypeAdapter()))
                .registerTypeAdapterFactory(TypeAdapters.newFactory(String.class, new StringTypeAdapter()))
                .registerTypeAdapterFactory(TypeAdapters.newFactory(BigDecimal.class, new BigDecimalTypeAdapter()))
                .create();
        return gson.fromJson(json, type);
    }
}
