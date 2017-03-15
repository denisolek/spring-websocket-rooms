package pl.denisolek.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import pl.denisolek.model.ChatMessage;
import pl.denisolek.model.InputMessage;

@Controller
public class ChatMessageController {

    @MessageMapping("/chat")
    @SendTo("/rooms/1")
    public ChatMessage chatMessage(InputMessage message) throws Exception {
        Thread.sleep(200);
        return new ChatMessage("[TEST] " + message.getMessage());
    }
}
