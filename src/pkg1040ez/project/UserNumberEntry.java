package pkg1040ez.project;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;

/**
 * Created by alxrsngrtn on 8/5/16.
 */
public class UserNumberEntry {
    JLabel label;
    JTextField entry;

    public UserNumberEntry(String labelText, String entryText, int xPos, int labelWidth, int entryWidth, int yPos, int height, int margin){
        label = new JLabel(labelText);
        entry = new JTextField(entryText);

        label.setBounds(xPos, yPos, labelWidth, height);
        entry.setBounds(labelWidth + margin, yPos, entryWidth, height);
    }

    public UserNumberEntry(String labelText, int xPos, int labelWidth, int entryWidth, int yPos, int height, int margin) {
        this(labelText, "0", xPos, labelWidth, entryWidth, yPos, height, margin);
    }

    public void addToPanel(JPanel panel){
        panel.add(label);
        panel.add(entry);
    }

    public void setVerification(InputVerifier verifier){
        entry.setInputVerifier(verifier);
    }

    public String getEntryText(){
        return entry.getText();
    }
}
