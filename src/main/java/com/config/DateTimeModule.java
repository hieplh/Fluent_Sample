package com.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateTimeModule extends SimpleModule {

	public DateTimeModule() {
		this.addDeserializer(LocalDate.class, new LocalDateSerializer());
	}

	static class LocalDateSerializer extends JsonDeserializer<LocalDate> {
		public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
				throws IOException {
			return LocalDate.parse(p.getValueAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}
	}
}
