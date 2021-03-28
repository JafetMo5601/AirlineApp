package airlineapp.Login;
 
import airlineapp.StartWindowGUI;
import javax.swing.JFrame;

public class Logout {
    public static void logOut(JFrame context){
        LoginSession.isLoggedIn = false;
        new StartWindowGUI().setVisible(true);
        context.setVisible(false);
    }
}
