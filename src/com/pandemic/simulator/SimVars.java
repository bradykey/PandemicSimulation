package com.pandemic.simulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.pandemic.cities.CityEnum;

/**
 * A class containing the variables that define the simulation.
 * 
 * @author Brady
 */
public class SimVars {
	/* FINAL VARS REPRESENTING THE SIMULATION */
	public static final int MAX_TURNS = 60;
	public static final int INFECTION_RATE = 2;
	public static final int NUM_CITIES = 48;
	public static final int MAX_INFECTION_OF_CITY = 3;
	public static final int NUM_INITIALLY_INFECTED = 9;
	public static final int NUM_ACTIONS_PER_TURN = 4;
	public static final CityEnum START_CITY = CityEnum.ATLANTA; // CDC
	// used as a lookup table
	public static final List<CityEnum> CITY_ALPHA_ORDER_LIST = new ArrayList<CityEnum>(
			Arrays.asList(CityEnum.ALGIERS, CityEnum.ATLANTA, CityEnum.BAGHDAD,
					CityEnum.BANGKOK, CityEnum.BEIJING, CityEnum.BOGOTA,
					CityEnum.BUENOS_AIRES, CityEnum.CAIRO, CityEnum.CHENNAI,
					CityEnum.CHICAGO, CityEnum.DELHI, CityEnum.ESSEN,
					CityEnum.HO_CHI_MINH_CITY, CityEnum.HONG_KONG,
					CityEnum.ISTANBUL, CityEnum.JAKARTA, CityEnum.JOHANNESBURG,
					CityEnum.KARACHI, CityEnum.KHARTOUM, CityEnum.KINSHASA,
					CityEnum.KOLKATA, CityEnum.LAGOS, CityEnum.LIMA,
					CityEnum.LONDON, CityEnum.LOS_ANGELES, CityEnum.MADRID,
					CityEnum.MANILA, CityEnum.MEXICO_CITY, CityEnum.MIAMI,
					CityEnum.MILAN, CityEnum.MONTREAL, CityEnum.MOSCOW,
					CityEnum.MUMBAI, CityEnum.NEW_YORK, CityEnum.OSAKA,
					CityEnum.PARIS, CityEnum.RIYADH, CityEnum.SAN_FRANSISCO,
					CityEnum.SANTIAGO, CityEnum.SAO_PAULO, CityEnum.SEOUL,
					CityEnum.SHANGHAI, CityEnum.ST_PETERSBURG, CityEnum.SYDNEY,
					CityEnum.TAIPEI, CityEnum.TEHRAN, CityEnum.TOKYO,
					CityEnum.WASHINGTON));
}
