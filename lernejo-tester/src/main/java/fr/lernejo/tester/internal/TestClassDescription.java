package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestClassDescription {
    public final Class<?> typeParameterClass;

    public TestClassDescription(Class<?> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public List<Method> listTestMethods() {
        List<Method> listMethods = new ArrayList<>();
        Method[] methods = this.typeParameterClass.getDeclaredMethods();

        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())
                && method.getReturnType().equals(Void.TYPE)
                && method.getParameterCount() == 0
                && method.isAnnotationPresent(TestMethod.class)) {
                listMethods.add(method);
            }
        }

        return listMethods;
    }
}
