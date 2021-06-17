package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;
import fr.lernejo.tester.api.TestMethod;

public class TestClassDescriptionLernejoTests {
    @TestMethod
    public static void main(String[] args) {
        TestClassDescription test = new TestClassDescription(SomeLernejoTests.class);

        System.out.println(test.listTestMethods());
    }
}
