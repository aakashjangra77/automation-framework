package com.sdet.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {

    @Test
    public void firstAutomationTest() {
        System.out.println("TestNG is working successfully!");
        Assert.assertTrue(true);
    }
}
