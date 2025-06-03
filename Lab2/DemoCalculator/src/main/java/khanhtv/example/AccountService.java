package khanhtv.example;

import java.util.regex.Pattern;

public class AccountService {

    // Regex for email: <name>@<domain>.<tld>
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);


    public boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public boolean registerAccount(String username, String password, String email) {
        // Username should not null or empty
        if (username == null || username.trim().isEmpty()) {
            return false;
        }

        // Check if password is 6 length and not null
        if (password == null || password.length() <= 6) {
            return false;
        }

        // Check if email is valid
        if (!isValidEmail(email)) {
            return false;
        }

        // If everything is good to go
        return true;
    }
}
