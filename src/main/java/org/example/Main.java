package org.example;

import java.util.Scanner;


public class Main {

    static void main() {
        Simulation simulation = new Simulation();
        simulation.creat();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Запустить бесконечный цикл симуляции [1] Сделать один ход [2] Остановить симуляцию [3]: ");

        while (true) {

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> simulation.startSimulation();
                case "2" -> simulation.nextTurn();
                case "3" -> simulation.pauseSimulation(true);
                default -> System.out.println("Введите коректные значения!!!");
            }
        }


    }

}
