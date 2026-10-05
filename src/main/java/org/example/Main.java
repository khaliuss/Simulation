package org.example;

import java.util.Scanner;


public class Main {

    static void main() {
        Simulation simulation = new Simulation();
        simulation.creat();
        Scanner scanner = new Scanner(System.in);

        while (true){
            String choice = makeChoice(scanner);

            switch (choice){
                case  "1" -> simulation.startSimulation();
                case "2" -> simulation.pauseSimulation();
                case "3" -> simulation.nextTurn();
                default -> System.out.println("Введите коректные значения!!!");
            }
        }


    }

    private static String makeChoice(Scanner scanner){
        System.out.print("Запустить бесконечный цикл симуляции [1] Остановить симуляцию [2] сделать один ход [3]: ");
        return scanner.nextLine();
    }



}
