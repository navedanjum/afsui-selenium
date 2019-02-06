package com.company.app.testcases;

import com.company.app.base.CommonWebElements;
import com.company.app.base.TestBase;
import com.company.app.pages.ContactPage;
import com.company.app.pages.HomePage;
import com.company.app.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @Test(priority=3)
    public void verifyJoinArvatoSectionContentTest(){
        String expectedString = "Join Arvato.\nCheck out our open positions";
        Assert.assertEquals(expectedString,contactPage.getTextContentFromJoinSection());
        Assert.assertTrue(contactPage.IsGoTocareerPageBtnDisplayed());
    }


    @Test(priority=4)
    public void verifyLocationTest(){
        contactPage.switchToMapFrame();
        System.out.println(contactPage.getAddressTextFromGoogleMap());
        String expectedAddress = contactPage.getAddressTextFromGoogleMap();
        contactPage.switchToParent();
        Assert.assertTrue(contactPage.isLocationLabelDisplayed());
        Assert.assertEquals(expectedAddress, contactPage.getAddressText());
    }

    @Test(priority=5)
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

    //Data-driven testing - positive test with valid data
    @DataProvider(name = "TestData1", indices = {0,1})
    public Object[][] getTestData1(){
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }


    //Data-driven testing - negative test with invalid data
    @DataProvider(name = "TestData2", indices = {2,3,4})
    public Object[][] getTestData2(){
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }


    @Test(priority=7)
    public void verifyContactUsLabelTest(){
        Assert.assertTrue(contactPage.isContactUsLabelDisplayed());
    }

    @Test(priority=8, dataProvider="TestData1")
    public void validateContactFormSubmissionSuccessTest(String name, String email, String phone, String message){
        contactPage.submitFormData(name, email, phone, message);
        String successMsg = "Thank you for your message. It has been sent.";
        Assert.assertEquals(successMsg, contactPage.getSubmissionResponseMsg());
    }

    @Test(priority=9, dataProvider="TestData2")
    public void validateContactFormSubmissionErrorTest(String name, String email, String phone, String message){
        contactPage.submitFormData(name, email, phone, message);
        String ErrorMsg = "One or more fields have an error. Please check and try again.";
        Assert.assertEquals(ErrorMsg, contactPage.getSubmissionResponseMsg());
    }

    //mandatory field validation tests
    @Test(priority=10)
    public void validateFormFieldValidatorMsgBlankTest(){
        String vMsg1 = "The field is required.";
        String vMsg2 = "The e-mail address entered is invalid.";

        contactPage.submitFormData("","","","xyz");
        Assert.assertEquals(vMsg1,contactPage.getEmailValidatorMsg());
        Assert.assertEquals(vMsg1,contactPage.getNameValidatorMsg());
    }

    //mandatory field validation tests
    @Test(priority=11)
    public void validateFormFieldValidatorMsgInvalidDataTest(){
        String vMsg1 = "The field is required.";
        String vMsg2 = "The e-mail address entered is invalid.";

        contactPage.submitFormData("","abc","1234","");
        Assert.assertEquals(vMsg2,contactPage.getEmailValidatorMsg());
        Assert.assertEquals(vMsg1,contactPage.getNameValidatorMsg());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
