package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.fields.Comment;
import seedu.address.model.fields.Tag;
import seedu.address.model.person.Address;
import seedu.address.model.person.Attendance;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"),
                new Attendance("0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0"),
                getTagSet("friends"),
                getCommentSet("Is always cheerful")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                new Attendance("0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0"),
                getTagSet("colleagues", "friends"),
                getCommentSet("Loves candy")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                new Attendance("0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0"),
                getTagSet("neighbours"),
                getCommentSet("Never comes on time")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                new Attendance("0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0"),
                getTagSet("family"),
                getCommentSet("Needs constant attention")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"),
                new Attendance("0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0"),
                getTagSet("classmates"),
                getCommentSet("Pretty average")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"),
                new Attendance("0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0"),
                getTagSet("colleagues"),
                getCommentSet("Happy-go-lucky attitude"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Comment> getCommentSet(String... strings) {
        return Arrays.stream(strings)
                .map(Comment::new)
                .collect(Collectors.toSet());
    }
}
