package moran;

import moran.filters.*;
import moran.structures.AutomaticPlaylist;
import moran.structures.Element;
import moran.structures.Playlist;
import moran.structures.Track;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Year;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Playlist master = new Playlist("Master");
        System.out.println("Step 1");
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
            Track p1 = new Track(id, duration, year, title, artist, albumTitle, genre, "comentario");
            //System.out.println(p1);
            trackVector.add(p1);
            master.add(p1);
            sc.nextLine();
        }
        sc.close();

        // Step 1 of the guide
        System.out.println("Step 2");
        Playlist clasicosDelRock = new Playlist("Clasicos del Rock");
        clasicosDelRock.add(trackVector.elementAt(0));
        clasicosDelRock.add(trackVector.elementAt(1));
        clasicosDelRock.add(trackVector.elementAt(7));
        clasicosDelRock.add(trackVector.elementAt(8));
        clasicosDelRock.add(trackVector.elementAt(9));
        clasicosDelRock.add(trackVector.elementAt(11));
        Playlist loMejor = new Playlist("Lo mejor");
        loMejor.add(trackVector.elementAt(2));
        loMejor.add(trackVector.elementAt(3));
        loMejor.add(trackVector.elementAt(6));
        loMejor.add(trackVector.elementAt(11));
        Playlist coldplay = new Playlist("Coldplay");
        coldplay.add(trackVector.elementAt(4));
        coldplay.add(trackVector.elementAt(5));
        coldplay.add(trackVector.elementAt(6));
        Playlist elIndio = new Playlist("EL Indio");
        elIndio.add(trackVector.elementAt(10));
        elIndio.add(trackVector.elementAt(11));

        // Step 3 of the guide
        System.out.println("Step 3");
        System.out.println(clasicosDelRock);
        System.out.println(loMejor);
        System.out.println(coldplay);

        // Step 4 of the guide
        Playlist founds;

        // Step a
        System.out.println("Step 4");
        System.out.println("Step a");
        Comparator greaterThan = new Comparator(ComparatorMode.GREATER);
        DurationFilter graterThan400Seconds = new DurationFilter(400, greaterThan);
        founds = master.find(graterThan400Seconds);
        System.out.println(founds);
        founds.clear();

        // Step b
        System.out.println("Step b");
        GenreFilter containsRock = new GenreFilter("rock");
        founds = master.find(containsRock);
        System.out.println(founds);
        founds.clear();

        // Step c
        System.out.println("Step c");
        ArtistFilter artistLMFAO = new ArtistFilter("LMFAO");
        NotFilter notArtistLMFAO = new NotFilter(artistLMFAO);
        ArtistFilter artistRock = new ArtistFilter("rock");
        AndFilter andFilter = new AndFilter(artistRock, notArtistLMFAO);
        founds = master.find(andFilter);
        System.out.println(founds);
        founds.clear();

        // Step d
        System.out.println("Step d");
        YearFilter greaterThan2016 = new YearFilter(2006, greaterThan);
        ArtistFilter artistColdplay = new ArtistFilter("coldplay");
        AndFilter andFilter1 = new AndFilter(containsRock, greaterThan2016);
        AndFilter andFilter2 = new AndFilter(containsRock, artistColdplay);
        OrFilter orFilter = new OrFilter(andFilter1, andFilter2);
        founds = master.find(orFilter);
        System.out.println(founds);
        founds.clear();

        // Step 5
        System.out.println("Step 5");
        System.out.println(master.getName() + ": " + master.totalDuration());
        System.out.println(clasicosDelRock.getName() + ": " + clasicosDelRock.totalDuration());
        System.out.println(loMejor.getName() + ": " + loMejor.totalDuration());
        System.out.println(coldplay.getName() + ": " + coldplay.totalDuration());
        founds = master.find(graterThan400Seconds);
        System.out.println(founds.getName() + ": " + founds.totalDuration());
        founds.clear();

        // Step 6
        System.out.println("Step 6");
        Playlist loMejorMasMas = loMejor.copy();
        loMejorMasMas.setName("Lo mejor++");
        int pista3 = loMejorMasMas.indexOf(trackVector.elementAt(2));
        int pista7 = loMejorMasMas.indexOf(trackVector.elementAt(6));
        if (pista3 != -1 && pista7 != -1) {
            loMejorMasMas.swap(pista3, pista7);
        }
        System.out.println(loMejor);
        System.out.println(loMejorMasMas);

        // Step 7
        System.out.println("Step 7");
        AutomaticPlaylist todoLoDeColdplay = new AutomaticPlaylist("Todo lo de Coldplay", artistColdplay, master);
        System.out.println(todoLoDeColdplay);

        // Step 8
        System.out.println("Step 8");
        Track paradise = new Track(13, 365, 2011, "Paradise", "Coldplay", "Mylo Xyloto", "Rock alternativo", "comentario");
        trackVector.add(paradise);
        master.add(paradise);
        System.out.println(todoLoDeColdplay);
    }
}
