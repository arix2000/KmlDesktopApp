package com.example.externalDbOperations;

import com.example.GlobalVars;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

public class DbGetUserData extends ExternalDbHelper {
    private final String fileName = "getDataAboutUser.php";

    private String result;

    @Override
    public void run() {
        String address = BASE_URL + fileName;

        try {
            HttpURLConnection connection = setConnection(address);
            sendData(connection);
            result = readResult(connection);
        } catch (Exception e) {
            System.out.println("run: " + e.getMessage());
        }
    }

    private void sendData(HttpURLConnection connection) throws IOException {
        OutputStream outStream = connection.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outStream, "UTF-8"));
        String dataToSend = URLEncoder.encode("loginId", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(GlobalVars.loginId), "UTF-8");

        writer.write(dataToSend);
        writer.flush();
        writer.close();
        outStream.close();
    }

    public String getResult() {
        try {
            this.join();
        } catch (InterruptedException e) {
            System.out.println("getResult: " + e.getMessage());
        }
        return result;
    }
}


