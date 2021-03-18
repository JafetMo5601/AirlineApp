package airlineapp.Login;
 
import airlineapp.Login.Login;
import javax.swing.JFrame;

public class Logout {
    public static void logOut(JFrame context){
        Login.isLoggedIn = false;
//        context.setVisible(false);
        new LoginGUI().setVisible(true);
    }
}
