package com.company.buildings.net.client;


import com.company.buildings.Building;
import com.company.buildings.Buildings;
import com.company.buildings.dwelling.DwellingFactory;
import com.company.buildings.hotel.HotelFactory;
import com.company.buildings.officeBuilding.OfficeFactory;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BinaryClient {
    static final int DWELLING = 10;
    static final int OFFICE_BUILDING = 11;
    static final int HOTEL = 12;

    public static void main(String[] args) {

        int buildingCount = 0;
        try (Socket socket = new Socket("192.168.0.105", 25069);
             FileReader fileBuildings = new FileReader("MyTxt1.txt")
        ) {
            ArrayList<String> lines = new ArrayList<>();
            Files.lines(Paths.get("typesOfBuildings.txt"), StandardCharsets.UTF_8).forEach(lines::add);
            new DataOutputStream(socket.getOutputStream()).writeInt(lines.size());
            for (String line :
                    lines
            ) {
                if (line.equals("Dwelling") == true) {
                    System.out.println(line);
                    Buildings.setBuildingFactory(new DwellingFactory());
                    new DataOutputStream(socket.getOutputStream()).writeInt(DWELLING);
                }
                if (line.equals("Hotel") == true) {
                    System.out.println(line);
                    Buildings.setBuildingFactory(new HotelFactory());
                    new DataOutputStream(socket.getOutputStream()).writeInt(HOTEL);
                }
                if (line.equals("OfficeBuilding") == true) {
                    System.out.println(line);
                    Buildings.setBuildingFactory(new OfficeFactory());
                    new DataOutputStream(socket.getOutputStream()).writeInt(OFFICE_BUILDING);
                }
                Buildings.outputBuilding(Buildings.readBuilding(fileBuildings), socket.getOutputStream());
                System.out.println("send building " + buildingCount);
                System.out.println("building " + buildingCount++ + " costs " + (new DataInputStream(socket.getInputStream())).readDouble() + "\n\n");
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
