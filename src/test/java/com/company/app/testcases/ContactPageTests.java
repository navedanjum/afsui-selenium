package com.company.app.testcases;

import com.company.app.base.CommonWebElements;
import com.company.app.base.TestBase;
import com.company.app.pages.ContactPage;
import com.company.app.pages.HomePage;
import com.company.app.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Ansari on 2/6/2019
 */
public class ContactPageTests extends TestBase {

    HomePage homePage;
    ContactPage contactPage;

    //For data provider from excel sheet
    String sheetName = "contact";

    ContactPageTests(){
        super();
    }

    @BeforeMethod
    public void testSetUp(){
        webDriverInitialization();
        homePage = new HomePage();
        contactPage = homePage.clickContactUsTab();
    }


    @Test(priority=1)
    public void verifyTopMenuTabsAndLogoTest(){
        Assert.assertTrue(contactPage.isApplicationLogoPresent());
        Assert.assertTrue(contactPage.isCareerTabPresent());
        Assert.assertTrue(contactPage.isItDevCenterTabPresent());
        Assert.assertTrue(contactPage.isCareerTabPresent());
    }

    @Test(priority=2)
    public void verifyBottomMenuLinkAndSocialMediaTest(){
        Assert.assertTrue(contactPage.isCareerLinkFooterPresent());
        Assert.assertTrue(contactPage.isItDevCenterLinkFooterPresent());
        Assert.assertTrue(contactPage.isContactLinkFooterPresent());
        Assert.assertTrue(contactPage.isFaceBookIconPresent());
        Assert.assertTrue(contactPage.isLinkedinIconPresent());
        Assert.assertTrue(contactPage.isEuProjectImagePresent());
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
