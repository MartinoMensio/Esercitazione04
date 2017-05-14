package it.polito.ai.lab4.websocket;

import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;

public class WebSocketSecurityConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {
	
	@Override
	protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
		messages.simpDestMatchers("/**").hasRole("USER");
	}
}
