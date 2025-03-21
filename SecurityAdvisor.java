import java.util.Random;

public class SecurityAdvisor {
    public static int calculatePrivacyScore(String password, String reuse, String twoFA, String socialMedia) {
        int score = 100;

        if (password.length() < 8 || !password.matches(".*[!@#$%^&*].*")) score -= 30;
        if (reuse.equalsIgnoreCase("yes")) score -= 20;
        if (twoFA.equalsIgnoreCase("no")) score -= 20;
        if (socialMedia.equalsIgnoreCase("yes")) score -= 30;

        return Math.max(score, 0);
    }

    public static String getPasswordStrength(String password) {
        if (password.length() < 8) return "Weak";
        if (password.matches(".*[!@#$%^&*].*")) return "Strong";
        return "Moderate";
    }

    public static String getPrivacyAdvice() {
        String[] tips = {
                "🔐 Use unique passwords for every account.",
                "🔑 Enable two-factor authentication (2FA) for all accounts.",
                "📵 Be mindful of the personal information you share online.",
                "🛡 Regularly update your passwords to prevent breaches.",
                "🕵️ Use a VPN to protect your browsing activity."
        };
        return tips[new Random().nextInt(tips.length)];
    }
}
