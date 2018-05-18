/*
 * Copyright (C) 2017  Jack DeSive
 *
 * This file is part of Core.
 *
 * Core is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.desive.utilities.strings;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.IntStream;

/**
 * Utilities class for ${@link String}'s
 *
 * @author Jack DeSive
 */
public class Strings {

    /** Empty string */
    public static String EMPTY = "";

    /** Windows new line character */
    public static String NEW_LINE = "\r\n";

    /** *nix/OSX new line character */
    public static String NEW_LINE_CR = "\n";

    /** Classic Mac new line character */
    public static String NEW_LINE_LF = "\r";

    /**
     * Get the string value of an ${@link Object}. Same as String.valueOf(${@link Object}).
     *
     * @param obj Object to get the ${@link String} value
     */
    public static String valueOf(Object obj) {
        return String.valueOf(obj);
    }

    /**
     * Merge two ${@link String}'s into a new ${@link String}.
     *
     * @param firstText Text to start new ${@link String} with
     * @param secondText Text to append to the end of ${@param firstText}
     */
    public static String concat(String firstText, String secondText) {
        return firstText.concat(secondText);
    }

    /**
     * Merge ${@link String}'s together into a new ${@link String}.
     *
     * @param texts Lists of ${@link String}'s to merge together
     */
    public static String concat(String... texts) {
        StringBuilder builder = build();
        Arrays.stream(texts).forEach(builder::append);
        return builder.toString();
    }

    /**
     * Remove all literal instances of ${@param removalText} from ${@param text}.
     *
     * @param text Base text to remove ${@param removalText} from
     * @param removalText Text to remove from ${@param text}
     */
    public static String remove(String text, String removalText) {
        return text.replace(removalText, EMPTY);
    }

    /**
     * Remove all instances of ${@param removalText} from ${@param text}.
     *
     * @param text Base text to remove ${@param removalText} from
     * @param removalText Text to remove from ${@param text}
     */
    public static String removeAll(String text, String removalText) {
        return text.replaceAll(removalText, EMPTY);
    }

    /**
     * Check if a ${@link String} is null.
     *
     * @param text ${@link String} to check
     */
    public static boolean isNull(String text) {
        return text == null;
    }

    /**
     * Check if a ${@link String} is null.
     *
     * @param text ${@link String} to check
     */
    public static boolean isBlank(String text) {
        return text.trim().equals(EMPTY);
    }

    /**
     * Check if a ${@link String} is null or is a blank string.
     *
     * @param text ${@link String} to check
     */
    public static boolean isNullOrBlank(String text) {
        return isNull(text) || isBlank(text);
    }

    /**
     * Get a new ${@link StringBuilder} with some default text.
     *
     * @param startText Default string to add to the ${@link StringBuilder}
     */
    public static StringBuilder build(String startText) {
        return new StringBuilder(startText);
    }

    /**
     * Get a new ${@link StringBuilder}.
     */
    public static StringBuilder build() {
        return new StringBuilder(EMPTY);
    }

    /**
     * Reverse a ${@link String}. Takes the last ${@link Character} from ${@link String} and puts it in front, the
     * second in-front of the first and so on.
     *
     * @param text The ${@link String} to reverse
     */
    public static String reverse(String text) {
        return build(text).reverse().toString();
    }

    /**
     * Turn a ${@link String} into a ${@link Character} array.
     *
     * @param text The ${@link String} to turn in to an ${@link Character} array
     */
    public static char[] chars(String text) {
        return text.toCharArray();
    }

    /**
     * Turn a ${@link String} into a ${@link Integer} array.
     *
     * @param text The ${@link String} to turn in to an ${@link Integer} array
     */
    public static int[] intArray(String text) {
        return intStream(text).toArray();
    }

    /**
     * Turn a ${@link String} into an ${@link IntStream}.
     *
     * @param text The ${@link String} to tuen into an ${@link IntStream}
     */
    public static IntStream intStream(String text) {
        return text.chars();
    }

    /**
     * Remove trailing whitespace from the beginning or end of ${@param text}.
     *
     * @param text The ${@link String} to trim
     */
    public static String trim(String text) {
        return text.trim();
    }

    /**
     * Convert all characters int ${@param text} to uppercase.
     *
     * @param text ${@link String} to convert
     */
    public static String toUppercase(String text) {
        return text.toUpperCase();
    }

    /**
     * Convert all characters in ${@param text} to uppercase.
     *
     * @param text ${@link String} to convert
     * @param locale ${@link Locale} to use
     */
    public static String toUppercase(String text, Locale locale) {
        return text.toUpperCase(locale);
    }

    /**
     * Convert all characters in ${@param text} to lowercase.
     *
     * @param text ${@link String} to convert
     */
    public static String toLowercase(String text) {
        return text.toLowerCase();
    }

    /**
     * Convert all characters in ${@param text} to lowercase.
     *
     * @param text ${@link String} to convert
     * @param locale ${@link Locale} to use
     */
    public static String toLowercase(String text, Locale locale) {
        return text.toLowerCase(locale);
    }

    /**
     * A toString method meant to override .toString in any class that does not display
     * null values.
     *
     * @param obj The class to map to a ${@link String}
     */
    public static String toStringExcludeNulls(Object obj){
        StringBuilder stringBuilder = new StringBuilder(obj.getClass().getName()).append("[ ");
        Arrays.stream(obj.getClass().getDeclaredFields()).filter(field -> {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                if(value != null)
                    return true;
            } catch (IllegalAccessException e) {}
            field.setAccessible(false);
            return false;
        }).forEach(field -> {
            try {
                stringBuilder.append(field.getName()).append("=").append(field.get(obj)).append(" ");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            field.setAccessible(false);
        });
        return stringBuilder.append("]").toString();
    }

    /**
     * A toString method meant to override .toString in any class.
     *
     * @param obj The class to map to a ${@link String}
     */
    public static String toString(Object obj){
        StringBuilder stringBuilder = new StringBuilder(obj.getClass().getName()).append("[ ");
        Arrays.stream(obj.getClass().getDeclaredFields()).forEach(field -> {
            field.setAccessible(true);
            try {
                stringBuilder.append(field.getName()).append("=").append(field.get(obj)).append(" ");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            field.setAccessible(false);
        });
        return stringBuilder.append("]").toString();
    }

}
