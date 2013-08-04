/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1040ez.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Bryan
 */
public class Project extends JFrame {
    String word = "duh";
    
    public Project() {
        
        initUI();
    }
    
    public void initUI() {
        String stuff;
        int w2Inc;
                
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);
        
        // Labels corresponding with data entry fields
        JLabel w2IncomeLabel = new JLabel("Wages, salaries, and tips. Enter total income from Box 1 of Form(s) W-2:");
        JLabel interestIncomeLabel = new JLabel("Taxable Interest. If the total is over $1,500, you cannot use this Form:");
        JLabel unemploymentIncomeAndAlaskaDividendsLabel = new JLabel("Unemployment compensation and Alaska Permanent Fund dividends:");
        JLabel adjustedGrossIncomeLabel = new JLabel("Your Adjusted Gross Income:");
        JLabel dependencyLabel = new JLabel("Check the appropriate box if you or your spouce can be claimed as a dependent on another's return:");
        
        // Text Fields for data entry
        final JTextField w2IncomeEntry = new JTextField("0");
        final JTextField interestIncomeEntry = new JTextField("0");
        final JTextField unemploymentEntry = new JTextField("0");
        final JTextField AGIField = new JTextField("0");
        final JTextField exemptionAmountEntry = new JTextField(0);
        
        // Button to compute calculations
        JButton computeAGIBtn = new JButton("Compute AGI");
        
        // Checkboxes to determine exemption amounts
        JCheckBox selfBox = new JCheckBox("You");
        JCheckBox spouseBox = new JCheckBox("Spouse");
        
        // Set location for buttons
        computeAGIBtn.setBounds(550, 105, 120, 25);
        
        // Set location for labels
        w2IncomeLabel.setBounds(25, 15, 410, 30);
        interestIncomeLabel.setBounds(25, 45, 400, 30);
        unemploymentIncomeAndAlaskaDividendsLabel.setBounds(25, 75, 400, 30);
        adjustedGrossIncomeLabel.setBounds(265, 95, 175, 50);
        dependencyLabel.setBounds(25, 125, 600, 50);
        
        // Set location for data entry fields
        w2IncomeEntry.setBounds(435, 15, 100, 30);
        interestIncomeEntry.setBounds(435, 45, 100, 30);
        unemploymentEntry.setBounds(435, 75, 100, 30);
        AGIField.setBounds(435, 105, 100, 30);
        exemptionAmountEntry.setBounds(435, 200, 100, 30);
        
        // Set location for exemption checkboxes
        selfBox.setBounds(500, 155, 100, 25);
        spouseBox.setBounds(400, 155, 100, 25);
        
        
        
        computeAGIBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                int w2Inc = Integer.parseInt(w2IncomeEntry.getText());
                int intInc = Integer.parseInt(interestIncomeEntry.getText());
                int UIncome = Integer.parseInt(unemploymentEntry.getText());
                String term = Integer.toString((w2Inc + intInc + UIncome));
                AGIField.setText(term);
            }
        });
        
        panel.add(computeAGIBtn);
        
        panel.add(w2IncomeLabel);
        panel.add(interestIncomeLabel);
        panel.add(unemploymentIncomeAndAlaskaDividendsLabel);
        panel.add(adjustedGrossIncomeLabel);
        panel.add(dependencyLabel);
        
        panel.add(w2IncomeEntry);
        panel.add(interestIncomeEntry);
        panel.add(unemploymentEntry);
        panel.add(AGIField);
        panel.add(exemptionAmountEntry);
        
        panel.add(selfBox);
        panel.add(spouseBox);
        
        setTitle("Compute AGI For 1040-EZ");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Project ex = new Project();
                ex.setVisible(true);
            }
            
        });
        // TODO code application logic here
    }
}