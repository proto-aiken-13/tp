package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.AssignmentCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.MarkAttendanceCommand;
import seedu.address.logic.commands.UnmarkAttendanceCommand;

/**
 * Controller for a help page
 */
public class HelpWindow extends UiPart<Stage> {

    public static final String USERGUIDE_URL = "https://ay2324s1-cs2103t-t12-1.github.io/tp/";
    public static final String SHOWING_HELP_MESSAGE =
            "Here are the list of commands:\n\n"
                    + "a. ADD COMMAND\n\n" + AddCommand.MESSAGE_USAGE + "\n\n"
                    + "b. CLEAR COMMAND\n\n" + ClearCommand.MESSAGE_USAGE + "\n\n"
                    + "c. DELETE COMMAND\n\n" + DeleteCommand.MESSAGE_USAGE + "\n\n"
                    + "d. EDIT COMMAND\n\n" + EditCommand.MESSAGE_USAGE + "\n\n"
                    + "e. EXIT COMMAND\n\n" + ExitCommand.MESSAGE_USAGE + "\n\n"
                    + "f. FIND COMMAND\n\n" + FindCommand.MESSAGE_USAGE + "\n\n"
                    + "g. HELP COMMAND\n\n" + HelpCommand.MESSAGE_USAGE + "\n\n"
                    + "h. LIST COMMAND\n\n" + ListCommand.MESSAGE_USAGE + "\n\n"
                    + "i. MARK ATTENDANCE COMMAND\n\n" + MarkAttendanceCommand.MESSAGE_USAGE + "\n\n"
                    + "j. UNMARK ATTENDANCE COMMAND\n\n" + UnmarkAttendanceCommand.MESSAGE_USAGE + "\n\n"
                    + "k. ASSIGN COMMAND\n\n" + AssignmentCommand.MESSAGE_USAGE + "\n\n";
    public static final String HELP_MESSAGE = "Refer to our website: " + USERGUIDE_URL;
    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);
    private static final String FXML = "HelpWindow.fxml";

    @FXML
    private Button copyButton;

    @FXML
    private Label helpMessage;

    /**
     * Creates a new HelpWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root) {
        super(FXML, root);
        helpMessage.setText(HELP_MESSAGE);
    }

    /**
     * Creates a new HelpWindow.
     */
    public HelpWindow() {
        this(new Stage());
    }

    /**
     * Shows the help window.
     * @throws IllegalStateException
     *     <ul>
     *         <li>
     *             if this method is called on a thread other than the JavaFX Application Thread.
     *         </li>
     *         <li>
     *             if this method is called during animation or layout processing.
     *         </li>
     *         <li>
     *             if this method is called on the primary stage.
     *         </li>
     *         <li>
     *             if {@code dialogStage} is already showing.
     *         </li>
     *     </ul>
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

    /**
     * Copies the URL to the user guide to the clipboard.
     */
    @FXML
    private void copyUrl() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(USERGUIDE_URL);
        clipboard.setContent(url);
    }

    /**
     * Opens the link to the user guide in the default browser.
     */
    @FXML
    private void openUrl() {
        UiUtil.open(USERGUIDE_URL);
    }
}
