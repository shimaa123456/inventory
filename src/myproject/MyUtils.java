/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myproject;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class MyUtils {
     public static TableModel resultSetTableModel(ResultSet rs) throws SQLException {
        // Get the metadata of the ResultSet
        java.sql.ResultSetMetaData metaData = rs.getMetaData();

        // Get the number of columns in the ResultSet
        int columnCount = metaData.getColumnCount();

        // Create an array to hold the column names
        String[] columnNames = new String[columnCount];

        // Add the column names to the model
        for (int i = 1; i <= columnCount; i++) {
            columnNames[i - 1] = metaData.getColumnName(i);
        }

        // Create a DefaultTableModel with the column names
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // Add the rows to the model
        while (rs.next()) {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = rs.getObject(i);
            }
            tableModel.addRow(rowData);
        }

        return tableModel;
    } 
}
