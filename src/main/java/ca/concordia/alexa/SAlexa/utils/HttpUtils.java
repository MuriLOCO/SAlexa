package ca.concordia.alexa.SAlexa.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import ca.concordia.alexa.SAlexa.enums.SquattingType;

public class HttpUtils {

  /**
   * Post the data to the remote server
   * @param url
   * @return
   * @throws ClientProtocolException
   * @throws IOException
   */
  public static CloseableHttpResponse postData(String url, SquattingType type, String text) throws ClientProtocolException, IOException {
    CloseableHttpClient client = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost(url);

    // Request parameters and other properties.
    List<NameValuePair> params = new ArrayList<>(2);
    params.add(new BasicNameValuePair("type", type.name()));
    params.add(new BasicNameValuePair("text", text));
    httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

    CloseableHttpResponse response = client.execute(httpPost);
    client.close();
   
    return response;
  }
}
