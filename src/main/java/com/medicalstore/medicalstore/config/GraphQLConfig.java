// filepath: /Users/vivekkurre/Desktop/my_works/medpix-project/medicalstore/src/main/java/com/medicalstore/medicalstore/config/GraphQLConfig.java
package com.medicalstore.medicalstore.config;

import graphql.schema.GraphQLScalarType;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class GraphQLConfig {

    @Bean
    public RuntimeWiring runtimeWiring() {
        GraphQLScalarType dateTimeScalar = GraphQLScalarType.newScalar()
                .name("DateTime")
                .description("A custom scalar for DateTime")
                .coercing(new DateTimeCoercing())
                .build();

        return RuntimeWiring.newRuntimeWiring()
                .scalar(dateTimeScalar)
                .build();
    }

    private static class DateTimeCoercing implements graphql.schema.Coercing<LocalDateTime, String> {
        private final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        @Override
        public String serialize(Object dataFetcherResult) {
            return ((LocalDateTime) dataFetcherResult).format(formatter);
        }

        @Override
        public LocalDateTime parseValue(Object input) {
            return LocalDateTime.parse(input.toString(), formatter);
        }

        @Override
        public LocalDateTime parseLiteral(Object input) {
            return LocalDateTime.parse(input.toString(), formatter);
        }
    }
}