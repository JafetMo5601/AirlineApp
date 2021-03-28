package airlineapp.Authentication;

import java.sql.SQLException;

public interface iAuthentication {
    public String generateSecretKey(String email) throws SQLException;   
}
