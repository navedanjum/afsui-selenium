package com.company.app.testcases;

import com.company.app.base.TestBase;
import com.company.app.pages.CareerPage;
import com.company.app.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Ansari on 2/6/2019
 */
public class CareerPageTests extends TestBase {

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



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
