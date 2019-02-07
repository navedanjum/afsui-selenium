package com.company.app.testcases;

import com.company.app.base.TestBase;
import com.company.app.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Ansari on 2/6/2019
 */

@Test(testName="itarvato homepage tests")
public class HomePageTests extends TestBase {

    HomePage homePage;

    //expected navigations
    String homeUrl = "https://itarvato.ee/";
    String careerUrl = "https://itarvato.ee/career/";
    String itcenterUrl = "https://itarvato.ee/it-development-center/";
    String contactUrl = "https://itarvato.ee/contact-us/";
    String arvatoGlobalUrl = "https://www.arvato.com/en.html";
    String bertelsmannUrl = "https://www.bertelsmann.com/#st-1";


    HomePageTests(){
        super();
    }

    @BeforeMethod
    public void testSetUp(){
        webDriverInitialization();
        homePage = new HomePage();
    }



    @Test(priority=1)
    public void verifyTopMenuTabsAndLogoTest(){
        Assert.assertTrue(homePage.isApplicationLogoPresent());
        Assert.assertTrue(homePage.isCareerTabPresent());
        Assert.assertTrue(homePage.isItDevCenterTabPresent());
        Assert.assertTrue(homePage.isCareerTabPresent());
    }

    @Test(priority=2)
    public void verifyNavigationUsingTopMenuTabsTest(){
        homePage.clickCareerTab();
        Assert.assertEquals(careerUrl,homePage.getPageUrl());
        homePage.returnToHomePage();
        homePage.clickITDevCenterTab();
        Assert.assertEquals(itcenterUrl,homePage.getPageUrl());
        homePage.returnToHomePage();
        homePage.clickContactUsTab();
        Assert.assertEquals(contactUrl,homePage.getPageUrl());
        homePage.returnToHomePage();
        Assert.assertEquals(homeUrl,homePage.getPageUrl());
    }

    @Test(priority=3)
    public void verifyBottomMenuLinkAndSocialMediaTest(){
        Assert.assertTrue(homePage.isCareerLinkFooterPresent());
        Assert.assertTrue(homePage.isItDevCenterLinkFooterPresent());
        Assert.assertTrue(homePage.isContactLinkFooterPresent());
        Assert.assertTrue(homePage.isLinkedinIconPresent());
        Assert.assertTrue(homePage.isFaceBookIconPresent());
        Assert.assertTrue(homePage.isEuProjectImagePresent());
    }

    @Test(priority=4)
    public void verifyNavigationUsingBottomMenuLinksTest(){
        homePage.clickCareerLinkFooter();
        Assert.assertEquals(careerUrl,homePage.getPageUrl());
        homePage.returnToHomePage();
        homePage.clickItDevCenterLinkFooter();
        Assert.assertEquals(itcenterUrl,homePage.getPageUrl());
        homePage.returnToHomePage();
        homePage.clickcontactLinkFooter();
        Assert.assertEquals(contactUrl,homePage.getPageUrl());
        homePage.returnToHomePage();
        Assert.assertEquals(homeUrl,homePage.getPageUrl());
    }

    @Test(priority=5)
    public void verifyNavigationUsingFooterLinkedinIconTest(){
        homePage.clickLinkedinIconFooter();
        Assert.assertTrue(homePage.getPageUrl().contains("www.linkedin.com"));
        Assert.assertTrue(homePage.getPageUrl().contains("afs-it-services-estonia"));
    }

    @Test(priority=6)
    public void verifyNavigationUsingFooterFacebookIconTest(){
        homePage.clickFaceBookIconFooter();
        Boolean result = homePage.getPageUrl().contains("www.facebook.com");
        Assert.assertTrue(result);
    }

    @Test(priority=7)
    public void verifyLinksAndButtonsOnHomePageTest(){
        Assert.assertTrue(homePage.isJoinArvatoLinkDisplayed());
        Assert.assertTrue(homePage.isMoreAboutBertelsmannBtnDisplayed());
        Assert.assertTrue(homePage.isMoreAboutArvatoBtnDisplayed());
        Assert.assertTrue(homePage.isMoreITDevBtnDisplayed());
        Assert.assertTrue(homePage.isGoToSocialMediaBtnDisplayed());
    }

    @Test(priority=8)
    public void verifySiteNavigationUsingLinksAndButtonsTest(){
        homePage.clickJoinArvatoLink();
        Assert.assertEquals(careerUrl,homePage.getPageUrl());
        homePage.returnToHomePage();
        Assert.assertEquals(homeUrl,homePage.getPageUrl());
        homePage.clickMoreITDevBtn();
        Assert.assertEquals(itcenterUrl,homePage.getPageUrl());
        homePage.returnToHomePage();
        Assert.assertEquals(homeUrl,homePage.getPageUrl());
    }

    @Test(priority=9)
    public void verifyNavigationUsingMoreAboutArvatoBtnTest(){
        homePage.clickMoreAboutArvatoBtn();
        Assert.assertEquals(arvatoGlobalUrl,homePage.getPageUrl());
    }

    @Test(priority=10)
    public void verifyNavigationUsingMoreAboutBertelsmannBtnTest(){
        homePage.clickMoreAboutBertelsmannBtn();
        Assert.assertEquals(bertelsmannUrl,homePage.getPageUrl());
    }

    @Test(priority=11)
    public void verifyNavigationUsingGoToSocialMediaBtnTest(){
        homePage.clickGoToSocialMediaBtn();
        Assert.assertTrue(homePage.getPageUrl().contains("www.linkedin.com"));
        Assert.assertTrue(homePage.getPageUrl().contains("arvato-ag"));
    }

    @Test(priority=12)
    public void verifyHomePageContentSectionTest(){

        String joinHeader = "IT DEVELOPMENT AND INNOVATION CENTER - AT A GLANCE";
        Assert.assertEquals(homePage.getJoinSectionHeaderText(),joinHeader);

        String globalHeader = "Arvato Bertelsmann";
        Assert.assertEquals(homePage.getArvatoGlobalSectionHeaderText(),globalHeader);

        String bertelsmannHeader = "IT Arvato is a part of the Bertelsmann SE & Co. KGaA";
        Assert.assertEquals(homePage.getBertelsmannSectionHeaderText(),bertelsmannHeader);

        String tallinnHeader = "Arvato IT in Tallinn";
        Assert.assertEquals(homePage.getArvatoTallinnSectionHeaderText(),tallinnHeader);

        String socialCloudHeader = "Arvato Social Cloud";
        Assert.assertEquals(homePage.getArvatoSocialCloudSectionHeaderText(),socialCloudHeader);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
