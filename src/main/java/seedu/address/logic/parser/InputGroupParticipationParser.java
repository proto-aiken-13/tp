package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PARTICIPATION_POINTS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIAL;

import java.util.stream.Stream;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.InputGroupParticipationCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Group;

/**
 * Parses input arguments and creates a new InputGroupParticipationCommand object
 */
public class InputGroupParticipationParser implements Parser<InputGroupParticipationCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the {@code InputGroupParticipationCommand}
     * and returns a {@code InputGroupParticipationCommand} object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public InputGroupParticipationCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_TUTORIAL,
                PREFIX_PARTICIPATION_POINTS);
        Group group;

        if (!arePrefixesPresent(argMultimap, PREFIX_TUTORIAL, PREFIX_PARTICIPATION_POINTS)) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, InputGroupParticipationCommand.MESSAGE_USAGE));
        }

        try {
            group = ParserUtil.parseGroup(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    InputGroupParticipationCommand.MESSAGE_USAGE), ive);
        }

        int tut = ParserUtil.parseTutorial(argMultimap.getValue(PREFIX_TUTORIAL).get());
        int points = ParserUtil.parseParticipationPoints(argMultimap.getValue(PREFIX_PARTICIPATION_POINTS).get());

        return new InputGroupParticipationCommand(group, Index.fromOneBased(tut), points);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
