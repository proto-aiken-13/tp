package seedu.address.logic.commands;

import seedu.address.model.Model;

/**
 * Format full help instructions for every command for display.
 */
public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORD;

    public static final String SHOWING_HELP_MESSAGE =
            "Here are the list of commands:\n"
                    + "a. ADD COMMAND\n" + AddCommand.MESSAGE_USAGE + "\n"
                    + "b. CLEAR COMMAND\n" + ClearCommand.MESSAGE_USAGE + "\n"
                    + "c. DELETE COMMAND\n" + DeleteCommand.MESSAGE_USAGE + "\n"
                    + "d. EDIT COMMAND\n" + EditCommand.MESSAGE_USAGE + "\n"
                    + "e. EXIT COMMAND\n" + ExitCommand.MESSAGE_USAGE + "\n"
                    + "f. FIND COMMAND\n" + FindCommand.MESSAGE_USAGE + "\n"
                    + "g. HELP COMMAND\n" + HelpCommand.MESSAGE_USAGE + "\n"
                    + "h. LIST COMMAND\n" + ListCommand.MESSAGE_USAGE + "\n"
                    + "i. MARK ATTENDANCE COMMAND\n" + MarkAttendanceCommand.MESSAGE_USAGE + "\n"
                    + "j. UNMARK ATTENDANCE COMMAND\n" + UnmarkAttendanceCommand.MESSAGE_USAGE + "\n"
                    + "k. ASSIGN COMMAND\n" + AssignmentCommand.MESSAGE_USAGE + "\n";
    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(SHOWING_HELP_MESSAGE, true, false);
    }
}
