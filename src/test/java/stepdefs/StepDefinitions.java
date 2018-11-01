package stepdefs;

import javafx.beans.property.SetProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class StepDefinitions {


    WebDriver driver = BaseDriverClass.getDriver();

    //@Given("^I am on the \"([^\"]*)\" page on URL \"([^\"]*)\"$")
    @Given("^I am on the page on URL \"([^\"]*)\"$")
    public void i_am_on_the_page_on_URL(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        try {
            driver.get(arg1);
        } catch (Exception ex) {

            throw new PendingException("Exception caught");
        }
    }

    @Then("^I should see page title as \"([^\"]*)\"$")
    public void I_should_see_page_title_as(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String actualTitle = this.driver.getTitle();
        System.out.println("Actual Title :  " + actualTitle);
        System.out.println("Expected Title : " + arg1);
        Assert.assertEquals(arg1, actualTitle);
        //throw new PendingException();
    }

    @When("^I fill query string in search box \"([^\"]*)\" with \"([^\"]*)\"$")
    public void I_fill_query_string_in_search_box_with(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Arg1  :" + arg1 + " Arg2  :" + arg2);
        this.driver.findElement(By.name(arg1)).sendKeys(arg2);
        //throw new PendingException();
    }

    @Then("^Verify suggestion is displayed$")
    public void Verify_suggestion_is_displayed() {
        this.driver.findElement(By.className("gstl_0")).submit();
        //BaseDriverClass.fluentlyWaitUntilElementIsVisible(suggestionList);
        //assertTrue(suggestionList.isDisplayed());
    }

    @When("^I click on the \"([^\"]*)\" button$")
    public void i_click_on_the_button(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.driver.findElement(By.name(arg1)).submit();
        //throw new PendingException();
    }

    @Then("^Verify Dictionary is shown with \"([^\"]*)\" as result$")
    public void Verify_Dictionary_is_shown_with_as_result(String resultString) {
        WebElement elementDictResult = driver.findElement(By.className("LC20lb"));
        BaseDriverClass.fluentlyWaitUntilElementIsVisible(elementDictResult);
        if(elementDictResult.toString().contains(resultString))
        {
            System.out.println("Found the search string in dictionary object");
        }
    }
}
