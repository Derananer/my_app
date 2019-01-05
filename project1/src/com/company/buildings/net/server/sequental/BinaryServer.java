package com.company.buildings.net.server.sequental;

import com.company.buildings.Building;
import com.company.buildings.Buildings;
import com.company.buildings.dwelling.Dwelling;
import com.company.buildings.hotel.HotelBuilding;
import com.company.buildings.officeBuilding.OfficeBuilding;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BinaryServer {
    double costEstimate(Building building){
        double koef = 0;
        if(building instanceof Dwelling)koef = 1000;
        if(building instanceof OfficeBuilding)koef = 1500;
        if(building instanceof HotelBuilding)koef = 2000;
        return building.getTotalSquare() * koef;

    }
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket clientSocket = null;
        try {
            server = new ServerSocket(25069);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true) {
            try {
                clientSocket = server.accept();
                while(true){
                    Building testBuilding = Buildings.inputBuilding(clientSocket.getInputStream());
                    System.out.println(testBuilding.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
