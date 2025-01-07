import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class TriathlonResults {
    private String name;
    private String id;
    private int swimmingTime;
    private int cyclingTime;
    private int runningTime;

    public TriathlonResults(String name, String id, int swimmingTime, int cyclingTime, int runningTime) {
        this.name = name;
        this.id = id;
        setSwimmingTime(swimmingTime);
        setCyclingTime(cyclingTime);
        setRunningTime(runningTime);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getSwimmingTime() {
        return swimmingTime;
    }

    public void setSwimmingTime(int swimmingTime) {
        if (swimmingTime < 0) {
            throw new IllegalArgumentException("Swimming time cannot be negative.");
        }
        this.swimmingTime = swimmingTime;
    }

    public int getCyclingTime() {
        return cyclingTime;
    }

    public void setCyclingTime(int cyclingTime) {
        if (cyclingTime < 0) {
            throw new IllegalArgumentException("Cycling time cannot be negative.");
        }
        this.cyclingTime = cyclingTime;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        if (runningTime < 0) {
            throw new IllegalArgumentException("Running time cannot be negative.");
        }
        this.runningTime = runningTime;
    }

    public int calculateTotalTime() {
        return swimmingTime + cyclingTime + runningTime;
    }

    public void displayDetails() {
        System.out.println("Participant: " + name + ", ID: " + id + ", Total Time: " + calculateTotalTime() + " minutes");
    }
}

class EliteParticipant extends TriathlonResults {
    private String sponsorName;

    public EliteParticipant(String name, String id, int swimmingTime, int cyclingTime, int runningTime, String sponsorName) {
        super(name, id, swimmingTime, cyclingTime, runningTime);
        this.sponsorName = sponsorName;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Sponsor: " + sponsorName);
    }
}

class BeginnerParticipant extends TriathlonResults {
    public BeginnerParticipant(String name, String id, int swimmingTime, int cyclingTime, int runningTime) {
        super(name, id, swimmingTime, cyclingTime, runningTime);
    }
}

class Triathlon {
    public static void main(String[] args) {
        List<TriathlonResults> participants = new ArrayList<>();

        // Adding participants
        participants.add(new BeginnerParticipant("Alice", "001", 25, 40, 20));
        participants.add(new BeginnerParticipant("Bob", "002", 20, 35, 25));
        participants.add(new EliteParticipant("Charlie", "003", 30, 50, 30, "Nike"));
        participants.add(new BeginnerParticipant("Diana", "004", 28, 42, 18));

        // Calculate total times and display details
        for (TriathlonResults participant : participants) {
            participant.displayDetails();
        }

        // Sort participants by total time
        Collections.sort(participants, Comparator.comparingInt(TriathlonResults::calculateTotalTime));

        // Determine and print the fastest and second fastest participants
        if (!participants.isEmpty()) {
            TriathlonResults fastest = participants.get(0);
            System.out.println("\nFastest Participant: " + fastest.getName() + " with Total Time: " + fastest.calculateTotalTime() + " minutes");

            // Check for second fastest
            TriathlonResults secondFastest = null;
            for (int i = 1; i < participants.size(); i++) {
                if (participants.get(i).calculateTotalTime() != fastest.calculateTotalTime()) {
                    secondFastest = participants.get(i);
                    break;
                }
            }
            if (secondFastest != null) {
                System.out.println("Second Fastest Participant: " + secondFastest.getName() + " with Total Time: " + secondFastest.calculateTotalTime() + " minutes");
            } else {
                System.out.println("There is no distinct second fastest participant.");
            }
        }
    }
}