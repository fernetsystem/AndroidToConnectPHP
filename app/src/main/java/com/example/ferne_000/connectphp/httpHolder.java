package com.example.ferne_000.connectphp;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class httpHolder {

    public String post(String postUrl,String datoEnviado){

            //Creo que se queda vacia
            //solucion
            String loQueMeEnviaste = datoEnviado;
        try{

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(postUrl);


            //Agregar parametros
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("data","Mandaste a la BD:"));
            params.add(new BasicNameValuePair("info",loQueMeEnviaste));
            httpPost.setEntity(new UrlEncodedFormEntity(params));

            HttpResponse res = httpClient.execute(httpPost);
            HttpEntity ent = res.getEntity();

            String txt = EntityUtils.toString(ent);
            return txt;
        }
        catch(Exception er){
            return  "Error. "+er;
        }


    }
}