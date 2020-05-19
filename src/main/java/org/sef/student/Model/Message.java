package org.sef.student.Model;

import java.util.Objects;

public class Message {
    private String user;
    private String dev;
    private String message;

    public Message(String user, String dev, String message) {
        this.user = user;
        this.dev = dev;
        this.message = message;
    }
    public Message()
    {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDev() {
        return dev;
    }

    public void setDev(String dev) {
        this.dev = dev;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "user='" + user + '\'' +
                ", dev='" + dev + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return Objects.equals(user, message1.user) &&
                Objects.equals(dev, message1.dev) &&
                Objects.equals(message, message1.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, dev, message);
    }
}
