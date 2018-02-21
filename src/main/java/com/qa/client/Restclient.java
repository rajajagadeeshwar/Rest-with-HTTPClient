/**
 * 
 */
package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * @author Jagadeeshwar
 *
 */
public class Restclient {

	// Get method
	public void get(String url) throws ClientProtocolException, IOException {

		// creating the HTTPClient connection
		CloseableHttpClient httpclient = HttpClients.createDefault();

		// HTTPGet request
		HttpGet httpget = new HttpGet(url);

		// Hit the url
		CloseableHttpResponse httpresponse = httpclient.execute(httpget);

		// Status code
		int statuscode = httpresponse.getStatusLine().getStatusCode();
		System.out.println("status code is" + statuscode);

		// Response entity in the form of String
		String responsestring = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");

		// Converting the Response String into Json Object
		JSONObject jsonresponse = new JSONObject(responsestring);
		System.out.println("json response is" + jsonresponse);

		// Getting all the headers
		Header[] headerarray = httpresponse.getAllHeaders();

		// using HashMap<String, String> to store the key,value pair of headers
		// and for iteration
		HashMap<String, String> allheaders = new HashMap<String, String>();

		for (Header header : headerarray) {

			allheaders.put(header.getName(), header.getValue());

		}
		System.out.println("Headerarray is" + allheaders);

	}

}
