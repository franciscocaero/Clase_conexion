import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarCarros {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton conectarButton;
    private JButton insertarButton;
    private JTextArea descripciónDelCarroTextArea;
    public JPanel panelCarros;

    public InsertarCarros() {
        conectarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConexionBD miconexion = new ConexionBD();
                miconexion.conexionLocal(
                        "jdbc:mysql://localhost:3306/proyectos",
                        "root", "");
                JOptionPane.showMessageDialog(null, miconexion.getMensaje());
            }
        });
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String modelo=textField1.getText();
                String marca=textField2.getText();
                int anyo=Integer.parseInt(textField3.getText());
                String color=textField4.getText();
                String caracteristicas= descripciónDelCarroTextArea.getText();
                ingresoDatos(marca,modelo,anyo,color,caracteristicas);
                JOptionPane.showMessageDialog(null, "Datos insertados exitosamente");
            }
        });
    }
    public static void ingresoDatos(String marca, String modelo, int anyo, String color,String caracteristicas) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/proyectos",
                "root", "")) {
            String sql = "INSERT INTO carros(marca, modelo, año, color,caracteristicas)values(?,?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, marca);
                preparedStatement.setString(2, modelo);
                preparedStatement.setInt(3, anyo);
                preparedStatement.setString(4, color);
                preparedStatement.setString(5,caracteristicas);
                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Inserción exitosa");
                } else {
                    System.out.println("Inserción fallida");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
