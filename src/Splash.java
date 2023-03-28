import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Splash extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel label;
    private JPanel panel;

    public Splash() {
        super("Cargando...");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setResizable(false);

        // Centrar la ventana en la pantalla
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);

        // Crear el panel con la imagen
        panel = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image image = new ImageIcon(getClass().getResource("/img/Splash.jpeg")).getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Agregar un borde al panel
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        // Agregar una etiqueta con el mensaje de carga
        label = new JLabel("Cargando...");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.black);
        label.setHorizontalAlignment(JLabel.CENTER);

        // Agregar la etiqueta al panel
        panel.add(label);

        // Agregar el panel a la ventana
        add(panel, BorderLayout.CENTER);

        // Hacer visible la ventana
        setVisible(true);

        // Agregar una pausa de tiempo antes de cerrar el Splash Screen
        try {
            Thread.sleep(3000); // Pausa durante 3 segundos (3000 milisegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Cerrar la ventana del Splash Screen
        dispose();
    }
}
