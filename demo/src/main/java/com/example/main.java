package com.example;

import javax.swing.SwingUtilities;


public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PadelRentalForm().setVisible(true));
    }
}

