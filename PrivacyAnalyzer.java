import java.util.*;

public class PrivacyAnalyzer {
    private List<PrivacyReport> reports;
    private Scanner sc;

    public PrivacyAnalyzer() {
        this.reports = ReportStorage.loadReports();
        this.sc = new Scanner(System.in);
    }

    public void performAnalysis() {
        System.out.print("Enter your username: ");
        String username = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        System.out.print("Do you reuse passwords on multiple sites? (yes/no): ");
        String reuse = sc.nextLine();
        System.out.print("Do you enable 2FA on your accounts? (yes/no): ");
        String twoFA = sc.nextLine();
        System.out.print("Do you share personal information on social media? (yes/no): ");
        String socialMedia = sc.nextLine();

        int score = SecurityAdvisor.calculatePrivacyScore(password, reuse, twoFA, socialMedia);
        String reportData = "Password Strength: " + SecurityAdvisor.getPasswordStrength(password) +
                "\nReused Passwords: " + reuse +
                "\nTwo-Factor Authentication: " + twoFA +
                "\nSocial Media Privacy: " + socialMedia +
                "\nPrivacy Score: " + score + "%";

        String encryptedData = CryptoUtil.encrypt(reportData);
        reports.add(new PrivacyReport(username, encryptedData, score));
        ReportStorage.saveReports(reports);
        System.out.println("✅ Privacy Analysis Completed! Score: " + score + "%");
    }

    public void viewReports() {
        if (reports.isEmpty()) {
            System.out.println("📄 No security reports found.");
            return;
        }

        System.out.println("\n🔐 Your Security Reports:");
        for (int i = 0; i < reports.size(); i++) {
            System.out.println((i + 1) + ". " + reports.get(i));
        }

        System.out.print("\nEnter report number to decrypt and view: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < reports.size()) {
            String decryptedData = CryptoUtil.decrypt(reports.get(index).getEncryptedData());
            System.out.println("\n📜 Decrypted Security Report:\n" + decryptedData);
        } else {
            System.out.println("❌ Invalid selection.");
        }
    }

    public void getPrivacyTips() {
        System.out.println("\n🤖 AI Privacy Tips:");
        System.out.println(SecurityAdvisor.getPrivacyAdvice());
    }

    public void deleteReport() {
        viewReports();
        System.out.print("Enter report number to delete: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < reports.size()) {
            reports.remove(index);
            ReportStorage.saveReports(reports);
            System.out.println("✅ Security Report Deleted Successfully!");
        } else {
            System.out.println("❌ Invalid selection.");
        }
    }
}
