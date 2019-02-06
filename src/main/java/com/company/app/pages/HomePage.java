package com.company.app.pages;

import com.company.app.base.CommonWebElements;
import com.company.app.base.TestBase;

/**
 * @author Ansari on 2/6/2019
 */
public class HomePage extends CommonWebElements {

        public ContactPage clickContactUsTab(){
            contactTab.click();
            return new ContactPage();
        }
}
