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

package com.desive;

import com.desive.scheduler.JobFactory;
import com.desive.scheduler.ScheduledJob;

import java.time.LocalDateTime;

/*
 Created by Jack DeSive on 11/28/2017 at 8:27 PM
*/
public class Core {

    private static JobFactory jobFactory = new JobFactory();

    public static void main(String[] args) {

        jobFactory.scheduleJob(new ScheduledJob(() -> {
            // Run some code
            System.out.println("Hello world!");
        }, LocalDateTime.now()));

    }

}
