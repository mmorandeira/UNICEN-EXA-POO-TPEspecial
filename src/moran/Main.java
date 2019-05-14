package moran;

import moran.structures.Playlist;
import moran.structures.Track;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Playlist master = new Playlist("Master");
        File file = new File("pistas.txt");
        Vector<Track> trackVector = new Vector<Track>();
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
            //System.out.println(p1);
            trackVector.add(p1);
            master.add(p1);
        }
        sc.close();
        //System.out.println("hola");
        Track copy;
        /*
        try {
            copy = (Track) trackVector.elementAt(0).clone();
            System.out.println(copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        */
        copy = trackVector.elementAt(0).copy();
        //System.out.println(copy);
        System.out.println(master);
    }
}
