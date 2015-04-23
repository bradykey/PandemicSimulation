package com.pandemic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.pandemic.cities.CityEnum;
import com.pandemic.simulator.Path;
import com.pandemic.simulator.SimVars;
import com.pandemic.simulator.Turn;
import com.pandemic.simulator.World;
import com.pandemic.simulator.GA.GAUtility;

/**
 * This class contains functions that collect data from the simulation.
 * 
 * @author Brady
 */
public class DataCollection {
	/**
	 * Figure 1: Show how quickly the disease spreads as you go through more
	 * turns of the game with no actions being played by a player. Print the
	 * results to a text file.
	 * 
	 * @param uninhibitedResult
	 *            the snapshots of the {@link World} at each {@link Turn}.
	 * 
	 * @param GAME_SEED
	 *            the {@code int} that is the seed used for this game.
	 */
	public static void saveDiseaseSpreadNoPlayer(List<World> uninhibitedResult,
			int GAME_SEED) {
		String fileName =
				"D:\\Programming\\Eclipse Workspace\\PandemicSimulation\\DataCollection\\Fig1\\TotalWorldInfectionPerTurnNoPlayer"
						+ GAME_SEED + ".txt";
		int currInfectionLevel;

		FileWriter writer;
		try {
			writer = new FileWriter(fileName);
			BufferedWriter bWriter = new BufferedWriter(writer);

			for (World world : uninhibitedResult) {
				currInfectionLevel = GAUtility.calcTotalInfectionLevel(world);

				bWriter.write("" + currInfectionLevel + "");
				bWriter.newLine();
			}

			bWriter.close();
		} catch (IOException e) {
			System.out.println("Error writing " + fileName + " to disk.");
			e.printStackTrace();
		}
	}

	/**
	 * Figure 2: Print the best fitness per generation.
	 * 
	 * @param bestFitnessPerGeneration
	 *            the {@code List<Integer>} that holds the fitness of the most
	 *            fit path at that generation.
	 */
	public static void saveBestFitnessPerGeneration(
			List<Integer> bestFitnessPerGeneration) {
		String fileName =
				"D:\\Programming\\Eclipse Workspace\\PandemicSimulation\\DataCollection\\Fig2\\BestFitnessPerGeneration"
						+ SimVars.NUM_ACTIONS_PER_TURN + "ActionsPerTurn.txt";

		FileWriter writer;
		try {
			writer = new FileWriter(fileName);
			BufferedWriter bWriter = new BufferedWriter(writer);

			for (Integer fitness : bestFitnessPerGeneration) {
				bWriter.write("" + fitness + "");
				bWriter.newLine();
			}

			bWriter.close();
		} catch (IOException e) {
			System.out.println("Error writing " + fileName + " to disk.");
			e.printStackTrace();
		}
	}

