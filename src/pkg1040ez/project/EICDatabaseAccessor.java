
package pkg1040ez.project;

import java.sql.*;

public class EICDatabaseAccessor {
    
    public double DetermineEIC(int income, String children, String table){
        Connection c = null;
        Statement stmt = null;
        int eicCredit = 0;
        
        try {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:EICDB.db");
        c.setAutoCommit(false);
        
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT " + children + " FROM " + table +
                                         " WHERE AT_LEAST < " + income + " AND LESS_THAN > " + income);
        eicCredit = rs.getInt(children);
        rs.close();
        stmt.close();
        c.close();
        
        } catch ( Exception e ){
            System.err.println("Database inaccessible!");
        }

        return eicCredit;
    }
    
}
