package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLOutput;
import java.util.Optional;

public class MyMain extends Application{

    @Override
    public void init() throws Exception {
        System.out.println("init"); //Initialize the Application
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("start"); //Starts an Application

        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0, menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");
        primaryStage.show();

    }

    private MenuBar createMenu(){

        //File Menu
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");

        newMenuItem.setOnAction(actionEvent -> {
            System.out.println("New Menu Item Clicked");
            //More Code....
        });

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem quitMenuItem = new MenuItem("Quit");

        quitMenuItem.setOnAction(actionEvent -> {  Platform.exit();
            System.exit(0);
        });


        fileMenu.getItems().addAll(newMenuItem, separatorMenuItem , quitMenuItem);

        //Help Menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");
        helpMenu.getItems().addAll(aboutApp);

        aboutApp.setOnAction(actionEvent -> aboutApp());

        //Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;
    }

    public static  void aboutApp() {

        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My First Desktop App");
        alertDialog.setHeaderText("Learning Javafx");
        alertDialog.setContentText("I am just a begineer but soon I will be pro and start developing awesome java Games.");

        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");

        alertDialog.getButtonTypes().setAll(yesBtn,noBtn);

       Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

       if (clickedBtn.isPresent() && clickedBtn.get() == yesBtn){
           System.out.println("Yes Button Clicked !");
       } else {
           System.out.println("No Button Clicked !");

       }

    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");// Called when app is stopped and is about to shutdown
        super.stop();
    }
}



