package br.com.satc;

import br.com.satc.objetos.Cliente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClienteController extends HttpServlet {
    private ClienteDao clienteDao;
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/add":
                    showNewForm(request, response);
                    break;
                case "/cadastrar":
                    insertCliente(request, response);
                    break;
                case "/deletar":
                    deletarCliente(request, response);
                    break;
                case "/editar":
                    showEditForm(request, response);
                    break;
                case "/atualizar":
                    updateCliente(request, response);
                    break;
                default:
                    listCliente(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listCliente(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Cliente> listCliente = clienteDao.listarCLientes();
        request.setAttribute("index", listCliente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Cliente existingCliente = clienteDao.getCliente(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editar.jsp");
        request.setAttribute("cliente", existingCliente);
        dispatcher.forward(request, response);

    }

    private void insertCliente(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String rg = request.getParameter("rg");
        String cpf =request.getParameter("cpf");

        Cliente cliente = new Cliente(id, nome,rg,cpf);
        clienteDao.cadastrar(cliente);
        response.sendRedirect("list");
    }

    private void updateCliente(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String rg = request.getParameter("rg");
        String cpf =request.getParameter("cpf");

        Cliente cliente = new Cliente(id,nome,rg,cpf);
        clienteDao.updateCliente(cliente);
        response.sendRedirect("list");
    }

    private void deletarCliente(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Cliente cliente = new Cliente(id);
        clienteDao.deletarCliente(cliente);
        response.sendRedirect("list");

    }
}
