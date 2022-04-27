package com.example.lib_java.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * 适配int、Integer
 */
public class IntegerTypeAdapter extends TypeAdapter<Integer> {

    @Override
    public void write(JsonWriter out, Integer value) throws IOException {
        out.value(value);
    }

    @Override
    public Integer read(JsonReader in) throws IOException {
        switch (in.peek()) {
            case NUMBER:
                try {
                    return in.nextInt();
                } catch (NumberFormatException e) {
                    return (int) in.nextDouble();
                }
            case STRING:
                String result = in.nextString();
                if (result == null || "".equals(result)) {
                    return 0;
                }
                try {
                    return Integer.parseInt(result);
                } catch (NumberFormatException e) {
                    try {
                        return (int) new BigDecimal(result).floatValue();
                    } catch (NumberFormatException e2) {
                        return 0;
                    }
                }
            case NULL:
                in.nextNull();
                break;
            default:
                in.skipValue();
                throw new IllegalArgumentException();
        }
        return null;
    }
}