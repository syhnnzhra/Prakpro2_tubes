/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actionListener;

/**
 *
 * @author Putri Azizah
 */
import java.awt.event.*;
import GreenCycle.Sampah;
import GreenCycle.SampahFrame;
import dao.GreenCycleDao;

public class EditSaveActionListener implements ActionListener {
    private final SampahFrame sampahFrame;
    private final GreenCycleDao greenCycleDao;
    private String id;

    public EditSaveActionListener(SampahFrame sampahFrame, GreenCycleDao greenCycleDao, String id) {
        // Inisialisasi nilai dari biodataFrame, biodataDao, dan id
        this.sampahFrame = sampahFrame;
        this. greenCycleDao =  greenCycleDao;
        this.id = id;
    }

      public void actionPerformed(ActionEvent e) {

        String nama_sampah = this.sampahFrame.getNamaTextField().getText();

        String jenis_sampah = this.sampahFrame.getJenisTextField().getText();
  
        String total_sampah = this.sampahFrame.getTotalTextField().getText();

}


}
