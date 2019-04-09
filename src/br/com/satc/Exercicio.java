/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.satc;

import br.com.satc.objetos.Cliente;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author juan.159417
 */
public class Exercicio {

    /**
     * @param args the command line arguments
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        Connection con = new ConnectionFactory().getConnection();
        System.out.println("Conectou!");
        ClienteDao clienteDao = new ClienteDao();

        String nome, rg, cpf;

        nome = JOptionPane.showInputDialog(null, " Informe o nome: ");
        rg = JOptionPane.showInputDialog(null, " Informe o rg: ");
        cpf = JOptionPane.showInputDialog(null, " Informe o cpf: ");

        Cliente cliente = new Cliente(nome, rg, cpf);

        clienteDao.cadastrar(cliente);
        con.close();

    }

}
