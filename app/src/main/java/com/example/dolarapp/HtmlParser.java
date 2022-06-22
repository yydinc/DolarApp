package com.example.dolarapp;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
public class HtmlParser extends AsyncTask<Void,Void,Void> {

    private static Context context;
    private static String dolar;
    private static TextView txv;
    public HtmlParser(Context context) {
        this.context = context;
        dolar = "00";
    }
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            Element x;
            Document doc = Jsoup.connect("https://dovizborsa.com/doviz/dolar").get();
            Elements el = doc.getElementsByClass("-d2 _d2 _x19");
            dolar = el.get(1).text();
            System.out.println(dolar);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        setDolar();

    }
    public void setDolar(){
        MainActivity.textView.setText(dolar);

    }
}
