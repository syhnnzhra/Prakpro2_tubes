/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actionListener;

import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GreenCycle.SampahFrame;
/**
 *
 * @author syhnn
 */
public class CloseWindowActionListener implements WindowListener {
	private final SampahFrame sampahFrame;

	public CloseWindowActionListener(SampahFrame sampahFrame) {
		this.sampahFrame = sampahFrame;
	}

	public void windowClosing(WindowEvent e) {
		int confirmation = JOptionPane.showConfirmDialog(this.sampahFrame,
				"Apakah anda yakin ingin keluar aplikasi?\nSemua data yang belum disimpan, tidak akan tersimpan.",
				"Form Biodata",
				JOptionPane.YES_NO_OPTION);

		if (confirmation == JOptionPane.YES_OPTION) {
			System.exit(0);
		} else {
			this.sampahFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
	}

	public void windowOpened(WindowEvent e) {
		// Tidak melakukan apa-apa
	}

	public void windowClosed(WindowEvent e) {
		// Tidak melakukan apa-apa
	}

	public void windowIconified(WindowEvent e) {
		// Tidak melakukan apa-apa
	}

	public void windowDeiconified(WindowEvent e) {
		// Tidak melakukan apa-apa
	}

	public void windowActivated(WindowEvent e) {
		// Tidak melakukan apa-apa
	}

	public void windowDeactivated(WindowEvent e) {
		// Tidak melakukan apa-apa
	}
}
