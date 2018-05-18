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

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Utilities class for performing HTTP requests.
 *
 * @author Jack DeSive
 */
public class SyncHttp implements Http{
    /**
     * HTTP Method enum
     */
    public enum HttpMethod {
        GET("get"),
        POST("post"),
        PUT("put"),
        DELETE("delete"),
        HEAD("head"),
        OPTIONS("options"),
        PATCH("patch");

        private String method;

        HttpMethod(String method) {
            this.method = method;
        }

        public String get() {
            return method.toUpperCase();
        }
    }

    /**
     * Preform a HTTP GET request to ${@param target}.
     *
     * @param target URL to request from
     * @param parameters URL query parameter map
     * @param headers Request header map
     * @throws IOException
     */
    @Override
    public String get(String target, Map<String, String> parameters, Map<String, String> headers) throws IOException{
        return request(target, parameters, headers, null, HttpMethod.GET);
    }

    /**
     * Preform a HTTP GET request to ${@param target}.
     *
     * @param target URL to request from
     * @param parameters URL query parameter map
     * @throws IOException
     */
    @Override
    public String get(String target, Map<String, String> parameters) throws IOException{
        return request(target, parameters, null, null, HttpMethod.GET);
    }

    /**
     * Preform a HTTP GET request to ${@param target}.
     *
     * @param target URL to request from
     * @throws IOException
     */
    @Override
    public String get(String target) throws IOException{
        return request(target, null, null, null, HttpMethod.GET);
    }

    /**
     * Preform a HTTP POST request to ${@param target}.
     *
     * @param target URL to post too
     * @param body The body for the request
     * @param parameters URL query parameter map
     * @param headers Request header map
     * @throws IOException
     */
    @Override
    public String post(String target, String body, Map<String, String> parameters, Map<String, String> headers) throws IOException{
        return request(target, parameters, headers, body, HttpMethod.POST);
    }

    /**
     * Preform a HTTP POST request to ${@param target}.
     *
     * @param target URL to post too
     * @param body The body for the request
     * @param parameters URL query parameter map
     * @throws IOException
     */
    @Override
    public String post(String target, String body, Map<String, String> parameters) throws IOException{
        return request(target, parameters, null, body, HttpMethod.POST);
    }

    /**
     * Preform a HTTP POST request to ${@param target}.
     *
     * @param target URL to post too
     * @param body The body for the request
     * @throws IOException
     */
    @Override
    public String post(String target, String body) throws IOException{
        return request(target, null, null, body, HttpMethod.POST);
    }

    /**
     * Preform a HTTP PUT request to ${@param target}.
     *
     * @param target URL to put too
     * @param body The body for the request
     * @param parameters URL query parameter map
     * @param headers Request header map
     * @throws IOException
     */
    @Override
    public String put(String target, String body, Map<String, String> parameters, Map<String, String> headers) throws IOException{
        return request(target, parameters, headers, body, HttpMethod.PUT);
    }

    /**
     * Preform a HTTP PUT request to ${@param target}.
     *
     * @param target URL to put too
     * @param body The body for the request*
     * @param parameters URL query parameter map
     * @throws IOException
     */
    @Override
    public String put(String target, String body, Map<String, String> parameters) throws IOException{
        return request(target, parameters, null, body, HttpMethod.PUT);
    }

    /**
     * Preform a HTTP PUT request to ${@param target}.
     *
     * @param target URL to put too
     * @param body The body for the request
     * @throws IOException
     */
    @Override
    public String put(String target, String body) throws IOException{
        return request(target, null, null, body, HttpMethod.PUT);
    }

    /**
     * Preform a HTTP DELETE request to ${@param target}.
     *
     * @param target URL to delete from
     * @param parameters URL query parameter map
     * @param headers Request header map
     * @throws IOException
     */
    @Override
    public String delete(String target, Map<String, String> parameters, Map<String, String> headers) throws IOException{
        return request(target, parameters, headers, null, HttpMethod.DELETE);
    }

    /**
     * Preform a HTTP DELETE request to ${@param target}.
     *
     * @param target URL to delete from
     * @param parameters URL query parameter map
     * @throws IOException
     */
    @Override
    public String delete(String target, Map<String, String> parameters) throws IOException{
        return request(target, parameters, null, null, HttpMethod.DELETE);
    }

    /**
     * Preform a HTTP DELETE request to ${@param target}.
     *
     * @param target URL to delete from
     * @throws IOException
     */
    @Override
    public String delete(String target) throws IOException{
        return request(target, null, null, null, HttpMethod.DELETE);
    }

