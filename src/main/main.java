/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.*;
import dao.GreenCycleDao;
import GreenCycle.SampahFrame;

/**
 *
 * @author syhnn
 */
public class main extends JFrame {
    private final GreenCycleDao greencycleDao; 
    private final SampahFrame sampahFrame;

    public main() {
        this.setTitle("Data Sampah");

        this.setSize(400, 500);
        
        this.greencycleDao = new GreenCycleDao();
        this.sampahFrame = new SampahFrame(greencycleDao);

        this.sampahFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new main();
            }
        });
    }
}
