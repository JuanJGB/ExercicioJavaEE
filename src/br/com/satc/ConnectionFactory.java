/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.satc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juan.159417
 */
public class ConnectionFactory {

  
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzaria", "root", "");
      
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
