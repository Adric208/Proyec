package org.example.Persistencia;
import org.example.Modelo.Princesas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class PrincesasDAO implements InterfazDAO {
    private  static int elID = 0;
    public PrincesasDAO() {
    }

    public static int getElID() {
        return elID;
    }

    public static void setElID(int elID) {
        PrincesasDAO.elID = elID;
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO princesas(Nombre,Edad,Principe,Lugar,Url) VALUES (?, ?, ?, ?, ?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("baseDatos.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((Princesas) obj).getNombre());
        pstm.setString(2, ((Princesas) obj).getEdad());
        pstm.setString(3, ((Princesas) obj).getPrincipe());
        pstm.setString(4, ((Princesas) obj).getLugar());
        pstm.setString(5, ((Princesas) obj).getUrl());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE princesas SET nombre = ?, edad = ?, principe = ?, lugar = ?, url = ? WHERE id = ?";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("baseDatos.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((Princesas) obj).getNombre());
        pstm.setString(2, ((Princesas) obj).getEdad());
        pstm.setString(3, ((Princesas) obj).getPrincipe());
        pstm.setString(4, ((Princesas) obj).getLugar());
        pstm.setString(5, ((Princesas) obj).getUrl());
        pstm.setInt(6, ((Princesas) obj).getId());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM princesas WHERE id = ?";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("baseDatos.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM princesas";
        ArrayList<Princesas> resultado = new ArrayList<>();
        Statement stm = ConexionSingleton.getInstance("baseDatos.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()){
            resultado.add(new Princesas(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6) ));
        }
        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        return null;
    }
}
