package Model;

import java.util.ArrayList;

public class Tutor extends Account {
    ArrayList<String> subjects;

    public Tutor() {
        super();

    }
    Tutor(String username, String password) {
        super(username, password);
    }
}
