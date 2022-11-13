package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Controllertut {

    @FXML
    private Button button;

    @FXML
    private TextField pass;

    @FXML
    private TextField login;

    @FXML
    private Button button1;

    @FXML
    void initialize() {
        button.setOnAction(click -> {  // Фактически прописываем функционал кнопки "Вход" и функционал TextField
            button.setText("Добро пожаловать");
            System.out.println("Логин:" + login.getText());
            System.out.println("Пароль:" + pass.getText());
            button.getScene().getWindow().hide(); // 37 строчка читает из файла(к которому прописан путь к документу txt
            try (BufferedReader reader = new BufferedReader(new FileReader("D:\\project\\src\\main\\resources\\login.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.equals(login.getText().trim())) {
                        try {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("List.fxml")); // Пропиываем путь к следующему окну( которое будет открываться после окна регистрации
                            loader.load();
                            Parent root = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));
                            stage.show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("Верный логин");
                }else {
                        try {
                        FXMLLoader loader = new FXMLLoader();//Создали исключение(при вводе логина и тд) для ошибки
                        loader.setLocation(getClass().getResource("error.fxml")); // Пропиываем путь к окну сообщающем ошибку вврда данных
                        loader.load();
                        Parent root = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                        System.out.println("Данные введены некорректно");
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }  // Повторяем те же действия для пароля
            try (BufferedReader reader = new BufferedReader(new FileReader("D:\\project\\src\\main\\resources\\pass.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.equals(pass.getText().trim())) {
                        try {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("List.fxml"));
                            loader.load();
                            Parent root = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));
                            stage.show();
                            stage.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("Верный пароль");
                    } else {
                        try {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("error.fxml"));
                            loader.load();
                            Parent root = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));
                            stage.show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("Данные введены некорректно");
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        button1.setOnAction(click -> {  // Пропиываем функционал для кнопки регистрации
            button1.getScene().getWindow().hide();
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("registration.fxml")); // Пропиываем путь к окну регистрации
                loader.load();
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}