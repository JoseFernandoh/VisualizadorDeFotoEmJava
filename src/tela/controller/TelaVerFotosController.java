/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tela.controller;

import config.MostrarFotos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author T-Gamer
 */
public class TelaVerFotosController implements Initializable {

    private int quantidadeFotos;
    private int posisao = 1;

    @FXML
    private Label posicaoFotos;

    @FXML
    private Button butaoProximo;

    @FXML
    private Button butaoVoltar;

    @FXML
    private ImageView imgView;

    @FXML
    private AnchorPane tela;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        quantidadeFotos = MostrarFotos.diretorioFotos.size();
        fotos();
    }

    /*
    private void fotos(){
        String foto = MostrarFotos.pegarFoto(posisao);
        if(foto == null){
            posicaoFotos.setText("ERRO");
        }else{        
            Image image = new Image(getClass().getResourceAsStream("../../ImgView/"+foto));
            imgView.setImage(image);
            
            posicaoFotos.setText(posisao+ " de "+ quantidadeFotos);
        }
            nomeFoto = foto;
    }
     */
    public void fotos() {
        imgView.setImage(MostrarFotos.pegarFoto(posisao, imgView.getFitHeight(), imgView.getFitWidth()));
        posicaoFotos.setText(posisao + " de " + quantidadeFotos);
        chkButao();
    }

    private void chkButao() {
        if (posisao == quantidadeFotos) {
            butaoProximo.setDisable(true);
        } else {
            butaoProximo.setDisable(false);
        }
        if (posisao == 1) {
            butaoVoltar.setDisable(true);
        } else {
            butaoVoltar.setDisable(false);
        }
    }

    public void proximo() {
        posisao++;
        fotos();

    }

    public void voltar() {
        posisao--;
        fotos();

    }

    public void pegarTamanhoTela() {
        System.out.println("Heigth: " + tela.getHeight());
        System.out.println("Width: " + tela.getWidth());
    }
}
