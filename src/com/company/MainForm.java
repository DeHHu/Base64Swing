package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainForm extends JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextField loginField;
    private JTextField passField;
    private JButton genButton;
    private JTextArea encodeTextArea;
    private JTextField decodedField;
    private JButton decodeButton;
    private JTextArea decodeTextArea;

    MainForm(String title) throws HeadlessException {
        super(title);
        setVisible(true);
        setContentPane(tabbedPane1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(660, 300);

        init();
    }

    private void init() {

        loginField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    genButton.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        passField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    genButton.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        decodedField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    decodeButton.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        genButton.addActionListener(e -> {
            encodeTextArea.setText("");
            String builder = loginField.getText().trim() +
                    ":" +
                    passField.getText().trim();
            if (!builder.equals(":")) {
                String res = EncoderDecoder.encode(builder);
                if (res != null) {
                    encodeTextArea.append(res);
                    encodeTextArea.append("\nBasic " + res);
                    encodeTextArea.append("\n\"Authorization\":\"Basic +" + res + "\"");
                       /* String result = res
                                + "\r\n"
                                + "Basic " + res
                                + "\r\n"
                                + "\"Authorization\":\"Basic +" + res + "\"";
                        encodeTextArea.setText(result);*/
                }
            }

        });

        decodeButton.addActionListener(e -> {
            decodeTextArea.setText("");
            String res = EncoderDecoder.decode(decodedField.getText().trim());
            if (res != null) {
                decodeTextArea.setText(res);
            }
        });

    }
}
