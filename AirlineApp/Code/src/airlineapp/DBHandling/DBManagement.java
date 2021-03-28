package airlineapp.DBHandling;

import airlineapp.Login.*;
import airlineapp.Registration.Client;
import airlineapp.Registration.Worker;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static void closeDBConnection(Connection connection) {
        try {
            connection.close();
            System.out.println("DB Connection closed!");
        } catch (SQLException ex) {
            Logger.getLogger(DBManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertNewUser(Client newClient) {
        Connection conn = connectToDB();
        try {
            CallableStatement statement = conn.prepareCall(
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
        } finally {
            closeDBConnection(conn);
        }
    }

    public static void insertNewWorker(Worker newWorker) {
        Connection conn = connectToDB();
        try {
            CallableStatement statement = conn.prepareCall(
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
        } finally {
            closeDBConnection(conn);
        }
    }

    public static CallableStatement userRetrieve(String emailParamenter) throws SQLException {
        Connection conn = connectToDB();
        CallableStatement statement
                = conn.prepareCall("{call UserRetrieve(?,?,?,?)}");
        try {
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

    public static boolean loginUser(String email, String password) {
        Connection conn = connectToDB();
        CallableStatement statement = null;
        try {
            statement = conn.prepareCall("{call LoginUser(?,?,?,?)}");
            statement.setString(1, email);
            statement.setString(2, password);
            statement.registerOutParameter(3, Types.VARCHAR);
            statement.registerOutParameter(4, Types.VARCHAR);
            statement.executeUpdate();
            if (thereAreOutputs(statement)) {
                setLoginAttributes(statement);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(conn);
        }
        return false;
    }

    public static void setLoginAttributes(CallableStatement statement) {
        try {
            System.out.println(statement.getObject("out_name").toString());
            System.out.println(statement.getObject("out_email").toString());
            LoginSession.name = statement.getObject("out_name").toString();
            LoginSession.email = statement.getObject("out_email").toString();
            LoginSession.isLoggedIn = true;
        } catch (SQLException ex) {
            Logger.getLogger(DBManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean thereAreOutputs(CallableStatement statement) {
        try {
            if (statement.getObject("out_name") != null
                    && statement.getObject("out_email") != null) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
