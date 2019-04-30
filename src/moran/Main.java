package moran;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("pistas.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        sc.useDelimiter(";");
        sc.nextLine();
        sc.nextLine();
        while (sc.hasNext()) {
            int id = Integer.parseInt(sc.next());
            String titulo = sc.next();
            int duracion = Integer.parseInt(sc.next());
            String artista = sc.next();
            String tituloAlbum = sc.next();
            int anio = Integer.parseInt(sc.next());
            String genero = sc.next();
            Pista p1 = new Pista(id, duracion, anio, titulo, artista, tituloAlbum, genero, "denunciado maquinola");
            if (sc.hasNextLine()) sc.nextLine();
            System.out.println(p1);
        }
        sc.close();
    }
}
