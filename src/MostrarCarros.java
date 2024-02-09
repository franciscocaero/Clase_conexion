import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MostrarCarros extends JFrame {

    public MostrarCarros() {
        setTitle("Tabla de Carros");
        DefaultTableModel tableModel = new DefaultTableModel();

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/proyectos",
                "root", "")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM carros");
            tableModel.addColumn("Marca");
            tableModel.addColumn("Modelo");
            tableModel.addColumn("Año");
            tableModel.addColumn("Color");
            tableModel.addColumn("Características");

            while (resultSet.next()) {
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                int anyo = resultSet.getInt("año");
                String color = resultSet.getString("color");
                String caracteristicas = resultSet.getString("caracteristicas");
                tableModel.addRow(new Object[]{marca, modelo, anyo, color, caracteristicas});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));

        add(scrollPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MostrarCarros());
    }

}
