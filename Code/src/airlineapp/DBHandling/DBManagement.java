package airlineapp.DBHandling;

import airlineapp.Login.Login;
import airlineapp.Registration.Client;
import airlineapp.Registration.Worker;
import java.sql.*;

public class DBManagement {

    public static Connection connectToDB() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/airline", "root", "");
            System.out.println("Connected!");
        } catch (SQLException e) {
            System.err.println(e);
        }
        return conn;
    }

    public static void insertNewUser(Client newClient) {
        try {
            CallableStatement statement = connectToDB().prepareCall(
                    "{call CreateUser(?,?,?,?,?,?,?,?)}");
            statement.setObject(1, newClient.getId());
            statement.setObject(2, newClient.getName());
            statement.setObject(3, newClient.getLastName());
            statement.setObject(4, newClient.getBirthday());
            statement.setObject(5, newClient.getEmail());
            statement.setObject(6, newClient.getPassword());
            statement.setString(7, newClient.getSex());
            statement.setObject(8, newClient.getAddress());
            statement.execute();
            statement.close();
            System.out.println("New User Created!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void insertNewWorker(Worker newWorker) {
        try {
            CallableStatement statement = connectToDB().prepareCall(
                    "{call CreateWorker(?,?,?,?,?,?,?,?,?)}");
            statement.setObject(1, newWorker.getId());
            statement.setObject(2, newWorker.getName());
            statement.setObject(3, newWorker.getLastName());
            statement.setObject(4, newWorker.getBirthday());
            statement.setObject(5, newWorker.getEmail());
            statement.setObject(6, newWorker.getPassword());
            statement.setString(7, newWorker.getSex());
            statement.setObject(8, newWorker.getAddress());
            statement.setObject(9, newWorker.getAdminAcces());
            statement.execute();
            statement.close();
            System.out.println("New Worker created!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static CallableStatement userRetrieve(String emailParamenter) {
        try {
            CallableStatement statement = 
                    connectToDB().prepareCall("{call UserRetrieve(?,?,?,?)}");
            statement.setString(1, emailParamenter);
            statement.registerOutParameter(2, Types.VARCHAR);
            statement.registerOutParameter(3, Types.VARCHAR);
            statement.registerOutParameter(4, Types.VARCHAR);
            statement.executeUpdate();
            return statement;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
    
    public static boolean loginUser(String email, String password){
        try{
            CallableStatement statement = 
                    connectToDB().prepareCall("{call LoginUser(?,?)}");
            statement.setString(1, email);
            statement.setString(2, password);
            statement.execute();
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                // This work to get info from users later
                Login.name = rs.getString(1);
                Login.email = rs.getString(2);
                Login.isLoggedIn = true;
                return true;
            }else {
                return false;
            }
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
}
