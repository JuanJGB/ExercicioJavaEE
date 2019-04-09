/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.satc;

import br.com.satc.objetos.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author juan.159417
 */
public class ClienteDao {
private Connection connection;

        public ClienteDao() {
            this.connection = new ConnectionFactory().geConnection();
        
        }
   

    public void cadastrar(Cliente cliente) throws SQLException {
        try (
                PreparedStatement st = connection.prepareStatement("INSERT INTO pizzaria.cliente (nome, rg, cpf) VALUES (?,?,?,?)")) {

            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getRg());
            st.setString(3, cliente.getCpf());
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
      
    }

    public Cliente getCliente(int id) throws SQLException {

        PreparedStatement st = connection.prepareStatement("SELECT * FROM cliente WHERE idcliente = ?");

        st.execute();


        st.setInt(1, id);

        ResultSet resultSet = st.executeQuery();

        if (resultSet.next()) {
            String nome = resultSet.getString("title");
            String rg = resultSet.getString("author");
            String cpf = resultSet.getString("price");

            Cliente cliente = new Cliente(id,nome,rg,cpf);
        }

        resultSet.close();
        statement.close();

        return book;
    }



}
