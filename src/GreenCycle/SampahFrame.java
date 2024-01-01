/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GreenCycle;

import javax.swing.*;
import java.util.*;
import dao.GreenCycleDao;
import actionListener.CloseWindowActionListener;

/**
 *
 * @author syhnn
 */
public class SampahFrame extends JFrame {
    private List<Sampah> sampahList; 
    private final JTextField textFieldNama; 
    private final JTextField textFieldJenis; 
    private final JTextField textFieldTotal; 
    private final ModelTable tableModel; 
    private final JTable table; 
    private final JButton buttonSimpanUbah; 
    private final GreenCycleDao GCDao; 

    public SampahFrame(GreenCycleDao GCDao) {
        this.GCDao = GCDao;
        this.sampahList = this.GCDao.findAll();
        
        JLabel labelHeader = new JLabel("Form Data Sampah", JLabel.CENTER);
        labelHeader.setBounds(0, 20, 350, 10);

        JLabel labelNama = new JLabel("Nama: ");
        labelNama.setBounds(15, 40, 350, 10);

        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        JLabel labelJenis = new JLabel("Jenis Sampah: ");
        labelJenis.setBounds(15, 100, 350, 10);

        textFieldJenis = new JTextField();
        textFieldJenis.setBounds(15, 120, 350, 30);
        
        JLabel labelTotal = new JLabel("Total Sampah: ");
        labelTotal.setBounds(15, 160, 350, 15);

        textFieldTotal = new JTextField();
        textFieldTotal.setBounds(15, 200, 350, 30);

        JButton button = new JButton("Simpan");
        button.setBounds(15, 380, 100, 40);

        JButton buttonUbah = new JButton("Ubah");
        buttonUbah.setBounds(125, 380, 100, 40);

        JButton buttonHapus = new JButton("Hapus");
        buttonHapus.setBounds(235, 380, 100, 40);

        buttonSimpanUbah = new JButton("Simpan Ubah");
        buttonSimpanUbah.setBounds(345, 380, 150, 40);

        JButton refresh = new JButton("Refresh");
        refresh.setBounds(15, 650, 100, 40);

        refresh.addActionListener(e -> {
            refreshMasyarakatTable();
        });

        table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15,440,500,200);

        tableModel = new ModelTable(sampahList);
        table.setModel(tableModel);

        JButton buttonFile = new JButton("Simpan ke File");
        buttonFile.setBounds(345, 650, 150, 40);

        CloseWindowActionListener closeWindowListener = new CloseWindowActionListener(this);
        this.addWindowListener(closeWindowListener);

        this.add(labelHeader);
        this.add(labelNama);
        this.add(textFieldNama);
        this.add(labelJenis);
        this.add(textFieldJenis);
        this.add(labelTotal);
        this.add(textFieldTotal);
        this.add(button);
        this.add(buttonUbah);
        this.add(buttonHapus);
        this.add(buttonFile);
        this.add(scrollableTable);
        this.add(refresh);
        this.add(buttonSimpanUbah);

        this.setSize(550, 1000);
        this.setLayout(null);
    }

    public String getNama() {
        return textFieldNama.getText();
    }

    public JTextField getNamaTextField() {
        return textFieldNama;
    }

    public String getJenis() {
        return textFieldJenis.getText();
    }

    public JTextField getJenisTextField() {
        return textFieldJenis;
    }

     public JTextField getTotalTextField() {
        return textFieldTotal;
    }

     public int getTotal() {
     String totalText = textFieldTotal.getText();
    try {
        return Integer.parseInt(totalText);
    } catch (NumberFormatException e) {
        return 0; 
    }
}
   
    public ModelTable getTableModel() {
        return this.tableModel;
    }

    public JTable getTable() {
        return this.table;
    }

    public JButton getButtonSimpanUbah() {
        return this.buttonSimpanUbah;
    }

    public void refreshMasyarakatTable() {
        this.sampahList = this.GCDao.findAll();
        this.getTable().setModel(new ModelTable(this.sampahList));

        System.out.println("Table refreshed: ");
        if (sampahList.isEmpty()) {
            System.out.println("Table is empty");
        } else {
            for (Sampah sampah : sampahList) {
                System.out.println(sampah.getId() + " " + sampah.getNama() + " " + sampah.getJenis() + " " + sampah.getTotal());
            }
        }
        System.out.println();
    }

    public void showAlertFailed(String tidak_ada_yang_diubah) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void showAlertAllEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public void showAlertJenisSampahEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void showAlertNamaSampahEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
