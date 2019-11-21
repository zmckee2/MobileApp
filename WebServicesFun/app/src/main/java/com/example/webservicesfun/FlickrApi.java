package com.example.webservicesfun;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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
        FetchInterestingPhotosAsyncTask asyncTask = new FetchInterestingPhotosAsyncTask();
        asyncTask.execute(url);

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
            ProgressBar pb = mainActivity.findViewById(R.id.progressBar);
            pb.setVisibility(View.VISIBLE);
        }

        @Override                                       //Means you don't know how many arguments you have
        protected List<InterestingPhoto> doInBackground(String... strings) {
            //runs on a background thread
            //cannot update UI on background thread
            String urlStr = strings[0];
            List<InterestingPhoto> retList = new ArrayList<>();
            //goals
            // open the url and request a json response
            // download the json response
            // parse the json to create a list of interesting photos

            try{
                //Opening the URL
                URL url = new URL(urlStr);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                //Downloading the JSON as a string
                //build char by char
                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                String resultStr = "";
                int data = inputStreamReader.read();
                while(data != -1) {
                    resultStr += (char) data;
                    data = inputStreamReader.read();
                }
                Log.d(TAG, "doInBackground: " + resultStr);

                //Parse the JSON
                JSONObject json = new JSONObject(resultStr);
                JSONObject photos = json.getJSONObject("photos");
                JSONArray photoA = photos.getJSONArray("photo");
                for(int i = 0; i < photoA.length(); i++)
                {
                    JSONObject photo = photoA.getJSONObject(i);
                    InterestingPhoto iPhoto = parsePhoto(photo);
                    if(iPhoto != null)
                        retList.add(iPhoto);
                }
            } catch (MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return retList;
        }

        private InterestingPhoto parsePhoto(JSONObject photo)
        {
            InterestingPhoto ip = null;
            try {
                String id = photo.getString("id");
                String title = photo.getString("title");
                String dateTaken = photo.getString("datetaken");
                String photoUrl = photo.getString("url_h");
                ip = new InterestingPhoto(id, title, dateTaken, photoUrl);
            } catch (JSONException e) {
                //do nothing
            }
            return ip;
        }

        @Override
        protected void onPostExecute(List<InterestingPhoto> interestingPhotos) {
            super.onPostExecute(interestingPhotos);
            //executes on main UI thread
            //runs after doInBackground
            //send interestingPhotos to main activity via a callback
            Log.d(TAG, "onPostExecute: " + interestingPhotos);
            Log.d(TAG, "onPostExecute: " + interestingPhotos.size());

            ProgressBar pb = mainActivity.findViewById(R.id.progressBar);
            pb.setVisibility(View.GONE);

            mainActivity.recieveInteresingPhoto(interestingPhotos);
        }
    }
}
