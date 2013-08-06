/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1040ez.project;

/**
 *
 * @author Bryan
 */
public class deductionCalculator {
    
    public int DedCalc(int w2income, boolean mfj, boolean oneAsDep, boolean bothAsDep){
    int minStdDed = 950;
    int maxStdDed;
    int actualStdDed;
    int exemptionAmt;
    int lineC;
    int lineF = 0;
    int total;
        
        if((w2income+300) < minStdDed){
            lineC = minStdDed;
        } else {
            lineC = w2income+300;
        }
        
        if(!mfj){
            maxStdDed = 5950;
        } else {
            maxStdDed = 11900;
        }
        
        if(lineC > maxStdDed){
            actualStdDed = maxStdDed;
        } else {
            actualStdDed = lineC;
        }
        
        if(!mfj){
            lineF = 0;
        } else if(mfj && bothAsDep){
            lineF = 0;
        } else if(mfj && oneAsDep){
            lineF = 3800;
        }
        
        total = lineF + actualStdDed;
        
        if(!oneAsDep && !bothAsDep){
            if(!mfj){
                total = 9750;
            } else {
                total = 19500;
            }
        }
        
        
        
        return total;
    }
    
}
