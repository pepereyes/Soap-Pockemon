package com.bankaya.pokemon;

import javax.xml.transform.Source;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptorAdapter;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.AbstractLoggingInterceptor;
import org.springframework.ws.soap.SoapMessage;

public class MyInterceptor extends ClientInterceptorAdapter {

    private EndpointInterceptor endpointInterceptor = new AbstractLoggingInterceptor() {
        @Override
        protected Source getSource(WebServiceMessage webServiceMessage) {
            // Base logic same as SoapEnvelopeLoggingInterceptor getSource method.You can adjust to your preference.
            if(webServiceMessage instanceof SoapMessage) {
                SoapMessage soapMessage = (SoapMessage)webServiceMessage;
                return soapMessage.getEnvelope().getSource();
            } else {
                return null;
            }
        }
        @Override
        protected void logMessage(String message) {
            // You can use your regex to remove the attribute and log the message.
            this.logger.debug(message);
        }
    };

    @Override
    public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
    	try {
    		return endpointInterceptor.handleRequest(messageContext, null);
    	} catch(Exception e) {
    		
    	}
        return false;

    }

    @Override
    public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
    	try {
    		return endpointInterceptor.handleResponse(messageContext, null);
    	} catch(Exception e) {
    		
    	}
        return false;
    	

    }

}
