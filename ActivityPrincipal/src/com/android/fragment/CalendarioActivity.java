package com.android.fragment;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.json.JSONException;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.util.Fechas;


public class CalendarioActivity extends Fragment implements OnClickListener {


	
	private Calendar _calendar;
	private int year ;
	private String month, day, campanha;
	private GridView calendarView;
	private CalendarAdapter adapter;
	private ImageView nextCampanha, prevCampanha;
	private Button selectedDayMonthYearButton;
		
	@Override
	public View onCreateView(LayoutInflater inflater,
	ViewGroup container, Bundle savedInstanceState) {
	View view = inflater.inflate(R.layout.calendar, container, false);	
		
		
		_calendar = Calendar.getInstance(Locale.getDefault());
		
		month = ""+(_calendar.get(Calendar.MONTH) + 1);
		year = _calendar.get(Calendar.YEAR);
		day = ""+(_calendar.get(Calendar.DAY_OF_MONTH));
		
		System.out.println("Calendar Instance:= " + "Day: "+day+ " Month: " + month + " " + "Year: " + year);
		
		calendarView = (GridView) view.findViewById(R.id.calendario);
		if(day.toString().length() == 1){
			day = "0"+day;
			System.out.println("day.... "+day);
		}
		if(month.toString().length() == 1){
			month = "0"+month;
			System.out.println("mes...."+month);
		}
		
		//String campana = (new Fechas()).obtenerCampanha(day+"/"+month+"/2012");
		campanha = (new Fechas()).obtenerCampanha(day+"/"+month+"/"+year);
		//campanha = campana.indexOf(1);
		
		System.out.println("LA campaña es en oncreate "+campanha);
		
		selectedDayMonthYearButton = (Button) view.findViewById(R.id.selectedDayMonthYear);
		selectedDayMonthYearButton.setText(campanha.toString());
		
		nextCampanha = (ImageView) view.findViewById(R.id.nextMonth);
		nextCampanha.setOnClickListener(this);
		
		
		prevCampanha = (ImageView) view.findViewById(R.id.prevMonth);
		prevCampanha.setOnClickListener(this);
		
		//adapter = new CalendarAdapter(getApplicationContext(), R.id.calendar_day_gridcell, campanha, year);
	
		adapter = new CalendarAdapter(getActivity(), R.id.calendar_day_gridcell, campanha, year);
		
		adapter.notifyDataSetChanged();
		calendarView.setAdapter(adapter);
		
		return view;
	}
	
	
	
	
	/**
	 * 
	 * @param month
	 * @param year
	 * @throws JSONException 
	 */
	private void setGridCellAdapterToDate(String campanha, int year) //throws JSONException
		{
			//adapter = new CalendarAdapter(getApplicationContext(), R.id.calendar_day_gridcell, campanha, year);
		adapter = new CalendarAdapter(getActivity(), R.id.calendar_day_gridcell, campanha, year);
			adapter.notifyDataSetChanged();
			calendarView.setAdapter(adapter);
		}
	
	
	@Override
	public void onClick(View v) {
		
		System.out.println("Entro al onClick");
		
		int evaluarCampana = Integer.parseInt(campanha.substring(1, 3));
		int anhoCampana = Integer.parseInt(campanha.substring(4));
		System.out.println("aaaaaaaaaaa  "+anhoCampana);
		//C01-2012 7
		int var1;
		if (v == prevCampanha)
		{
			if( evaluarCampana == 1){
				System.out.println("Integer.parseInt(campanha.substring(1, 3) "+Integer.parseInt(campanha.substring(1, 3)));
				campanha = "C13-"+(anhoCampana-1);
				selectedDayMonthYearButton.setText(campanha);
				year--;
			}
			else{
				
				var1 = Integer.parseInt(campanha.substring(1, 3)) - 1;
				System.out.println("(-)  Integer.parseInt(campanha.substring(1, 3)): "+Integer.parseInt(campanha.substring(1, 3)));
				if(var1 < 10){
					campanha = (String)"C0"+var1+"-"+anhoCampana;
					selectedDayMonthYearButton.setText(campanha);
				}else{
				campanha = (String)"C"+var1+"-"+anhoCampana;
				selectedDayMonthYearButton.setText(campanha);
				}
			}
			
			System.out.println("Campanha: "+campanha+ " anho: " + year);
			//try {
				setGridCellAdapterToDate(campanha, year);
			/*} catch (JSONException e) {
				System.out.println("ESTA MAL MI CONSUMIDOR DESDE ONCLICK 3");
				e.printStackTrace();
			}*/
			
		}
		
		
		int var;
		if (v == nextCampanha)
		{
			if (Integer.parseInt(campanha.substring(1, 3)) > 12)
				{
				System.out.println("Integer.parseInt(campanha.substring(1, 3)) "+Integer.parseInt(campanha.substring(1, 3)));
				campanha = "C01-"+(anhoCampana+1);
				year++;
				selectedDayMonthYearButton.setText(campanha);	
				}
			else
				{	var = Integer.parseInt(campanha.substring(1, 3)) + 1;
					System.out.println("Integer.parseInt(campanha.substring(1, 3)): "+Integer.parseInt(campanha.substring(1, 3)));
					if(var >9){
						campanha = (String)"C"+var+"-"+anhoCampana;
						selectedDayMonthYearButton.setText(campanha);
					}else{
					campanha = (String)"C0"+var+"-"+anhoCampana;
					selectedDayMonthYearButton.setText(campanha);
					}
				}
			
			System.out.println("Campanha: "+campanha+ " anho: " + year);
				setGridCellAdapterToDate(campanha, year);

		}
		
		
	}
	
	
	
