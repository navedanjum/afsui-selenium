package com.company.app.testcases;

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

    //@Test(priority=1)
    public void verifyTopMenuTabsAndLogoTest(){
        Assert.assertTrue(contactPage.isApplicationLogoPresent());
        Assert.assertTrue(contactPage.isCareerTabPresent());
        Assert.assertTrue(contactPage.isItDevCenterTabPresent());
        Assert.assertTrue(contactPage.isCareerTabPresent());
    }

    //@Test(priority=2)
    public void verifyBottomMenuLinkAndSocialMediaTest(){
        Assert.assertTrue(contactPage.isCareerLinkFooterPresent());
        Assert.assertTrue(contactPage.isItDevCenterLinkFooterPresent());
        Assert.assertTrue(contactPage.isContactLinkFooterPresent());
        Assert.assertTrue(contactPage.isFaceBookIconPresent());
        Assert.assertTrue(contactPage.isLinkedinIconPresent());
        Assert.assertTrue(contactPage.isEuProjectImagePresent());
    }

    //@Test(priority=3)
    public void verifyJoinArvatoSectionContentTest(){
        String expectedString = "Join Arvato.\nCheck out our open positions";
        Assert.assertEquals(expectedString,contactPage.getTextContentFromJoinSection());
    }


    //@Test(priority=4)
    public void verifyLocationTest(){
        contactPage.switchToMapFrame();
        System.out.println(contactPage.getAddressTextFromGoogleMap());
        String expectedAddress = contactPage.getAddressTextFromGoogleMap();
        contactPage.switchToParent();
        Assert.assertTrue(contactPage.isLocationLabelDisplayed());
        Assert.assertEquals(expectedAddress, contactPage.getAddressText());
    }

    //@Test(priority=5)
    public void verifyEmailTest(){
        String expectedGeneralEmail = "AFS_EE.Administration@arvato.com";
        String expectedHrEmail = "hr.itarvato@arvato.com";
        Assert.assertTrue(contactPage.isEmailLabelDisplayed());
        Assert.assertEquals(expectedGeneralEmail, contactPage.getGeneralEmail());
        Assert.assertEquals(expectedHrEmail, contactPage.getHrEmail());
    }

    @Test(priority=6)
    public void verifyPhoneNumberTest(){
        String expectedGeneralPhone = "+372 51 917 882";
        String expectedHrPhone = "+372 53 053 405";
        Assert.assertTrue(contactPage.isPhoneLabelDisplayed());
        Assert.assertEquals(expectedGeneralPhone, contactPage.getGeneralPhone());
        Assert.assertEquals(expectedHrPhone, contactPage.getHrPhone());
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
