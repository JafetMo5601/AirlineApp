package airlineapp.Menus;

import airlineapp.StartWindowGUI;
import airlineapp.iWindows;

public class ClientMenu implements iWindows{
    public void goBack(){
        new StartWindowGUI().setVisible(true);
    }
    
}
