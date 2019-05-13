package moran;

public class NotFilter implements Filter {
    private Filter filterOne;

    public NotFilter(Filter filter) {
        this.filterOne = filter;
    }

    @Override
    public boolean accept(Track track) {
        return !filterOne.accept(track);
    }
}
