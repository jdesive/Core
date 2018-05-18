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

package com.desive.utilities;

import com.desive.utilities.strings.Strings;

/*
 Created by Jack DeSive on 11/16/2017 at 9:44 PM
*/
public class Utils {

    boolean active = true;
    String name = "My name", asfsdsd = null;

   static  Utils instance;

    public Utils() {
        instance = this;
    }

    public static void main(String[] args) {
        new Utils();
        System.out.println(Strings.toStringExcludeNulls(instance));
    }

}
