import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class ListReader {
    private BufferedReader reader;

    public void readMessresultate(List<Participant> list) throws IOException {
        try {
            reader = new BufferedReader(new FileReader(Objects.requireNonNull(Main.class.getClassLoader().getResource("messresultate.txt")).getFile()));
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                String[] lineParts = line.split("\\t");

                int startnumber = Integer.parseInt(lineParts[0]);
                LocalTime endTime = LocalTime.parse(lineParts[1], DateTimeFormatter.ofPattern("HH:mm:ss"));

                list.add(new Participant(startnumber, endTime));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found, please enter a valid filepath");
            throw e;
        } catch (IOException e) {
            System.out.println("There was an error with reading a line");
            throw e;
        }
    }

    public void readStartliste(List<Participant> list) {
        try {
            reader = new BufferedReader(new FileReader(Objects.requireNonNull(Main.class.getClassLoader().getResource("startliste.txt")).getFile()));
            String line;

            while ((line = (reader.readLine())) != null) {
                line = line.trim();
                String[] lineParts = line.split("\\t");

                int startnumber = Integer.parseInt(lineParts[0]);
                int category = Integer.parseInt(lineParts[1]);
                String name = lineParts[2];
                LocalTime startTime;
                switch (category) {
                    case 1:
                        startTime = LocalTime.parse("14:00:00");
                        break;
                    case 2:
                        startTime = LocalTime.parse("14:15:00");
                        break;
                    case 3:
                        startTime = LocalTime.parse("15:00:00");
                        break;
                    default:
                        throw new IllegalStateException("Invalid category: " + category);
                }

                for (Participant participant : list) {
                    if (participant.getNumber() == startnumber) {
                        participant.setCategory(category);
                        participant.setName(name);
                        participant.setStartTime(startTime);
                        participant.setMinutes(Duration.between(participant.getStartTime(), participant.getEndTime()));
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found, please enter a valid filepath");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("There was an error with reading a line");
            e.printStackTrace();
        }
    }
}
