package com.android.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

public class Fechas {
	
	//private List<FechaBean>
	
		
	public List<FechaBean> lstFechas(String anho) {
		
		
		List<FechaBean> lstCole = new ArrayList<FechaBean>();
		
		if(anho.equals("2012")){
		lstCole.add(new FechaBean("C01", "2012", "02/01/2012", "29/01/2012", "1"));
		lstCole.add(new FechaBean("C02", "2012", "30/01/2012", "26/02/2012", "5"));
		lstCole.add(new FechaBean("C03", "2012", "27/02/2012", "25/03/2012", "9"));
		lstCole.add(new FechaBean("C04", "2012", "26/03/2012", "22/04/2012", "13"));
		lstCole.add(new FechaBean("C05", "2012", "23/04/2012", "20/05/2012", "17"));
		lstCole.add(new FechaBean("C06", "2012", "21/05/2012", "17/06/2012", "21"));
		lstCole.add(new FechaBean("C07", "2012", "18/06/2012", "15/07/2012", "25"));
		lstCole.add(new FechaBean("C08", "2012", "16/07/2012", "12/08/2012", "29"));
		lstCole.add(new FechaBean("C09", "2012", "13/08/2012", "09/09/2012", "33"));
		lstCole.add(new FechaBean("C10", "2012", "10/09/2012", "07/10/2012", "37"));
		lstCole.add(new FechaBean("C11", "2012", "08/10/2012", "04/11/2012", "41"));
		lstCole.add(new FechaBean("C12", "2012", "05/11/2012", "02/12/2012", "45"));
		lstCole.add(new FechaBean("C13", "2012", "03/12/2012", "31/12/2012", "49"));
		
		}
		
		if(anho.equals("2013")){
		lstCole.add(new FechaBean("C01", "2013", "01/01/2013", "28/01/2013", "1"));
		lstCole.add(new FechaBean("C02", "2013", "29/01/2013", "25/02/2013", "5"));
		lstCole.add(new FechaBean("C03", "2013", "26/02/2013", "26/03/2013", "9"));
		lstCole.add(new FechaBean("C04", "2013", "27/03/2013", "23/04/2013", "13"));
		lstCole.add(new FechaBean("C05", "2013", "24/04/2013", "19/05/2013", "17"));
		lstCole.add(new FechaBean("C06", "2013", "20/05/2013", "16/06/2013", "21"));
		lstCole.add(new FechaBean("C07", "2013", "17/06/2013", "14/07/2013", "25"));
		lstCole.add(new FechaBean("C08", "2013", "15/07/2013", "11/08/2013", "29"));
		lstCole.add(new FechaBean("C09", "2013", "12/08/2013", "08/09/2013", "33"));
		lstCole.add(new FechaBean("C10", "2013", "09/09/2013", "06/10/2013", "37"));
		lstCole.add(new FechaBean("C11", "2013", "07/10/2013", "05/11/2013", "41"));
		lstCole.add(new FechaBean("C12", "2013", "06/11/2013", "01/12/2013", "45"));
		lstCole.add(new FechaBean("C13", "2013", "02/12/2013", "30/12/2013", "49"));
		}
		
		return lstCole;
	}
	
	
	/*public List<String> lstMes(String fechaHoy){
		
		String tempAnho = fechaHoy.substring(6);		
		System.out.println("EL AÑO ES "+tempAnho);
		List<String> lstFechaxMes = new ArrayList<String>();
		List<FechaBean> lstFechaxAho = lstFechas(tempAnho);
		
		String fechInicio, fechFin;
		
		for(int i=0; i<lstFechaxAho.size(); i++){
			
			fechInicio = lstFechaxAho.get(i).getFechaInicio();
			fechFin = lstFechaxAho.get(i).getFechaFin();
			
			if((esAnterior(fechInicio, fechaHoy) && esPosterior(fechFin, fechaHoy)) || esMismoDia(fechInicio, fechFin, fechaHoy)){
				
				String diafi = fechInicio.substring(0, 2);
				String mesfi = fechInicio.substring(3, 5);
				String anhofi = fechInicio.substring(6);
				
				String diaff = fechFin.substring(0, 2);
				String mesff = fechFin.substring(3, 5);
				String anhoff = fechFin.substring(6);
				
				int diaMesFi = diasDelMes(Integer.parseInt(anhofi),Integer.parseInt(mesfi)-1);
				
				if(mesfi.equals(mesff)){
					for(int j= Integer.parseInt(diafi); j<=Integer.parseInt(diaff); j++){
						lstFechaxMes.add( j+ "-GREY" + "-" + nombreMes(mesfi) + "-" + anhofi);
					}
					System.out.println("\n");
				}
				else{
					for(int k=Integer.parseInt(diafi); k<=diaMesFi;k++){
						lstFechaxMes.add( k+ "-GREY" + "-" + nombreMes(mesfi) + "-" + anhofi);
						System.out.println(k);
					}
					for(int h= 1; h<=Integer.parseInt(diaff); h++ ){
						lstFechaxMes.add( h+ "-WHITE" + "-" + nombreMes(mesff) + "-" + anhoff);
					}
				}
				
				return lstFechaxMes;
				
			}
					
		}
		
		return lstFechaxMes;
		
	}*/
	
	
	public List<String> lstCalendarxCamapana(String campana){// throws JSONException{
		System.out.println("Entre a listar x Campana");
		
		String tempAnho = campana.substring(4);		
		System.out.println("EL AÑO ES "+tempAnho);
		
		
		campana = campana.substring(0, 3);
		
		List<String> lstFechaxCampana = new ArrayList<String>();
		List<FechaBean> lstFechaxAho = lstFechas(tempAnho);
		/*List<FechaBean> lstFechaxAho = new ArrayList<FechaBean>();
		try {
			lstFechaxAho = (new Consumidor()).obtenerLstCampanhas(tempAnho);
		} catch (JSONException e) {
			System.out.println("SE ha caido al obtener la Lsita de Camapanas");
			e.printStackTrace();
		}*/
		String fechInicio, fechFin;
		
		for(int i=0; i<lstFechaxAho.size(); i++){
			
			if(lstFechaxAho.get(i).getNroCampana().equals(campana)){
					System.out.println("Coincido la Campana");
				fechInicio = lstFechaxAho.get(i).getFechaInicio();
				fechFin = lstFechaxAho.get(i).getFechaFin();
				
				
				String diafi = fechInicio.substring(0, 2);
				String mesfi = fechInicio.substring(3, 5);
				String anhofi = fechInicio.substring(6);
				
				String diaff = fechFin.substring(0, 2);
				String mesff = fechFin.substring(3, 5);
				String anhoff = fechFin.substring(6);
				
				int diaMesFi = diasDelMes(Integer.parseInt(anhofi),Integer.parseInt(mesfi)-1);
				
				if(mesfi.equals(mesff)){
					for(int j= Integer.parseInt(diafi); j<=Integer.parseInt(diaff); j++){
						lstFechaxCampana.add( j+ "-GREY" + "-" + nombreMes(mesfi) + "-" + anhofi);
					}
					System.out.println("\n");
				}
				else{
					for(int k=Integer.parseInt(diafi); k<=diaMesFi;k++){
						lstFechaxCampana.add( k+ "-GREY" + "-" + nombreMes(mesfi) + "-" + anhofi);
						System.out.println(k);
					}
					for(int h= 1; h<=Integer.parseInt(diaff); h++ ){
						lstFechaxCampana.add( h+ "-WHITE" + "-" + nombreMes(mesff) + "-" + anhoff);
					}
				}
				
				return lstFechaxCampana;
				
			}
			
		}
		
		return lstFechaxCampana;
	}
	
	
	public String obtenerCampanha(String fecha){
		
		System.out.println("entramos a obtener campana");
		String tempAnho = fecha.substring(6);		
		System.out.println("EL AÑO ES "+tempAnho);
		
		List<FechaBean> lstFechaxAho = lstFechas(tempAnho);
		/*List<FechaBean> lstFechaxAho = new ArrayList<FechaBean>();
		try {
			lstFechaxAho = (new Consumidor()).obtenerLstCampanhas(tempAnho);
		} catch (JSONException e) {
			System.out.println("SE ha caido al obtener al OBTENERCamapanas");
			e.printStackTrace();
		}*/
		String campana="", anho="";
		String fechInicio, fechFin;
		
		for(int i=0; i<lstFechaxAho.size(); i++){
			
			fechInicio = lstFechaxAho.get(i).getFechaInicio();
			fechFin = lstFechaxAho.get(i).getFechaFin();
			if((esAnterior(fechInicio, fecha) && esPosterior(fechFin, fecha)) || esMismoDia(fechInicio, fechFin, fecha)){
			campana = lstFechaxAho.get(i).getNroCampana();
			anho = lstFechaxAho.get(i).getAnho();
			return campana+"-"+anho;
			//return campana;
			}
		}
		return campana+"-"+anho;
		//return campana;
	}
	
	
	
	
	public int diasDelMes (int anio, int mesBase0){
	     int dias = 31;
	     Calendar c = Calendar.getInstance();
	     c.set(anio, mesBase0, dias);
	     while (c.get(Calendar.MONTH) != mesBase0){
	         c.set(anio, mesBase0, --dias);
	     }
	     return dias;
	}
	
