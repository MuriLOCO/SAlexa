package ca.concordia.alexa.SAlexa;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import ca.concordia.alexa.SAlexa.enums.SquattingType;
import ca.concordia.alexa.SAlexa.utils.AlexaUtils;
import ca.concordia.alexa.SAlexa.utils.HttpUtils;

public class PostDataTest {

  @Test
  public void postData_validData_success() throws ClientProtocolException, IOException {
    HttpUtils.postData(AlexaUtils.URL, SquattingType.BANK_ACCOUNT, "my bank account is 9999");
  }

}
