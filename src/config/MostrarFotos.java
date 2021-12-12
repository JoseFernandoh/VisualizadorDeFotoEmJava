/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;

/**
 *
 * @author T-Gamer
 */
public class MostrarFotos {

    public static List<Path> diretorioFotos = new ArrayList<>();

    public static boolean carregaFotos(String diretorio) {
        try {
            Files.walkFileTree(Paths.get(diretorio), new AcharFotos());
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    
    /*
    public static String pegarFoto(int posisao) {
        File local = diretorioFotos.get(posisao - 1).toFile();
        File diretorioSalve = new File("build/classes/ImgView/" + local.getName());

        try {
            FileInputStream fileInputStream = new FileInputStream(local);
            FileOutputStream fileOutputStream = new FileOutputStream(diretorioSalve);

            int bufferSize;
            byte[] buffer = new byte[1024];
            while ((bufferSize = fileInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, bufferSize);
            }

            fileInputStream.close();
            fileOutputStream.close();
            
            return local.getName();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Nao foi Posivel Encontrar a IMG");
        } catch (IOException ex) {
            System.out.println("Nao foi possivel Salvar a img pra Visualiazar");
        }

        return null;
    }
    */
    
    public static Image pegarFoto(int posisao,double height, double width){
        return new Image(diretorioFotos.get(posisao-1).toString(),width,height,false,true);
    }

    /*
    public static void apagaFoto(String foto) {
        File file = new File("build/classes/ImgView/" + foto);
        System.out.println(file.delete());
    }
    */
}
    