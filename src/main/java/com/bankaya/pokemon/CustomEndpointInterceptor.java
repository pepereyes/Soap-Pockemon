package com.bankaya.pokemon;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Source;
import javax.xml.ws.spi.http.HttpExchange;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.AbstractLoggingInterceptor;
import org.springframework.ws.soap.SoapMessage;

import com.bankaya.pokemon.request.logging.*;

@Component
public class CustomEndpointInterceptor implements EndpointInterceptor {

	@Autowired
	private HttpServletRequest request;
	@Autowired RequestLoggingRepository repository;
	
    private static final Log LOG = LogFactory.getLog(CustomEndpointInterceptor.class);
    private RequestLogging requestLogging;

    @Override
	public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
    	requestLogging = new RequestLogging();
        
    	requestLogging.setFechaRequest(new Date(request.getDateHeader("If-Unmodified-Since")));
    	requestLogging.setIp(getIpAddress());
    	requestLogging.setMetodo(request.getMethod());
    	repository.save(requestLogging);
    	return handleRequest(messageContext, null);
    }

    @Override
	public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
    	try {
    		return handleResponse(messageContext, null);
    	} catch(Exception e) {
    		
    	}
        return false;
    }

	@Override
	public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	protected String getIpAddress() {
	    String ipAddress = request.getHeader("X-FORWARDED-FOR");
	    if (ipAddress == null) {
	        ipAddress = request.getRemoteAddr();
	    }
	    return ipAddress;
	}
}
