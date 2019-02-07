package com.company.app.pages;

import com.company.app.base.CommonWebElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Ansari on 2/6/2019
 */
public class HomePage extends CommonWebElements {

    @FindBy(xpath = "//span[contains(text(),'Join Arvato')]")
    WebElement joinArvatoLink;

    @FindBy(xpath = "//span[contains(text(),'Bertelsmann')]")
    WebElement moreAboutBertelsmannBtn;

    @FindBy(xpath = "//span[contains(text(),'More about Arvato')]")
    WebElement moreAboutArvatoBtn;

    @FindBy(xpath = "//span[./text()= 'More']")
    WebElement moreITDevBtn;

    @FindBy(xpath = "//span[contains(text(),'Social Media')]")
    WebElement goToSocialMediaBtn;

    @FindBy(css = "div.slide-subtitle.p")
    WebElement joinSection;

    @FindBy(xpath = "//div[@data-id='288f69b']")
    WebElement bertelsmannSection;

    @FindBy(xpath ="//div[@data-id='39becf9']")
    WebElement arvatoGlobalSection;

    @FindBy(xpath ="//div[@data-id='280cd18']")
    WebElement arvatoTallinnSection;

    @FindBy(xpath = "//div[@data-id='0681987']")
    WebElement arvatoSocialCloudSection;





    public HomePage(){
        PageFactory.initElements(driver, this);
    }


    //Inner Links and Buttons Navigation
    public void clickJoinArvatoLink(){
        wait.until(ExpectedConditions.elementToBeClickable(joinArvatoLink));
        joinArvatoLink.click();
    }

    public void clickMoreAboutBertelsmannBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(moreAboutBertelsmannBtn));
        moreAboutBertelsmannBtn.click();
    }

    public void clickMoreITDevBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(moreITDevBtn));
        moreITDevBtn.click();
    }

    public void clickGoToSocialMediaBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(goToSocialMediaBtn));
        goToSocialMediaBtn.click();
    }

    public void clickMoreAboutArvatoBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(moreAboutArvatoBtn));
        moreAboutArvatoBtn.click();
    }

    //Elements check
    public boolean isJoinArvatoLinkDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(joinArvatoLink));
        return joinArvatoLink.isDisplayed();
    }

    public boolean isMoreAboutBertelsmannBtnDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(moreAboutBertelsmannBtn));
        return moreAboutBertelsmannBtn.isDisplayed();
    }

    public boolean isMoreITDevBtnDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(moreITDevBtn));
        return moreITDevBtn.isDisplayed();
    }

    public boolean isGoToSocialMediaBtnDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(goToSocialMediaBtn));
        return goToSocialMediaBtn.isDisplayed();
    }

    public boolean isMoreAboutArvatoBtnDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(moreAboutArvatoBtn));
        return moreAboutArvatoBtn.isDisplayed();
    }

    public String getJoinSectionHeaderText() {
        return joinSection.getText();
    }

    public String getBertelsmannSectionHeaderText() {
        return bertelsmannSection.getText();
    }

    public String getArvatoGlobalSectionHeaderText() {
        return arvatoGlobalSection.getText();
    }

    public String getArvatoTallinnSectionHeaderText() {
        return arvatoTallinnSection.getText();
    }

    public String getArvatoSocialCloudSectionHeaderText() {
        return arvatoSocialCloudSection.getText();
    }
}
