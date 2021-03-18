package airlineapp.Login;

import airlineapp.Authentication.iAuthentication;
import airlineapp.DBHandling.DBManagement;
import static airlineapp.DBHandling.DBManagement.userRetrieve;
import airlineapp.Login.LoginGUI;
import airlineapp.Menus.ClientMenuGUI;
import airlineapp.StartWindowGUI;
import airlineapp.iWindows;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Login implements iWindows, iAuthentication{
    
    public static String name;
    public static String email;
    public static boolean isLoggedIn = false;
 
//    public static void main(String[] args) {
//        System.out.println(DBManagement.loginUser("jafet.moraugalde15@gmail.com", "f10b7247f971f2c92b5b5b31f40dd76bebca82e5c29420dbddaafa10da3a8eb0"));
//    }
    
    public void verifyUser(String email, String password){
        if (DBManagement.loginUser(email, password)){
            new ClientMenuGUI().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "The user email or password are incorrect!");
        }
    }

    @Override
    public void goBack(){
        new StartWindowGUI().setVisible(true);
    }

    @Override
    public String generateToken(String userEmail) throws SQLException{
                return "" + userRetrieve(userEmail).getString("out_user_id").charAt(0)
                + userRetrieve(userEmail).getString("out_name").charAt(0) 
                + userRetrieve(userEmail).getString("out_last_name").charAt(0);
    }
}
