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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 Created by Jack DeSive on 11/15/2017 at 11:15 PM
*/
class StringsTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void valueOf() {
        int number = 13423;
        assertEquals(String.valueOf(number), Strings.valueOf(number));
    }

    @Test
    void concat() {
        String str1 = "This is ", str2 = "some text";
        assertEquals(str1 + str2, Strings.concat(str1, str2));
    }

    @Test
    void concat1() {
        String[] arr = {"This " + "is " + "some " + "text"};
        String expected = "This is some text";
        assertEquals(expected, Strings.concat(arr));
    }

    @Test
    void remove() {
    }

    @Test
    void removeAll() {
    }

    @Test
    void isNull() {
    }

    @Test
    void isBlank() {
    }

    @Test
    void isNullOrBlank() {
    }

    @Test
    void build() {
    }

    @Test
    void build1() {
    }

    @Test
    void reverse() {
    }

    @Test
    void chars() {
    }

    @Test
    void intArray() {
    }

    @Test
    void intStream() {
    }

    @Test
    void trim() {
    }

}