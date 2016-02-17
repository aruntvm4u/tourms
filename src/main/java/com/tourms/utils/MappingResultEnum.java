package com.tourms.utils;
import java.util.Locale;
/**
 * Created by aruntvm4u on 2/14/2016.
 */
public enum MappingResultEnum {
    SUCCESS, ERROR;

    @Override
    public String toString() {
        return this.name().toLowerCase(Locale.ENGLISH);
    }
}
