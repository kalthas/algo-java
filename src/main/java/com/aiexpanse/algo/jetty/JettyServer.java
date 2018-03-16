package com.aiexpanse.algo.jetty;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JettyServer {

    final static public Map<String, Object> jsonPathMapping = new ConcurrentHashMap<>();

    public void serve(String path, Object object) {
        jsonPathMapping.put(path, object);
    }

    public void start() {
        Server server = new Server(8080);
        // Create the ResourceHandler. It is the object that will actually handle the request for a given file. It is
        // a Jetty Handler object so it is suitable for chaining with other handlers as you will see in other examples.
        ResourceHandler resource_handler = new ResourceHandler();

        // Configure the ResourceHandler. Setting the resource base indicates where the files should be served out of.
        // In this example it is the current directory but it can be configured to anything that the jvm has access to.
        resource_handler.setDirectoriesListed(true);
        resource_handler.setWelcomeFiles(new String[]{ "index.html" });
        resource_handler.setResourceBase("fe/build");

        // The ServletHandler is a dead simple way to create a context handler
        // that is backed by an instance of a Servlet.
        // This handler then needs to be registered with the Server object.
        ServletHandler servlet_handler = new ServletHandler();

        // Passing in the class for the Servlet allows jetty to instantiate an
        // instance of that Servlet and mount it on a given context path.

        // IMPORTANT:
        // This is a raw Servlet, not a Servlet that has been configured
        // through a web.xml @WebServlet annotation, or anything similar.
        servlet_handler.addServletWithMapping(JsonServlet.class, "/tree");

        // Add the ResourceHandler to the server.
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { resource_handler, servlet_handler, new DefaultHandler()});

        server.setHandler(handlers);
        try {
            server.start();
        } catch (Exception e) {
            throw new RuntimeException("Failed to start jetty server", e);
        }
        server.dumpStdErr();
        try {
            server.join();
        } catch (InterruptedException e) {
            throw new RuntimeException("Failed to join jetty server", e);
        }
    }

    public static void main(String[] args) {
        new JettyServer().start();
    }

}