	@Override
	public void onDestroy()
		{
			System.out.println("Destroying View ...");
			super.onDestroy();
		}
	
	public class CalendarAdapter extends BaseAdapter implements OnClickListener {

		String tag = "CalendarAdapter";
		Button gridcell;
		TextView txtMes;
		List<String> list;
		Context _context;
		private int currentDayOfMonth;
		private int currentWeekDay;
		private final HashMap eventsPerMonthMap;
		TextView num_events_per_day;
		Button campana;
		
	public CalendarAdapter(Context context, int textViewResourceId, String campana, int year) {//throws JSONException{
			
			super();
			this._context = context;
			this.list = new ArrayList<String>();

			
			String campanatemp = campana.substring(0, 3);
			
			if(!campana.equals("")){
			list = 	(new Fechas()).lstCalendarxCamapana(campana);
			}
			System.out.println("tamaño de la lista "+list.size());
			eventsPerMonthMap =findNumberOfEventsPerMonth(year, campanatemp);
			
		}
		
		private HashMap findNumberOfEventsPerMonth(int year, String campana)
		{	
			System.out.println("entro a findNumberOfEventsPerMonth");
			HashMap map = new HashMap<String, Integer>();
			return map;
		}
		
		@Override
		public long getItemId(int position) {
			System.out.println("en getItemID la position "+position);
			return position;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View row = convertView;
			
			if (row == null)
				{	System.out.println("Entramos al getView");
					LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
					row = inflater.inflate(R.layout.calendar_day_gridcell, parent, false);
				}

			// Get a reference to the Day gridcell
			gridcell = (Button) row.findViewById(R.id.calendar_day_gridcell);
			gridcell.setOnClickListener(this);
			
			txtMes = (TextView) row.findViewById(R.id.txtMes);
			

			// ACCOUNT FOR SPACING
			String[] day_color = list.get(position).split("-");
			String theday = day_color[0];
			String themonth = day_color[2];
			String theyear = day_color[3];
			if ((!eventsPerMonthMap.isEmpty()) && (eventsPerMonthMap != null))
			{
				if (eventsPerMonthMap.containsKey(theday))
					{	
						num_events_per_day = (TextView) row.findViewById(R.id.num_events_per_day);
						Integer numEvents = (Integer) eventsPerMonthMap.get(theday);
						num_events_per_day.setText(numEvents.toString());
					}
			}
			
			//set Button Campaña 
//			campana = (Button) row.findViewById(R.id.selectedDayMonthYear);
//			campana.setText("C02-2012");
			
			//Set the Month Gridcell
			txtMes.setText(themonth);
			txtMes.setTextColor(Color.BLACK);
			// Set the Day GridCell
			gridcell.setText(theday);
			gridcell.setTag(theday + "-" + themonth + "-" + theyear);
			Log.d(tag, "Setting GridCell " + theday + "-" + themonth + "-" + theyear);

			if (day_color[1].equals("GREY"))
				{
					//gridcell.setTextColor(Color.LTGRAY);
					gridcell.setTextColor(Color.BLACK);
				}
			if (day_color[1].equals("WHITE"))
				{
					gridcell.setTextColor(Color.BLACK);
				}
			if (day_color[1].equals("BLUE"))
				{
					gridcell.setTextColor(_context.getResources().getColor(R.color.static_text_color));
				}
			return row;
		}

		


		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			System.out.println("en getItem la position "+position);
			return list.get(position);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}


		
		@Override
		public void onClick(View view) {
			//Esta fecha la deseo enviar al fragment d ListaEventos
			System.out.println("Entramos a dar click a una fecha");
			String fechaEscogida = (String) view.getTag();
			System.out.println("FechaEscogida "+fechaEscogida);
			
		}

	}

	
	
	
	
	
}
