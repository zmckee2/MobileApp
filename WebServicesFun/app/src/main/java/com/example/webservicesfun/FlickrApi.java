package com.example.webservicesfun;

import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

public class FlickrApi {
    static final String TAG = "WebServicesFunTag";
    static final String BASE_URL = "https://api.flickr.com/services/rest";
    static final String API_KEY = "1e62fea963ae2caf0854ae1be8fee7fd";

    MainActivity mainActivity; //For callbacks when async code has results

    public FlickrApi(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void fetchInterestingPhotos() {
        //Create request url
        String url = createInterestingPhotosUrl();
        Log.d(TAG, "fetchInterestingPhotos: " + url);
        //start background thread to complete request
        //we gotta make a subclass of AsyncTask
        //  Means doesn't wait, doesn't block
    }

    private String createInterestingPhotosUrl() {
        String url = BASE_URL;
        url += "?method=flickr.interestingness.getList";
        url += "&api_key=" + API_KEY;
        url += "&format=json";
        url += "&nojsoncallback=1";
        url += "&extras=date_taken,url_h";
        return url;
    }

    //Nested subclass of AsyncTask
    //The three parameterized types
    //1st: String - the argument to the doInBackground type (in our case the url)
    //2nd: Void - the argument for onProgressUpdate (in our case we're not publishing intermediate results)
    //      You could use this for something like a progress bar
    //3rd: The return type to doInBackground and argument to onPostExecute (our result type!)
    class FetchInterestingPhotosAsyncTask extends AsyncTask<String, Void, List<InterestingPhoto>>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Executes on the main UI thread
            //can update the UI in onPreExecute
            //runs before doInBackground
        }

        @Override
        protected List<InterestingPhoto> doInBackground(String... strings) {
            //runs on a background thread
            //cannot update UI on background thread
            return null;
        }

        @Override
        protected void onPostExecute(List<InterestingPhoto> interestingPhotos) {
            super.onPostExecute(interestingPhotos);
            //executes on main UI thread
            //runs after doInBackground
            //send interestingPhotos to main activity via a callback
        }
    }
}