    /**
     * Preform a HTTP HEAD request to ${@param target}.
     *
     * @param target URL to head too
     * @param parameters URL query parameter map
     * @param headers Request header map
     * @throws IOException
     */
    @Override
    public String head(String target, Map<String, String> parameters, Map<String, String> headers) throws IOException{
        return request(target, parameters, headers, null, HttpMethod.HEAD);
    }

    /**
     * Preform a HTTP HEAD request to ${@param target}.
     *
     * @param target URL to head too
     * @param parameters URL query parameter map
     * @throws IOException
     */
    @Override
    public String head(String target, Map<String, String> parameters) throws IOException{
        return request(target, parameters, null, null, HttpMethod.HEAD);
    }

    /**
     * Preform a HTTP HEAD request to ${@param target}.
     *
     * @param target URL to head too
     * @throws IOException
     */
    @Override
    public String head(String target) throws IOException{
        return request(target, null, null, null, HttpMethod.HEAD);
    }

    /**
     * Preform a HTTP OPTIONS request to ${@param target}.
     *
     * @param target URL to request options from
     * @param parameters URL query parameter map
     * @param headers Request header map
     * @throws IOException
     */
    @Override
    public String options(String target, Map<String, String> parameters, Map<String, String> headers) throws IOException{
        return request(target, parameters, headers, null, HttpMethod.OPTIONS);
    }

    /**
     * Preform a HTTP OPTIONS request to ${@param target}.
     *
     * @param target URL to request options from
     * @param parameters URL query parameter map
     * @throws IOException
     */
    @Override
    public String options(String target, Map<String, String> parameters) throws IOException{
        return request(target, parameters, null, null, HttpMethod.OPTIONS);
    }

    /**
     * Preform a HTTP OPTIONS request to ${@param target}.
     *
     * @param target URL to request options from
     * @throws IOException
     */
    @Override
    public String options(String target) throws IOException{
        return request(target, null, null, null, HttpMethod.OPTIONS);
    }

    /**
     * Preform a HTTP PATCH request to ${@param target}.
     *
     * @param target URL to patch
     * @param body The body for the request
     * @param parameters URL query parameter map
     * @param headers Request header map
     * @throws IOException
     */
    @Override
    public String patch(String target, String body, Map<String, String> parameters, Map<String, String> headers) throws IOException{
        return request(target, parameters, headers, body, HttpMethod.PATCH);
    }

    /**
     * Preform a HTTP PATCH request to ${@param target}.
     *
     * @param target URL to patch
     * @param body The body for the request
     * @param parameters URL query parameter map
     * @throws IOException
     */
    @Override
    public String patch(String target, String body, Map<String, String> parameters) throws IOException{
        return request(target, parameters, null, body, HttpMethod.PATCH);
    }

    /**
     * Preform a HTTP PATCH request to ${@param target}.
     *
     * @param target URL to patch
     * @param body The body for the request
     * @throws IOException
     */
    @Override
    public String patch(String target, String body) throws IOException{
        return request(target, null, null, body, HttpMethod.PATCH);
    }

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
    @Override
    public String request(String target, Map<String, String> parameters, Map<String, String> headers, String body, HttpMethod method) throws IOException {

        URL targetUrl = new URL(target + createParameterString(parameters));
        HttpURLConnection connection = (HttpURLConnection) targetUrl.openConnection();

        if(headers != null && !headers.isEmpty()){
            headers.forEach(connection::setRequestProperty);
        }

        connection.setRequestMethod(method.get());
        connection.setConnectTimeout(15000);
        connection.setReadTimeout(15000);

        if(body != null && !body.equals("")) {
            connection.setDoOutput(true);
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(body);
            outputStream.flush();
            outputStream.close();
        }

        BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = inputStream.readLine()) != null) {
            response.append(inputLine);
        }
        inputStream.close();

        connection.disconnect();
        return response.toString();
    }

    /**
     * Create the parameter string for HTTP requests queries
     *
     * @param parameters ${@link Map} of query parameters
     */
    private static String createParameterString(Map<String, String> parameters){
        if(parameters == null || parameters.isEmpty())
            return "";

        StringBuilder paramString = new StringBuilder("?");
        parameters.forEach((k, v) -> {
            paramString.append(k);
            paramString.append("=");
            paramString.append(v);
            paramString.append("&");
        });
        paramString.deleteCharAt(paramString.length()-1);
        return paramString.toString();
    }

}