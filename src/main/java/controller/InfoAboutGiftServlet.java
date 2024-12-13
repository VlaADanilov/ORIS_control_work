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

@WebServlet("/info")
public class InfoAboutGiftServlet extends HttpServlet {
    private ServiceReturner serviceReturner;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        serviceReturner = (ServiceReturner) config.getServletContext().getAttribute("database");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id_str = req.getParameter("id");
        if(id_str == null || id_str.isEmpty()){
            id_str = "1";
        }
        long id;
        try{
            id = Long.parseLong(id_str);
        }catch(NumberFormatException e){
            id = 1L;
        }
        Gift gift = serviceReturner.getGiftService().getGift(id);
        req.setAttribute("gift", gift);
        req.getRequestDispatcher("/WEB-INF/jsp/info.jsp").forward(req, resp);
    }
}
