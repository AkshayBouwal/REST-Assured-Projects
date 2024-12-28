package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class LoginConfig {

    public static RequestSpecification loginSpec() {

        RequestSpecBuilder reqSpec = new RequestSpecBuilder();

        return reqSpec.setBaseUri(Configurations.getProperties("baseURL"))
                .addHeader("Accept", "*/*")
                .addHeader("Authorization", Configurations.getProperties("token"))
                .addFilter(RequestLoggingFilter.logRequestTo(Logs.progressLogs()))
                .addFilter(ResponseLoggingFilter.logResponseTo(Logs.progressLogs()))
                .build();

    }

}
