import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insertar {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton conectarButton;
    private JButton borrarCamposButton;
    private JButton ingresarDatosButton;
    public JPanel form1;

    public Insertar() {
        conectarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConexionBD miconexion = new ConexionBD();
                miconexion.conexionLocal(
                        "jdbc:mysql://localhost:3306/estudiantes",
                        "root", "1234");
                JOptionPane.showMessageDialog(null, miconexion.getMensaje());
            }

        });
        borrarCamposButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
            }
        });
        ingresarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textField1.getText();
                String cedula = textField2.getText();
                int calificacion1 = Integer.parseInt(textField3.getText());
                int calificacion2 = Integer.parseInt(textField4.getText());

                ingresoDatos(nombre, cedula, calificacion1, calificacion2);
                JOptionPane.showMessageDialog(null, "Datos insertados exitosamente");
            }
        });
    }

    public static void ingresoDatos(String nombre, String cedula, int calificacion1, int calificacion2) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/estudiantes",
                "root", "1234")) {
            String sql = "INSERT INTO calificaciones(nombre, cedula, calificacion1, calificacion2)values(?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nombre);
                preparedStatement.setString(2, cedula);
                preparedStatement.setInt(3, calificacion1);
                preparedStatement.setInt(4, calificacion2);
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