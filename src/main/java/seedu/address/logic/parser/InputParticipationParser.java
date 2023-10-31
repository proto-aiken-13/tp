package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PARTICIPATION_POINTS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIAL;

import java.util.stream.Stream;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.InputParticipationCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new InputParticipationCommand object
 */
public class InputParticipationParser implements Parser<InputParticipationCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the {@code InputParticipationCommand}
     * and returns a {@code InputParticipationCommand} object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public InputParticipationCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_TUTORIAL,
                        PREFIX_PARTICIPATION_POINTS);
        Index index;

        if (!arePrefixesPresent(argMultimap, PREFIX_TUTORIAL, PREFIX_PARTICIPATION_POINTS)) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, InputParticipationCommand.MESSAGE_USAGE));
        }

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    InputParticipationCommand.MESSAGE_USAGE), ive);
        }

        int tut = ParserUtil.parseTutorial(argMultimap.getValue(PREFIX_TUTORIAL).get());
        int points = ParserUtil.parseParticipationPoints(
                argMultimap.getValue(PREFIX_PARTICIPATION_POINTS).get());

        return new InputParticipationCommand(index, Index.fromOneBased(tut), points);
    }


    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
