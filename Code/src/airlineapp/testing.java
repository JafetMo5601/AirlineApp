package airlineapp;

import airlineapp.DBHandling.DBManagement;
import airlineapp.Registration.Worker;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class testing {
    public static void main(String[] args) {
        Worker w = new Worker(
                "0", "101110111", "Roberto", "Ulate Blanco", "2000-01-01",
                "r.ulate@airlineapp.com", "12345678", "M", "Coyol, Alajuela");
        DBManagement.insertNewWorker(w);
//        System.out.println(st);
    }
}

