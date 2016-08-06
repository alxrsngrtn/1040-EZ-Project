package pkg1040ez.project;

import javax.swing.*;

/**
 * Created by alxrsngrtn on 8/5/16.
 */
public class InvalidInputVerifier extends InputVerifier {
    private JPanel panel;
    private JTextField entry;
    private Double max;
    private String alertMsg;

    public InvalidInputVerifier(JPanel panel, JTextField entry, Double max, String alertMsg){
        this.panel    = panel;
        this.entry    = entry;
        this.max      = max;
        this.alertMsg = alertMsg;
    }


    /* Included input verifier to ensure that all information entered by
     * user is a number equal to or greater than zero. Otherwise, user
     * is prompted with warning label and cursor will not leave textfield.
     */
    @Override
    public boolean verify(JComponent comp){
        boolean returnValue;
        JTextField textField = (JTextField) comp;
        try {
            double num = Double.parseDouble(textField.getText());
            double entryVal = Double.parseDouble(entry.getText());
            returnValue = num >= 0;
            if(num < 0) {
                JOptionPane.showMessageDialog(panel, "Please enter a positive number (or zero).");
            } else if(entryVal > max){
                JOptionPane.showMessageDialog(panel, alertMsg);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(panel, "Please enter a positive number (or zero).");
            returnValue = false;
        }

        return returnValue;
    }
}


