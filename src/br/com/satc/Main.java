/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.satc;

import br.com.satc.objetos.Cliente;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author juan.159417
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws SQLException
     */
//    private static final String USER = "root", PSW = "", CON = "jdbc:mysql://localhost:3306/teste";
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = new ConnectionFactory().geConnection();

        System.out.println("Conectou!");

        ClienteDao clienteDao = new ClienteDao();

            
    }

    

}
