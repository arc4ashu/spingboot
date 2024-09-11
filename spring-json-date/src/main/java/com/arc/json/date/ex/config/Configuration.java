package com.arc.json.date.ex.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper mapper=new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //mapper.setDateFormat(df);
       return mapper;
    }

    private static final String dateFormat = "yyyy-MM-dd";
    private static final String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";

    @Bean
    @ConditionalOnProperty(value = "spring.jackson.date-format", matchIfMissing = true, havingValue = "none")
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> {
            builder.simpleDateFormat(dateTimeFormat);
            builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)));
            builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
        };
    }

}
