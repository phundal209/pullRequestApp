package example.pullrequest.com.pullrequestapp.ui.main;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by phundal on 11/3/17.
 */

public class FileUtilities {

    /**
     * Method to read contents of a file.
     * @param onFileReadHandler
     */
    public static void readFile(final String diffUrl, final IOnFileReadHandler onFileReadHandler) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(diffUrl);
                    URLConnection yc = url.openConnection();
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    yc.getInputStream()));
                    String inputLine;
                    StringBuilder builder = new StringBuilder();
                    while ((inputLine = in.readLine()) != null)
                        builder.append(inputLine.trim());
                    in.close();
                    String htmlPage = builder.toString();

                    onFileReadHandler.onRead(htmlPage);
                } catch (Exception ex) {
                    Log.e(FileUtilities.class.getSimpleName(), "unable to parse diff file", ex);
                    onFileReadHandler.onRead("");
                }
            }
        });
        thread.start();
    }

    public interface IOnFileReadHandler {
        void onRead(String fileOutput);
    }
}
