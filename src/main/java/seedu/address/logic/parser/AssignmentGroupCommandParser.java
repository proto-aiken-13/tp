package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MAX_SCORE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;

import java.util.stream.Stream;

import seedu.address.logic.commands.AssignmentGroupCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Group;
import seedu.address.model.person.Name;

/**
 * Parses input arguments and creates a new AssignmentGroupCommand object
 */
public class AssignmentGroupCommandParser implements Parser<AssignmentGroupCommand> {
    /**
     * Parses the given arguments and constructs an AssignmentGroupCommand object for execution.
     * @param args A string of arguments representing the assignmentGroup command.
     * @return An AssignmentGroupCommand for execution.
     * @throws ParseException If the user input does not conform to the expected format
     *     or if maxScore is not a positive integer.
     */
    public AssignmentGroupCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_MAX_SCORE);
        if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_MAX_SCORE)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AssignmentGroupCommand.MESSAGE_USAGE));
        }
        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_NAME, PREFIX_MAX_SCORE);
        Group group = ParserUtil.parseGroup(argMultimap.getPreamble());
        Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
        int maxScore = ParserUtil.parseInt(argMultimap.getValue(PREFIX_MAX_SCORE).get());

        if (maxScore <= 0) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AssignmentGroupCommand.MESSAGE_USAGE));
        }

        return new AssignmentGroupCommand(group, name, maxScore);
    }


    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
