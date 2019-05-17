package moran.structures;

import moran.filters.AndFilter;
import moran.filters.Filter;

import java.util.Vector;

public class AutomaticPlaylist extends Element {
    private Filter criteria;
    private Vector<Track> trackVector;

    public AutomaticPlaylist(String name, Filter criteria, Vector<Track> trackVector) {
        super(name);
        this.criteria = criteria;
        this.trackVector = trackVector;
    }

    @Override
    public int totalDuration() {
        int duration = 0;
        for (Track track : trackVector) {
            if (criteria.accept(track))
                duration += track.getDuration();
        }
        return duration;
    }

    @Override
    public int size() {
        int size = 0;
        for (Track track : trackVector) {
            if (criteria.accept(track))
                size++;
        }
        return size;
    }

    @Override
    public Vector<Element> find(Filter filter) {
        Vector<Element> result = new Vector<Element>();
        AndFilter aux = new AndFilter(this.criteria, filter);
        for (Track track : trackVector) {
            if (aux.accept(track))
                result.add(track);
        }
        return result;
    }

    @Override
    public Element copy() {
        return new AutomaticPlaylist(this.getName(), this.criteria, this.trackVector);
    }

}
