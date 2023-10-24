package seedu.address.ui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;

/**
 * Utility class for UI components.
 */
public class UiUtil {
    /**
     * Opens a link using the default web browser on the user's system.
     * @param url The URL to be opened in the web browser.
     */
    private static final Logger logger = Logger.getLogger(UiUtil.class.getName());
    public static void open(String url) {
        String os = System.getProperty("os.name").toLowerCase();
        assert !os.equals("");
        logger.info("Opening link: " + url);

        try {
            if (os.contains("win") || os.contains("mac")) {
                Desktop.getDesktop().browse(new URI(url));
            } else if (os.contains("nix") || os.contains("nux") || os.contains("linux")) {
                Runtime.getRuntime().exec("xdg-open " + url);
            } else {
                // We do not support other operating systems.
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
