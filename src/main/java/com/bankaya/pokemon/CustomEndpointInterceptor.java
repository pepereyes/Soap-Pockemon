package com.bankaya.pokemon;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;

import com.bankaya.pokemon.request.logging.*;

@Component
public class CustomEndpointInterceptor implements EndpointInterceptor {

	@Autowired
	private HttpServletRequest request;
	@Autowired RequestLoggingRepository repository;
	
    private RequestLogging requestLogging;

    @Override
	public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
    	requestLogging = new RequestLogging();
        
    	requestLogging.setFechaRequest(new Date(request.getDateHeader("If-Unmodified-Since")));
    	requestLogging.setIp(getIpAddress());
    	requestLogging.setMetodo(request.getMethod());
    	repository.save(requestLogging);
    	return true;
    }

    @Override
	public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
    	return true;
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
