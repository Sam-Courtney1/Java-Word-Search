package oop_project;

import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.util.List;
import java.util.Map;

//GUI class is declared

public class Gui {

    private JFrame frame;
    private JPanel panel;
    private JLabel inputLabel;
    private JTextField inputField;
    private JButton fileButton;
    private JButton saveButton;
    private JButton clearButton;
    private JTextArea consoleField;
    private JTextArea rankfield;

    //Constructor
    public Gui() {
    	
        frame = new JFrame();
        panel = new JPanel();
        inputLabel = new JLabel("Enter A Word To Search For");
        inputField = new JTextField(20);
        fileButton = new JButton("Click Me To Access Files");
        saveButton = new JButton("Save Output");
        clearButton = new JButton("Clear output");
        consoleField = new JTextArea();
        rankfield = new JTextArea();

        setupUI();
    }

    
    private void setupUI() {
    	
        frame.setLayout(null);
        panel.setLayout(null);

        frame.setSize(600, 690);
        frame.setResizable(false);
        frame.setTitle("Search Engine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel.setBounds(200, 0, 200, 300);
        panel.setVisible(true);

        inputLabel.setBounds(20, 0, 200, 50);
        panel.add(inputLabel);

        inputField.setBounds(25, 50, 150, 50);
        panel.add(inputField);

        fileButton.setBounds(0, 120, 200, 75);
        panel.add(fileButton);

        
        /*
         *   .setLayout(null); Does not allow Computer to make changes 
         *   thus giving me total access in placing boxs / components
         * 
         * 	Setting the frame size and ensuring is cant be resized, setting
         *  a title and making sure it closers when the user asks and
         *  setting it to visible
         *  
         *  Next the bounds of the panel, label , inputfield and file button
         *  are set to where i want them on the screen, adding them to the panel
         *  so that they can be seen
         *   
         */
        
        
        consoleField.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(consoleField);
        scrollPane.setBounds(100, 220, 400, 200);

        rankfield.setEditable(false);
        JScrollPane rankpane = new JScrollPane(rankfield);
        rankpane.setBounds(100, 430, 280, 200);
        
        // Add Save button to panel
        saveButton.setBounds(380, 430, 120, 50);
        frame.add(saveButton);
        
        //Add Clear button to panel
        clearButton.setBounds(380, 500, 120, 50);
        frame.add(clearButton);

        frame.add(scrollPane);
        frame.add(panel);
        frame.add(rankpane);
        
        
        
        /*
         *  Make sure the user cant type in the output boxs 
         *  and make the boxs scroll by creating
         *  JScrollPane objects to enable scrolling
         * 
         *  setting the bounds of each panel and button
         *  
         *  Adding the panels to the frame
         * 
         * 
         */
        
        
       
        clearButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        consoleField.setText("");
	        rankfield.setText(""); 
        	}
    	});
        
        // Removes any text from the output consoles 
        // When the clear-button is pressed
        
        
        
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showSaveDialog(null);
                
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try (PrintWriter writer = new PrintWriter(selectedFile)) {
                        writer.println(rankfield.getText());
                        writer.println(consoleField.getText()); // Write console output to file
                        // Show pop up message with file path
                        JOptionPane.showMessageDialog(null, "File saved successfully to: " + selectedFile.getAbsolutePath());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
        
        /*
         *  Adds an action listener to the save button
         *  
         *  Writes content to the selected file
         *  
         *  Displays a pop up message indicating the
         *  success or failure to save the file
         * 
         * 
         */
        
        
        
    }

    public void printRanking(List<String> sortedFiles, Map<String, Double> rankingScoresMap) {
        rankfield.append("\nFiles in the order of most relevant:\n\n");
        for (String filename : sortedFiles) {
            double score = rankingScoresMap.getOrDefault(filename, 0.0);
            rankfield.append(filename + " - Ranking Score: " + String.format("%.2f", score) + "\n");
        }
    }
    
    
    
    
    
    
    /*
     *  Method for printing ranking information in the JTExtArea
     *  
     *  Iterates through a list if the files that the user uploaded and
     *  there linked score and appends them to the rankfield
     */
    
    
    
    /*
     * 
     * 
     * 
     */

    public void appendToConsole(String text) {
        consoleField.append(text + "\n");
    }

    public void appendToRank(String message, String message2, int match) {
        rankfield.append(message + message2 + match + "\n");
    }
    
    public void appendPercentage(String message, double percentage) {
        rankfield.append(message + String.format("%.2f%%", percentage) + "\n");
    }
    public void appendRankingScore(String message, String score) {
        rankfield.append(message + score + "\n");
    }
    
    
    /*
     *  Methods to append to the console consoleField and rankfield JTextArea with
     *  different formatting options depending on which is called
     * 
     * 
     * 
     */
    

    public JTextField getInputField() {
        return inputField;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getFileButton() {
        return fileButton;
    }

    public JTextArea getConsoleField() {
        return consoleField;
    }
    
    
    /*
     *  Getter methods to access the input-field , frame , file-button and console field
     */
}




