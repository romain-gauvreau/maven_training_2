package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;

public class TestClassDescriptionLernejoTests {

    public static void main(String[] args) {
        TestClassDescription test = new TestClassDescription(SomeLernejoTests.class);

        System.out.println(test.listTestMethods());
    }
}
