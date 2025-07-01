package com.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PadelRentalForm extends JFrame {
    private JTable rentalTable;
    private DefaultTableModel tableModel;
    private JTextField nameField, phoneField, dateField, startField, endField;
    private JComboBox<String> courtField;
    private JButton saveButton, editButton, deleteButton;

    private List<PadelRental> rentals = new ArrayList<>();
    private int nextId = 1;

    public PadelRentalForm() {
        setTitle("Customer Form");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel Form
        JPanel formPanel = new JPanel();

        formPanel.add(new JLabel("Nama:"));
        nameField = new JTextField(10);
        formPanel.add(nameField);

        formPanel.add(new JLabel("No HP:"));
        phoneField = new JTextField(10);
        formPanel.add(phoneField);

        formPanel.add(new JLabel("Tanggal:"));
        dateField = new JTextField(8);
        formPanel.add(dateField);

        formPanel.add(new JLabel("Jam Mulai:"));
        startField = new JTextField(5);
        formPanel.add(startField);

        formPanel.add(new JLabel("Jam Selesai:"));
        endField = new JTextField(5);
        formPanel.add(endField);

        saveButton = new JButton("Simpan");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Hapus");

        formPanel.add(saveButton);
        formPanel.add(editButton);
        formPanel.add(deleteButton);

        add(formPanel, BorderLayout.NORTH);

        // Table
        tableModel = new DefaultTableModel(new String[]{"ID", "Nama", "No HP", "Tanggal", "Jam Mulai", "Jam Selesai", "Lapangan"}, 0);
        rentalTable = new JTable(tableModel);
        add(new JScrollPane(rentalTable), BorderLayout.CENTER);

        // Simpan & Update
        saveButton.addActionListener(e -> {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String date = dateField.getText();
            String start = startField.getText();
            String end = endField.getText();
            String court = (String) courtField.getSelectedItem();

            if (name.isEmpty() || phone.isEmpty() || date.isEmpty() || start.isEmpty() || end.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
                return;
            }

            int selectedRow = rentalTable.getSelectedRow();
            if (selectedRow != -1) {
                // Update
                PadelRental rental = rentals.get(selectedRow);
                rental.setName(name);
                rental.setPhoneNumber(phone);
                rental.setRentalDate(date);
                rental.setStartTime(start);
                rental.setEndTime(end);
                rental.setCourtType(court);

                tableModel.setValueAt(name, selectedRow, 1);
                tableModel.setValueAt(phone, selectedRow, 2);
                tableModel.setValueAt(date, selectedRow, 3);
                tableModel.setValueAt(start, selectedRow, 4);
                tableModel.setValueAt(end, selectedRow, 5);
                tableModel.setValueAt(court, selectedRow, 6);

                JOptionPane.showMessageDialog(this, "Data berhasil diperbarui.");
            } else {
                // Simpan baru
                PadelRental rental = new PadelRental(name, phone, date, start, end, court);
                rentals.add(rental);
                tableModel.addRow(new Object[]{nextId++, name, phone, date, start, end, court});
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan.");
            }

            clearForm();
            rentalTable.clearSelection();
        });

        // Edit
        editButton.addActionListener(e -> {
            int selectedRow = rentalTable.getSelectedRow();
            if (selectedRow != -1) {
                nameField.setText((String) tableModel.getValueAt(selectedRow, 1));
                phoneField.setText((String) tableModel.getValueAt(selectedRow, 2));
                dateField.setText((String) tableModel.getValueAt(selectedRow, 3));
                startField.setText((String) tableModel.getValueAt(selectedRow, 4));
                endField.setText((String) tableModel.getValueAt(selectedRow, 5));
                courtField.setSelectedItem(tableModel.getValueAt(selectedRow, 6));
            } else {
                JOptionPane.showMessageDialog(this, "Pilih data yang ingin diedit.");
            }
        });

        // Hapus
        deleteButton.addActionListener(e -> {
            int selectedRow = rentalTable.getSelectedRow();
            if (selectedRow != -1) {
                rentals.remove(selectedRow);
                tableModel.removeRow(selectedRow);
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus.");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PadelRentalForm().setVisible(true));
    }
}
