package airlineapp.Tickets;

import airlineapp.DBHandling.DBManagement;
import airlineapp.StartWindowGUI;
import airlineapp.iWindows;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tickets implements iWindows {

    private String id, date, source,
            destination, depTime, arrTime, fClass, passengers;

    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 6;

    public Tickets() {
    }

    public Tickets(
            String id, String date, String source, String destination, 
            String depTime, String arrTime, String fClass, String passengers) {
        this.id = id;
        this.date = date;
        this.source = source;
        this.destination = destination;
        this.depTime = depTime;
        this.arrTime = arrTime;
        this.fClass = fClass;
        this.passengers = passengers;
    }
    
    public void saveTicket(
            String id, String date, String source, String destination, 
            String depTime, String arrTime, String fClass, String passengers) {
        try {
            Tickets t = new Tickets(
                    id, date, source, destination, depTime, arrTime, fClass, passengers);
            new DBManagement().saveBook(t);
            JOptionPane.showMessageDialog(null, "Booked!");
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(
                    new JFrame(), "There is a problem with the server, try it later.",
                    "Dialog", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String getRandomString() {
        Random random = new Random();
        String randomString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return randomString;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public String getfClass() {
        return fClass;
    }

    public void setfClass(String fClass) {
        this.fClass = fClass;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public void goBack() {
        new StartWindowGUI().setVisible(true);
    }

}
