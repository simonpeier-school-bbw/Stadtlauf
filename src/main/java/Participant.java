import java.time.Duration;
import java.time.LocalTime;

class Participant {
    private int number;
    private int category;
    private int rank;
    private String name;
    private LocalTime startTime;
    private LocalTime endTime;
    private Duration minutes;

    public Participant(int number, LocalTime endTime) {
        this.number = number;
        this.endTime = endTime;
    }

    public int getNumber() {
        return number;
    }

    public int getCategory() {
        return category;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Duration getMinutes() {
        return minutes;
    }

    public void setMinutes(Duration minutes) {
        this.minutes = minutes;
    }

    public String getMinutesAsString() {
        if (this.minutes == null) {
            return "null";
        } else {
            return this.minutes.toHoursPart() + ":" +
                    String.format("%02d", this.minutes.toMinutesPart()) + ":"
                    + String.format("%02d", this.minutes.toSecondsPart());
        }
    }

    @Override
    public String toString() {
        return "Participant{" +
                "number=" + number +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", minutes=" + getMinutesAsString() +
                '}';
    }
}
