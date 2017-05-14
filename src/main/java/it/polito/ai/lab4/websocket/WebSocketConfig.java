package it.polito.ai.lab4.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer{

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// the interceptor is used to bind HttpSession to the WebSocket session (copying attributes like sessionId)
		registry.addEndpoint("/chat").withSockJS().setSessionCookieNeeded(true);
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		// which broker to use: in memory
		// all the messages with prefixes /topic and /queue will be handled
		// /topic is for publish-subscribe
		// /queue is for messages to a specific recipient
		// TODO get topics from the service? or /topic is a prefix?
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app");
	}

	@Override
	protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
		messages.simpDestMatchers("/**").hasRole("USER");
	}
}
