import java.util.Comparator;

public class DurationComparator implements Comparator<Participant> {
    @Override
    public int compare(final Participant p1, final Participant p2) {
        return p1.getMinutes().compareTo(p2.getMinutes());
    }
}
