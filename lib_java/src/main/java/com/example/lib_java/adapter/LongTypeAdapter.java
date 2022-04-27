package com.example.lib_java.adapter;


import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * 适配long、Long
 */
public class LongTypeAdapter extends TypeAdapter<Long> {

    @Override
    public void write(JsonWriter out, Long value) throws IOException {
        out.value(value);
    }

    @Override
    public Long read(JsonReader in) throws IOException {
        switch (in.peek()) {
            case NUMBER:
                try {
                    return in.nextLong();
                } catch (NumberFormatException e) {
                    return new BigDecimal(in.nextString()).longValue();
                }
            case STRING:
                String str = in.nextString();
                if (str == null || "".equals(str)) {
                    return 0L;
                }
                try {
                    return Long.parseLong(str);
                } catch (NumberFormatException e) {
                    try {
                        return new BigDecimal(str).longValue();
                    } catch (NumberFormatException e2) {
                        return 0L;
                    }
                }
            case NULL:
                in.nextNull();
                return null;
            default:
                in.skipValue();
                throw new IllegalArgumentException();
        }
    }
}
