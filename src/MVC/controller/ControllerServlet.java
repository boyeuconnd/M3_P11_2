package MVC.controller;

import MVC.model.Product;
import MVC.service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ControllerServlet",urlPatterns = "/product")
public class ControllerServlet extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "add":
                addProduct(req,resp);
                break;
            case "edit":
                updateCustomer(req,resp);
                break;
            case "delete":
                deleteCustomer(req,resp);
                break;
            default:
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Product deleteProduct = productService.findById(id);
        productService.deleteProduct(deleteProduct);
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/deleteConfirm.jsp");
        req.setAttribute("messenger", "Product was deleted");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String color = req.getParameter("color");
        String url = req.getParameter("imgurl");
        Product updateProduct = productService.findById(id);
        productService.updateProduct(updateProduct,name,color,url);
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/edit.jsp");
        req.setAttribute("messenger", "Product was updated");
        req.setAttribute("product",updateProduct);
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void addProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String color = req.getParameter("color");
        Product addProduct = new Product(id,name,color);
        productService.add(addProduct);
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/add.jsp");
        req.setAttribute("messenger", "New product was created");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "add":
                showAddForm(req,resp);
                break;
            case "edit":
                showEditForm(req,resp);
                break;
            case "delete":
                showDeleteForm(req,resp);
                break;
            case "view":
//                viewCustomer(request,response);
                break;
            default:
                listCustomer(req,resp);
                break;
        }

    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Product deleteProduct = productService.findById(id);
        RequestDispatcher dispatcher;
        if(deleteProduct == null){
            dispatcher = req.getRequestDispatcher("product/edit.jsp");
        }else {
            req.setAttribute("product",deleteProduct);
            dispatcher = req.getRequestDispatcher("product/delete.jsp");
            try {
                dispatcher.forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher dispatcher;
        if(product == null){
            req.setAttribute("messenger","Product ID "+id+" not found.");
            dispatcher = req.getRequestDispatcher("product/edit.jsp");
        }else {
            req.setAttribute("product",product);
            dispatcher = req.getRequestDispatcher("product/edit.jsp");
            try {
                dispatcher.forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/add.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest req, HttpServletResponse resp) {
        List<Product> productList = productService.showList();
        req.setAttribute("productList",productList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/list.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
