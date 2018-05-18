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

package com.desive.scheduler;

import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.Callable;

/*
 Created by Jack DeSive on 11/28/2017 at 8:32 PM
*/
public class ScheduledJob implements Callable{

    private Job job;
    private LocalDateTime time;

    public ScheduledJob(Job job, LocalDateTime localDateTime) {
        this.job = job;
        this.time = localDateTime;
    }

    public ScheduledJob(Job job, long delay, TemporalUnit unit) {
        this.job = job;
        this.time = LocalDateTime.now().plus(delay, unit);
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Job getJob() {
        return job;
    }

    @Override
    public Object call() throws Exception {
        job.work();
        return true;
    }
}