	public String nombreMes(String mes){
		String nomMes="";
		if(mes.equals("01")){
			nomMes = "ENE";
		}
		if(mes.equals("02")){
			nomMes = "FEB";
		}
		if(mes.equals("03")){
			nomMes = "MAR";
		}
		if(mes.equals("04")){
			nomMes = "ABR";
		}
		if(mes.equals("05")){
			nomMes = "MAY";
		}
		if(mes.equals("06")){
			nomMes = "JUN";
		}
		if(mes.equals("07")){
			nomMes = "JUL";
		}
		if(mes.equals("08")){
			nomMes = "AGO";
		}
		if(mes.equals("09")){
			nomMes = "SEP";
		}
		if(mes.equals("10")){
			nomMes = "OCT";
		}
		if(mes.equals("11")){
			nomMes = "NOV";
		}
		if(mes.equals("12")){
			nomMes = "DIC";
		}
		return nomMes;
	}
	
	public Date convertStrFecha(String strFecha){
		 SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
		 Date fecha = null;
		 try {

		     fecha = formatoDelTexto.parse(strFecha);
		 } catch (Exception ex) {
		     ex.printStackTrace();
		 }
		 return fecha;
		 
	}
	
	public boolean esAnterior(String fechaIni, String fechaHoy){
		
		boolean valor = false;
		if(convertStrFecha(fechaIni).before(convertStrFecha(fechaHoy))){
			valor = true;
		}	
		return valor;
	}

	public boolean esPosterior(String fechaFin, String fechaHoy){
		
		boolean valor = false;
		if(convertStrFecha(fechaFin).after(convertStrFecha(fechaHoy))){
			valor = true;
		}	
		return valor;
	}
	
	public boolean esMismoDia(String fechaIni, String fechaFin, String fechaHoy){
		
		boolean valor = false;
		if(convertStrFecha(fechaIni).equals(convertStrFecha(fechaHoy)) || convertStrFecha(fechaFin).equals(convertStrFecha(fechaHoy)) ){
			valor = true;
		}
		return valor;
	}

	


	
	
	
}
