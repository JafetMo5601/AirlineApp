package airlineapp.Registration;

import airlineapp.DBHandling.DBManagement;
import airlineapp.Registration.iRegistration;
import static airlineapp.DBHandling.DBManagement.userRetrieve;
import airlineapp.DBHandling.Encryptation;
import airlineapp.StartWindowGUI;
import airlineapp.iWindows;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class NewPerson implements iWindows, iRegistration{

    SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");

    public String getDate(Date dateInput) {
        String date = null;
        try {
            date = dFormat.format(dateInput);
        } catch (NullPointerException e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(
                    new JFrame(), "You have to enter a birth date!",
                    "Dialog", JOptionPane.ERROR_MESSAGE);
        } finally {
            return date;
        }
    }
    
    @Override
    public void goBack(){
        new StartWindowGUI().setVisible(true);
    }

    @Override
    public String generateTokenNewUser(
            String uID, String uName, String uLast) throws SQLException {
                 return "" + uID.charAt(0) + uName.charAt(0) + uLast.charAt(0);
    }
    
    public void createUser(
            String id, String name, String last, String date, 
            String email, String password, String sex, String address){
            try {
                Client c = new Client(
                        id, name, last, date, email,
                        new Encryptation().getSHA256SecurePassword(
                                password,
                                new Encryptation().getSalt(
                                        new NewPerson().generateTokenNewUser(
                                                id, name, last))),
                        sex, address);
                new DBManagement().insertNewUser(c);
            } catch (NoSuchAlgorithmException e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(
                    new JFrame(), "There was a problem with the password, try again.",
                    "Dialog", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(
                    new JFrame(), "There is a problem with the server, try it later.",
                    "Dialog", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(null,"User created successfully!");
        
    }
}
