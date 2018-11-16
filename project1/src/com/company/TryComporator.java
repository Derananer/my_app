package com.company;

import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class TryComporator {
    class City {
            int population;
            String title;

            public City (int population, String title){
                this.population = population;
                this.title = title;
            }

            public int getPopulation() {
                return population;
            }

            public String getTitle() {
                return title;
            }
        }
        public void myFunc() {
            int n = 5;
            Scanner in = new Scanner(System.in);
            System.out.println("enter count of cities : ");
            n = in.nextInt();
            Random random = new Random();
            int popul;
            City arr[] = new City[n];
            for (int i = 0; i < arr.length; i++) {
                popul = random.nextInt(10000000);
                if (in.hasNextLine())
                arr[i] = new City(popul, in.nextLine());
            }

            class CityCompare implements Comparator<City> {

                @Override
                public int compare(City o1, City o2) {
                    return o2.getPopulation() - o1.getPopulation();
                }
            }

            CityCompare Comp = new CityCompare();

            java.util.Arrays.sort(arr, Comp);
            for (City i :
                    arr
            ) {
                System.out.println("Title : " + i.getTitle() + "\tPopulation : " + i.getPopulation());

            }
        }
}
