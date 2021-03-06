
package Controlador;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;
 

public class ImagenFondo implements Border{
    public BufferedImage back;
 
    public ImagenFondo() throws Exception{
        try {
            URL imagePath = new URL(getClass().getResource("../img/club5.jpg").toString());
            back = ImageIO.read(imagePath);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public ImagenFondo(String file) throws Exception{
        try {
            URL imagePath = new URL(getClass().getResource("../img/"+file+"").toString());
            back = ImageIO.read(imagePath);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawImage(back, (x + (width - back.getWidth())/1),(y + (height - back.getHeight())/8), null);
    }
 
    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0,0,0,0);
    }
 
    @Override
    public boolean isBorderOpaque() {
        return false;
    }
 
}
