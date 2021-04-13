package airlineapp.Login;

import airlineapp.DBHandling.DBManagement;
import airlineapp.DBHandling.Encryptation;
import airlineapp.ClientMenu.ClientMenuGUI;
import airlineapp.EmployeeManagement.AdministratorGUI;
import airlineapp.StartWindowGUI;
import airlineapp.Tickets.TicketsSaleGUI;
import airlineapp.iWindows;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Login implements iWindows {
    public void verifyUser(String email, String password) {
        Encryptation e = new Encryptation();
        String encryptedPassword = e.generateEncryptedPassword(email, password);
        if (DBManagement.loginUser(email, encryptedPassword)) {
            new ClientMenuGUI().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null,
                    "The user email or password are incorrect!");
        }
    }
    
    public void verifyWorker(String email, String password){
        Encryptation e = new Encryptation();
        String encryptedPassword = e.generateEncryptedPassword(email, password);
        if (DBManagement.loginWorker(email, encryptedPassword)) {
            try {
                if (isAdmin(DBManagement.workerRetrieve(email))){
                    new AdministratorGUI().setVisible(true);
                } else {
                    new TicketsSaleGUI().setVisible(true);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "The user email or password are incorrect!");
        }
    }
    
    public boolean isAdmin(java.sql.CallableStatement st) throws SQLException{
        if (st.getObject("out_admin_access") == "0"){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void goBack() {
        new StartWindowGUI().dispose();
    }
}