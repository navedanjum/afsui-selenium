package com.company.app.pages;

import com.company.app.base.CommonWebElements;
import com.company.app.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Ansari on 2/6/2019
 */
public class ContactPage extends CommonWebElements {

    @FindBy(name = "contact-name")
    WebElement nameInput;

    @FindBy(name = "contact-email")
    WebElement emailInput;

    @FindBy(name = "contact-phone")
    WebElement phoneInput;

    @FindBy(name ="contact-message")
    WebElement msgArea;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//form/h1[contains(text(), 'Contact')]")
    WebElement contactUsLabel;

    @FindBy(xpath = "//h2[contains(text(),'Email')]")
    WebElement emailLabel;

    @FindBy(xpath = "//h2[contains(text(),'Phone')]")
    WebElement phoneLabel;

    @FindBy(xpath = "//h2[contains(text(),'Location')]")
    WebElement locationLabel;

    @FindBy(xpath = "//iframe[contains(@src,'map')]")
    WebElement mapIframe;

    @FindBy(xpath = "//div[@class='place-desc-large']/div[@class='address']")
    WebElement addressOnMap;

    @FindBy(xpath = "//a[contains(@href,'map') and @class='detail']")
    WebElement addressOnLabel;

    @FindBy(xpath = "//a[contains(@href,'mailto')]/span[contains(text(),'General:')]/following-sibling::span")
    WebElement generalEmail;

    @FindBy(xpath = "//a[contains(@href,'mailto')]/span[contains(text(),'HR:')]/following-sibling::span")
    WebElement hrEmail;

    @FindBy(xpath = "//a[contains(@href,'tel')]/span[contains(text(),'HR:')]/following-sibling::span")
    WebElement hrPhoneNumber;

    @FindBy(xpath = "//a[contains(@href,'tel')]/span[contains(text(),'General:')]/following-sibling::span")
    WebElement generalPhoneNumber;

    @FindBy(css = ".elementor-clearfix")
    WebElement joinArvatoSection;

    @FindBy(xpath = "//div[@data-id='898aa72']/div/div/a[contains(@href,'career')]")
    WebElement navigateToCareerBtn;

    @FindBy(css = ".wpcf7-response-output")
    WebElement formSubmissionResponseMsgArea;

    @FindBy(xpath = "//input[@type='text']/following-sibling::span[@role='alert' and @class='wpcf7-not-valid-tip']")
    WebElement nameInputValidatorMsg;

    @FindBy(xpath = "//input[@type='email']/following-sibling::span[@role='alert' and @class='wpcf7-not-valid-tip']")
    WebElement emailInputValidatorMsg;


    public ContactPage() {

        PageFactory.initElements(driver, this);
    }

    public boolean isContactUsLabelDisplayed(){
        return contactUsLabel.isDisplayed();
    }

    public boolean isLocationLabelDisplayed(){
        return locationLabel.isDisplayed();
    }

    public String getAddressText(){
        return addressOnLabel.getText();
    }

    public String getAddressTextFromGoogleMap(){
        wait.until(ExpectedConditions.visibilityOf(addressOnMap));
        return addressOnMap.getText();
    }

    public boolean isEmailLabelDisplayed(){
        return emailLabel.isDisplayed();
    }

    public String getGeneralEmail(){
        return generalEmail.getText();
    }

    public String getHrEmail(){
        return hrEmail.getText();
    }

    public boolean isPhoneLabelDisplayed(){
        return phoneLabel.isDisplayed();
    }

    public String getGeneralPhone(){
        return generalPhoneNumber.getText();
    }

    public String getHrPhone(){
        return hrPhoneNumber.getText();
    }

    public String getTextContentFromJoinSection(){
        return joinArvatoSection.getText();
    }

    public boolean IsGoTocareerPageBtnDisplayed(){
        return navigateToCareerBtn.isDisplayed();
    }

    public CareerPage clickNavigateToCareer(){
        wait.until(ExpectedConditions.elementToBeClickable(navigateToCareerBtn));
        navigateToCareerBtn.click();
        wait.until(ExpectedConditions.urlContains("career"));
        return new CareerPage();
    }

    public void switchToMapFrame(){
        driver.switchTo().frame(mapIframe);
    }

    public void switchToParent(){
        driver.switchTo().defaultContent();
    }

    public void submitFormData(String name, String email, String phone, String msg){
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        phoneInput.sendKeys(phone);
        msgArea.sendKeys(msg);
        submitBtn.click();
    }

    public String getSubmissionResponseMsg(){
        wait.until(ExpectedConditions.visibilityOf(formSubmissionResponseMsgArea));
        return formSubmissionResponseMsgArea.getText();
    }

    public String getEmailValidatorMsg(){
        wait.until(ExpectedConditions.visibilityOf(emailInputValidatorMsg));
        return emailInputValidatorMsg.getText();
    }

    public String getNameValidatorMsg(){
        wait.until(ExpectedConditions.visibilityOf(nameInputValidatorMsg));
        return nameInputValidatorMsg.getText();
    }

}
