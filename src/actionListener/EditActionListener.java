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
import GreenCycle.SampahFrame;
import dao.GreenCycleDao;

public class EditActionListener implements ActionListener {
    private final SampahFrame sampahFrame;
    private final GreenCycleDao greenCycleDao;

    public EditActionListener(SampahFrame sampahFrame, GreenCycleDao greenCycleDao) {
     
        this.sampahFrame = sampahFrame;
        this.greenCycleDao = greenCycleDao ;

}

      public void actionPerformed(ActionEvent e) {
        int row = this.sampahFrame.getTable().getSelectedRow();

        int column = this.sampahFrame.getTable().getSelectedColumn();

        if (row == -1 || column == -1) {
            this.sampahFrame.showAlertFailed("tidak ada yang diubah");
            return;
        }

        String ubah = (String) this.sampahFrame.getTable().getModel().getValueAt(row, column);

        String id = "";

        String col = "";

             switch (column) {
      
            case 0:
            
                col = "nama_sampah";
                break;
           
            case 1:
              
                col = "jenis_sampah";
                break;
         
            case 2:
           
                col = "total_sampah";
                break;
          
            default:
          
                System.out.println("Kolom tidak ditemukan");
                break;
        }

             id = this.greenCycleDao .select(col, ubah).getId();
        
             this.sampahFrame.getNamaTextField().setText(this.greenCycleDao.select(col, ubah).getNama());
       
             this.sampahFrame. getJenisTextField().setText(this.greenCycleDao.select(col, ubah).getJenis());

            int totalValue = this.greenCycleDao.select(col, ubah).getTotal();
            this.sampahFrame.getTotalTextField().setText(String.valueOf(totalValue));
             
             EditSaveActionListener editListener = new EditSaveActionListener(
                this.sampahFrame,
                this.greenCycleDao,
                id);
 
               this.sampahFrame.getButtonSimpanUbah().addActionListener( editListener);
    }
        }


