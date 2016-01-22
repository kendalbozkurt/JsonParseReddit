package com.example.el_tayr.jsonparsereddit;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by El-tayr on 21.01.2016.
 */
public class AsyncTask extends android.os.AsyncTask<String,Void,Void>  {
     private JSONObject jSonTitles = null;
        String strJson = null;
    private static final String LOG_TAG = "KENDALLLLLL";
        @Override
        protected Void doInBackground(String... url) {

            strJson = getJsonFromUrl(url[0]);
            return null;
        }

        private String getJsonFromUrl(String strUrl) {
            String strJson = null;
            InputStream is = null;
            try {
                URL url = new URL(strUrl);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                is=urlConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"), 8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                is.close();
                strJson = sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
                strJson = null;
            }

            return strJson;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            try {
                jSonTitles = new JSONObject(strJson);
                 init();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        private List<Titles> getTitleListFromJson(JSONObject jSon){
            List<Titles> list = new ArrayList<Titles>();
            String tagData="data";
            String tagChildren="children";
            String tagDatain="data";
            String tagTitle="title";
            String tagUrl="url";
            String tagBlogType="link_flair_text";
            String tagUps="ups";
            Titles titleOb=null;
            try {
                JSONObject jsonTagData=jSon.getJSONObject(tagData);
                JSONArray jsonArrayChildren=jsonTagData.getJSONArray(tagChildren);
                int length = jsonArrayChildren.length();


                for (int i = 0; i < length; i++) {
                    JSONObject jSonBook = (JSONObject) jsonArrayChildren.get(i);
                    JSONObject jSonDatain =  jSonBook.getJSONObject(tagDatain);

                    String title = jSonDatain.getString(tagTitle);


                    String url = jSonDatain.getString(tagUrl);
                    String Blogtype=jSonDatain.getString(tagBlogType);
                    int ups=jSonDatain.getInt(tagUps);
                    titleOb=new Titles(title,url,Blogtype,ups);
                    list.add(titleOb);
                }

            }catch (Exception e){
            }
            return list;
        }

    private void init() {
        List<Titles> listTitle = getTitleListFromJson(jSonTitles);

        for (Titles title : listTitle) {
            Log.i(LOG_TAG, "title -> " + title.getTitle() + " | url -> " + title.getUrl()+
                    "| Blog Type ->"+title.getBlogType()+"| Ups ->"+title.getUps());
        }
    }


}
