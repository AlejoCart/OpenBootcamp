package org.example;
import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Producto> listaProductos= new ArrayList<>();
        int precio;
        String descripcion,nombre,img;

        //DB Conection


        /*String url = "jdbc:mysql://localhost:3306/productos_test";
        String username = "root";
        String password = "";

        System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }*/
       Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/productos_test";
            connection = DriverManager.getConnection(url, "root", "");
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            System.out.println("Error en la conexion!!: "+ e.getMessage());

        }
        Statement statement;
        ResultSet resultSet=null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from productos");
        } catch (Exception e) {
            System.out.println("Error en la consulta");
        }
        try{
            while (resultSet.next()){
            precio=resultSet.getInt("Precio");
            nombre=resultSet.getString("Nombre");
            descripcion= resultSet.getString("Descripcion");
            img=resultSet.getString("img");
            listaProductos.add(new Producto(precio,nombre,descripcion,img));
            }
        }catch(Exception e){
            System.out.println("Error de lectura de los resultados ");
            }

        for(Producto p: listaProductos){
            System.out.println(p.toString());
        }

        }

    }
