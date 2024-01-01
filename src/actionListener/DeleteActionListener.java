/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actionListener;
import java.awt.event.*;

import GreenCycle.Sampah;
import GreenCycle.SampahFrame;
import dao.GreenCycleDao;
/**
 *
 * @author fathiamaulida
 */
public class DeleteActionListener implements ActionListener {
      private final SampahFrame sampahFrame; // Variable biodataFrame untuk menyimpan nilai biodataFrame
      private final GreenCycleDao greenCycleDao; // Variable biodataDao untuk menyimpan nilai biodataDao
  // Constructor HapusActionListener
  public DeleteActionListener(SampahFrame sampahFrame, GreenCycleDao greenCycleDao ) {
    // Inisialisasi nilai dari biodataFrame dan biodataDao
    this.sampahFrame = sampahFrame;
    this.greenCycleDao = greenCycleDao;
  }

}

