import java.util.Scanner;

public class PrivacyApp {
    private static PrivacyAnalyzer privacyAnalyzer = new PrivacyAnalyzer();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🕵️‍♂️ Welcome to Digital Privacy Analyzer 🕵️‍♂️");

        while (true) {
            System.out.println("\n1. Perform Privacy Analysis");
            System.out.println("2. View Security Reports");
            System.out.println("3. Get Privacy Suggestions");
            System.out.println("4. Delete Security Report");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    privacyAnalyzer.performAnalysis();
                    break;
                case 2:
                    privacyAnalyzer.viewReports();
                    break;
                case 3:
                    privacyAnalyzer.getPrivacyTips();
                    break;
                case 4:
                    privacyAnalyzer.deleteReport();
                    break;
                case 5:
                    System.out.println("Exiting... Stay safe online! 🔐");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
}
