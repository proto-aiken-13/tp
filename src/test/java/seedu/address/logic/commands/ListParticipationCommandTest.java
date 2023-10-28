package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class ListParticipationCommandTest {
    private Model model;
    private ListParticipationCommand listParticipationCommand;

    @BeforeEach
    public void setUp() {
        model = new ModelManager();
    }

    @Test
    public void execute_validIndex_listParticipationSuccessful() throws CommandException {
        // Create a sample person with attendance and participation points
        Person person = new PersonBuilder()
                .withAttendance("1,0,1,0,1,0,1,0,1,0,1,0", "100,0,150,0,300,0,50,0,70,0,90,0",
                        "P,A,P,A,P,A,P,A,P,A,P,A")
                .build();

        // Add the sample person to the model
        model.addPerson(person);

        // Index 1 corresponds to the sample person
        int index = 1;

        // Create a new ListParticipationCommand
        listParticipationCommand = new ListParticipationCommand(Index.fromOneBased(index));

        // Execute the command
        String result = listParticipationCommand.execute(model).getFeedbackToUser();

        // Check if the result contains the person's name, attendance, and participation points
        assertTrue(result.contains("Tutorial 1: [X], Participation Points: [100]"));
        assertTrue(result.contains("Tutorial 2: [ ], Participation Points: [0]"));
        assertTrue(result.contains("Tutorial 3: [X], Participation Points: [150]"));
        assertTrue(result.contains("Tutorial 4: [ ], Participation Points: [0]"));
        assertTrue(result.contains("Tutorial 5: [X], Participation Points: [300]"));
        assertTrue(result.contains("Tutorial 6: [ ], Participation Points: [0]"));
        assertTrue(result.contains("Tutorial 7: [X], Participation Points: [50]"));
        assertTrue(result.contains("Tutorial 8: [ ], Participation Points: [0]"));
        assertTrue(result.contains("Tutorial 9: [X], Participation Points: [70]"));
        assertTrue(result.contains("Tutorial 10: [ ], Participation Points: [0]"));
        assertTrue(result.contains("Tutorial 11: [X], Participation Points: [90]"));
        assertTrue(result.contains("Tutorial 12: [ ], Participation Points: [0]"));
    }

    @Test
    public void execute_invalidIndex_throwsCommandException() {
        // Index 1 is invalid in an empty model
        int index = 1;

        // Create a new ListParticipationCommand
        listParticipationCommand = new ListParticipationCommand(Index.fromOneBased(index));

        // Execute the command and expect a CommandException
        assertThrows(CommandException.class, () -> listParticipationCommand.execute(model));
    }
}
