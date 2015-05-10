package net.thelightmc;

/**
 * @Author TheLightMC
 */

public class Note {
    private final String target;
    private final String content;
    private final String sender;

    public Note(String target, String content, String sender) {
        this.target = target;
        this.content = content;
        this.sender = sender;
    }

    public String getTarget() {
        return target;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }
}
