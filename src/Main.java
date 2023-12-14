import DB.MySqlDB;
import view.GUI;

public class Main {
    public static void main(String[] args) {

        //Initialize DB
        MySqlDB db = new MySqlDB();
        db.init();

        GUI.launch( GUI.class, args );
    }
}