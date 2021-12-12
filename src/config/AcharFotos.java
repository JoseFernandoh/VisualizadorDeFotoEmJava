/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author T-Gamer
 */public class AcharFotos extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        String fotos = file.getFileName().toString();
        if (fotos.endsWith(".png") || fotos.endsWith(".jpg")) {
            MostrarFotos.diretorioFotos.add(file);
        }
        return FileVisitResult.CONTINUE;
    }
}