	/**
	 * Calculate the average infection level of each city over the entire
	 * {@link Path}.
	 * 
	 * @param pathResult
	 *            the {@code List<World>} that is the list of snapshots of the
	 *            world across the path.
	 * @param pathDescription
	 *            the {@code String} that is either "Best" or "Worst".
	 */
	public static void saveAvgInfectionLevelPerCity(List<World> pathResult,
			String pathDescription) {
		double algiersAIL = 0;
		double atlantaAIL = 0;
		double baghdadAIL = 0;
		double bangkokAIL = 0;
		double beijingAIL = 0;
		double bogotaAIL = 0;
		double buenosAiresAIL = 0;
		double cairoAIL = 0;
		double chennaiAIL = 0;
		double chicagoAIL = 0;
		double delhiAIL = 0;
		double essenAIL = 0;
		double hoChiMinhCityAIL = 0;
		double hongKongAIL = 0;
		double istanbulAIL = 0;
		double jakartaAIL = 0;
		double johannesburgAIL = 0;
		double karachiAIL = 0;
		double khartoumAIL = 0;
		double kinshasaAIL = 0;
		double kolkataAIL = 0;
		double lagosAIL = 0;
		double limaAIL = 0;
		double londonAIL = 0;
		double losAngelesAIL = 0;
		double madridAIL = 0;
		double manilaAIL = 0;
		double mexicoCityAIL = 0;
		double miamiAIL = 0;
		double milanAIL = 0;
		double montrealAIL = 0;
		double moscowAIL = 0;
		double mumbaiAIL = 0;
		double newYorkAIL = 0;
		double osakaAIL = 0;
		double parisAIL = 0;
		double riyadhAIL = 0;
		double sanFransiscoAIL = 0;
		double santiagoAIL = 0;
		double saoPauloAIL = 0;
		double seoulAIL = 0;
		double shanghaiAIL = 0;
		double stPetersburgAIL = 0;
		double sydneyAIL = 0;
		double taipeiAIL = 0;
		double tehranAIL = 0;
		double tokyoAIL = 0;
		double washingtonAIL = 0;

		for (World world : pathResult) {
			for (CityEnum cityEnum : world.getWorldMap().keySet()) {
				switch (cityEnum) {
				case ALGIERS:
					algiersAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case ATLANTA:
					atlantaAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case BAGHDAD:
					baghdadAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case BANGKOK:
					bangkokAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case BEIJING:
					beijingAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case BOGOTA:
					bogotaAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case BUENOS_AIRES:
					buenosAiresAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case CAIRO:
					cairoAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case CHENNAI:
					chennaiAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case CHICAGO:
					chicagoAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case DELHI:
					delhiAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case ESSEN:
					essenAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case HO_CHI_MINH_CITY:
					hoChiMinhCityAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case HONG_KONG:
					hongKongAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case ISTANBUL:
					istanbulAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case JAKARTA:
					jakartaAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case JOHANNESBURG:
					johannesburgAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case KARACHI:
					karachiAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case KHARTOUM:
					khartoumAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case KINSHASA:
					kinshasaAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case KOLKATA:
					kolkataAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case LAGOS:
					lagosAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case LIMA:
					limaAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case LONDON:
					londonAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case LOS_ANGELES:
					losAngelesAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case MADRID:
					madridAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case MANILA:
					manilaAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case MEXICO_CITY:
					mexicoCityAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case MIAMI:
					miamiAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case MILAN:
					milanAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case MONTREAL:
					montrealAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case MOSCOW:
					moscowAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case MUMBAI:
					mumbaiAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case NEW_YORK:
					newYorkAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case OSAKA:
					osakaAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case PARIS:
					parisAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case RIYADH:
					riyadhAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case SAN_FRANSISCO:
					sanFransiscoAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case SANTIAGO:
					santiagoAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case SAO_PAULO:
					saoPauloAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case SEOUL:
					seoulAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case SHANGHAI:
					shanghaiAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case ST_PETERSBURG:
					stPetersburgAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case SYDNEY:
					sydneyAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case TAIPEI:
					taipeiAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case TEHRAN:
					tehranAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case TOKYO:
					tokyoAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				case WASHINGTON:
					washingtonAIL +=
							world.getWorldMap().get(cityEnum)
									.getInfectionLevel();
					break;
				default:
					break;
				}
			}
		}

		// calculate the average over all the turns in the path
		algiersAIL /= (double) SimVars.MAX_TURNS;
		atlantaAIL /= (double) SimVars.MAX_TURNS;
		baghdadAIL /= (double) SimVars.MAX_TURNS;
		bangkokAIL /= (double) SimVars.MAX_TURNS;
		beijingAIL /= (double) SimVars.MAX_TURNS;
		bogotaAIL /= (double) SimVars.MAX_TURNS;
		buenosAiresAIL /= (double) SimVars.MAX_TURNS;
		cairoAIL /= (double) SimVars.MAX_TURNS;
		chennaiAIL /= (double) SimVars.MAX_TURNS;
		chicagoAIL /= (double) SimVars.MAX_TURNS;
		delhiAIL /= (double) SimVars.MAX_TURNS;
		essenAIL /= (double) SimVars.MAX_TURNS;
		hoChiMinhCityAIL /= (double) SimVars.MAX_TURNS;
		hongKongAIL /= (double) SimVars.MAX_TURNS;
		istanbulAIL /= (double) SimVars.MAX_TURNS;
		jakartaAIL /= (double) SimVars.MAX_TURNS;
		johannesburgAIL /= (double) SimVars.MAX_TURNS;
		karachiAIL /= (double) SimVars.MAX_TURNS;
		khartoumAIL /= (double) SimVars.MAX_TURNS;
		kinshasaAIL /= (double) SimVars.MAX_TURNS;
		kolkataAIL /= (double) SimVars.MAX_TURNS;
		lagosAIL /= (double) SimVars.MAX_TURNS;
		limaAIL /= (double) SimVars.MAX_TURNS;
		londonAIL /= (double) SimVars.MAX_TURNS;
		losAngelesAIL /= (double) SimVars.MAX_TURNS;
		madridAIL /= (double) SimVars.MAX_TURNS;
		manilaAIL /= (double) SimVars.MAX_TURNS;
		mexicoCityAIL /= (double) SimVars.MAX_TURNS;
		miamiAIL /= (double) SimVars.MAX_TURNS;
		milanAIL /= (double) SimVars.MAX_TURNS;
		montrealAIL /= (double) SimVars.MAX_TURNS;
		moscowAIL /= (double) SimVars.MAX_TURNS;
		mumbaiAIL /= (double) SimVars.MAX_TURNS;
		newYorkAIL /= (double) SimVars.MAX_TURNS;
		osakaAIL /= (double) SimVars.MAX_TURNS;
		parisAIL /= (double) SimVars.MAX_TURNS;
		riyadhAIL /= (double) SimVars.MAX_TURNS;
		sanFransiscoAIL /= (double) SimVars.MAX_TURNS;
		santiagoAIL /= (double) SimVars.MAX_TURNS;
		saoPauloAIL /= (double) SimVars.MAX_TURNS;
		seoulAIL /= (double) SimVars.MAX_TURNS;
		shanghaiAIL /= (double) SimVars.MAX_TURNS;
		stPetersburgAIL /= (double) SimVars.MAX_TURNS;
		sydneyAIL /= (double) SimVars.MAX_TURNS;
		taipeiAIL /= (double) SimVars.MAX_TURNS;
		tehranAIL /= (double) SimVars.MAX_TURNS;
		tokyoAIL /= (double) SimVars.MAX_TURNS;
		washingtonAIL /= (double) SimVars.MAX_TURNS;

		// save to file
		String fileName =
				"D:\\Programming\\Eclipse Workspace\\PandemicSimulation\\DataCollection\\Fig3\\AvgInfectionLvlPerCity"
						+ pathDescription + ".txt";

		FileWriter writer;
		try {
			writer = new FileWriter(fileName);
			BufferedWriter bWriter = new BufferedWriter(writer);

			bWriter.write("Algiers: " + algiersAIL + "");
			bWriter.newLine();
			bWriter.write("Atlanta: " + atlantaAIL + "");
			bWriter.newLine();
			bWriter.write("Baghdad: " + baghdadAIL + "");
			bWriter.newLine();
			bWriter.write("Bangkok: " + bangkokAIL + "");
			bWriter.newLine();
			bWriter.write("Beijing: " + beijingAIL + "");
			bWriter.newLine();
			bWriter.write("Bogota: " + bogotaAIL + "");
			bWriter.newLine();
			bWriter.write("Buenos Aires: " + buenosAiresAIL + "");
			bWriter.newLine();
			bWriter.write("Cairo: " + cairoAIL + "");
			bWriter.newLine();
			bWriter.write("Chennai: " + chennaiAIL + "");
			bWriter.newLine();
			bWriter.write("Chicago: " + chicagoAIL + "");
			bWriter.newLine();
			bWriter.write("Delhi: " + delhiAIL + "");
			bWriter.newLine();
			bWriter.write("Essen: " + essenAIL + "");
			bWriter.newLine();
			bWriter.write("Ho Chi Minh City: " + hoChiMinhCityAIL + "");
			bWriter.newLine();
			bWriter.write("Hong Kong: " + hongKongAIL + "");
			bWriter.newLine();
			bWriter.write("Istanbul: " + istanbulAIL + "");
			bWriter.newLine();
			bWriter.write("Jakarta: " + jakartaAIL + "");
			bWriter.newLine();
			bWriter.write("Johannesburg: " + johannesburgAIL + "");
			bWriter.newLine();
			bWriter.write("Karachi: " + karachiAIL + "");
			bWriter.newLine();
			bWriter.write("Khartoum: " + khartoumAIL + "");
			bWriter.newLine();
			bWriter.write("Kinshasa: " + kinshasaAIL + "");
			bWriter.newLine();
			bWriter.write("Kolkata: " + kolkataAIL + "");
			bWriter.newLine();
			bWriter.write("Lagos: " + lagosAIL + "");
			bWriter.newLine();
			bWriter.write("Lima: " + limaAIL + "");
			bWriter.newLine();
			bWriter.write("London: " + londonAIL + "");
			bWriter.newLine();
			bWriter.write("Los Angeles: " + losAngelesAIL + "");
			bWriter.newLine();
			bWriter.write("Madrid: " + madridAIL + "");
			bWriter.newLine();
			bWriter.write("Manila: " + manilaAIL + "");
			bWriter.newLine();
			bWriter.write("Mexico City: " + mexicoCityAIL + "");
			bWriter.newLine();
			bWriter.write("Miami: " + miamiAIL + "");
			bWriter.newLine();
			bWriter.write("Milan: " + milanAIL + "");
			bWriter.newLine();
			bWriter.write("Montreal: " + montrealAIL + "");
			bWriter.newLine();
			bWriter.write("Moscow: " + moscowAIL + "");
			bWriter.newLine();
			bWriter.write("Mumbai: " + mumbaiAIL + "");
			bWriter.newLine();
			bWriter.write("New York: " + newYorkAIL + "");
			bWriter.newLine();
			bWriter.write("Osaka: " + osakaAIL + "");
			bWriter.newLine();
			bWriter.write("Paris: " + parisAIL + "");
			bWriter.newLine();
			bWriter.write("Riyadh: " + riyadhAIL + "");
			bWriter.newLine();
			bWriter.write("San Fransisco: " + sanFransiscoAIL + "");
			bWriter.newLine();
			bWriter.write("Santiago: " + santiagoAIL + "");
			bWriter.newLine();
			bWriter.write("Sau Paulo: " + saoPauloAIL + "");
			bWriter.newLine();
			bWriter.write("Seoul: " + seoulAIL + "");
			bWriter.newLine();
			bWriter.write("Shanghai: " + shanghaiAIL + "");
			bWriter.newLine();
			bWriter.write("St. Petersburg: " + stPetersburgAIL + "");
			bWriter.newLine();
			bWriter.write("Sydney: " + sydneyAIL + "");
			bWriter.newLine();
			bWriter.write("Taipei:" + taipeiAIL + "");
			bWriter.newLine();
			bWriter.write("Tehran: " + tehranAIL + "");
			bWriter.newLine();
			bWriter.write("Tokyo: " + tokyoAIL + "");
			bWriter.newLine();
			bWriter.write("Washington: " + washingtonAIL + "");

			bWriter.close();
		} catch (IOException e) {
			System.out.println("Error writing " + fileName + " to disk.");
			e.printStackTrace();
		}
	}
}
