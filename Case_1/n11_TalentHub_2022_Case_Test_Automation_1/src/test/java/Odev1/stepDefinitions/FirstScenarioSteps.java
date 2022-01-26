package Odev1.stepDefinitions;

import Odev1.driverControl.driverControls;
import Odev1.driverControl.driverShutdown;
import Odev1.pageObjects.KampanyaPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import Odev1.navigationUrl.Navigate;
import Odev1.pageObjects.N11Page;
import Odev1.utilities.BufferedWriteFile;

public class FirstScenarioSteps {
    WebDriver driver;
    BufferedWriteFile bFileWriter;
    Navigate navigate;
    KampanyaPage kPage;
    //Set Up Environments Required
    public void SetupEnv(String driverName,String env) {
        driver=driverControls.driverControl(driver,driverName);
        System.out.printf("Environment %s\n",env);
        navigate=new Navigate(driver);
        kPage=new KampanyaPage(driver);
        bFileWriter=new BufferedWriteFile();
     }

    @Given("I launch {} browser and {} environment")
    public void I_launch_desired_browser_and_target_environment(String driverName,String env) {
      SetupEnv(driverName,env);
    }

    @When("Go to {string}")
    public void goToPage(String urlN11KampanyaPage) {
    navigate.openN11HomePage(urlN11KampanyaPage);
    }

    @And("Inside a loop to each of the categories on the opened page, campaigns or to promotions will be clicked on")
    public void insideALoopToEachOfTheCategoriesOnTheOpenedPageCampaignsOrToPromotionsWillBeClickedOn() {
    kPage.handle();
    }

    @Then("Urls with details will be written to a csv")
    public void urlsWithDetailsWillBeWrittenToACsv() {
        bFileWriter.printToFile();
        driverShutdown.driverClose(driver);
    }
}
