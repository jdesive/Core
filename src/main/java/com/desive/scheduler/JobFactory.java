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

import com.desive.scheduler.exceptions.JobTimeException;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.*;

/*
 Created by Jack DeSive on 11/28/2017 at 8:32 PM
*/
public class JobFactory {

    private ConcurrentMap<ScheduledJob, LocalDateTime> jobQueue;
    private ScheduledExecutorService executor;

    private final int defaultPoolSize = 2;

    public JobFactory() {
        jobQueue = new ConcurrentHashMap<>();
        executor = Executors.newScheduledThreadPool(defaultPoolSize);
    }

    public JobFactory(int poolSize) {
        jobQueue = new ConcurrentHashMap<>();
        executor = Executors.newScheduledThreadPool(poolSize <= 0 ? defaultPoolSize : poolSize);
    }

    public void scheduleJob(ScheduledJob scheduledJob) {
        if(scheduledJob.getTime().isBefore(LocalDateTime.now())){
            throw new JobTimeException("A job cannot be scheduled before the current date");
        }
        jobQueue.putIfAbsent(scheduledJob, scheduledJob.getTime());
        executor.schedule(() ->{
            scheduledJob.getJob().work();
            jobQueue.remove(scheduledJob);
        }, scheduledJob.getTime().toLocalTime().getNano()-LocalDateTime.now().toLocalTime().getNano(), TimeUnit.MILLISECONDS);
    }

    public ConcurrentMap<ScheduledJob, LocalDateTime> getJobQueueMap() {
        return jobQueue;
    }

    public Set<ScheduledJob> getJobQueue() {
        return jobQueue.keySet();
    }

}
