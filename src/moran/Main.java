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
//        File file = new File("pistas.txt");
        Vector<Track> trackVector = new Vector<Track>();
//        Scanner sc = null;
//        try {
//            sc = new Scanner(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        sc.useDelimiter(";");
//        sc.nextLine();
//        sc.nextLine();
//        while (sc.hasNext()) {
//            int id = Integer.parseInt(sc.next());
//            String title = sc.next();
//            int duration = Integer.parseInt(sc.next());
//            String artist = sc.next();
//            String albumTitle = sc.next();
//            int year = Integer.parseInt(sc.next());
//            String genre = sc.next();
//            Track p1 = new Track(id, duration, year, title, artist, albumTitle, genre, "comentario");
//            //System.out.println(p1);
//            trackVector.add(p1);
//            master.add(p1);
//            sc.nextLine();
//        }
//        sc.close();
        Track t1 = new Track(1, 311, 2002, "El Tiempo No Para", "Bersuit Vergabarat", "De la cabeza", "Rock nacional", "comentario");
        trackVector.add(t1);
        master.add(t1);
        Track t2 = new Track(2, 290, 2002, "Mi caramelo", "Bersuit Vergabarat", "De la cabeza", "Rock nacional", "comentario");
        trackVector.add(t2);
        master.add(t2);
        Track t3 = new Track(3, 408, 2011, "Party Rock Anthem", "LMFAO", "Sorry for Party Rocking", "Electro pop", "comentario");
        trackVector.add(t3);
        master.add(t3);
        Track t4 = new Track(4, 421, 2011, "Sorry for Party Rocking", "LMFAO", "Sorry for Party Rocking", "Electro pop", "comentario");
        trackVector.add(t4);
        master.add(t4);
        Track t5 = new Track(5, 255, 2005, "Fix you", "Coldplay", "X&Y", "Rock alternativo", "comentario");
        trackVector.add(t5);
        master.add(t5);
        Track t6 = new Track(6, 455, 2005, "Speed of Sound", "Coldplay", "X&Y", "Rock alternativo", "comentario");
        trackVector.add(t6);
        master.add(t6);
        Track t7 = new Track(7, 320, 2008, "Viva la vida", "Coldplay", "Viva la vida", "Rock alternativo", "comentario");
        trackVector.add(t7);
        master.add(t7);
        Track t8 = new Track(8, 360, 1987, "Whit or whitout you", "U2", "The Joshua Tree", "Rock", "comentario");
        trackVector.add(t8);
        master.add(t8);
        Track t9 = new Track(9, 355, 2004, "Vertigo", "U2", "How to Dismantle an Atomic Bomb", "Rock", "comentario");
        trackVector.add(t9);
        master.add(t9);
        Track t10 = new Track(10, 284, 2004, "City of Blinding Lights", "U2", "How to Dismantle an Atomic Bomb", "Rock", "comentario");
        trackVector.add(t10);
        master.add(t10);
        Track t11 = new Track(11, 438, 2013, "A la luz de la luna", "El Indio Solari", "Pajaritos, bravos muchachitos", "Rock nacional", "comentario");
        trackVector.add(t11);
        master.add(t11);
        Track t12 = new Track(12, 258, 1993, "Yo Canibal", "Patricio rey y sus redonditos de ricota", "Lobo Suelto, Cordero atado", "Rock nacional", "comentario");
        trackVector.add(t12);
        master.add(t12);

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
