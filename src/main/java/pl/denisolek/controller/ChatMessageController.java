package pl.denisolek.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import pl.denisolek.model.ChatMessage;
import pl.denisolek.model.InputMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ChatMessageController {

    @MessageMapping("/chat/{roomName}")
    @SendTo("/rooms/{roomName}")
    public ChatMessage chatMessage(@DestinationVariable String roomName, InputMessage message) throws Exception {
        Thread.sleep(200);
        return new ChatMessage("[ "+ roomName +" ] " + message.getMessage());
    }

}
