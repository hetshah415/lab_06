/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author het
 */
public class shoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("logout")) {
                session.invalidate();
                String message = "logged out";
                request.setAttribute("message", message);
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
        }

        if (session.getAttribute("username") != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        ArrayList<String> itemList = (ArrayList<String>) session.getAttribute("itemList");

        if (itemList == null) {
            itemList = new ArrayList<>();
        }
        if (action != null) {
            switch (action) {
                case "register": {
                    String username = request.getParameter("username");
                    session.setAttribute("username", username);
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                    break;
                }
                case "add": {
                    String item = request.getParameter("item");
                    if (item != null) {
                        itemList.add(item);
                        session.setAttribute("itemList", itemList);
                    }
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                    break; 
                }
                case "delete": {
                    String item = request.getParameter("item");

                    itemList.remove(item);
                    session.setAttribute("itemList", itemList);

                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                    break;
                }

            }
        }

    }
}
