import com.unlimint.base.TestSuiteBase;
import org.testng.annotations.Test;

import java.util.HashMap;

public class RegisterAndOrderTest extends TestSuiteBase {

    HashMap<String, String> randomUserData = new HashMap<>();


    @Test(description = " Generate the random user and then parse the user details to the UI code " +
            "and Register the user. Add address for the user and then place a random order " +
            "and then fetch the order Id and validate the order on My Orders page. ")
    public void generateUserRegisterAndThenPlaceAndValidateTheOrder() throws Exception {

        initTest();

        randomUserData = getRandomUserDataApi.getRandomUserData();
        regsiterUser.registerUser(randomUserData);
        regsiterUser.fillAddressAfterRegistration(randomUserData);
        placeOrder.placeOrder();
        placeOrder.getOrderIdAndValidateOrderDetailsOnMyOrdersPage();

    }

    @Test(description = " Generate the random user and then parse the user details to the UI code " +
            "and Register the user with already registered email Id. Registration will fail as email id " +
            "already exists. ")
    public void useAlreadyRegisteredUserEmailIdAndValidateRegistrationGetsFailed() throws Exception {

        initTest();

        randomUserData = getRandomUserDataApi.getRandomUserData();
        regsiterUser.registerUserWithRegisteredEmailId(randomUserData);

    }
}
