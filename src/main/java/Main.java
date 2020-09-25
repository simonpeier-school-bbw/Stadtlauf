import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Participant> participants = new ArrayList<>();
    private static List<Participant> juniors = new ArrayList<>();
    private static List<Participant> seniors = new ArrayList<>();
    private static List<Participant> elite = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.out.println("read files and add participants to list");
        ListReader listReader = new ListReader();
        listReader.readMessresultate(participants);
        listReader.readStartliste(participants);

        System.out.println("create a separate list for each category");
        splitUpLists();

        System.out.println("sort lists");
        juniors.sort(new DurationComparator());
        seniors.sort(new DurationComparator());
        elite.sort(new DurationComparator());
        participants.sort(new NameComparator());

        System.out.println("write results");
        ResultWriter resultWriter = new ResultWriter();
        resultWriter.writeRankingList("junioren", juniors);
        resultWriter.writeRankingList("senioren", seniors);
        resultWriter.writeRankingList("elite", elite);
        resultWriter.writeNameList(participants);
    }

    private static void splitUpLists() {
        for (Participant participant : participants) {
            switch (participant.getCategory()) {
                case 1:
                    juniors.add(participant);
                    break;
                case 2:
                    seniors.add(participant);
                    break;
                case 3:
                    elite.add(participant);
                    break;
                default:
            }
        }
    }
}