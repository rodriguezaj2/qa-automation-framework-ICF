package utils;

import io.restassured.response.Response;
import models.PersonRecord;

import java.util.Map;

public class ScenarioContext {

    public static Response resp;
    public static String firstName;
    public static String lastName;
    public static Map<String, Object> latestMatch;
    public static Integer apiID;
    public static Integer dbID;
    public static PersonRecord personRecord;

}
