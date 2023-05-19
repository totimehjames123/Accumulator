package com.AppOneGroup10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class AppOneGroup10 extends JFrame implements ActionListener {

    JMenuItem exitMenuItem;
    JMenuItem aboutMenuItem;
    JWindow window;
    JButton disappearButton;
    JTextField outputTextField;
    JTextField inputTextField;
    int results;

    AppOneGroup10(){
        ImageIcon imageIcon = new ImageIcon("images.png");
        Image image = imageIcon.getImage();

        //CREATING A FRAME
        this.setTitle("AppOneGroup10");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);

        //CREATING A MENU BAR
        JMenuBar menuBar = new JMenuBar();

        /* CREATING MENU ITEMS */
        //Creating menu items for File menu
        JMenuItem newMenuItem = new JMenuItem("New");
        ImageIcon newImageIcon = new ImageIcon("new.jpg");
        Image imageForNewMenuItem = newImageIcon.getImage();
        Image newImageForNewMenuItem = imageForNewMenuItem.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        newImageIcon = new ImageIcon(newImageForNewMenuItem);
        newMenuItem.setIcon(newImageIcon);

        JMenuItem saveAsMenuItem = new JMenuItem("Save As");

        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(this);

        //Creating menu items for Edit menu
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        JMenuItem pasteMenuItem = new JMenuItem("Paste");

        JMenu findMenuLikeItem = new JMenu("Find");
        //Creating submenus for find menu (act like menu item)
        JMenuItem findMenuItem = new JMenuItem("Find");

        JMenuItem replaceMenuItem = new JMenuItem("Replace");
        ImageIcon replaceImageIcon = new ImageIcon("replace.png");
        Image imageForReplaceMenuItem = replaceImageIcon.getImage();
        Image newImageForReplaceMenuItem = imageForReplaceMenuItem.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        replaceImageIcon = new ImageIcon(newImageForReplaceMenuItem);
        replaceMenuItem.setIcon(replaceImageIcon);

        JMenuItem preferencesMenuItem = new JMenuItem("Preferences");

        //Creating menu items for Help menu
        aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(this);



        //Creating menus
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        /*ADDING MENU ITEMS TO MENUS*/
        //Adding menu items to file menu
        fileMenu.add(newMenuItem);
        fileMenu.add(saveAsMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        //Adding menu items to edit menu
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);
        editMenu.addSeparator();
        editMenu.add(findMenuLikeItem);
        editMenu.add(preferencesMenuItem);

        //Adding menu items to help menu
        helpMenu.add(aboutMenuItem);

        //Adding sub-menus to find menu (acts as item)
        findMenuLikeItem.add(findMenuItem);
        findMenuLikeItem.add(replaceMenuItem);


        //Adding menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        //Adding Mnemonics to all main menus
        fileMenu.setMnemonic(KeyEvent.VK_F);
        editMenu.setMnemonic(KeyEvent.VK_E);
        helpMenu.setMnemonic(KeyEvent.VK_F1);

        //Adding Mnemonics to all menu items
        //For file menu
        newMenuItem.setMnemonic(KeyEvent.VK_N);
        newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));

        saveAsMenuItem.setMnemonic(KeyEvent.VK_S);
        saveAsMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK + KeyEvent.SHIFT_MASK));

        exitMenuItem.setMnemonic(KeyEvent.VK_X);
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK));

        //For edit menu
        copyMenuItem.setMnemonic(KeyEvent.VK_C);
        copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));

        pasteMenuItem.setMnemonic(KeyEvent.VK_V);
        pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_MASK));

        findMenuLikeItem.setMnemonic(KeyEvent.VK_F);

        findMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_MASK));

        replaceMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_MASK));

        preferencesMenuItem.setMnemonic(KeyEvent.VK_P);
        preferencesMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.ALT_MASK));

        aboutMenuItem.setMnemonic(KeyEvent.VK_A);
        aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.ALT_MASK));



        //MENU BAR ENDS HERE

        //GUI FORM
        JPanel framePanel = new JPanel();
        framePanel.setBackground(Color.white);

        //Creating an image label for the form
        JLabel imageLabel = new JLabel();
        ImageIcon logoImageIcon = new ImageIcon("images.png");
        Image imageForLogo = logoImageIcon.getImage();
        Image newImageForLogo = imageForLogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        logoImageIcon = new ImageIcon(newImageForLogo);
        imageLabel.setIcon(logoImageIcon);
        imageLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));

        //Creating the components of the form
        JLabel inputLabel = new JLabel("Enter an integer");
        inputLabel.setFont(new Font("Consolas", Font.BOLD, 20));

        JLabel outputLabel = new JLabel("Accumulated sum is");
        outputLabel.setFont(new Font("Consolas", Font.BOLD, 20));


        inputTextField = new JTextField();
        inputTextField.addActionListener(this);
        inputTextField.setPreferredSize(new Dimension(300, 50));
        inputTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        inputTextField.setFont(new Font("Consolas", Font.BOLD, 20));
        inputTextField.setHorizontalAlignment(JTextField.CENTER);

        outputTextField = new JTextField();
        outputTextField.setPreferredSize(new Dimension(300, 50));
        outputTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
        outputTextField.setForeground(Color.white);
        outputTextField.setFont(new Font("Consolas", Font.BOLD, 20));
        outputTextField.setBackground(Color.black);
        outputTextField.setCaretColor(Color.white);
        outputTextField.setHorizontalAlignment(JTextField.CENTER);
        outputTextField.setEditable(false);

        GridBagLayout gridBagLayout = new GridBagLayout();
        framePanel.setLayout(gridBagLayout);
        GridBagConstraints constraints = new GridBagConstraints();

        //Setting constraints for image label
        framePanel.add(imageLabel, constraints);

        //Setting constraints for input label
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_START; // Align to the left
        constraints.insets = new Insets(10, 10, 0, 0);
        framePanel.add(inputLabel, constraints);

        //Setting constraints for input text field
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 5, 0, 10);
        framePanel.add(inputTextField, constraints);

        //Setting constraints for output label
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(10, 10, 0, 0);
        framePanel.add(outputLabel, constraints);

        // Setting constraints for output text field
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 5, 0, 10);
        framePanel.add(outputTextField, constraints);



        //ADDING COMPONENTS TO FRAME
        this.setIconImage(image);
        this.setJMenuBar(menuBar);

        this.getContentPane().add(framePanel);


        this.setVisible(true);
    }

    public static void main(String[] args) {
        new AppOneGroup10();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitMenuItem){
            System.exit(0);
        }
        if (e.getSource() == aboutMenuItem) {
            window = new JWindow(this);
            JPanel panel = new JPanel();
            JLabel label = new JLabel("copyright information");

            disappearButton = new JButton("CLEAR");
            disappearButton.setFont(new Font("Consolas", Font.PLAIN, 20));
            disappearButton.setBackground(Color.BLACK);
            disappearButton.setFocusPainted(false);
            disappearButton.addActionListener(this);
            disappearButton.setForeground(Color.white);
            disappearButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));

            label.setFont(new Font("Consolas", Font.BOLD, 20));
            label.setForeground(Color.white);

            panel.setBorder(BorderFactory.createLineBorder(Color.black));
            panel.add(label);
            panel.add(disappearButton);
            panel.setLayout(new GridLayout(2, 1));
            panel.setBackground(Color.gray);
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));


            window.add(panel);
            window.setSize(400, 100);
            window.setLocationRelativeTo(null);
            window.setVisible(true);

        }
        if (e.getSource() == disappearButton){
            window.setVisible(false);
        }

        if (e.getSource() == inputTextField) {
            try{
                int number = Integer.parseInt(inputTextField.getText());
                results = results + number;
                outputTextField.setText(Integer.toString(results));
                inputTextField.setText("");
            }
            catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(this, "Input must be an integer!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                inputTextField.setText("");
            }
        }
    }
}
