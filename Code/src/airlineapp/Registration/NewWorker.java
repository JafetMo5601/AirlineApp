package airlineapp.Registration;

import airlineapp.StartWindowGUI;
import airlineapp.iWindows;

public class NewWorker implements iWindows{
    public void goBack(){
        new StartWindowGUI().setVisible(true);
    }
}
