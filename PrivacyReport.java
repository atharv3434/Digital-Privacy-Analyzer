public class PrivacyReport {
    private String username;
    private String encryptedData;
    private int privacyScore;

    public PrivacyReport(String username, String encryptedData, int privacyScore) {
        this.username = username;
        this.encryptedData = encryptedData;
        this.privacyScore = privacyScore;
    }

    public String getUsername() { return username; }
    public String getEncryptedData() { return encryptedData; }
    public int getPrivacyScore() { return privacyScore; }

    @Override
    public String toString() {
        return "👤 User: " + username + " | 🔐 Privacy Score: " + privacyScore + "% | 📜 Encrypted Report Available";
    }
}
