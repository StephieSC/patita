package com.example.stephie.prueba;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.DatagramPacket;
import java.net.UnknownHostException;

/**
 * Created by Pipos on 18-10-2016.
 */

public class Connection extends AsyncTask<Void, Void, Boolean>{
    private int duracion;
    private String address;
    private int port;
    public Socket socket;
    public DatagramPacket packet;
    public byte[]         buffer;
    public int            serverPort;
    public JSONObject status;
    String response;
    ProgressDialog dialog = null;
    Activity activity;

    public Connection(){
        duracion = -1;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = ProgressDialog.show(activity, "Esperando...", "Esperando Servidor...", true, true);
        //this method will be running on UI thread

    }
    @Override
    protected Boolean doInBackground(Void... params) {
        return connect();
    }

    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        dialog.dismiss();
        if (result){
            Toast.makeText(activity, "Logrado", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(activity, "Cancelado", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onCancelled() {
        // Make sure we clean up if the task is killed
        dialog.dismiss();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //terminateTask();
    }
    public Connection(int desafio1, Activity activity) {
        this.activity = activity;
        SharedPreferences preferencesCompat = PreferenceManager.getDefaultSharedPreferences(activity.getBaseContext());
        address = preferencesCompat.getString("ip_address","127.0.0.1");
        port = Integer.parseInt(preferencesCompat.getString("ip_port","80"));
        duracion = desafio1;
    }

    public boolean connect(){
        try{
            status = new JSONObject();
            status.put("Duracion", duracion);
            socket = new Socket(address, port);
            DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //response = inFromUser.readLine();
            outToServer.writeBytes(status.toString()+'\n');
            response = inFromServer.readLine();
            //response es lo que recibe
            System.out.println("FROM SERVER: " + response);
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
