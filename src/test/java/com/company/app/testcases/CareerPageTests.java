package com.company.app.testcases;

import com.company.app.base.CommonWebElements;
import com.company.app.base.TestBase;
import com.company.app.pages.CareerPage;
import com.company.app.pages.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * @author Ansari on 2/6/2019
 */
public class CareerPageTests extends TestBase {

    HomePage homePage;
    CareerPage careerPage;


    CareerPageTests(){
        super();
    }

    @BeforeMethod
    public void testSetUp(){
        webDriverInitialization();
        homePage = new HomePage();
        careerPage = homePage.clickCareerTab();
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
