package com.aiexpanse.algo.jetty;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonServlet extends HttpServlet {
    public JsonServlet() {
        super();
    }
    @Override
    protected void doGet( HttpServletRequest request,
                          HttpServletResponse response ) throws ServletException, IOException
    {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        String json = new JsonMapper().toJson(JettyServer.jsonPathMapping.get(request.getServletPath()));
        response.getWriter().println(json);
    }
}