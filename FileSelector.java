package oop_project;

import javax.swing.*;
import java.io.File;

public class FileSelector {
    public static File[] selectFiles() {
        int result;
        JFileChooser fileSelector = new JFileChooser();
        fileSelector.setMultiSelectionEnabled(true);
        // Allows multiple files to be chosen

        result = fileSelector.showOpenDialog(fileSelector);
        
        // Checks if user has selected and opened a file
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileSelector.getSelectedFiles();
        } 
        else
        {
            return null;
        }
    }
}
