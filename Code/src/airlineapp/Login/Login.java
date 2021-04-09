package airlineapp.Login;

import airlineapp.DBHandling.DBManagement;
import airlineapp.DBHandling.Encryptation;
import airlineapp.Menus.ClientMenuGUI;
import airlineapp.StartWindowGUI;
import airlineapp.iWindows;
import javax.swing.JOptionPane;

public class Login implements iWindows {
    public void verifyUser(String email, String password) {
        Encryptation e = new Encryptation();
        String encryptedPassword = e.generateEncryptedPassword(email, password);
        if (new DBManagement().loginUser(email, encryptedPassword)) {
            new ClientMenuGUI().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null,
                    "The user email or password are incorrect!");
        }
    }

    @Override
    public void goBack() {
        new StartWindowGUI().dispose();
    }
}