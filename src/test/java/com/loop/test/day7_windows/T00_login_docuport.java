package com.loop.test.day7_windows;

import com.loop.test.base.TestBase;
import com.loop.test.utillites.DocuportConstants;
import com.loop.test.utillites.DocuportUtils;
import org.testng.annotations.Test;

public class T00_login_docuport extends TestBase {

        @Test
    public void test_login_logOut_docuport() throws InterruptedException {
            DocuportUtils.login(driver, DocuportConstants.CLIENT);
            DocuportUtils.logOut(driver);
        }
}
