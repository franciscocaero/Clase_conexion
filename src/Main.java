import javax.swing.*;
import javax.swing.table.DefaultTableModel;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        /*JFrame frame=new JFrame("Ingreso de calificaciones");
        frame.setContentPane(new Insertar().form1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        Instrumento miInstrumento=new Instrumento();
        miInstrumento.setNombre("Guitarra");
        miInstrumento.setTipo("Española");
        miInstrumento.setPrecio(400.00);
        miInstrumento.setCarcteristicas("Guitarra clásica de madera");
        miInstrumento.setFoto("null");
        miInstrumento.insertarItem(miInstrumento.getNombre(), miInstrumento.getTipo(), miInstrumento.getPrecio(), miInstrumento.getCarcteristicas(), miInstrumento.getFoto());
    */
        JFrame frame=new JFrame("Ingreso de carros");
        frame.setContentPane(new InsertarCarros().panelCarros);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        JFrame ft=new JFrame("Frame Tabla");
        JTable table1=new JTable();
        DefaultTableModel tableModel=new DefaultTableModel(6,4);

        ft.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ft.setSize(400,500);
        ft.setLocationRelativeTo(null);
        ft.add(table1);
    }

}