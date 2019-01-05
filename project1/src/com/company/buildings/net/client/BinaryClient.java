package com.company.buildings.net.client;


import com.company.buildings.Building;
import com.company.buildings.Buildings;
import com.company.buildings.dwelling.DwellingFactory;
import com.company.buildings.hotel.HotelFactory;
import com.company.buildings.officeBuilding.OfficeFactory;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class BinaryClient {
    public static void main(String[] args) {
        FileReader fileBuildings = null;
        try (Socket socket = new Socket("localhost", 25069);
                BufferedReader typesOfBuildings = new BufferedReader(new FileReader("typesOfBuildings.txt"))
                ){
            fileBuildings = new FileReader("MyTxt1.txt");
            ArrayList<Building> buildings = new ArrayList<>();
            String line = typesOfBuildings.readLine();
            while(line != null) {
                if (line.equals("Dwelling") == true){
                    System.out.println(line);
                    Buildings.setBuildingFactory(new DwellingFactory());
                }
                if (line.equals("Hotel") == true){
                    System.out.println(line);
                    Buildings.setBuildingFactory(new HotelFactory());
                }
                if (line.equals("OfficeBuilding") == true){
                    System.out.println(line);
                    Buildings.setBuildingFactory(new OfficeFactory());
                }
                buildings.add(Buildings.readBuilding(fileBuildings));
                System.out.println(buildings.get(buildings.size()-1).toString());
                line = typesOfBuildings.readLine();
            }
            for (Building i:
                    buildings
                 ) {
                Buildings.outputBuilding(i, socket.getOutputStream());
            }



            /*
            fileWriter = new FileWriter("client.txt");
            fileBuildings = new FileReader("MyTxt1.txt");

            Building testBuilding = Buildings.readBuilding(bufferedReader);
            Building testBuilding1 = Buildings.readBuilding(bufferedReader);
            System.out.println(testBuilding.toString());
            System.out.println(testBuilding1.toString());*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
