package it.polito.ai.lab4.rest;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CsrfController {
	
	/**
	 * Returns the csrf token for connecting to the secured WebSocket
	 * @param token
	 * @return
	 */
    @RequestMapping("/rest/csrf")
    public CsrfToken csrf(CsrfToken token) {
        return token;
    }
}