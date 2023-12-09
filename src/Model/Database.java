package Model;

import Model.Exceptions.AccountNotFound;
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

    public static Account getAccount(Integer i) throws AccountNotFound {
        System.out.println(database);
        if (database.get( i ) != null)
            return database.get( i );
        else
            throw new AccountNotFound();

    }

    public static boolean correctLogin(String username, String password){
        for (int i = 0; i < numAccounts; i++) {
            if (database.get(i).getUsername().equals( username ))
                if (database.get(i).getPassword().equals( password ))
                    return true;
                else
                    return false;
        }
        return false;
    }

    public static Account searchUsername(String username) throws AccountNotFound{
        for (int i = 0; i < numAccounts; i++) {
            if (database.get(i).getUsername().equals( username ))
                return database.get(i);
        }
        throw new AccountNotFound();
    }


}
