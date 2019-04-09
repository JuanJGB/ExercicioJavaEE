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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author juan.159417
 */
public class ClienteDao {
    private Connection connection;

    public ClienteDao() {
        this.connection = new ConnectionFactory().geConnection();

    }


    public void cadastrar(Cliente cliente) throws SQLException {
        try (
                PreparedStatement st = connection.prepareStatement("INSERT INTO pizzaria.cliente (idcliente, nome, rg, cpf) VALUES (?,?,?,?)")) {

            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getRg());
            st.setString(3, cliente.getCpf());
            st.execute();
            st.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean updateCliente(Cliente cliente) throws SQLException {

        PreparedStatement st = connection.prepareStatement("UPDATE INTO pizzaria.cliente  SEt nome = ?, rg = ?, cpf = ? where idcliente = idcliente) VALUES (?,?,?)");
        {


            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getRg());
            st.setString(3, cliente.getCpf());
            st.execute();
            st.close();

            boolean rowUpdated = st.executeUpdate() > 0;
            st.close();
            connection.close();
            return rowUpdated;
        }
    }

    public Cliente getCliente(int id) throws SQLException {

        PreparedStatement st = connection.prepareStatement("SELECT * FROM cliente WHERE idcliente = idcliente");

        st.execute();


        ResultSet resultSet = st.executeQuery();


        String nome = resultSet.getString("nome");
        String rg = resultSet.getString("rg");
        String cpf = resultSet.getString("cpf");

        Cliente cliente = new Cliente(id, nome, rg, cpf);
        resultSet.close();
        st.close();

        return cliente;
    }

    public List<Cliente> listarCLientes() throws SQLException {

        List<Cliente> listaClientes = new ArrayList<>();

        PreparedStatement st = connection.prepareStatement("SELECT * FROM cliente");

        st.execute();
        ResultSet resultSet = st.executeQuery();

        String nome = resultSet.getString("nome");
        int id = resultSet.getInt("idcliente");
        String rg = resultSet.getString("rg");
        String cpf = resultSet.getString("cpf");

        Cliente cliente = new Cliente(id, nome, rg, cpf);
        listaClientes.add(cliente);


        resultSet.close();
        st.close();

        connection.close();

        return listaClientes;
    }

    public boolean deletarCliente(Cliente cliente) throws SQLException {

        PreparedStatement st = connection.prepareStatement("SELECT * FROM cliente");

        st.execute();
        ResultSet resultSet = st.executeQuery();


        boolean rowDeleted = st.executeUpdate() > 0;
        st.close();
        connection.close();
        return rowDeleted;
    }


}
