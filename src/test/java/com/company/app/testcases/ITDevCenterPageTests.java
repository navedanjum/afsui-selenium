package com.company.app.testcases;

import com.company.app.base.TestBase;
import com.company.app.pages.HomePage;
import com.company.app.pages.ITDevCenterPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Ansari on 2/7/2019
 */

@Test(testName="itarvato IT development center page tests")
public class ITDevCenterPageTests extends TestBase {

    //expected navigations
    String careerUrl = "https://itarvato.ee/career/";
    String itcenterUrl = "https://itarvato.ee/it-development-center/";
    String contactUrl = "https://itarvato.ee/contact-us/";

    HomePage homePage;
    ITDevCenterPage itDevCenterPage;

    ITDevCenterPageTests(){
        super();
    }

    @BeforeMethod
    public void testSetUp(){
        webDriverInitialization();
        homePage = new HomePage();
        itDevCenterPage = homePage.clickITDevCenterTab();
    }

    @Test(priority=1)
    public void verifyITDevCenterContentSectionTest(){

        String introHeader = "IT DEVELOPMENT AND INNOVATION CENTER AT ARVATO IN TALLINN";
        Assert.assertEquals(itDevCenterPage.getIntroSectionHeaderText(),introHeader);

        String teamValuesHeader = "Team values";
        Assert.assertEquals(itDevCenterPage.getTeamValuesSectionHeaderText(),teamValuesHeader);

        String openingsHeader = "Current openings";
        Assert.assertEquals(itDevCenterPage.getCurrentOpeningSectionHeaderText(),openingsHeader);

        String contactHeader = "Don’t see the position you’re looking for? \nWe’d still love to hear from you!";
        Assert.assertEquals(itDevCenterPage.getContactSectionHeaderText(),contactHeader);

    }

    @Test(priority=2)
    public void verifyNavigationUsingLinksAndButtonsTest(){
        itDevCenterPage.clickBecomeMemberBtn();
        Assert.assertEquals(careerUrl, itDevCenterPage.getPageUrl());

        itDevCenterPage.clickITDevCenterTab();
        Assert.assertEquals(itcenterUrl, itDevCenterPage.getPageUrl());

        itDevCenterPage.clickDropUsBtn();
        Assert.assertEquals(contactUrl, itDevCenterPage.getPageUrl());

    }

    @Test(priority=3)
    public void verifyVideoLinkTest(){
        itDevCenterPage.clickVideoLink();
        Assert.assertTrue(itDevCenterPage.isVideoPopUpDisplayed());
        itDevCenterPage.closeVideo();
    }

    @Test(priority=4)
    public void verifyListedJobs(){
        List<String> retrievedJobs = itDevCenterPage.numberOfJobs();
        logger.info("Number of jobs listed: " + retrievedJobs.size());

        for(String job: retrievedJobs){
            System.out.println(job);
            logger.info(job);
        }
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
