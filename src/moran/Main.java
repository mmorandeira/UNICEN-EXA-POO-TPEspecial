package moran;

import moran.filters.*;
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
            sc.nextLine();
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
        /*
        Comparator c1 = new Comparator(ComparatorMode.GREATER);
        YearFilter f1 = new YearFilter(2006,c1);
        for(Track track:trackVector){
            if(f1.accept(track)){
                System.out.println(track);
            }
        }
        */

        ///2

        Playlist clasicosDelRock = new Playlist("Clasicos del Rock");
        clasicosDelRock.add(trackVector.elementAt(0).copy());
        clasicosDelRock.add(trackVector.elementAt(1).copy());
        clasicosDelRock.add(trackVector.elementAt(7).copy());
        clasicosDelRock.add(trackVector.elementAt(8).copy());
        clasicosDelRock.add(trackVector.elementAt(9).copy());
        clasicosDelRock.add(trackVector.elementAt(11).copy());

        Playlist loMejor = new Playlist("Lo Mejor");
        loMejor.add(trackVector.elementAt(2).copy());
        loMejor.add(trackVector.elementAt(3).copy());
        loMejor.add(trackVector.elementAt(6).copy());
        loMejor.add(trackVector.elementAt(11).copy());

        Playlist coldplay = new Playlist("Clodplay");
        coldplay.add(trackVector.elementAt(4).copy());
        coldplay.add(trackVector.elementAt(5).copy());
        coldplay.add(trackVector.elementAt(6).copy());

        Playlist elIndio = new Playlist("El Indio");
        elIndio.add(trackVector.elementAt(10).copy());
        elIndio.add(trackVector.elementAt(11).copy());

        /// 3
        System.out.println(clasicosDelRock);
        System.out.println(loMejor);
        System.out.println(coldplay);

        /// 4

        Comparator igual = new Comparator(ComparatorMode.EQUAL);
        Comparator menor = new Comparator(ComparatorMode.LESS);
        Comparator mayor = new Comparator(ComparatorMode.GREATER);
        //a
        System.out.println(master.find(new DurationFilter(400, mayor)));
        //b
        System.out.println(master.find(new GenreFilter("rock")));
        //c
        System.out.println(master.find(new AndFilter(new TitleFilter("rock"), new NotFilter(new ArtistFilter("LMFAO")))));
        //d
        System.out.println(master.find(new OrFilter(new AndFilter(new GenreFilter("rock"), new YearFilter(2006, mayor)), new AndFilter(new GenreFilter("rock"), new ArtistFilter("coldplay")))));
        /// 5

    }
}
