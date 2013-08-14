
package pkg1040ez.project;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TabbedWindowProject extends JFrame {
    
    JTabbedPane tabbedPane;
    JPanel incomeEntryPanel;
    JPanel personalDetailsPanel;
    JPanel finalTaxFormPanel;
    
    JCheckBox selfBox;
    JCheckBox spouseBox;
    JCheckBox mfjBox;
    
    JTextField w2IncomeEntry;
    JTextField interestIncomeEntry;
    JTextField unemploymentEntry;
    JTextField nonTaxableCombatPayElectionField;
    JTextField withholdingEntry;
    JTextField amountOfChildrenField;
    
    public TabbedWindowProject(){
        
        setTitle("1040EZ Project");
        setSize(900, 550);
                
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);
        
        incomePage();
        personalDetailsPage();
        //finalFormPage();
        
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Income and Withholding Information", incomeEntryPanel);
        tabbedPane.addTab("Personal Details", personalDetailsPanel);
        //tabbedPane.addTab("Form 1040-EZ", finalTaxFormPanel);
        topPanel.add(tabbedPane, BorderLayout.CENTER);
    }
    
    public void incomePage(){
        
        incomeEntryPanel = new JPanel();
        incomeEntryPanel.setLayout(null);
        
        JLabel w2IncomeLabel = new JLabel("Wages, salaries, and tips. Enter total income from Box 1 of Form(s) W-2:");
        JLabel interestIncomeLabel = new JLabel("Taxable Interest. If the total is over $1,500, you cannot use this Form:");
        JLabel unemploymentIncomeAndAlaskaDividendsLabel = new JLabel("Unemployment compensation and Alaska Permanent Fund dividends:");
        JLabel nonTaxableCombatPayElectionLabel = new JLabel("Nontaxable combat pay election:");
        JLabel incomeTaxWithheld = new JLabel("Income Tax Withheld:");
        
        w2IncomeEntry = new JTextField("0");
        interestIncomeEntry = new JTextField("0");
        unemploymentEntry = new JTextField("0");
        nonTaxableCombatPayElectionField = new JTextField("0");
        withholdingEntry = new JTextField("0");
        
        w2IncomeEntry.setBounds(435, 15, 100, 30);
        interestIncomeEntry.setBounds(435, 45, 100, 30);
        unemploymentEntry.setBounds(435, 75, 100, 30);
        nonTaxableCombatPayElectionField.setBounds(435, 105, 100, 30);
        withholdingEntry.setBounds(435, 135, 100, 30);

        w2IncomeLabel.setBounds(25, 15, 410, 30);
        interestIncomeLabel.setBounds(25, 45, 400, 30);
        unemploymentIncomeAndAlaskaDividendsLabel.setBounds(25, 75, 400, 30);
        nonTaxableCombatPayElectionLabel.setBounds(231, 105, 200, 30);
        incomeTaxWithheld.setBounds(231, 135, 150, 30);
        
        incomeEntryPanel.add(w2IncomeEntry);
        incomeEntryPanel.add(interestIncomeEntry);
        incomeEntryPanel.add(unemploymentEntry);
        incomeEntryPanel.add(nonTaxableCombatPayElectionField);
        incomeEntryPanel.add(withholdingEntry);

        incomeEntryPanel.add(w2IncomeLabel);
        incomeEntryPanel.add(interestIncomeLabel);
        incomeEntryPanel.add(unemploymentIncomeAndAlaskaDividendsLabel);
        incomeEntryPanel.add(nonTaxableCombatPayElectionLabel);
        incomeEntryPanel.add(incomeTaxWithheld);
        
    }
    
    public void personalDetailsPage(){
        
        personalDetailsPanel = new JPanel();
        personalDetailsPanel.setLayout(null);
        Color backgroundColor = personalDetailsPanel.getBackground();
        
        JLabel dependencyLabel = new JLabel("Can you or your spouse can be claimed as a dependent on another's return:");
        JLabel amountOfChildrenLabel = new JLabel("Enter the amount of dependents you have that meet all four of the above conditions:");
        JLabel marriedFilingJointlyLabel = new JLabel("Check box if you are married, filing jointly:");
        JLabel eicInfoLabel = new JLabel("If you will be claiming dependents, continue to section below. Otherwise, proceed to the next tab.");
        
        JLabel eicFourConditionsLabel = new JLabel("For your dependent(s) to be considered a Qualified Child under the Earned Income Tax Credit, s/he must satisfy the following four conditions:");
        JTextArea eicConditionALabel = new JTextArea("A. Be your son, daughter, stepchild, foster child, or a descendant of any of them, or\n"
                + "     Brother, sister, half brother, half sister, stepbrother, stepsister, or any descendent of any of them.");
        eicConditionALabel.setBackground(backgroundColor);
        JTextArea eicConditionBLabel = new JTextArea("B. Under the age of 19 at the end of 2012 and younger than you (or your spouse, if married, filing jointly), or\n"
                + "     Under age 24 at the end of 2012, a student, and younger than you (or spouse, if MFJ), or\n"
                + "     Permanently and totally disabled at any time during the year, regardless of age.");
        eicConditionBLabel.setBackground(backgroundColor);
        JTextArea eicConditionCLabel = new JTextArea("C. Who is not filing a joint return for 2012 (or is filing a joint return for 2012 only to claim a refund of income tax\n"
                + "     withheld or estimated tax paid).");
        eicConditionCLabel.setBackground(backgroundColor);
        JTextArea eicConditionDLabel = new JTextArea("D. Who lived with you in the United States for more than half of 2012.");
        eicConditionDLabel.setBackground(backgroundColor);

        amountOfChildrenField = new JTextField("0");
        
        selfBox = new JCheckBox("You");
        selfBox.setSelected(false);
        spouseBox = new JCheckBox("Spouse");
        spouseBox.setSelected(false);
        mfjBox = new JCheckBox("Married Filing Jointly");
        mfjBox.setSelected(false);
        
        dependencyLabel.setBounds(25, 15, 450, 30);
        marriedFilingJointlyLabel.setBounds(25, 45, 250, 30);
        eicInfoLabel.setBounds(25, 75, 550, 30);
        eicFourConditionsLabel.setBounds(25, 120, 800, 30);
        eicConditionALabel.setBounds(40, 155, 800, 30);
        eicConditionBLabel.setBounds(40, 190, 800, 50);
        eicConditionCLabel.setBounds(40, 240, 800, 30);
        eicConditionDLabel.setBounds(40, 275, 800, 30);
        amountOfChildrenLabel.setBounds(25, 310, 480, 30);
        
        amountOfChildrenField.setBounds(510, 315, 20, 20);

        selfBox.setBounds(475, 18, 50, 25);
        spouseBox.setBounds(550, 18, 75, 25);
        mfjBox.setBounds(275, 48, 150, 25);
        
        personalDetailsPanel.add(dependencyLabel);
        personalDetailsPanel.add(marriedFilingJointlyLabel);
        personalDetailsPanel.add(eicInfoLabel);
        personalDetailsPanel.add(eicFourConditionsLabel);
        personalDetailsPanel.add(eicConditionALabel);
        personalDetailsPanel.add(eicConditionBLabel);
        personalDetailsPanel.add(eicConditionCLabel);
        personalDetailsPanel.add(eicConditionDLabel);
        personalDetailsPanel.add(amountOfChildrenLabel); 
        
        personalDetailsPanel.add(amountOfChildrenField);
        
        personalDetailsPanel.add(selfBox);
        personalDetailsPanel.add(spouseBox);
        personalDetailsPanel.add(mfjBox);
        
    }
    
    public static void main(String args[]){
        
        TabbedWindowProject mainFrame = new TabbedWindowProject();
        mainFrame.setVisible(true);
    }
        
}
