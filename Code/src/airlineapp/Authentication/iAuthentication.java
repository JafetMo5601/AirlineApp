package airlineapp.Authentication;

import java.sql.SQLException;

public interface iAuthentication {
    public String generateToken(String email) throws SQLException;   
}
