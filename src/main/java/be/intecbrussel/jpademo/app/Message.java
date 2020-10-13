package be.intecbrussel.jpademo.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {

    //Het is om de erste koloom as Id (primary key) te zetten.
    @Id
    //Om automatisch de Id te genereren. IDENTITY creert een record om de Id atumatish op te hogen.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String text;

    public Message() {
    }

    ;

    public Message(long id, String text) {
        this.id = id;
        this.text = text;
    }

    //Wanner wij de GeneratedValue gebruik moet de @Id here verwijderen.
    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }
}
