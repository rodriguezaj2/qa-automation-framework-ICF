package utils;

import io.restassured.RestAssured;

public class APIConstants {

    //endpoints

    public static final String BaseURI = RestAssured.baseURI = "http://localhost:3000/api";
    public static final String USER_LOGIN = BaseURI+"/auth/login";
    public static final String GET_USER_BY_EMAIL = BaseURI+"/record/user/email/{email}";
    public static final String GET_USER_BY_QUERY = BaseURI+"/record/user";

    //headers
    public static final String HEADER_CONTENT_TYPE_KEY = "Content-Type";
    public static final String HEADER_CONTENT_TYPE_VALUE= "application/json";
}
