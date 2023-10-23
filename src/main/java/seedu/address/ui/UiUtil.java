package seedu.address.ui;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class UiUtil {
    /**
     * Opens a link using the default web browser on the user's system.
     * @param url The URL to be opened in the web browser.
     */
    public static void open(String url) {
        String os = System.getProperty("os.name").toLowerCase();
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
