package meta_feature_mapping;

import java.util.ArrayList;

import meta_feature_building.Meta_feature_building;
import data.HouseData;

public class Test{
	
	public static final String[] houseNames = {"A", "B", "C", "D", "E"};
	public static final int nrHouses = houseNames.length;
	public static final String houseNamePrefix = "house";
	public static final int [] alpha = {5, 5,5,5,5};
	public static int [] beta = {14, 7,7,10,12};
	
	public static void main(String[] args)
	{
		
		ArrayList<HouseData> housesData = new ArrayList<HouseData>();
		
		for (String houseName : houseNames) {
			HouseData h = new HouseData(houseNamePrefix + houseName);
			housesData.add(h);
		}
		
		
		Meta_feature_building.alpha_beta_clustering(housesData, alpha, beta);
		
//		int one_hour = 60*60;
		int two_hours = 60*60*2;
		Meta_feature_mapping map = new Meta_feature_mapping(two_hours, 5, 200);
		map.map_metafeatures_one_to_one_heuristic(housesData, 0); //2nd param. is index houseData 
		
		System.out.println("\n\nResults printing:\n house 1 \n");
		
		for (HouseData houseData : housesData) {
			System.out.println("House: "+ houseData.houseName);
			
			for(Integer sensor: houseData.sensorList())
			{
				System.out.print(HouseData.sensorContainer(sensor).name + "\t\t");
				System.out.print(HouseData.sensorContainer(sensor).metacontainer.name + "\t\t");
				System.out.println(HouseData.sensorContainer(sensor).metacontainer.metacontainer.name + "\n");			
			}
		}
	
		for (HouseData houseData : housesData) {
			houseData.formatLena(HouseData.MAPPING_LEVEL_METAMETAFEATURE, HouseData.MAPPING_LEVEL_METAMETAFEATURE);
		}
	}
}