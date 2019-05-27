package moran.structures;

import moran.filters.AndFilter;
import moran.filters.Filter;

public class AutomaticPlaylist extends Element {
    private Filter criteria;
    private Playlist playlist;

    public AutomaticPlaylist(String name, Filter criteria, Playlist playlist) {
        super(name);
        this.criteria = criteria;
        this.playlist = playlist;
    }

    @Override
    public int totalDuration() {
        return this.playlist.find(criteria).totalDuration();
    }

    @Override
    public int size() {
        return this.playlist.find(criteria).size();
    }

    @Override
    public Playlist find(Filter filter) {
        AndFilter aux = new AndFilter(this.criteria, filter);
        Playlist result = this.playlist.find(aux);
        return result;
    }

    @Override
    public Element copy() {
        return new AutomaticPlaylist(this.getName(), this.criteria, this.playlist);
    }

    @Override
    public String toString() {
        return this.playlist.find(criteria).toString();
    }
}
