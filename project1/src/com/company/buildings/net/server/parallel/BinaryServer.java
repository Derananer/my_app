package com.company.buildings.net.server.parallel;

import com.company.buildings.Building;
import com.company.buildings.Buildings;
import com.company.buildings.dwelling.Dwelling;
import com.company.buildings.dwelling.DwellingFactory;
import com.company.buildings.hotel.HotelBuilding;
import com.company.buildings.hotel.HotelFactory;
import com.company.buildings.officeBuilding.OfficeBuilding;
import com.company.buildings.officeBuilding.OfficeFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class BinaryServer {
   /* static final int DWELLING = 10;
    static final int OFFICE_BUILDING = 11;
    static final int HOTEL = 12;

    double costEstimate(Building building){
        double koef = 0;
        if(building instanceof Dwelling)koef = 1000;
        if(building instanceof OfficeBuilding)koef = 1500;
        if(building instanceof HotelBuilding)koef = 2000;
        return building.getTotalSquare() * koef;

    }
    public static void main(String[] args) {
        Socket clientSocket = null;
        ServerSocket server = null;
        DataInputStream clientInput = null;
        int buildingsAmount = 0;
        int [] typesOfBuildings;
        ArrayList<Building> buildings = new ArrayList<>();
        try {
            server = new ServerSocket(25069);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true) {
            try {
                clientSocket = server.accept();
                System.out.println("Client connect.");
                // clientInput = new DataInputStream(clientSocket.getInputStream());
                buildingsAmount = new DataInputStream(clientSocket.getInputStream()).readInt();
                System.out.println("buildings amount: " + buildingsAmount);
                int typeOfBuilding;
                for (int i = 0 ; i < buildingsAmount ; i++){
                    typeOfBuilding = new DataInputStream(clientSocket.getInputStream()).readInt();
                    if (typeOfBuilding == DWELLING) {
                        Buildings.setBuildingFactory(new DwellingFactory());
                        System.out.print("Type Dwelling was read. ");
                    }
                    if (typeOfBuilding == HOTEL) {
                        Buildings.setBuildingFactory(new HotelFactory());
                        System.out.print("Type Hotel was read. ");
                    }
                    if (typeOfBuilding == OFFICE_BUILDING) {
                        Buildings.setBuildingFactory(new OfficeFactory());
                        System.out.print("Type OfficeBuilding was read. ");
                    }
                    Building testBuilding = Buildings.inputBuilding(clientSocket.getInputStream());
                    System.out.println("Building was read.");
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    System.out.println("Client disconnect.\n\n");
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
*/
}
