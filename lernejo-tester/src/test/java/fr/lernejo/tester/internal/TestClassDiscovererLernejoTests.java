package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

public class TestClassDiscovererLernejoTests {
    @TestMethod
    public static void main(String[] args) {
        TestClassDiscoverer test = new TestClassDiscoverer("fr.lernejo.tester");
        System.out.println(test.listTestClasses());
    }
}
