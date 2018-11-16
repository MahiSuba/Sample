package com.example.mahendranm.sampletrue.AsyncCall;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;


import com.example.mahendranm.sampletrue.Activity.MainActivity;

import java.io.InputStream;

public class AsyncService extends AsyncTask<Void, String, String> {

    Context contect;
    Activity activity;
    String result;

    public AsyncService(Context contect, Activity activity) {
        this.contect = contect;
        this.activity = activity;
    }

    @Override
    protected String doInBackground(Void... voids) {
        String json = null;

        try {
            InputStream is = contect.getAssets().open("ResponseJson.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return json;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        ((MainActivity)contect).sendResponse(s);

    }
}
