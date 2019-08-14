package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
            e.printStackTrace();
        }
        new MainForm("Base64");

    }

}
