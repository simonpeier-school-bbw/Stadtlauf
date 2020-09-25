import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ResultWriter {
    private FileWriter fileWriter;

    public void writeRankingList(String filename, List<Participant> participants) throws IOException {
        fileWriter = new FileWriter(filename + ".rl.txt");
        fileWriter.write("Rang\tStart-Nr.\tLaufzeit\tName" + System.lineSeparator());
        int rank = 1;

        for (Participant participant : participants) {
            participant.setRank(rank);
            fileWriter.write(rank + "\t" +
                    participant.getNumber() + "\t" +
                    participant.getMinutesAsString() + "\t" +
                    participant.getName() +
                    System.lineSeparator());
            rank++;
        }
        fileWriter.close();
    }

    public void writeNameList(List<Participant> participants) throws IOException {
        fileWriter = new FileWriter("namen.ref.txt");
        fileWriter.write("Startnummer\tName\tKategorie\tRang\tLaufzeit" + System.lineSeparator());

        for (Participant participant : participants) {
            fileWriter.write(participant.getNumber() + "\t" +
                    participant.getName() + "\t" +
                    participant.getCategory() + "\t" +
                    participant.getRank() + "\t" +
                    participant.getMinutesAsString() +
                    System.lineSeparator());
        }
        fileWriter.close();
    }
}