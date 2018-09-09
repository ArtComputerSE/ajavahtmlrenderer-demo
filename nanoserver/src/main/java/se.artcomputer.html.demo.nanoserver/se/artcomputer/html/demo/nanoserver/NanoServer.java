package se.artcomputer.html.demo.nanoserver;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class NanoServer {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        try {
            new NanoServer().run();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("Server started in %d ms", (System.currentTimeMillis() - startTime)));
    }

    private void run() throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
        httpServer.createContext(HomePage.path(), new HomePage().handler());
        httpServer.createContext(NextPage.path(), new NextPage().handler());
        httpServer.createContext(FormPage.path(), new FormPage().handler());
        httpServer.start();
    }


}