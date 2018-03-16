package com.aiexpanse.algo.jetty;

public class UIAware {

    private JettyServer server;

    protected synchronized void serve(String path, Object object) {
        if (server == null) {
            server = new JettyServer();
            server.serve(path, object);
            server.start();
        }
        server.serve(path, object);
    }

}
