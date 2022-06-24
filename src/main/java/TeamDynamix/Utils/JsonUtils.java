package TeamDynamix.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class JsonUtils {

    public static void jsonPost(HttpURLConnection connection, String jsonString) throws IOException {
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
    }

    public static String jsonGet(HttpURLConnection connection) throws IOException {
        BufferedReader br;
        if (connection.getResponseCode() >= 100 && connection.getResponseCode() <= 399) {
            br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
        } else {
            br = new BufferedReader(new InputStreamReader(connection.getErrorStream(), "utf-8"));
        }
        StringBuilder responseBody = new StringBuilder();
        String responseLine;
        while ((responseLine = br.readLine()) != null) {
            responseBody.append(responseLine.trim());
        }

        br.close();

        return responseBody.toString();
    }
}
