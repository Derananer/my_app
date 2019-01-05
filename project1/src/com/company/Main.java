package com.company;

import com.company.buildings.*;
import com.company.buildings.officeBuilding.OfficeFactory;
import com.company.buildings.threads.MySemaphore;
import com.company.buildings.threads.SequentalCleaner;
import com.company.buildings.threads.SequentalRepairer;


import java.io.*;


public class Main {

    public static void main(String[] args) {
        //PrintWriter output = null;
        //Reader inputMyTxtFile = null;
        //PrintWriter errorOutput = null;
       // Writer outputNewTxtFile = null;
        try {
            FileReader inputMyTxtFile = new FileReader("myTxt.txt");
            Building building = Buildings.readBuilding(inputMyTxtFile);
            inputMyTxtFile.close();

            inputMyTxtFile = new FileReader("myTxt1.txt");
            Buildings.setBuildingFactory(new OfficeFactory());
            Building building1 = Buildings.readBuilding(inputMyTxtFile);
            inputMyTxtFile.close();

            MySemaphore semaphore1 = new MySemaphore(1);
            MySemaphore semaphore2 = new MySemaphore(0);

            System.out.println("hi");
            new Thread(new SequentalRepairer(building1,semaphore1,semaphore2)).start();
            new Thread(new SequentalCleaner(building1,semaphore2,semaphore1)).start();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Space space1 = new Flat(1,50.6);
        //Space space2 = new Flat(1, 50.601);
        //Space space3 = new Flat(1,50.6);
        //System.out.println("1: " + space1.equals(space2));
        //System.out.println("2: " + space1.equals(space3));
        //System.out.println("1: " + space1.equals(space2));
        /*try (BufferedWriter output =new BufferedWriter(new OutputStreamWriter(System.out));
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

        /*} catch (IOException e) {
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
        }*/

        // write your code here
    }
}
