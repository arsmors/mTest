package testDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MyStepdefs {

    BaseFunc baseFunc = new BaseFunc();
    testDef.HomePage homePage = new testDef.HomePage(baseFunc);

    @Given("website with category {string}")
    public void websiteWithCategory(String gender) {
        homePage.openHomePage(gender);
    }

    @When("user adds {int} items to shopping basket")
    public void userAddItems(int items) {
        homePage.selectItems(items);
    }
}
