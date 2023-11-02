package com.o1b4.serverquota.dto.request;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

//List<LocalDate> JSON binding
public class JsonDateSerializer extends JsonSerializer<List<LocalDate>> {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void serialize(List<LocalDate> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray();
        for (LocalDate date : value) {
            gen.writeString(date.format(DATE_FORMATTER));
        }
        gen.writeEndArray();
    }
}

