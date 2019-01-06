package com.company.buildings.net.server.sequental;

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
    static final int DWELLING = 10;
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
            try (OutputStreamWriter stdOutput = new OutputStreamWriter(System.out)) {
                clientSocket = server.accept();
               // clientInput = new DataInputStream(clientSocket.getInputStream());
                buildingsAmount = new DataInputStream(clientSocket.getInputStream()).readInt();
                System.out.println("buildings amount: " + buildingsAmount);
                int typeOfBuilding;
                for (int i = 0 ; i < buildingsAmount ; i++){
                    typeOfBuilding = new DataInputStream(clientSocket.getInputStream()).readInt();
                    if (typeOfBuilding == DWELLING) {
                        Buildings.setBuildingFactory(new DwellingFactory());
                    }
                    if (typeOfBuilding == HOTEL) {
                        Buildings.setBuildingFactory(new HotelFactory());
                    }
                    if (typeOfBuilding == OFFICE_BUILDING) {
                        Buildings.setBuildingFactory(new OfficeFactory());
                    }
                    Building testBuilding = Buildings.inputBuilding(clientSocket.getInputStream());
                    if(testBuilding instanceof OfficeBuilding)stdOutput.write("OfficeBuilding: ");
                    if(testBuilding instanceof Dwelling)stdOutput.write("Dwelling: ");
                    if(testBuilding instanceof HotelBuilding)stdOutput.write("Hotel: ");
                    Buildings.writeBuilding(testBuilding, stdOutput);
                    stdOutput.write("\n");
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                   // clientInput.close();
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
