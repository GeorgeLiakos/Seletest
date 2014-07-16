/**
 *
 */
package com.automation.sele.web.services.actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**Interface for synchronization methods
 * @author Giannis Papadakis(mailTo:gpapadakis84@gmail.com) *
 */
public interface ActionsSync {


    /** Wait for element to be present in DOM
     *
     * @param driver
     * @param waitSeconds
     * @param locator
     * @return
     */
    WebElement waitForElementPresence(long waitSeconds, String locator);
    /** Wait for element to be visible
     * @param driver
     * @param waitSeconds
     * @param locator
     * @return
     */
    WebElement waitForElementVisibility(long waitSeconds, Object locator);
    /**
     * Wait for element to be clickable
     * @param driver
     * @param waitSeconds
     * @param locator
     * @return
     */
    WebElement waitForElementToBeClickable(long waitSeconds, Object locator);
    /**
     * Wait for alert
     * @param driver
     * @param waitSeconds
     * @return
     */
    Alert waitForAlert(long waitSeconds);

    /**
     * Wait for a frame and switch to it
     * @param driver
     * @param waitSeconds
     * @param locator
     * @return
     */
    WebDriver switchToFrame(long waitSeconds, String locator);

}