package com.firststage.services.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDeserializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        String date = jsonParser.getText();

        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            return format.parse(date);
        } catch(Exception e) {
            return null;
        }

    }
}
