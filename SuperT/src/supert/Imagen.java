/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supert;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author ironfart
 */
public class Imagen extends javax.swing.JPanel {

    public Imagen() {
        this.setSize(324, 128); //se selecciona el tamaño del panel
    }

    public Imagen(String a) {
        this.setSize(162, 64);
    }

    public Imagen(String a, String b) {
        this.setSize(100, 100);
    }

    //Se crea un método cuyo parámetro debe ser un objeto Graphics
    public void paint(Graphics g) {
        Dimension height = getSize();

        //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
        ImageIcon logo = new ImageIcon(getClass().getResource("/images/logo.jpeg"));

        //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
        g.drawImage(logo.getImage(), 0, 0, height.width, height.height, null);

        setOpaque(false);
        super.paintComponent(g);
    }
}
