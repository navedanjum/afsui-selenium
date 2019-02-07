package com.company.app.pages;

import com.company.app.base.CommonWebElements;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ansari on 2/6/2019
 */
public class ITDevCenterPage extends CommonWebElements {

    List<String> jobs = new ArrayList<String>();

    @FindBy(css = "div.slide-subtitle.p")
    WebElement introSection;

    @FindBy(xpath = "//span[@class='link-title']" )
    WebElement videoLink;

    @FindBy(xpath = "//span[contains(text(),'Become a member')]")
    WebElement becomeMemberBtn;

    @FindBy(xpath = "//div[@data-id='50a423a']")
    WebElement teamValuesSection;

    @FindBy(xpath = "//div[@data-id='cbf4a46']")
    WebElement currentOpeningSection;

    @FindBy(xpath = "//div[@data-id='68fe448']")
    WebElement contactSection;

    @FindBy(xpath = "//span[contains(text(),'Drop Us a Line')]")
    WebElement dropUsBtn;

    @FindBy(xpath = "//div[@class='wp-video-popup-wrapper']")
    WebElement videoPopUp;

    @FindBy(xpath = "//div[@class='wp-video-popup-close']")
    WebElement videoCloseBtn;

    @FindBy(xpath = "//span[@class='job-name']")
    List<WebElement> jobList;

    public String getTeamValuesSectionHeaderText() {
        return teamValuesSection.getText();
    }

    public String getCurrentOpeningSectionHeaderText() {
        return currentOpeningSection.getText();
    }

    public String getContactSectionHeaderText() {
        return contactSection.getText();
    }

    public String getIntroSectionHeaderText() {
        return introSection.getText();
    }

    public void clickBecomeMemberBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(becomeMemberBtn));
        becomeMemberBtn.click();
    }

    public void clickDropUsBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(dropUsBtn));
        dropUsBtn.click();
    }

    public void clickVideoLink(){
        wait.until(ExpectedConditions.elementToBeClickable(videoLink));
        videoLink.click();
    }

    public boolean isVideoPopUpDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(videoPopUp));
        return videoPopUp.isDisplayed();
    }

    public void closeVideo(){
        wait.until(ExpectedConditions.visibilityOf(videoCloseBtn));
        videoCloseBtn.click();
    }

    public List<String> numberOfJobs(){
        for(WebElement w: jobList){
            jobs.add(w.getText());
        }

        return jobs;
    }

}
