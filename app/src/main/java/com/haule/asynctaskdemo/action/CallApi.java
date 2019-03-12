package com.haule.asynctaskdemo.action;

import android.os.AsyncTask;
import android.util.Log;

import com.haule.asynctaskdemo.Callback;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

public class CallApi extends AsyncTask<String, Integer, String> {
    private Callback callback;

    public CallApi(Callback callback) {
        this.callback = callback;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        callback.onTaskCompleted(s);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            HttpGet httpGet = new HttpGet(strings[0]);
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(httpGet);

            int status = response.getStatusLine().getStatusCode();

            if (status == 200) {
                HttpEntity entity = response.getEntity();
                // Read the contents of an entity and return it as a String.
                return EntityUtils.toString(entity);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
