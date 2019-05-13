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
            String title = sc.next();
            int duration = Integer.parseInt(sc.next());
            String artist = sc.next();
            String albumTitle = sc.next();
            int year = Integer.parseInt(sc.next());
            String genre = sc.next();
            Track p1 = new Track(id, duration, year, title, artist, albumTitle, genre, "denunciado maquinola");
            if (sc.hasNextLine()) sc.nextLine();
            System.out.println(p1);
        }
        sc.close();
    }
}
