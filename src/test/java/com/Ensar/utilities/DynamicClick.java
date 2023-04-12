package com.Ensar.utilities;


import com.Ensar.pages.DashBoard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;


public class DynamicClick {

    private static FindBy findBy;


    public static void clickOnElement(String webElementName) {
        webElementName = toCamelCase(webElementName);
        List<WebElement> locators = new ArrayList<>();


        try {
            List<Class<?>> classes = getClasses("com.Ensar.pages");

            for (int i = 0; i < classes.size(); i++) {

                Field[] fields = classes.get(i).getDeclaredFields();

                for (Field field : fields) {
                    if (field.getName().equals(webElementName)) {
                        findBy = field.getAnnotation(FindBy.class);
                        locators = annotationFieldValueFinder();
                        if (locators.size() == 1) {
                            locators.get(0).click();
                            break;
                        }
                    }
                }

                if (i == classes.size() - 1 && locators.size() == 0) {
                    System.out.println("WebElement does not exist check again dynamic class ");
                    throw new NoSuchElementException();
                }

            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static List<Class<?>> getClasses(String packageName) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        String path = packageName.replace('.', '/');
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            classLoader = DashBoard.class.getClassLoader();
        }
        URL resource = classLoader.getResource(path);
        if (resource == null) {
            throw new IllegalArgumentException("Package " + packageName + " not found");
        }
        String filePath = resource.getFile();
        File directory = new File(filePath);
        if (directory.exists()) {
            String[] files = directory.list();
            for (String fileName : files) {
                if (fileName.endsWith(".class")) {
                    String className = packageName + '.' + fileName.substring(0, fileName.length() - 6);
                    Class<?> cls = Class.forName(className);
                    classes.add(cls);
                }
            }
        }
        return classes;
    }


    private static List<WebElement> annotationFieldValueFinder() {
        String annotationValue;
        List<WebElement> webElement = new ArrayList<>();

        if (!findBy.xpath().equals("")) {
            annotationValue = findBy.xpath();
            webElement = Driver.get().findElements(By.xpath(annotationValue));
        } else if (!findBy.css().equals("")) {
            annotationValue = findBy.css();
            webElement = Driver.get().findElements(By.cssSelector(annotationValue));
        } else if (!findBy.id().equals("")) {
            annotationValue = findBy.id();
            webElement = Driver.get().findElements(By.id(annotationValue));
        } else if (!findBy.linkText().equals("")) {
            annotationValue = findBy.linkText();
            webElement = Driver.get().findElements(By.linkText(annotationValue));
        } else if (!findBy.partialLinkText().equals("")) {
            annotationValue = findBy.partialLinkText();
            webElement = Driver.get().findElements(By.partialLinkText(annotationValue));
        } else if (!findBy.name().equals("")) {
            annotationValue = findBy.name();
            webElement = Driver.get().findElements(By.name(annotationValue));
        } else if (!findBy.className().equals("")) {
            annotationValue = findBy.className();
            webElement = Driver.get().findElements(By.className(annotationValue));
        } else if (!findBy.tagName().equals("")) {
            annotationValue = findBy.tagName();
            webElement = Driver.get().findElements(By.tagName(annotationValue));
        }


        return webElement;
    }


    private static String toCamelCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder camelCase = new StringBuilder(str.length());
        boolean capitalizeNextChar = false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isWhitespace(ch) || ch == '-' || ch == '_') {
                capitalizeNextChar = true;
            } else if (capitalizeNextChar) {
                camelCase.append(Character.toTitleCase(ch));
                capitalizeNextChar = false;
            } else {
                camelCase.append(Character.toLowerCase(ch));
            }
        }
        return camelCase.toString();
    }


    public static WebElement webElementOfString(String webElementName) {
        webElementName = toCamelCase(webElementName);
        List<WebElement> locators = new ArrayList<>();
        try {
            List<Class<?>> classes = getClasses("com.Ensar.pages");
            for (int i = 0; i < classes.size(); i++) {
                Field[] fields = classes.get(i).getDeclaredFields();
                for (Field field : fields) {
                    if (field.getName().equals(webElementName)) {
                        findBy = field.getAnnotation(FindBy.class);
                        locators = annotationFieldValueFinder();
                    }
                }
                if (i == classes.size() - 1 && locators.size() == 0) {
                    System.out.println("WebElement does not exist check again dynamic class ");
                    throw new NoSuchElementException();
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return locators.get(0);
    }


}
