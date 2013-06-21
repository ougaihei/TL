package meta_feature_mapping;

import java.util.ArrayList;

import meta_feature_building.Meta_feature_building;
import data.HouseData;

public class Test{
	
	public static void main(String[] args)
	{
		
		ArrayList<HouseData> data = new ArrayList<HouseData>();
		HouseData house1 = new HouseData("houseTest1");
		data.add(house1);		
		HouseData house2 = new HouseData("houseTest2");		
		data.add(house2);
		int [] alpha = {5, 5};
		int [] beta = {1400, 1400};
		Meta_feature_building.alpha_beta_clustering(data, alpha, beta);
		
//		int one_hour = 60*60;
		int two_hours = 60*60*2;
		Meta_feature_mapping map = new Meta_feature_mapping(two_hours, 5, 200);
		map.map_metafeatures_one_to_one_heuristic(data, 0);
		
		System.out.println("\n\nResults printing:\n house 1 \n");
		for(Integer sensor: house1.sensorList())
		{
			System.out.print(HouseData.sensorContainer(sensor).name + "\t\t");
			System.out.print(HouseData.sensorContainer(sensor).metacontainer.name + "\t\t");
			System.out.println(HouseData.sensorContainer(sensor).metacontainer.metacontainer.name + "\n");			
		}
		System.out.println("\n\n house 2 \n");
		for( Integer sensor: house2.sensorList())
		{
			System.out.print(HouseData.sensorContainer(sensor).name + "\t\t");
			System.out.print(HouseData.sensorContainer(sensor).metacontainer.name + "\t\t");
			System.out.println(HouseData.sensorContainer(sensor).metacontainer.metacontainer.name + "\n");
		}		
		
	}
}