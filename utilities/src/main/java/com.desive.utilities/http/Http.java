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

package com.desive.utilities.http;

import java.io.IOException;
import java.util.Map;

/*
 Created by Jack DeSive on 1/14/2018 at 6:36 PM
*/
public interface Http {

    /**
     * Preform a HTTP GET request to ${@param target}.
     *
     * @param target URL to request from
     * @param parameters URL query parameter map
     * @param headers Request header map
     * @throws IOException
     */
    String get(String target, Map<String, String> parameters, Map<String, String> headers) throws IOException;

    /**
     * Preform a HTTP GET request to ${@param target}.
     *
     * @param target URL to request from
     * @param parameters URL query parameter map
     * @throws IOException
     */
    String get(String target, Map<String, String> parameters) throws IOException;

    /**
     * Preform a HTTP GET request to ${@param target}.
     *
     * @param target URL to request from
     * @throws IOException
     */
    String get(String target) throws IOException;

    /**
     * Preform a HTTP POST request to ${@param target}.
     *
     * @param target URL to post too
     * @param body The body for the request
     * @param parameters URL query parameter map
     * @param headers Request header map
     * @throws IOException
     */
    String post(String target, String body, Map<String, String> parameters, Map<String, String> headers) throws IOException;

    /**
     * Preform a HTTP POST request to ${@param target}.
     *
     * @param target URL to post too
     * @param body The body for the request
     * @param parameters URL query parameter map
     * @throws IOException
     */
    String post(String target, String body, Map<String, String> parameters) throws IOException;

    /**
     * Preform a HTTP POST request to ${@param target}.
     *
     * @param target URL to post too
     * @param body The body for the request
     * @throws IOException
     */
    String post(String target, String body) throws IOException;

    /**
     * Preform a HTTP PUT request to ${@param target}.
     *
     * @param target URL to put too
     * @param body The body for the request
     * @param parameters URL query parameter map
     * @param headers Request header map
     * @throws IOException
     */
    String put(String target, String body, Map<String, String> parameters, Map<String, String> headers) throws IOException;

    /**
     * Preform a HTTP PUT request to ${@param target}.
     *
     * @param target URL to put too
     * @param body The body for the request*
     * @param parameters URL query parameter map
     * @throws IOException
     */
    String put(String target, String body, Map<String, String> parameters) throws IOException;

    /**
     * Preform a HTTP PUT request to ${@param target}.
     *
     * @param target URL to put too
     * @param body The body for the request
     * @throws IOException
     */
    String put(String target, String body) throws IOException;

    /**
     * Preform a HTTP DELETE request to ${@param target}.
     *
     * @param target URL to delete from
     * @param parameters URL query parameter map
     * @param headers Request header map
     * @throws IOException
     */
    String delete(String target, Map<String, String> parameters, Map<String, String> headers) throws IOException;

    /**
     * Preform a HTTP DELETE request to ${@param target}.
     *
     * @param target URL to delete from
     * @param parameters URL query parameter map
     * @throws IOException
     */
    String delete(String target, Map<String, String> parameters) throws IOException;

    /**
     * Preform a HTTP DELETE request to ${@param target}.
     *
     * @param target URL to delete from
     * @throws IOException
     */
    String delete(String target) throws IOException;

    /**
     * Preform a HTTP HEAD request to ${@param target}.
     *
     * @param target URL to head too
     * @param parameters URL query parameter map
     * @param headers Request header map
     * @throws IOException
     */
    String head(String target, Map<String, String> parameters, Map<String, String> headers) throws IOException;

    /**
     * Preform a HTTP HEAD request to ${@param target}.
     *
     * @param target URL to head too
     * @param parameters URL query parameter map
     * @throws IOException
     */
    String head(String target, Map<String, String> parameters) throws IOException;

    /**
     * Preform a HTTP HEAD request to ${@param target}.
     *
     * @param target URL to head too
     * @throws IOException
     */
    String head(String target) throws IOException;

    /**
     * Preform a HTTP OPTIONS request to ${@param target}.
     *
     * @param target URL to request options from
     * @param parameters URL query parameter map
     * @param headers Request header map
     * @throws IOException
     */
    String options(String target, Map<String, String> parameters, Map<String, String> headers) throws IOException;

    /**
     * Preform a HTTP OPTIONS request to ${@param target}.
     *
     * @param target URL to request options from
     * @param parameters URL query parameter map
     * @throws IOException
     */
    String options(String target, Map<String, String> parameters) throws IOException;

    /**
     * Preform a HTTP OPTIONS request to ${@param target}.
     *
     * @param target URL to request options from
     * @throws IOException
     */
    String options(String target) throws IOException;

    /**
     * Preform a HTTP PATCH request to ${@param target}.
     *
     * @param target URL to patch
     * @param body The body for the request
     * @param parameters URL query parameter map
     * @param headers Request header map
     * @throws IOException
     */
    String patch(String target, String body, Map<String, String> parameters, Map<String, String> headers) throws IOException;

    /**
     * Preform a HTTP PATCH request to ${@param target}.
     *
     * @param target URL to patch
     * @param body The body for the request
     * @param parameters URL query parameter map
     * @throws IOException
     */
    String patch(String target, String body, Map<String, String> parameters) throws IOException;

    /**
     * Preform a HTTP PATCH request to ${@param target}.
     *
     * @param target URL to patch
     * @param body The body for the request
     * @throws IOException
     */
    String patch(String target, String body) throws IOException;

    /**
     * Preform a HTTP request to ${@param target}
     *
     * @param target URL to request from
     * @param parameters URL query parameter map
     * @param headers Request header map
     * @param body The body of the request
     * @param method The HTTP request method
     * @throws IOException
     */
    String request(String target, Map<String, String> parameters, Map<String, String> headers, String body, SyncHttp.HttpMethod method) throws IOException;

}
