package com.woodpecker;

import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.springframework.format.datetime.DateFormatter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends TypeAdapter<LocalDate> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

    @Override
    public void write(JsonWriter out, LocalDate value) throws IOException {
        if(value == null) out.nullValue();
        else out.value(value.format(formatter));
    }

    @Override
    public LocalDate read(JsonReader in) throws IOException{
        switch (in.peek()){
            case NULL:
                in.nextNull();
                return null;
            case STRING:
                String date = in.nextString();
                return LocalDate.parse(date,formatter);
            default:
                throw new JsonParseException("Expected string or null but was " + in.peek() + " at path: " + in.getPath());
        }
    }
}
