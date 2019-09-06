package mockdata;


import beans.Student;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.*;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockData {

    public static ImmutableList<Student> getStudent() throws IOException {
        InputStream inputStream = Resources.getResource("student.json").openStream();
        String json = IOUtils.toString(inputStream);
        Type listType = new TypeToken<ArrayList<Student>>() {
        }.getType();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new DateDeserializer());
        List<Student> people = gsonBuilder.create().fromJson(json, listType);
        return ImmutableList.copyOf(people);
    }

    public static class DateDeserializer implements JsonDeserializer<LocalDate> {

        @Override
        public LocalDate deserialize(JsonElement element, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
            try {
                return LocalDate.parse(element.getAsString());
            } catch (Exception e) {
                System.err.println("Failed to parse Date due to: " + e);
                return null;
            }
        }
    }
}