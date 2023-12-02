package Model;

import java.util.HashMap;

public class Database {
    private static HashMap<Integer, Account> database;
    private static Integer numAccounts;

    public Database() {
        database = new HashMap<Integer, Account>();
        numAccounts = 0;
    }

    public static Integer addAccount(Account a){
        database.put(numAccounts, a);
        a.setID(numAccounts);
        return numAccounts++;
    }

    public static Account getAccount(Integer i){
        return database.get(i);
    }

    public static boolean correctLogin(String username, String password){
        for (int i = 0; i < numAccounts; i++) {
            if (database.get(i).getUsername() == username)
                if (database.get(i).getPassword() == password)
                    return true;
                else
                    return false;
        }
        return false;
    }


}
