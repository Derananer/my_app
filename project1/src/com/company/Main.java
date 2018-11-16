package com.company;

import com.company.buildings.*;
import com.company.buildings.dwelling.Flat;
import com.company.buildings.hotel.HotelFactory;
import com.company.buildings.officeBuildings.Office;
import com.company.buildings.officeBuildings.OfficeFactory;
import com.company.buildings.officeBuildings.OfficeFloor;
import com.company.myExceptions.FloorIndexOutOfBoundsException;
import com.company.myExceptions.InexchangeableFloorsException;


import java.io.*;


public class Main {

    public static void main(String[] args) {
        //PrintWriter output = null;
        Reader inputMyTxtFile = null;
        //PrintWriter errorOutput = null;
       // Writer outputNewTxtFile = null;


        //Space space1 = new Flat(1,50.6);
        //Space space2 = new Flat(1, 50.601);
        //Space space3 = new Flat(1,50.6);
        //System.out.println("1: " + space1.equals(space2));
        //System.out.println("2: " + space1.equals(space3));
        //System.out.println("1: " + space1.equals(space2));
        try (BufferedWriter output =new BufferedWriter(new OutputStreamWriter(System.out));
             PrintWriter errorOutput = new PrintWriter(new FileWriter("errorLogFile.txt"))){

            PrintWriter printWriter = new PrintWriter(output);
            inputMyTxtFile = new FileReader("myTxt.txt");
            Building building = Buildings.readBuilding(inputMyTxtFile);
            inputMyTxtFile.close();

            inputMyTxtFile = new FileReader("myTxt1.txt");
            Buildings.setBuildingFactory(new HotelFactory());
            Building building1 = Buildings.readBuilding(inputMyTxtFile);
            inputMyTxtFile.close();

            printWriter.println(building.toString());
            printWriter.println(building1.toString());
            Buildings.serializeBuilding(building,new FileOutputStream("serialize1.bin"));
            Buildings.serializeBuilding(building1, new FileOutputStream("serialize2.bin"));
            Building building2 = Buildings.deserializeBuilding(new FileInputStream("serialize1.bin"));
            Building building3 = Buildings.deserializeBuilding(new FileInputStream("serialize2.bin"));
            printWriter.println(building.equals(building2));
            printWriter.println(building1.equals(building3));
            printWriter.println(building2.toString());
            printWriter.println(building3.toString());
            //output.close();
            /*System.out.print("\n" + building.getFloorsCount() + " ");
            for (Floor i:
                    building
                 ) {
                System.out.print(i.getSpacesCount() + " ");
                for (Space j:
                        i
                     ) {
                    System.out.print(j.getRoomCount() + " " + j.getSquare() + " ");
                }
            }*/

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try{
               // if(outputNewTxtFile !=null) outputNewTxtFile.close();
                if(inputMyTxtFile != null) inputMyTxtFile.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        // write your code here
    }
}
