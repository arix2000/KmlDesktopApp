package com.example.externalDbOperations;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

public class DbChangePass extends ExternalDbHelper
{
    private final String fileName = "changePass.php";

    private String newPassword, oldPassword;
    private int loginId;
    private String toastText;
    private String result;

    public DbChangePass(String newPassword, String oldPassword, int loginId)
    {

        this.newPassword = newPassword;
        this.oldPassword = oldPassword;
        this.loginId = loginId;
    }

    @Override
    public void run()
    {
        super.run();
        String address = BASE_URL+fileName;

        try {

            HttpURLConnection conn = setConnection(address);
            sendData(conn);
            result = readResult(conn);

            if(result.equals("1"))
            {
                toastText = "Pomyślnie zmieniono hasło!";
            }
            else if(result.equals("0"))
            {
                toastText = "Coś poszło nie tak!";
            }
            else toastText = result;

        } catch (IOException e) {
            System.out.println("run: "+e.getMessage());
        }
    }

    private void sendData(HttpURLConnection conn) throws IOException
    {
        OutputStream outSteam = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outSteam,"UTF-8"));
        String dataToSend = URLEncoder.encode("newPassword","UTF-8")+"="+URLEncoder.encode(newPassword,"UTF-8")
                +"&&"+URLEncoder.encode("oldPassword","UTF-8")+"="+ URLEncoder.encode(oldPassword,"UTF-8")
                +"&&"+URLEncoder.encode("loginId","UTF-8")+"="+URLEncoder.encode(String.valueOf(loginId),"UTF-8");
        writer.write(dataToSend);
        writer.flush();
        writer.close(); outSteam.close();
    }

    public String getResult()
    {
        try {
            this.join();
        } catch (InterruptedException e) {
            System.out.println("getResult: "+e.getMessage());
        }
        return result;
    }
}
