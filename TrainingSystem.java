import java.util.*;

class Participant {
    int id;
    String name;
    String program;
    boolean attendance;

    Participant(int id, String name, String program) {
        this.id = id;
        this.name = name;
        this.program = program;
        this.attendance = false;
    }

    void markAttendance() {
        attendance = true;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name +
                ", Program: " + program +
                ", Attendance: " + (attendance ? "Present" : "Absent"));
    }
}

public class TrainingSystem {
    static ArrayList<Participant> participants = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Training Program System ---");
            System.out.println("1. Register Participant");
            System.out.println("2. Mark Attendance");
            System.out.println("3. View Participants");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    registerParticipant();
                    break;
                case 2:
                    markAttendance();
                    break;
                case 3:
                    viewParticipants();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    static void registerParticipant() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Training Program: ");
        String program = sc.nextLine();

        participants.add(new Participant(id, name, program));
        System.out.println("Participant Registered Successfully!");
    }

    static void markAttendance() {
        System.out.print("Enter Participant ID: ");
        int id = sc.nextInt();

        for (Participant p : participants) {
            if (p.id == id) {
                p.markAttendance();
                System.out.println("Attendance Marked!");
                return;
            }
        }
        System.out.println("Participant not found!");
    }

    static void viewParticipants() {
        if (participants.isEmpty()) {
            System.out.println("No participants found.");
            return;
        }

        for (Participant p : participants) {
            p.display();
        }
    }
}