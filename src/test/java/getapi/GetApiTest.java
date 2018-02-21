/**
 * 
 */
package getapi;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.client.Restclient;

/**
 * @author Jagadeeshwar
 *
 */
public class GetApiTest extends Testbase {
	Testbase testbase;
	String Serviceurl;
	String Apiurl;
	String Url;
	Restclient restclient;

	@BeforeMethod
	public void getprop() {

		testbase = new Testbase();

		Serviceurl = prop.getProperty("Serviceurl");
		Apiurl = prop.getProperty("Apiurl");
		Url = Serviceurl + Apiurl;

	}

	@Test
	public void getapi() throws ClientProtocolException, IOException {

		restclient = new Restclient();
		restclient.get(Url);
	}
}
