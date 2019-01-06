package main;

import database.DataBaseOpera;
import regex.CheckImput;
import regex.Regular;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;


class Case {
    void occasion() {
        DataBaseOpera dbo = new DataBaseOpera();
        menu();
        int choice = Integer.parseInt(keyboard());
        while (choice != 4) {
            switch (choice) {
                case 1:
                    dbo.showAllInfo();
                    break;
                case 2:
                    try {
                        insertEnter();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        deleteEnter();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Попробуй еще раз, давай, от 1 до 4");
                    break;
            }
            System.out.println("\nDo you want something else? Press the number:");
            choice = Integer.parseInt(keyboard());
        }
    }


    private static void insertEnter() throws IOException {
        DataBaseOpera dbo = new DataBaseOpera();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите название добавляемой машины");
        String name = br.readLine();
        name = caseLoopString(name, "Введите название добавляемой машины,но нормально", br);
        System.out.println("Введите год выпуска добавляемой машины");
        String year = br.readLine();
        year = caseLoopInt(year, br);
        System.out.println(year);
        System.out.println("Введите цвет добавляемой машины");
        String color = br.readLine();
        color = caseLoopString(color, "Введите цвет добавляемой машины,но нормально", br);
        dbo.insertInfo(name, Integer.parseInt(year), color);
        System.out.println("Запись наверное добавлена");
    }

    private static void menu() {
        System.out.println("Крутой сервис по выбору машины");
        System.out.println("_______________________________________________________________________");
        System.out.println("1 - посмотреть все машины");
        System.out.println("2 - добавить желаемую машину");
        System.out.println("3 - не жми на удалить, но если нажмешь, то удаляй по любому параметру");
        System.out.println("4 - выход");
        System.out.println("_______________________________________________________________________");
        System.out.println("Lets do your choice:");

    }

    private static String keyboard() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String key = null;
        try {
            key = br.readLine();
            if (!key.matches(Regular.getYEARVALID())) {
                key = "0";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return key;
    }

    private static void deleteEnter() throws IOException {
        DataBaseOpera dbo = new DataBaseOpera();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите название машины, которую хотите удалить");
        if (br.readLine().matches(Regular.getSTRINGVALID())) {
            dbo.deleteInfo(br.readLine());
            System.out.println("Maybe it was deleted successful");
        } else {
            System.out.println("ВВедите нормально");
        }
    }

    private static String caseLoopString(String param, String line, BufferedReader br) throws IOException {
        while (Objects.equals(CheckImput.checkStringInput(param), "-1")) {
            System.out.println(line);
            param = br.readLine();
        }
        return param;
    }

    private static String caseLoopInt(String param, BufferedReader br) throws IOException {
        while (Objects.equals(CheckImput.checkIntInput(param), "-1")) {
            System.out.println("Введите год выпуска добавляемой машины, но нормально");
            param = br.readLine();
        }
        return param;
    }
}
