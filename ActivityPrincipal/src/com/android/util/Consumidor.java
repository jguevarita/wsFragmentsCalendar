package com.android.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.bean.FechaBean;

public class Consumidor {

	
	
	public List<FechaBean> obtenerLstCampanhas(String anho) throws JSONException {     
		 System.out.println("Entramos a Consumirrr");
		HttpClient httpclient = new DefaultHttpClient();     
		HttpPost httppost = new HttpPost("http://perms83.unique-yanbal.com:9080/WSIntegracionGeneralWeb/rest/WSConsultasCalendarios/consCampanhasMbl");      
		httppost.setHeader("content-type", "application/x-www-form-urlencoded");
		//String anho = "2013"; 
		List<FechaBean> lstCampanas = new ArrayList<FechaBean>();
		try {         
			//Añade las variables a enviar por post         
			List<NameValuePair> postValues = new ArrayList<NameValuePair>(2);  
			//String trama1= "{\"IntegracionWSReq\":{\"Cabecera\":{\"CodigoInterfaz\":\"CCAMPANHAS\",\"UsuarioAplicacion\":\"PruebaMobile\",\"CodigoAplicacion\":\"PAR\",\"CodigoPais\":\"PER\",\"CodigosPaisOD\":{\"CodigoPaisOD\":{\"Valor\":\"PER\"}}},\"Detalle\":{\"Parametros\":{\"Anho\":\"2012\"}}}}";
			String trama1= "{\"IntegracionWSReq\":{\"Cabecera\":{\"CodigoInterfaz\":\"CCAMPANHAS\",\"UsuarioAplicacion\":\"PruebaMobile\",\"CodigoAplicacion\":\"PAR\",\"CodigoPais\":\"PER\",\"CodigosPaisOD\":{\"CodigoPaisOD\":{\"Valor\":\"PER\"}}},\"Detalle\":{\"Parametros\":{\"Anho\":\""+anho+"\"}}}}";
			postValues.add(new BasicNameValuePair("trama", trama1));         
			postValues.add(new BasicNameValuePair("formato", "json"));         

			
			httppost.setEntity(new UrlEncodedFormEntity(postValues));          

			//Hace la petición         
			HttpResponse response = httpclient.execute(httppost);   
			String respStr = EntityUtils.toString(response.getEntity());
        	  	
        	JSONObject respJSON = new JSONObject(respStr);
        	JSONObject  IntegracionWSResp = respJSON.getJSONObject("IntegracionWSResp");
        	JSONObject  Detalle = IntegracionWSResp.getJSONObject("Detalle");
        	JSONObject  Respuesta = Detalle.getJSONObject("Respuesta");
        	JSONObject  Datos = Respuesta.getJSONObject("Datos");
        	
        	JSONArray  Campanhas = Datos.getJSONArray("Campanhas");

        	for(int i=0; i<Campanhas.length(); i++){
        		System.out.println("Contamos las Campanas "+Campanhas.length());
        		JSONObject objetos= new JSONObject(Campanhas.get(i).toString());
        		lstCampanas.add(new FechaBean(objetos.getString("NumeroCampanha"), objetos.getString("Anho"), objetos.getString("FechaInicio"), objetos.getString("FechaFin"), objetos.getString("SemanaAnualS1")));
        	}
        		
        	System.out.println("Recorriendo ListaCamapanas "+lstCampanas.size());
        	for (int i = 0; i < lstCampanas.size(); i++) {
        		System.out.println("Camapana-Anho: "+lstCampanas.get(i).getNroCampana()+"-"+lstCampanas.get(i).getAnho());
        		
			}
        	
        	
		} 
		catch (ClientProtocolException e) {         
			System.out.println("ClientProtocolException  "+e.toString());  
		} 
		catch (IOException e) {         
			System.out.println("IOException aaaaaaa "+e.toString());
		} 
		
		return lstCampanas;
		
	}	
	
}
