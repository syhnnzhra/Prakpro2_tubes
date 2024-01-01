/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GreenCycle;

import javax.swing.table.*;
import java.util.List;
/**
 *
 * @author syhnn
 */
public class ModelTable extends AbstractTableModel{
    private String[] columnNames = { "ID", "Sampah", "Jenis", "Total", };
    private List<Sampah> data;

    public ModelTable(List<Sampah> data) {
        this.data = data;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        Sampah rowItem = data.get(row);
        String value = "";

        switch (col) {
            case 0:
                value = rowItem.getId();
                break;
            case 1:
                value = rowItem.getNama();
                break;
            case 2:
                value = rowItem.getJenis();
                break;
            case 3:
                value = String.valueOf(rowItem.getTotal());
                break;
        }
        return value;
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }
}
