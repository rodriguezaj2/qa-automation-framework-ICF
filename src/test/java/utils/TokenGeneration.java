package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class TokenGeneration {

    Response resp;
    RequestSpecification req;
    public static Map<String, String> authCookies;

    public int token(int statusCode) {

        String email = ConfigReader.read("email");
        String password = ConfigReader.read("password");

        RequestSpecification tokenRequest = given()
                .header(APIConstants.HEADER_CONTENT_TYPE_KEY, APIConstants.HEADER_CONTENT_TYPE_VALUE)
                .body( "{\n" +
                        "  \"email\": \"" + email + "\",\n" +
                        "  \"password\": \"" + password + "\"\n" +
                        "}");

        resp = tokenRequest.when().post(APIConstants.USER_LOGIN);
        int actualStatusCode = resp.getStatusCode();
        resp.then().statusCode(actualStatusCode);

        authCookies = resp.getCookies();
        return actualStatusCode;
    }
}
