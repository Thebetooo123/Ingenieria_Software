/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supert;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ironfart
 */
public class Connect {

    Connection conn = null;

    public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SuperT_v1.0?useSSL=false", "root", "Asd123456.");
            //System.out.println("Conecxión establecida");
            //JOptionPane.showMessageDialog(null, "Conectado");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexión");
            JOptionPane.showMessageDialog(null, "Error de conexión" + e);
        }
        return conn;
    }

}
