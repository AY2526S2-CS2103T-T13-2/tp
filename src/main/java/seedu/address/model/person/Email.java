package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's email in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidEmail(String)}
 * Format: Exactly one "@" with no spaces, at least one character before and after the "@".
 */
public class Email {

    public static final String MESSAGE_CONSTRAINTS = "Invalid email format. Example: student@domain.com";

    public final String value;

    /**
     * Constructs an {@code Email}.
     * Leading and trailing spaces are trimmed.
     *
     * @param email A valid email address.
     */
    public Email(String email) {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        checkArgument(isValidEmail(trimmedEmail), MESSAGE_CONSTRAINTS);
        value = trimmedEmail;
    }

    /**
     * Returns if a given string is a valid email.
     * Exactly one "@", no spaces, at least one char before and after "@".
     */
    public static boolean isValidEmail(String test) {
        if (test == null) {
            throw new NullPointerException();
        }
        if (test.isEmpty()) {
            return false;
        }
        if (test.contains(" ")) {
            return false;
        }
        int atIndex = test.indexOf('@');
        if (atIndex == -1 || test.indexOf('@', atIndex + 1) != -1) {
            return false; // No @ or multiple @
        }
        return atIndex > 0 && atIndex < test.length() - 1;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Email)) {
            return false;
        }

        Email otherEmail = (Email) other;
        return value.equals(otherEmail.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
