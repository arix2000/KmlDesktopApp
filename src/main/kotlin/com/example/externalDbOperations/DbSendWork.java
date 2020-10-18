package com.example.externalDbOperations;

import com.example.GlobalVars;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

public class DbSendWork extends ExternalDbHelper
{
    private final String fileName = "updateCzasPracy.php";

    String workName;
    String workDescription;
    String firstName;
    String lastName;
    int minutes, hours;
    public boolean mResult;

    public DbSendWork(String workName, String workDescription, String name, String lastName, int minutes, int hours)
    {
        this.workName = workName;
        this.workDescription = workDescription;
        this.firstName = name;
        this.lastName = lastName;
        this.minutes = minutes;
        this.hours = hours;
    }

    @Override
    public void run()
    {
        mResult = false;
        float timeToSend;
        timeToSend = hours + (float) minutes / 60;
        timeToSend = roundToTwoDecimalPoint(timeToSend);

        String address = BASE_URL+fileName;;
        HttpURLConnection httpConnection = setConnection(address);
        try {
            sendData(httpConnection, timeToSend);
            mResult = readResult(httpConnection).equals("true");

        } catch (IOException e) {
            System.out.println("run: " + e.getMessage());
        }
    }

    private float roundToTwoDecimalPoint(float timeToSend)
    {
        timeToSend = timeToSend * 100;
        timeToSend = Math.round(timeToSend);
        timeToSend = timeToSend / 100;
        return timeToSend;
    }

    private void sendData(HttpURLConnection connection, float timeToSend) throws IOException
    {
        OutputStream outStream = connection.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outStream, "UTF-8"));

        String dataToSend = setDataToSend(timeToSend);

        writer.write(dataToSend);
        writer.flush();
        writer.close();
        outStream.close();

    }

    private String setDataToSend(float timeToSend) throws UnsupportedEncodingException
    {
        String workTimeExact = hours + "h " + minutes + "min";
        String dataToSend = URLEncoder.encode("czasPracy", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(timeToSend), "UTF-8")
                + "&&" + URLEncoder.encode("loginId", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(GlobalVars.loginId), "UTF-8")
                + "&&" + URLEncoder.encode("nazwaZadania", "UTF-8") + "=" + URLEncoder.encode(workName, "UTF-8")
                + "&&" + URLEncoder.encode("opisZadania", "UTF-8") + "=" + URLEncoder.encode(workDescription, "UTF-8")
                + "&&" + URLEncoder.encode("czasPracyDokladny", "UTF-8") + "=" + URLEncoder.encode(workTimeExact, "UTF-8")
                + "&&" + URLEncoder.encode("imie", "UTF-8") + "=" + URLEncoder.encode(firstName, "UTF-8")
                + "&&" + URLEncoder.encode("nazwisko", "UTF-8") + "=" + URLEncoder.encode(lastName, "UTF-8");
        return dataToSend;
    }

    public boolean getResult()
    {
        try {
            this.join();
        } catch (InterruptedException e) {
            System.out.println("getResult: " + e.getMessage());
        }
        return mResult;
    }

}
