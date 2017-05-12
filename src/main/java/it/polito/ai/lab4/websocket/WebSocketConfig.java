package it.polito.ai.lab4.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import it.polito.ai.lab4.business.services.chat.HttpHandshakeInterceptor;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// the interceptor is used to bind HttpSession to the WebSocket session (copying attributes like sessionId)
		registry.addEndpoint("/chat").addInterceptors(new HttpHandshakeInterceptor()).withSockJS();
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

}
