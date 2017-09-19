/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosTablas;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author MARCEL
 */
public class TablaRender extends DefaultTableCellRenderer{

    Color fondo, texto;
    
    public TablaRender() {
    }

    public TablaRender(Color fondo, Color texto) {
        this.fondo = fondo;
        this.texto = texto;
    }    

    public Color getFondo() {
        return fondo;
    }

    public void setFondo(Color fondo) {
        this.fondo = fondo;
    }

    public Color getTexto() {
        return texto;
    }

    public void setTexto(Color texto) {
        this.texto = texto;
    }

//    public TablaRender(int r, int g, int b) {
//        this.fondo = new Color(r, g, b);
//        this.texto = new Color(r,g,b);
//    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setBackground(fondo);//color de fondo
        table.setForeground(texto);//color de texto
        //Si la celda corresponde a una fila con estado FALSE, se cambia el color de fondo a rojo
//        if( table.getValueAt(row,columna_patron).equals(false) )
//        {
//            setBackground(Color.red);
//        }

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        return this;
    }
    
    
}
