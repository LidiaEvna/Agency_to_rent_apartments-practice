package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class registration {

    @FXML
    private TextField login;

    @FXML
    private TextField pass;

    @FXML
    private Button button;


    @FXML
    void initialize() {
        button.setOnAction(click -> {
            System.out.println("Логин:" + login.getText());
            System.out.println("Пароль:" + pass.getText());
            button.getScene().getWindow().hide();
             // Запись в txt документ для регистрации
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\project\\src\\main\\resources\\login.txt"))) {
                writer.write(login.getText());
                writer.newLine();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("Auto1.fxml"));
                loader.load();
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                        }
                        catch(IOException ex){
                            System.out.println(ex.getMessage());
                        }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\project\\src\\main\\resources\\pass.txt"))) {
                writer.write(pass.getText());
                writer.newLine();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("Auto1.fxml"));
                loader.load();
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        });
    }
}