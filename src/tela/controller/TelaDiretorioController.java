/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tela.controller;

import config.MostrarFotos;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class TelaDiretorioController implements Initializable {
    
    public Stage stage;
    
    @FXML
    private TextField diretorio;
    
    @FXML
    private Label statusErro;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void concluir(){
        if(MostrarFotos.carregaFotos(diretorio.getText().strip()) && MostrarFotos.diretorioFotos.size() > 0){
            try {
                FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(this.getClass().getResource("telasFXML/TelaVerFotos.fxml")));
                Stage stage = new Stage();
                stage.setScene(new Scene(loader.load()));
                stage.show();
                stage.setTitle("FotosViwer");
                this.stage.close(); 
            } catch (IOException ex) {
                ex.printStackTrace();
                statusErro.setText("Erro ao Abrir as Fotos");
            }
        }else{
            statusErro.setText("Diretorio Invalido ou \nNenhuma Foto Encontrada");
        } 
    }
}
