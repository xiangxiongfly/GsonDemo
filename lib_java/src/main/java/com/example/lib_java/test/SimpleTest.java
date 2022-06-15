package com.example.lib_java.test;

import com.example.lib_java.bean.Person;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 基本数据类型容错
 */
public class SimpleTest {
    public static void main(String[] args) {

        Gson gson = new Gson();
        String json = "{}";
        Person person = gson.fromJson(json, Person.class);
        System.out.println(person);

//        Gson gson = new GsonBuilder()
//                .registerTypeAdapterFactory(TypeAdapters.newFactory(boolean.class, Boolean.class, new BooleanTypeAdapter()))
//                .registerTypeAdapterFactory(TypeAdapters.newFactory(int.class, Integer.class, new IntegerTypeAdapter()))
//                .registerTypeAdapterFactory(TypeAdapters.newFactory(long.class, Long.class, new LongTypeAdapter()))
//                .registerTypeAdapterFactory(TypeAdapters.newFactory(float.class, Float.class, new FloatTypeAdapter()))
//                .registerTypeAdapterFactory(TypeAdapters.newFactory(double.class, Double.class, new DoubleTypeAdapter()))
//                .registerTypeAdapterFactory(TypeAdapters.newFactory(String.class, new StringTypeAdapter()))
//                .registerTypeAdapterFactory(TypeAdapters.newFactory(BigDecimal.class, new BigDecimalTypeAdapter()))
//                .create();
//
//        System.out.println("正常情况：");
//        String json = getJson("./person.json");
//        System.out.println("json: \n" + json);
//        Person person = gson.fromJson(json, Person.class);
//        System.out.println("结果：\n" + person);
//        System.out.println("=================");

//        System.out.println("都为null情况：");
//        String json2 = getJson("./person_error1.json");
//        System.out.println("json: \n" + json2);
//        Person person2 = gson.fromJson(json2, Person.class);
//        System.out.println("结果：\n" + person2);
//        System.out.println("=================");
//
//        System.out.println("都为\"\"情况：");
//        String json3 = getJson("./person_error2.json");
//        System.out.println("json: \n" + json3);
//        Person person3 = gson.fromJson(json3, Person.class);
//        System.out.println("结果：\n" + person3);
//        System.out.println("=================");
//
//        System.out.println("其他情况：");
//        String json4 = getJson("./person_error3.json");
//        System.out.println("json: \n" + json4);
//        Person person4 = gson.fromJson(json4, Person.class);
//        System.out.println("结果：\n" + person4);
//        System.out.println("=================");
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
