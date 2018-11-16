package com.company.buildings;


import com.company.buildings.dwelling.DwellingFactory;


import java.io.*;
import java.util.Scanner;

public class Buildings{

    public static BuildingFactory buildingFactory = new DwellingFactory();

    public static void setBuildingFactory(BuildingFactory buildingFactory) {
        Buildings.buildingFactory = buildingFactory;
    }


    public static void outputBuilding(Building building, OutputStream out) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(out);
        dataOutputStream.writeInt(building.getFloorsCount());
        for (Floor floor :
                building.getFloors()
        ) {
            dataOutputStream.writeInt(floor.getSpacesCount());
            for (Space space :
                    floor.getSpaces()
            ) {
                dataOutputStream.writeInt(space.getRoomCount());
                dataOutputStream.writeDouble(space.getSquare());

            }
        }
    }


    public static Building inputBuilding(InputStream in) throws Exception {
        DataInputStream dataInputStream = new DataInputStream(in);
        int floorsCount = dataInputStream.readInt();
        Floor[] newFloors = new Floor[floorsCount];
        for(int i = 0; i < floorsCount ; i++){
            int spacesCount = dataInputStream.readInt();
            Space [] newSpaces = new Space[spacesCount];
            for (int j = 0 ; j < spacesCount ; j++){
                newSpaces[j] = buildingFactory.createSpace(dataInputStream.readInt(),dataInputStream.readDouble());
            }
            newFloors[i] = buildingFactory.createFloor(newSpaces);
        }
        return buildingFactory.createBuilding(newFloors);
    }



    public static void outMy (OutputStream out,InputStream in) throws IOException {
        System.out.print("Введите здание : ");
        Scanner scanner = new Scanner(in);
        DataOutputStream dataOutputStream = new DataOutputStream(out);
        int floorsCount =  scanner.nextInt();
        dataOutputStream.writeInt(floorsCount);
        int spacesCount = 0;
        for(int i = 0; i < floorsCount ; i++){
            System.out.print("введите этаж : ");
            spacesCount = scanner.nextInt();
            dataOutputStream.writeInt(spacesCount);
            for (int j = 0 ; j < spacesCount ; j++){
                System.out.print("введите офис : ");
                dataOutputStream.writeInt(scanner.nextInt());
                dataOutputStream.writeDouble(scanner.nextDouble());
            }
        }
    }

    public static void writeBuilding(Building building, Writer out) {
        PrintWriter printWriter = new PrintWriter(out);
        printWriter.print(building.getFloorsCount() + " ");
        for (Floor floor:
                building.getFloors()
        ) {
            printWriter.print(floor.getSpacesCount() + " ");
            for (Space space:
                    floor.getSpaces()
            ){
                printWriter.print(space.getRoomCount() + " " + space.getSquare() + " ");
            }
        }
    }

    public static Building readBuilding(Reader in) throws IOException{
        StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(in));
        Space[] newSpaces;
        if (streamTokenizer.nextToken() == StreamTokenizer.TT_NUMBER) {
            int floorsCount = (int) streamTokenizer.nval;
            Floor[] newFloors = new Floor[floorsCount];
            for (int i = 0; i < floorsCount; i++) {
                if (streamTokenizer.nextToken() == StreamTokenizer.TT_NUMBER) {
                    int spacesOnFloorCount = (int) streamTokenizer.nval;
                    newSpaces = new Space[spacesOnFloorCount];
                    for (int j = 0; j < spacesOnFloorCount; j++) {
                        int spaceRoomCount = 0;
                        double spaceSquare = 0;
                        if (streamTokenizer.nextToken() == StreamTokenizer.TT_NUMBER) {
                            spaceRoomCount = (int) streamTokenizer.nval;
                        }
                        if (streamTokenizer.nextToken() == StreamTokenizer.TT_NUMBER) {
                            spaceSquare = streamTokenizer.nval;
                        }
                        newSpaces[j] = buildingFactory.createSpace(spaceRoomCount, spaceSquare);
                    }
                    newFloors[i] = buildingFactory.createFloor(newSpaces);
                }
            }
            return buildingFactory.createBuilding(newFloors);
        }
        else return null;

    }

    public static void serializeBuilding(Building building, OutputStream out) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        objectOutputStream.writeObject(building);

    }

    public static Building deserializeBuilding(InputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(in);
        Building newBuilding = (Building)objectInputStream.readObject();
        return newBuilding;
    }


}
