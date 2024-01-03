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



 public void actionPerformed(ActionEvent e) {
    // Variable row untuk menyimpan nilai baris yang dipilih
    int row = this.sampahFrame.getTable().getSelectedRow();

    // Variable column untuk menyimpan nilai kolom yang dipilih
    int column = this.sampahFrame.getTable().getSelectedColumn();

    if (row == -1 || column == -1) {
      this.sampahFrame.showAlertFailed("tidak ada yang dihapus");
      return;
    } else {
      // Variable newValue untuk menyimpan nilai dari table yang diedit
      String newValue = (String) this.sampahFrame.getTable().getModel().getValueAt(row, column);
      // Variable id untuk menyimpan nilai id dari sampah yang akan dihapus
      Sampah id = new Sampah();

      // Variable col untuk menyimpan nama kolom yang dipilih
      String col = "";

      // Switch case untuk menentukan nama kolom yang dipilih
      switch (column) {
          // Jika kolom bernilai 0
          case 0:
              // Set col dengan nama
              col = "id_sampah";
              break;
           case 1:
              // Set col dengan no_telepon
              col = "nama_sampah";
              break;
          // Jika kolom bernilai 2
          case 2:
              // Set col dengan jenis_kelamin
              col = "jenis_sampah";
              break;
          // Jika kolom bernilai 3
          case 3:
              // Set col dengan alamat
              col = "total_sampah";
              break;
              
          default:
              // Tampilkan pesan kolom tidak ditemukan
              System.out.println("Kolom tidak ditemukan");
              break;
      }

	  // Set id dengan nilai id dari biodata yang akan dihapus
	  id = this.greenCycleDao.select(col, newValue);

      // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
      int confirmation = this.sampahFrame.showConfirmation("hapus");

      // Jika confirmation bernilai 1
      if (confirmation == 1) {
        // Panggil method showAlertFailed pada biodataFrame dengan parameter "tidak dihapus"
        this.sampahFrame.showAlertFailed("tidak dihapus");
        // Batalkan proses
        return;
      } 
      // Jiak confirmation bernilai 0
      else {
        // Hapus tabel biodata berdasarkan id
        this.sampahFrame.deletesampah(id);
       
        // Hapus data biodata berdasarkan id
        this.sampahFrame.delete(id);
        // Panggil method showAlertSuccess pada biodataFrame dengan parameter "dihapus"
        this.sampahFrame.showAlertSuccess("dihapus");
      }
    }
  }
}

