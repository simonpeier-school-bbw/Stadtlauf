import java.util.Comparator;

public class NameComparator implements Comparator<Participant> {
    @Override
    public int compare(final Participant p1, final Participant p2) {
        return p1.getName().compareTo(p2.getName());
    }
}
