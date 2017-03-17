package pl.denisolek.model;

import pl.denisolek.entities.Project;
import pl.denisolek.entities.User;

import javax.persistence.*;

@Entity
@Table(name = "chat_messages")
public class ChatMessage {

    @Id
    @GeneratedValue
    private long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ChatMessage() {
    }

    public ChatMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
