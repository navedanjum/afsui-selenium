package com.company.app.base;

import com.company.app.pages.CareerPage;
import com.company.app.pages.ContactPage;
import com.company.app.pages.ITDevCenterPage;
import com.company.app.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Ansari on 2/6/2019
 */
public class CommonWebElements extends TestBase {
    /* Mapping all elements that should exist on all the web pages*/

    @FindBy(xpath="//img[@class='custom-logo'][@alt='IT Arvato']")
    public WebElement applicationLogo;

    @FindBy(xpath = "//a[contains(@href,'career') and @class='menu-link']")
    public WebElement careerTab;

    @FindBy(xpath = "//a[contains(@href,'it-development-center') and @class='menu-link']")
    public WebElement itDevCenterTab;

    @FindBy(xpath = "//a[contains(@href,'contact-us') and @class='menu-link']")
    public WebElement contactTab;

    /*Footer Web elements*/
    @FindBy(xpath = "//i[contains(@class,'facebook')]")
    public WebElement faceBookIcon;

    @FindBy(xpath = "//i[contains(@class,'linkedin')]")
    public WebElement linkedinIcon;

    @FindBy(xpath ="//span[contains(text(),'Career') and @class='elementor-button-text']")
    public WebElement careerLinkFooter;

    @FindBy(xpath ="//span[contains(text(),'IT Development') and @class='elementor-button-text']")
    public WebElement itDevCenterLinkFooter;

    @FindBy(xpath ="//span[contains(text(),'Contact Us') and @class='elementor-button-text']")
    public WebElement contactLinkFooter;

    @FindBy(xpath="//img[@title='eu-project-ee' and @alt='eu-project-ee']")
    public WebElement euProjectImage;

    public CommonWebElements() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, TestUtil.EXPLICIT_WAIT);
    }

    //Top menu navigation
    public CareerPage clickCareerTab(){
        careerTab.click();
        return  new CareerPage();
    }

    public ITDevCenterPage clickITDevCenterTab(){
        itDevCenterTab.click();
        return new ITDevCenterPage();
    }

    public ContactPage clickContactUsTab(){
        contactTab.click();
        return new ContactPage();
    }

    //Bottom menu navigation
    public CareerPage clickCareerLinkFooter(){
        careerLinkFooter.click();
        return  new CareerPage();
    }

    public ITDevCenterPage clickItDevCenterLinkFooter(){
        itDevCenterLinkFooter.click();
        return new ITDevCenterPage();
    }

    public ContactPage clickcontactLinkFooter(){
        contactLinkFooter.click();
        return new ContactPage();
    }

    //Footer social media icon click
    public void clickFaceBookIconFooter(){
        wait.until(ExpectedConditions.elementToBeClickable(faceBookIcon));
        faceBookIcon.click();

    }

    public void clickLinkedinIconFooter(){
        wait.until(ExpectedConditions.elementToBeClickable(linkedinIcon));
        linkedinIcon.click();
    }

    //check if elements exist
    public boolean isApplicationLogoPresent(){
        wait.until(ExpectedConditions.visibilityOf(applicationLogo));
        return applicationLogo.isDisplayed();
    }

    public boolean isCareerTabPresent(){
        wait.until(ExpectedConditions.visibilityOf(careerTab));
        return careerTab.isDisplayed();
    }

    public boolean isItDevCenterTabPresent(){
        wait.until(ExpectedConditions.visibilityOf(itDevCenterTab));
        return itDevCenterTab.isDisplayed();
    }

    public boolean isContactTabPresent(){
        wait.until(ExpectedConditions.visibilityOf(contactTab));
        return contactTab.isDisplayed();
    }

    public boolean isFaceBookIconPresent(){
        wait.until(ExpectedConditions.visibilityOf(faceBookIcon));
        return faceBookIcon.isDisplayed();
    }

    public boolean isLinkedinIconPresent(){
        wait.until(ExpectedConditions.visibilityOf(linkedinIcon));
        return linkedinIcon.isDisplayed();
    }

    public boolean isCareerLinkFooterPresent(){
        wait.until(ExpectedConditions.visibilityOf(careerLinkFooter));
        return careerLinkFooter.isDisplayed();
    }

    public boolean isItDevCenterLinkFooterPresent(){
        wait.until(ExpectedConditions.visibilityOf(itDevCenterLinkFooter));
        return itDevCenterLinkFooter.isDisplayed();
    }

    public boolean isContactLinkFooterPresent(){
        wait.until(ExpectedConditions.visibilityOf(contactLinkFooter));
        return contactLinkFooter.isDisplayed();
    }

    public boolean isEuProjectImagePresent(){
        wait.until(ExpectedConditions.visibilityOf(euProjectImage));
        return euProjectImage.isDisplayed();
    }

    public String getPageUrl(){
        logger.info(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public void returnToHomePage(){
        applicationLogo.click();
        wait.until(ExpectedConditions.visibilityOf(applicationLogo));
    }
}
