package org.vibioh.utils;


import java.util.Date;

public abstract class DateHelper {
    public static Date now() {
        return new Date();
    }

    private DateHelper() {
        throw new AssertionError();
    }
}
