import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;

public class Notepad {
    public static void main(String[] args){
        JFrame frame = new JFrame("s16979 - Notepad");
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(900,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");

        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    frame,
                    "Notepad\nCreated by: Amashi Fernando\nID: s16979",
                    "About",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        JFileChooser chooser = new JFileChooser();

        openItem.addActionListener(e -> {
            int choice = chooser.showOpenDialog(frame);
            if (choice == JFileChooser.APPROVE_OPTION) {
                try {
                    FileReader fr = new FileReader(chooser.getSelectedFile());
                    textArea.read(fr, null);
                    fr.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error opening file!");
                }
            }
        });

        saveItem.addActionListener(e -> {
            int choice = chooser.showSaveDialog(frame);
            if (choice == JFileChooser.APPROVE_OPTION) {
                try {
                    FileWriter fw = new FileWriter(chooser.getSelectedFile());
                    textArea.write(fw);
                    fw.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error saving file!");
                }
            }
        });

        exitItem.addActionListener(e -> System.exit(0));

        cutItem.addActionListener(e -> textArea.cut());
        copyItem.addActionListener(e -> textArea.copy());
        pasteItem.addActionListener(e -> textArea.paste());
        
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }
}


