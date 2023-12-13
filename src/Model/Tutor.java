package Model;

import java.util.ArrayList;

/**
 * Tutor.java
 * Represents a Tutor User
 * @author Austin Cain
 */
public class Tutor extends Account {
    ArrayList<String> subjects;

    public Tutor() {
        super();

    }
    Tutor(String username, String password) {
        super(username, password);
    }
}
