package com.teamai.hackitall.instorepicking;

import com.sun.net.httpserver.HttpServer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //launch(); // Start the JavaFX application
        new CalcPath();
        System.out.println("Java is running!");
        startHttpServer(); // Start the HTTP server
        System.out.println("Java is running!");
    }

    private static void startHttpServer() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress("0.0.0.0", 8081), 0);
            server.createContext("/confirm", new ConfirmationHandler());
            server.setExecutor(null); // Creates a default executor
            server.start();
            System.out.println("Server started on port 8081");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
