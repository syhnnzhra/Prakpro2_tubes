/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GreenCycle;

/**
 *
 * @author syhnn
 */
public class Sampah {
    private String id_sampah; 
    private String nama_sampah; 
    private String jenis_sampah;
    private int total_sampah; 
    
    public void setId(String id_sampah) {
        this.id_sampah = id_sampah;
    }
    
    public String getId() {
        return this.id_sampah;
    } 
    
    public void setNama(String nama_sampah) {
        this.nama_sampah = nama_sampah;
    }
    
    public String getNama() {
        return this.nama_sampah;
    } 
    
    public void setJenis(String jenis_sampah) {
        this.jenis_sampah = jenis_sampah;
    }
    
    public String getJenis() {
        return this.jenis_sampah;
    }
    
    public void setTotal(int total_sampah) {
        this.total_sampah = total_sampah;
    }
    
    public int getTotal() {
        return this.total_sampah;
    }
}
