package com.unlimint.workflow;

import com.unlimint.Pojo.JsonFile;
import com.unlimint.base.Config;
import com.unlimint.base.TestSuiteBase;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

import static com.unlimint.base.Config.apiEndpoint;


public class GetRandomUserDataApi extends TestSuiteBase {

    public static Logger log = LogManager.getLogger(GetRandomUserDataApi.class);

    public static RequestSpecification request() {
        return RestAssured.given().urlEncodingEnabled(true);
    }

    /**
     * This will fetch the random user and its details in JSON format which is getting parsed to Java object
     *
     * @return userData - User details of the random data fetched
     */

    public HashMap<String, String> getRandomUserData() {
        log.info("Calling random user API to get random data ");

        JsonFile jsonFile = request().get(apiEndpoint).as(JsonFile.class);

        log.info("JSON response parsed successfully to Java object ");

        HashMap<String, String> userData = new HashMap<>();


        userData.put(UserDataValues.FIRST_NAME.getValue(), jsonFile.getResults().get(0).getName().getFirst());
        userData.put(UserDataValues.LAST_NAME.getValue(), jsonFile.getResults().get(0).getName().getLast());
        userData.put(UserDataValues.EMAIL.getValue(), jsonFile.getResults().get(0).getEmail());
        userData.put(UserDataValues.PASSWORD.getValue(), jsonFile.getResults().get(0).getLogin().getPassword());
        userData.put(UserDataValues.CITY.getValue(), jsonFile.getResults().get(0).getLocation().getCity());
        userData.put(UserDataValues.COUNTRY.getValue(), jsonFile.getResults().get(0).getLocation().getCountry());
        userData.put(UserDataValues.STATE.getValue(), jsonFile.getResults().get(0).getLocation().getState());
        userData.put(UserDataValues.STREET_NAME.getValue(), jsonFile.getResults().get(0).getLocation().getStreet().getName());
        userData.put(UserDataValues.POST_CODE.getValue(), String.valueOf(jsonFile.getResults().get(0).getLocation().getPostcode()));
        userData.put(UserDataValues.PHONE.getValue(), jsonFile.getResults().get(0).getPhone());

        log.info("User data parsed successfully : " + userData);
        return userData;
    }

    public static void main(String[] args) {
        GetRandomUserDataApi api = new GetRandomUserDataApi();

    }
}
