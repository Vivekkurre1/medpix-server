package com.medicalstore.medicalstore.config;

import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class GraphQLConfig {

    @Bean
    public RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .scalar(dateTimeScalar())
                .build();
    }

    private GraphQLScalarType dateTimeScalar() {
        return GraphQLScalarType.newScalar()
                .name("DateTime")
                .description("A custom scalar that handles DateTime")
                .coercing(new DateTimeCoercing())
                .build();
    }

    private static class DateTimeCoercing implements Coercing<LocalDateTime, String> {

        @Override
        public String serialize(Object dataFetcherResult) {
            return ((LocalDateTime) dataFetcherResult).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }

        @Override
        public LocalDateTime parseValue(Object input) {
            return LocalDateTime.parse(input.toString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }

        @Override
        public LocalDateTime parseLiteral(Object input) {
            return LocalDateTime.parse(input.toString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }
    }
}