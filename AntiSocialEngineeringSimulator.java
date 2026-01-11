import java.util.Scanner;

// Scenario class
class Scenario {
    private String description;
    private int correctChoice; // safe option number
    private String explanation;

    public Scenario(String description, int correctChoice, String explanation) {
        this.description = description;
        this.correctChoice = correctChoice;
        this.explanation = explanation;
    }

    public void showScenario() {
        System.out.println("\n⚠ SCENARIO:");
        System.out.println(description);
        System.out.println("1. Share information / Click link");
        System.out.println("2. Ignore and verify from official source");
        System.out.print("Choose option (1 or 2): ");
    }

    public boolean evaluate(int userChoice) {
        return userChoice == correctChoice;
    }

    public String getExplanation() {
        return explanation;
    }
}

// Main Simulator class
public class AntiSocialEngineeringSimulator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        System.out.println("🔐 ANTI-SOCIAL ENGINEERING SIMULATOR 🔐");
        System.out.println("--------------------------------------");

        // Scenario 1
        Scenario s1 = new Scenario(
            "You receive a call saying:\n\"I am calling from your bank. Please share your OTP to block suspicious activity.\"",
            2,
            "Banks never ask for OTP. Sharing OTP can lead to fraud."
        );

        // Scenario 2
        Scenario s2 = new Scenario(
            "You receive an email:\n\"Congratulations! You won a lottery. Click the link to claim now.\"",
            2,
            "Lottery scam emails use fake rewards to steal personal data."
        );

        // Scenario 3
        Scenario s3 = new Scenario(
            "You get a message:\n\"Your account will be blocked today. Update details immediately.\"",
            2,
            "Urgency is a common social engineering trick."
        );

        Scenario[] scenarios = { s1, s2, s3 };

        for (Scenario s : scenarios) {
            s.showScenario();
            int choice = sc.nextInt();

            if (s.evaluate(choice)) {
                System.out.println("✅ SAFE DECISION");
                score += 10;
            } else {
                System.out.println("❌ UNSAFE DECISION");
                System.out.println("ℹ Explanation: " + s.getExplanation());
            }
        }

        // Final result
        System.out.println("\n📊 FINAL AWARENESS SCORE: " + score + "/30");

        if (score >= 20) {
            System.out.println("🟢 You have GOOD cyber awareness.");
        } else {
            System.out.println("🔴 You need more awareness about cyber scams.");
        }

        System.out.println("\n✔ Simulation Completed. Stay Cyber Safe!");
        sc.close();
    }
}
