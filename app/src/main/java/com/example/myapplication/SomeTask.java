package com.example.myapplication;


import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by cesarferreira on 22/05/14.
 * https://gist.github.com/cesarferreira/ef70baa8d64f9753b4da
 */
public class SomeTask extends AsyncTask<Void, Void, String> {

    private OnEventListener<String> mCallBack;
    private Context mContext;
    public Exception mException;


    public SomeTask(Context context, OnEventListener callback) {
        mCallBack = callback;
        mContext = context;
    }

    @Override
    protected String doInBackground(Void... params) {

        try {
            // todo try to do something dangerous
            return "HELLO";

        } catch (Exception e) {
            mException = e;
        }

        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        if (mCallBack != null) {
            if (mException == null) {
                mCallBack.onSuccess(result);
            } else {
                mCallBack.onFailure(mException);
            }
        }
    }
}
