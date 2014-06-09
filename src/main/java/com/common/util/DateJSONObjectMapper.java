package com.common.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.module.SimpleModule;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.knappsack.swagger4springweb.util.JavaToScalaUtil;
import com.wordnik.swagger.model.AllowableListValues;
import com.wordnik.swagger.model.AllowableValues;

public class DateJSONObjectMapper extends ObjectMapper {

	public DateJSONObjectMapper() {
		CustomSerializerFactory factory = new CustomSerializerFactory();
		factory.addGenericMapping(Date.class, new JsonSerializer<Date>() {
			@Override
			public void serialize(Date value, JsonGenerator jsonGenerator, SerializerProvider provider)
					throws IOException, JsonProcessingException {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				jsonGenerator.writeString(sdf.format(value));
			}
		});
		this.setSerializerFactory(factory);
		this.registerModule(new SimpleModule("",Version.unknownVersion()));
		//registerModule(new DefaultScalaModule());
	}

    class AllowableValuesDeserializer extends StdScalarDeserializer<AllowableValues> {

        protected AllowableValuesDeserializer() {
            super(AllowableValues.class);
        }

        @Override
        public AllowableValues deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

            String currentName = jp.getCurrentName();
            if (currentName.equalsIgnoreCase("AllowableValues")) {
                if (jp.getText().isEmpty() || jp.getText().equals("{}") || jp.getText().equals("{")) {
                    return new AllowableListValues(JavaToScalaUtil.toScalaList(new ArrayList<String>()), "");
                }
            }
            return new AllowableListValues(JavaToScalaUtil.toScalaList(new ArrayList<String>()), "");
        }
    }
}