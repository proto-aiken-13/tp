package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's assignment in the assignment book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAssignment(String)}
 */
public class Assignment {

    public static final String MESSAGE_CONSTRAINTS =
        "Assignments should only contain alphanumeric characters "
        + "and spaces, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String name;
    private int score;
    private int maxScore;

    /**
     * Constructs an assignment with the given name and maximum score.
     *
     * @param name The name of the assignment. Must not be null and must satisfy the constraints.
     * @param maxScore The maximum possible score for the assignment.
     * @throws NullPointerException If the provided name is null.
     * @throws IllegalArgumentException If the provided name does not satisfy the constraints.
     */
    public Assignment(String name, int maxScore) {
        requireNonNull(name);
        checkArgument(isValidAssignment(name), MESSAGE_CONSTRAINTS);
        this.name = name;
        this.maxScore = maxScore;
    }

    /**
     * Returns true if a given string is a valid email.
     */
    public static boolean isValidAssignment(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public int getScore() {
        return score;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    @Override
    public String toString() {
        return String.format("%s: %d/%d", name, score, maxScore);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Assignment)) {
            return false;
        }

        Assignment otherAssignment = (Assignment) other;
        return name.equals(otherAssignment.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
