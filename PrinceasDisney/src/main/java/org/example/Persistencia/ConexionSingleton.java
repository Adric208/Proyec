package org.example.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSingleton {
    private String baseDatos;
    private Connection connection;
    private static ConexionSingleton _instance;

    public ConexionSingleton(String baseDatos) {
        this.baseDatos = baseDatos;
        try{
            //Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:"+this.baseDatos);
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ConexionSingleton getInstance(String baseDatos){
        if (_instance == null){
            _instance = new ConexionSingleton(baseDatos);
        }else{
            System.out.println("Ya fue creada");
        }
        return _instance;
    }
    public Connection getConnection(){
        return connection;
    }
}