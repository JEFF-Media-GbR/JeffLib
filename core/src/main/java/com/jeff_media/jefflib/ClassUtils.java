package com.jeff_media.jefflib;

import lombok.experimental.UtilityClass;

import javax.annotation.Nonnull;

/**
 * Class related methods that do not have something to do with Reflection (see {@link ReflUtils} for that)
 */
@UtilityClass
public final class ClassUtils {

    /**
     * Checks if a class exists
     *
     * @param name Fully qualified class name
     * @return true if the class exists, otherwise false
     */
    public static boolean exists(@Nonnull final String name) {
        try {
            Class.forName(name);
            return true;
        } catch (final ClassNotFoundException exception) {
            return false;
        }
    }

    public static int getCurrentLineNumber() {
        return getCurrentLineNumber(1);
    }

    /**
     * Returns the current line number from which this method was called from
     */
    public static int getCurrentLineNumber(final int offset) {
        return Thread.currentThread().getStackTrace()[2 + offset].getLineNumber();
    }

    public static String getCurrentClassName() {
        return getCurrentClassName(1);
    }

    /**
     * Returns the current class name from which this method was called from
     */
    public static String getCurrentClassName(int offset) {
        return Thread.currentThread().getStackTrace()[2 + offset].getClassName();
    }

    public static Class<?> getCurrentClass() {
        return getCurrentClass(1);
    }

    public static Class<?> getCurrentClass(final int offset) {
        try {
            return Class.forName(Thread.currentThread().getStackTrace()[2 + offset].getClassName());
        } catch (final ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the current class file name from which this method was called from
     */
    public static String getCurrentClassFileName() {
        return getCurrentClassFileName(1);
    }

    public static String getCurrentClassFileName(int offset) {
        return Thread.currentThread().getStackTrace()[2 + offset].getFileName();
    }

    public static String getCurrentMethodName() {
        return getCurrentMethodName(1);
    }

    /**
     * Returns the current method name from which this method was called from
     */
    public static String getCurrentMethodName(int offset) {
        return Thread.currentThread().getStackTrace()[2 + offset].getMethodName();
    }
}
