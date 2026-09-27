package org.example;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URI;

public class Main {

    final static Logger logger = Logger.getLogger(Main.class);
    public static final String BASE_URI = "http://localhost:8080/myapp/";
    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig(MathService.class);
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        logger.info(String.format("Servidor arrancado en %s - Pulsa ENTER para apagarlo...", BASE_URI));
        System.in.read();
        server.shutdownNow();
    }
}