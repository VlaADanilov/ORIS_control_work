package controller;

import db.ServiceReturner;
import model.Gift;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ListOfGiftsServlet extends HttpServlet {
    private ServiceReturner serviceReturner;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        serviceReturner = (ServiceReturner) config.getServletContext().getAttribute("database");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Gift> list = serviceReturner.getGiftService().getAllGifts();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/WEB-INF/jsp/listOfGifts.jsp").forward(req, resp);
    }
}
