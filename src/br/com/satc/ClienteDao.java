/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.satc;

import br.com.satc.objetos.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author juan.159417
 */
public class ClienteDao {
private Connection connection;

        public ClienteDao() {
            this.connection = new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "CONECTOU");
        }
   

    public void cadastrar(Cliente cliente) throws SQLException {

        try (
                PreparedStatement st = connection.prepareStatement("INSERT INTO pizzaria.cliente (nome, rg, cpf, endereco) VALUES (?,?,?,?)")) {

            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getRg());
            st.setString(3, cliente.getCpf());
            st.setString(4, cliente.getEndereco());
            st.execute();
            st.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
      
    }

}
