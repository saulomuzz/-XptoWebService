/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author SAULOD
 */
public class Conexao {
    private static final String banco = "jdbc:mysql://localhost:3306/db_xpto";
 
    private static final String driver =  "com.mysql.jdbc.Driver";

    private static final String usuario = "root";
    private static final String senha = "";  
   
    private static Connection con = null;
    

    public static Connection getConexao(){
        
        if (con == null){
            try {
               
                Class.forName(driver);
                // criação da conexão com o BD
                con = 
                DriverManager.getConnection( banco, usuario, senha);
            } catch (ClassNotFoundException ex) {
                System.out.println("Não encontrou o driver");
            } catch (SQLException ex) {
                System.out.println("Erro ao conectar: "+ ex.getMessage());
            }
        }
        return con;
    }

    public static PreparedStatement getPreparedStatement(String sql){
      
        if (con == null){
           
            con = getConexao();
        }
        try {
            
            return con.prepareStatement(sql);
        } catch (SQLException e){
            System.out.println("Erro de sql: "+ e.getMessage());
        }
        return null;
    }
    
}
