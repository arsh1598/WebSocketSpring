package com.github.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
public class WebSocketController {

	@MessageMapping("/hello")
	  @SendTo("/topic/greetings")
	  public Greeting greeting(HelloMessage message) throws Exception {
		System.out.println(message.getName());
	    return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	  }
}
