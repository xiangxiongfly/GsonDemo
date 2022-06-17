package com.example.lib_java.test;

import com.example.lib_java.adapter.BaseResultTypeAdapter;
import com.example.lib_java.adapter.BigDecimalTypeAdapter;
import com.example.lib_java.adapter.BooleanTypeAdapter;
import com.example.lib_java.adapter.DoubleTypeAdapter;
import com.example.lib_java.adapter.FloatTypeAdapter;
import com.example.lib_java.adapter.IntegerTypeAdapter;
import com.example.lib_java.adapter.LongTypeAdapter;
import com.example.lib_java.adapter.StringTypeAdapter;
import com.example.lib_java.bean.BaseResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.TypeAdapters;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 复杂JSON容错
 */
public class OtherTest {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(TypeAdapters.newFactory(boolean.class, Boolean.class, new BooleanTypeAdapter()))
                .registerTypeAdapterFactory(TypeAdapters.newFactory(int.class, Integer.class, new IntegerTypeAdapter()))
                .registerTypeAdapterFactory(TypeAdapters.newFactory(long.class, Long.class, new LongTypeAdapter()))
                .registerTypeAdapterFactory(TypeAdapters.newFactory(float.class, Float.class, new FloatTypeAdapter()))
                .registerTypeAdapterFactory(TypeAdapters.newFactory(double.class, Double.class, new DoubleTypeAdapter()))
                .registerTypeAdapterFactory(TypeAdapters.newFactory(String.class, new StringTypeAdapter()))
                .registerTypeAdapterFactory(TypeAdapters.newFactory(BigDecimal.class, new BigDecimalTypeAdapter()))
                .registerTypeAdapter(BaseResult.class, new BaseResultTypeAdapter())
                .create();

//        //JSON原始类型
//        System.out.println("data为double：");
//        String json = getJson("./user_double.json");
//        System.out.println("json:\n" + json);
//        BaseResult<Double> result = gson.fromJson(json, new TypeToken<BaseResult<Double>>() {
//        }.getType());
//        System.out.println("输出：\n" + result);
//        System.out.println("=================================");
//
//        System.out.println("data为boolean：");
//        String json2 = getJson("./user_boolean.json");
//        System.out.println("json:\n" + json2);
//        BaseResult<Boolean> result2 = gson.fromJson(json2, new TypeToken<BaseResult<Boolean>>() {
//        }.getType());
//        System.out.println("输出：\n" + result2);
//        System.out.println("=================================");
//
//        System.out.println("data为String：");
//        String json3 = getJson("./user_string.json");
//        System.out.println("json:\n" + json3);
//        BaseResult<String> result3 = gson.fromJson(json3, new TypeToken<BaseResult<String>>() {
//        }.getType());
//        System.out.println("输出：\n" + result3);
//        System.out.println("=================================");

//        System.out.println("data为null：");
//        String json3 = getJson("./user_null.json");
//        System.out.println("json:\n" + json3);
//        BaseResult<String> result3 = gson.fromJson(json3, new TypeToken<BaseResult<Double>>() {
//        }.getType());
//        System.out.println("输出：\n" + result3);
//        System.out.println("=================================");

//        //JSON Object类型
//        System.out.println("data为正确的JSONObject");
//        String json = getJson("./user_object.json");
//        System.out.println("json:\n" + json);
//        BaseResult<User> result = gson.fromJson(json, new TypeToken<BaseResult<User>>() {
//        }.getType());
//        System.out.println("输出：\n" + result);
//        System.out.println("=================================");
//
//        System.out.println("data为错误的JSONObject");
//        String json2 = getJson("./user_object_error.json");
//        System.out.println("json:\n" + json2);
//        BaseResult<User> result2 = gson.fromJson(json2, new TypeToken<BaseResult<User>>() {
//        }.getType());
//        System.out.println("输出：\n" + result2);
//        System.out.println("=================================");

        //JSON Array类型
//        System.out.println("data为正确的JSONArray");
//        String json = getJson("./user_array.json");
//        System.out.println("json:\n" + json);
//        BaseResult<ArrayList<User>> result = gson.fromJson(json, new TypeToken<BaseResult<ArrayList<User>>>() {
//        }.getType());
//        System.out.println("输出：\n" + result);
//        System.out.println("=================================");

//        System.out.println("data为错误的JSONArray");
//        String json2 = getJson("./user_array_error.json");
//        System.out.println("json:\n" + json2);
//        BaseResult<ArrayList<User>> result2 = gson.fromJson(json2, new TypeToken<BaseResult<ArrayList<User>>>() {
//        }.getType());
//        System.out.println("输出：\n" + result2);
//        System.out.println("=================================");
    }

    public static String getJson(String path) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            return new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
