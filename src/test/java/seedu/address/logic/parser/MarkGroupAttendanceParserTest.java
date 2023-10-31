package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.MarkGroupAttendanceCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Attendance;

public class MarkGroupAttendanceParserTest {
    private static final String MESSAGE_INVALID_FORMAT =
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, MarkGroupAttendanceCommand.MESSAGE_USAGE);
    private MarkGroupAttendanceParser parser = new MarkGroupAttendanceParser();

    @Test
    public void parse_missingParts_failure() {
        // Test case 1: Missing group (preamble)
        String userInput1 = "t/1 s/P";
        assertParseFailure(parser, userInput1, MESSAGE_INVALID_FORMAT);

        // Test case 2: Missing week (tutorial)
        String userInput2 = "1 s/P";
        assertParseFailure(parser, userInput2, Attendance.TUTORIAL_ERROR_MSG);

        // Missing both group and tutorial
        assertParseFailure(parser, "", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidGroup_failure() {
        // Invalid group (not alphanumeric)
        assertParseFailure(parser, "t/1", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidTutorial_failure() {
        // Invalid tutorial (not a positive integer)
        assertParseFailure(parser, "Group1 t/a s/P", Attendance.TUTORIAL_ERROR_MSG);

        // Invalid tutorial (0)
        assertParseFailure(parser, "Group1 t/0 s/P", Attendance.TUTORIAL_ERROR_MSG);

        // Invalid tutorial (greater than 12)
        assertParseFailure(parser, "Group1 t/13 s/P", Attendance.TUTORIAL_ERROR_MSG);
    }

    @Test
    public void parse_invalidStatus_failure() {
        // Invalid status (Not a letter)
        assertParseFailure(parser, "Group1 t/1 s/1", Attendance.STATUS_ERROR_MSG);

        // Invalid status (Not recognised as a valid status)
        assertParseFailure(parser, "Group1 t/1 s/G", Attendance.STATUS_ERROR_MSG);

        // Invalid status (Unknown - Unmarked status, not one used for marking)
        assertParseFailure(parser, "Group1 t/1 s/U", Attendance.STATUS_ERROR_MSG);
    }

    @Test
    public void parse_validInput_success() throws ParseException {
        // Valid input
        assertParseSuccess(parser, "Group1 t/1 s/P", new MarkGroupAttendanceCommand(ParserUtil.parseGroup("Group1"),
                Index.fromOneBased(1), ParserUtil.parseParticipationStatus("P")));

        // Valid input with different indices and tutorial
        assertParseSuccess(parser, "Group2 t/5 s/P", new MarkGroupAttendanceCommand(ParserUtil.parseGroup("Group2"),
                Index.fromOneBased(5), ParserUtil.parseParticipationStatus("P")));
    }
}
