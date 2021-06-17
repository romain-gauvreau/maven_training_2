package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestClassDiscoverer {
    String myPackage;

    public TestClassDiscoverer(String name) {
        this.myPackage = name;
    }

    public  List<TestClassDescription> listTestClasses() {
        Reflections reflections = new Reflections(this.myPackage, new SubTypesScanner(false));
        Set<Class<?>> allTypes = reflections.getSubTypesOf(Object.class);
        List<TestClassDescription> testClasses = new ArrayList<>();
        for (Class<?> currentClass: allTypes) {
            Method[] methods = currentClass.getDeclaredMethods();
            boolean hasTestMethod = false;

            for(Method currentMethod: methods) {
                if(currentMethod.isAnnotationPresent(TestMethod.class)) {
                    hasTestMethod = true;
                    break;
                }
            }

            if(hasTestMethod && currentClass.getSimpleName().endsWith("LernejoTests")) {
                testClasses.add(new TestClassDescription(currentClass));
            }
        }
        return testClasses;
    }
}
