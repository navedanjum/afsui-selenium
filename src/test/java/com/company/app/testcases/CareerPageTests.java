package com.company.app.testcases;

import com.company.app.base.TestBase;
import com.company.app.pages.CareerPage;
import com.company.app.pages.ContactPage;
import com.company.app.pages.HomePage;
import com.company.app.pages.ITDevCenterPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Ansari on 2/6/2019
 */
public class CareerPageTests extends TestBase {

    String contactUrl = "https://itarvato.ee/contact-us/";
    String teamPageUrl = "https://itarvato.ee/it-development-centre/";

    HomePage homePage;
    CareerPage careerPage;


    CareerPageTests(){
        super();
    }

    @BeforeMethod
    public void testSetUp(){
        webDriverInitialization();
        homePage = new HomePage();
        careerPage = homePage.clickCareerTab();
    }

    @Test(priority=1)
    public void verifyCareerContentSectionTest(){

        String careerIntroHeader = "CAREER AT IT DEVELOPMENT AND INNOVATION CENTER";
        Assert.assertEquals(careerPage.getCareerIntroSectionHeaderText(),careerIntroHeader);

        String careerOpeningsHeader = "Current openings";
        Assert.assertEquals(careerPage.getCurrentOpeningSectionHeaderText(),careerOpeningsHeader);

        String uniqueHeader = "What makes us unique";
        Assert.assertEquals(careerPage.getUniqueSectionHeaderText(),uniqueHeader);

        String workEnvHeader = "Modern work environment";
        Assert.assertEquals(careerPage.getWorkEnvironmentSectionHeaderText(),workEnvHeader);

        String benefitHeader = "Benefits";
        Assert.assertEquals(careerPage.getBenefitSectionHeaderText(),benefitHeader);

        String contactHeader = "Don’t see the position you’re looking for? \nWe’d still love to hear from you!";
        Assert.assertEquals(careerPage.getContactSectionHeaderText(),contactHeader);

    }

    @Test(priority=2)
    public void verifyNavigationUsingDropUsButtonsTest(){
        ContactPage contactPage = careerPage.clickDropUsBtn();
        Assert.assertEquals(contactUrl, contactPage.getPageUrl());
        //Validate the navigated page is the contact us page
        Assert.assertTrue(contactPage.isContactUsLabelDisplayed());
        Assert.assertTrue(contactPage.isEmailLabelDisplayed());
        Assert.assertTrue(contactPage.isPhoneLabelDisplayed());
        Assert.assertTrue(contactPage.isLocationLabelDisplayed());

    }

    @Test(priority=3)
    public void verifyNavigationUsingTeamPageButtonsTest(){
        ITDevCenterPage itDevCenterPage = careerPage.clickTeamPageBtn();
        Assert.assertEquals(teamPageUrl, itDevCenterPage.getPageUrl());
        //Validate the navigated page is the IT Dev center page.
        Assert.assertTrue(itDevCenterPage.isIntroSectionHeaderDisplayed());
        Assert.assertTrue(itDevCenterPage.isTeamValuesSectionHeaderDisplayed());
    }

    @Test(priority=4)
    public void verifyListedJobsTest(){
        List<String> retrievedJobs = careerPage.numberOfJobs();
        logger.info("Number of jobs listed: " + retrievedJobs.size());

        for(String job: retrievedJobs){
            System.out.println(job);
            logger.info(job);
        }

    }

    @Test(priority=5)
    public void verifyNavigateToListedJobDescriptionTest() {
        int length = careerPage.getJobList().size();
        System.out.println(length);
        for (int i = 0; i < length; i++) {
            careerPage.getJobList().get(i).click();
            careerPage.clickCareerTab();
            //driver.navigate().back();
            wait.until(ExpectedConditions.urlContains("career"));
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
