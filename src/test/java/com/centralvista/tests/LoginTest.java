/**
 * @author surendragangwar
 * @since 13-Aug-2026
 * @version 1.0
 * 
 * Description: [Enter class purpose here]
 */
package com.centralvista.tests;



import org.testng.annotations.Test;
import com.centralvista.base.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void openApplicationTest() {

        System.out.println("Page Title: " + driver.getTitle());

    }
}