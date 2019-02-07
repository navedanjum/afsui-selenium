package com.company.app.pages;

import com.company.app.base.CommonWebElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author Ansari on 2/7/2019
 */
public class CareerPage extends CommonWebElements {

    @FindBy(css = "div.slide-subtitle.p")
    WebElement careerIntroSection;

    @FindBy(xpath = "//div[@data-id='13d2581']")
    WebElement currentOpeningSection;

    @FindBy(xpath = "//div[@data-id='4560809']")
    WebElement uniqueSection;

    @FindBy(xpath = "//div[@data-id='b8dabfb']")
    WebElement workEnvironmentSection;

    @FindBy(xpath = "//div[@data-id='36e7fb4']")
    WebElement benefitSection;

    @FindBy(xpath = "//div[@data-id='2cf5596']")
    WebElement contactSection;

    @FindBy(xpath = "//span[contains(text(),'Team Page')]")
    WebElement teamPageBtn;

    @FindBy(xpath = "//span[contains(text(),'Drop Us a Line')]")
    WebElement dropUsBtn;

    @FindBy(xpath = "//span[@class='job-name']")
    List<WebElement> jobList;

    public String getCareerIntroSectionHeaderText() {
        return careerIntroSection.getText();
    }

    public String getCurrentOpeningSectionHeaderText() {
        return currentOpeningSection.getText();
    }

    public String getUniqueSectionHeaderText() {
        return uniqueSection.getText();
    }

    public String getWorkEnvironmentSectionHeaderText() {
        return workEnvironmentSection.getText();
    }

    public String getBenefitSectionHeaderText() {
        return benefitSection.getText();
    }

    public String getContactSectionHeaderText() {
        return contactSection.getText();
    }

}
