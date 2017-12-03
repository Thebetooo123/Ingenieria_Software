package supert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    private Connection cnn;
    private Statement st;
    private ResultSet rs;
    private boolean conexion;
    private String connectionQuery[] = new String[]{"localhost", "3306", "Notero", "appNotero", "Asd123456."};

    public ResultSet getRs() {
        return rs;
    }

    public Conexion() {
        conexion = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://" + connectionQuery[0] + ":" + connectionQuery[1] + "/" + connectionQuery[2], connectionQuery[3], connectionQuery[4]);
            conexion = true;
        } catch (ClassNotFoundException | SQLException e) {
            reConectar();
        }

    }

    private void reConectar() {
        try {
            if (!conexion) {
                requestBD();
                Class.forName("com.mysql.jdbc.Driver");
                cnn = DriverManager.getConnection("jdbc:mysql://" + connectionQuery[0] + ":" + connectionQuery[1] + "/" + connectionQuery[2], connectionQuery[3], connectionQuery[4]);
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public ResultSet consultar(String sql) {
        try {
            Statement sentencia = cnn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = sentencia.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
        return rs;
    }

    public boolean buscarSQL(String sql) {
        try {
            st = cnn.createStatement(0, 0);
            st.executeQuery(sql);
            return true;
        } catch (Exception e) {
            reConectar();
            return false;
        }
    }

    public boolean registroNuevo(String sql) {
        try {
            Statement sentencia = cnn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql);
        } catch (SQLException e) {
            reConectar();
            return false;
        }
        return true;
    }

    public void requestBD() {
        javax.swing.JLabel lblMensaje1 = new javax.swing.JLabel("Contacte a soporte técnico para obtener los siguientes datos:");
        javax.swing.JLabel lblMensaje2 = new javax.swing.JLabel("(Esto solo solucionara el problema en esta ocación)");
        javax.swing.JLabel lblHost = new javax.swing.JLabel("dato1");
        javax.swing.JTextField txtHost = new javax.swing.JTextField();
        javax.swing.JLabel lblPort = new javax.swing.JLabel("dato2");
        javax.swing.JTextField txtPort = new javax.swing.JTextField();
        Object[] ob = {lblMensaje1, lblMensaje2, lblHost, txtHost, lblPort, txtPort,};
        int result = javax.swing.JOptionPane.showConfirmDialog(null, ob, "Reintentar conexión a base de datos:", 0);
        if (result == javax.swing.JOptionPane.OK_OPTION) {
            connectionQuery[0] = txtHost.getText();
            connectionQuery[1] = txtPort.getText();
        } else {
            System.exit(0);
        }
    }

    public void freeRS() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        } catch (SQLException ex) {
        }
    }

}
