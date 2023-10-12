package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.fields.Comment;
import seedu.address.model.fields.Tag;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;

    // Data fields
    private final Address address;
    private final Attendance attendance;
    private final Set<Tag> tags = new HashSet<>();
    private final Set<Comment> comments = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Address address, Attendance attendance, Set<Tag> tags, Set<Comment> comments) {
        requireAllNonNull(name, phone, email, address, tags);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.tags.addAll(tags);
        this.comments.addAll(comments);
        this.attendance = attendance;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns an immutable comment set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Comment> getComments() {
        return Collections.unmodifiableSet(comments);
    }

    /**
     * Gets the student's attendance record.
     *
     * @return The `Attendance` object representing the student's attendance for a specific period.
     */
    public Attendance getAttendance() {
        return this.attendance;
    }

    /**
     * Retrieves the number of weeks the student was present based on their attendance record.
     *
     * @return The count of weeks for which the student was marked as present.
     */
    public int getWeeksPresent() {
        return this.attendance.getWeeksPresent();
    }

    /**
     * Retrieves the total number of weeks in the attendance record period.
     *
     * @return The total number of weeks in the period, typically 12 weeks.
     */
    public int getTotalWeeks() {
        return this.attendance.getTotalWeeks();
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return name.equals(otherPerson.name)
                && phone.equals(otherPerson.phone)
                && email.equals(otherPerson.email)
                && address.equals(otherPerson.address)
                && tags.equals(otherPerson.tags)
                && comments.equals(otherPerson.comments)
                && attendance.equals(otherPerson.attendance);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, tags, comments, attendance);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("phone", phone)
                .add("email", email)
                .add("address", address)
                .add("tags", tags)
                .add("comments", comments)
                .add("attendance", attendance)
                .toString();
    }

}
