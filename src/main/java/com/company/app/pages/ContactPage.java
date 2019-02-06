package com.company.app.pages;

import com.company.app.base.CommonWebElements;
import com.company.app.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath = "//*[@class='address']")
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


    public ContactPage() {

        PageFactory.initElements(driver, this);
    }




}
