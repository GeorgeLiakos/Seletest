/*
This file is part of the Seletest by Papadakis Giannis <gpapadakis84@gmail.com>.

Copyright (c) 2014, Papadakis Giannis <gpapadakis84@gmail.com>
All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice,
      this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice,
      this list of conditions and the following disclaimer in the documentation
      and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.automation.seletest.core.services.actions;

import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.seletest.core.selenium.threads.SessionContext;
import com.automation.seletest.core.spring.ApplicationContextProvider;

/**
 * AbstractBase contains all static abstract classes used
 * @author Giannis Papadakis (mailTo:gpapadakis84@gmail.com)
 *
 */
@Slf4j
public abstract class AbstractBase {


    /**
     * Abstract class for Waiting Conditions
     * @author Giannis Papadakis (mailTo:gpapadakis84@gmail.com)
     *
     */
    public static abstract class WaitBase implements WaitFor{

        /**Component name for WebDriverWait*/
        private final String webDriverWait="webdriverwait";


        /**
         * Returns a new WebDriverWait instance
         * @return WebDriverWait object
         */
        protected WebDriverWait wfExpected(){
            return (WebDriverWait) ApplicationContextProvider.getApplicationContext().getBean(webDriverWait, SessionContext.getSession().getWebDriver(),SessionContext.getSession().getWaitUntil());
        }

        /**
         * Sleeps a thread
         * @param timeout long timeout for thread sleep
         */
        protected void threadSleep(final long timeout){
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                log.error("Interrupted exception occured trying to sleep thread for: "+timeout);
            }
        }

        /**
         * Define locator
         * @param locator Object locator
         * @return String locator
         */
        protected String defineLocator(Object locator){
            if(((String)locator).startsWith("jquery=")){
                return ((String)locator).replace("jquery=", "css=");
            } else{
                return (String)locator;
            }
        }

    }


}
