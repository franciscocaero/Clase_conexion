import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Instrumento {
    int id;
    String nombre;
    String  tipo;
    double precio;
    String carcteristicas;
    String foto;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCarcteristicas() {
        return carcteristicas;
    }

    public void setCarcteristicas(String carcteristicas) {
        this.carcteristicas = carcteristicas;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public boolean insertarItem(String nombre,String tipo,double precio,String carcteristicas,String foto){
        try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectos","root","")){
            String sql = "INSERT INTO instrumentos(nombre, tipo, precio, caracteristicas,foto)values(?,?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nombre);
                preparedStatement.setString(2, tipo);
                preparedStatement.setDouble(3, precio);
                preparedStatement.setString(4, carcteristicas);
                preparedStatement.setString(5, foto);
                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Filas insertadas correctamente");
                } else {
                    System.out.println("Inserción fallida");
                }
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
}
