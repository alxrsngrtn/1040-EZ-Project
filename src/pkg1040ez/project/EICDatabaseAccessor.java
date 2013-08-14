
package pkg1040ez.project;

import java.sql.*;

public class EICDatabaseAccessor {
    
    public String DetermineEIC(int incomeWithoutCombat, int combatIncome, int amtOfChildren, boolean filingStatus){
        String children = "";
        String table = "";
        String EICAmt = "";
        int eicCredit = 0;
        int eicWithCombat = 0;
        int eicWithoutCombat = 0;
        
        if(amtOfChildren == 0){
               children = "NO_CHILD";
          } else if(amtOfChildren == 1){
               children = "ONE_CHILD";
          } else if(amtOfChildren == 2){
               children = "TWO_CHILD";
          } else if(amtOfChildren >= 3){
               children = "THREE_CHILD";
           }
        
        if(filingStatus){
               table = "MFJ";
           } else {
               table = "SINGLE";
           }
        
        if(combatIncome > 0){
            eicWithCombat = QueryEICTable((incomeWithoutCombat + combatIncome), children, table);
            eicWithoutCombat = QueryEICTable(incomeWithoutCombat, children, table);   
        } else {
            eicWithoutCombat = QueryEICTable(incomeWithoutCombat, children, table);
        }
        
        if(eicWithoutCombat >= eicWithCombat){
              EICAmt = Integer.toString(eicWithoutCombat);
        } else {
              EICAmt = Integer.toString(eicWithCombat);
        }
        
        return EICAmt;
    }
    
    public int QueryEICTable(int income, String children, String table){
	Connection c = null;
        Statement stmt = null;
        int eicCredit = 0;


        try {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:EICDB.db");
        c.setAutoCommit(false);
        
        stmt = c.createStatement();
        ResultSet rs;
        if((income % 50 != 0) && income != 1) {
             rs = stmt.executeQuery("SELECT " + children + " FROM " + table +
                                    " WHERE AT_LEAST < " + income + " AND LESS_THAN > " + income);
        } else {
             rs = stmt.executeQuery("SELECT " + children + " FROM " + table +
                                    " WHERE AT_LEAST = " + income);
        }
        
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
