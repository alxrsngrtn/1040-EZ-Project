
package pkg1040ez.project;

import java.sql.*;

public class EICDatabaseAccessor {

    /*
     * The purpose of this class is to calculate the user's optimal earned
     * income tax credit.
     */
    public String DetermineEIC(int incomeWithoutCombat, int combatIncome, int amtOfChildren, boolean filingStatus) {
        String children = "";
        String table = "";
        String EICAmt = "";
        int eicWithCombat = 0;
        int eicWithoutCombat = 0;
        
        /* 
         * Takes the amount of qualified children entered by user and converts it
         * to the appropriate SQL query.
         */

        if (amtOfChildren == 0) {
            children = "NO_CHILD";
        } else if (amtOfChildren == 1) {
            children = "ONE_CHILD";
        } else if (amtOfChildren == 2) {
            children = "TWO_CHILD";
        } else if (amtOfChildren >= 3) {
            children = "THREE_CHILD";
        }
        
        /*
         * Takes the filing status for the user and converts it to the appropriate
         * SQL query.
         */

        if (filingStatus) {
            table = "MFJ";
        } else {
            table = "SINGLE";
        }
        
        /*
         * If the user enters any nontaxable combat income, the method queries the
         * database twice. First, including the nontaxable combat income. Second,
         * without it. If there is no nontaxable combat income, the method only
         * conducts one query based on total taxable income.
         */

        if (combatIncome > 0) {
            eicWithCombat = QueryEICTable((incomeWithoutCombat + combatIncome), children, table);
            eicWithoutCombat = QueryEICTable(incomeWithoutCombat, children, table);
        } else {
            eicWithoutCombat = QueryEICTable(incomeWithoutCombat, children, table);
        }
        
        /*
         * Method checks to determine which credit is higher, based on the
         * one or two queries it conducts above, and returns it.
         */

        if (eicWithoutCombat >= eicWithCombat) {
            EICAmt = Integer.toString(eicWithoutCombat);
        } else {
            EICAmt = Integer.toString(eicWithCombat);
        }

        return EICAmt;
    }

    public int QueryEICTable(int income, String children, String table) {
        Connection c;
        Statement stmt;
        int eicCredit = 0;


        try {
            //Accessing database created with SQLite and packaged with program.
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:EICDB.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs;
        
        /*
         * Accessing the SQLite database. Two tables were created, one containing
         * the EIC table for single filers, the other for MFJ filers.
         * Also checks to determine whether the income is evenly divisible by 50
         * and that it does not equal one. If either is true, the method changes
         * the SQL query to look for matches that equal the amount of income being
         * sought. This is because the table rows end on numbers evenly divisible
         * by 50 and begin with 1.
         * 
         */

            if ((income % 50 != 0) && income != 1) {
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

        } catch (Exception e) {
            System.err.println("Database inaccessible!");
            System.err.println(e.getMessage());
        }

        return eicCredit;
    }

}
