import Controller.*;
import Model.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        List<Comite> comites = new ArrayList<>();
        List<Donante> donantes = new ArrayList<>();
        List<EncuestaSatisfaccion> encuestas = new ArrayList<>();
        List<PartidoPolitico> partidos = new ArrayList<>();

        ComiteController comiteController = new ComiteController(comites, new View.ComiteView());
        DonanteController donanteController = new DonanteController(donantes, new View.DonanteView());
        EncuestaSatisfaccionController encuestaSatisfaccionController =
                new EncuestaSatisfaccionController(encuestas, new View.EncuestaSatisfaccionView());
        PartidoPoliticoController partidoPoliticoController =
                new PartidoPoliticoController(partidos, new View.PartidoPoliticoView());
        printWelcomeMessage();
        while (!exit) {
            printMainMenu();
            int choice = getUserChoice(scanner);
            switch (choice) {
                case 1:
                    comiteMenu(scanner, comiteController);
                    break;
                case 2:
                    donanteMenu(scanner, donanteController);
                    break;
                case 3:
                    encuestaSatisfaccionMenu(scanner, encuestaSatisfaccionController);
                    break;
                case 4:
                    partidoPoliticoMenu(scanner, partidoPoliticoController);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting program.");
    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printMainMenu() {
        clearScreen();
        System.out.println("+-------------------------------+");
        System.out.println("|         Menú Principal        |");
        System.out.println("+-------------------------------+");
        System.out.println("| 1. Operaciones de comite      |");
        System.out.println("| 2. Operaciones de donante     |");
        System.out.println("| 3. Operaciones de encuesta    |");
        System.out.println("|    de satisfacción            |");
        System.out.println("| 4. Operaciones de partido     |");
        System.out.println("|    político                   |");
        System.out.println("| 0. Salir                      |");
        System.out.println("+-------------------------------+");
    }

    private static int getUserChoice(Scanner scanner) {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void comiteMenu(Scanner scanner, ComiteController comiteController) {
        boolean back = false;

        while (!back) {
            printComiteMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    comiteController.createComite(createComiteFromUserInput(scanner));
                    break;
                case 2:
                    comiteController.listComites();
                    break;
                case 3:
                    filterComitesByObjective(scanner, comiteController);
                    break;
                case 4:
                    deleteComite(scanner, comiteController);
                    break;
                case 5:
                    updateComite(scanner, comiteController);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printWelcomeMessage() {
        System.out.println("+------------------------------------------------+");
        System.out.println("|                    BIENVENIDO                  |");
        System.out.println("+------------------------------------------------+");
        System.out.println("| *** SISTEMA DE REGISTRO DE FIRMAS DIGITALES*** |");
        System.out.println("+------------------------------------------------+\n");
    }


    private static void printComiteMenu() {
        System.out.println("+-------------------------------+");
        System.out.println("|        Menú de Comités        |");
        System.out.println("+-------------------------------+");
        System.out.println("| 1. Crear Comité              |");
        System.out.println("| 2. Listar Comités            |");
        System.out.println("| 3. Filtrar por Objetivo      |");
        System.out.println("| 4. Eliminar Comité           |");
        System.out.println("| 5. Actualizar Comité         |");
        System.out.println("| 0. Volver                    |");
        System.out.println("+-------------------------------+");
    }

    private static void filterComitesByObjective(Scanner scanner, ComiteController comiteController) {
        System.out.print("Enter objective to filter by: ");
        String objective = scanner.next();
        comiteController.filterComitesByObjective(objective);
    }

    private static void deleteComite(Scanner scanner, ComiteController comiteController) {
        System.out.print("Enter Comite Name to delete: ");
        String nameToDelete = scanner.next();
        comiteController.deleteComite(comiteController.findComiteByName(nameToDelete));
    }

    private static void updateComite(Scanner scanner, ComiteController comiteController) {
        comiteController.listComites();
        System.out.print("\nEnter Comite Name to update: ");
        scanner.nextLine(); // Consume the newline character
        String nameToUpdate = scanner.nextLine();
        Comite comiteToUpdate = comiteController.findComiteByName(nameToUpdate);
        if (comiteToUpdate != null) {
            System.out.print("Enter new Name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new Objective: ");
            String newObjective = scanner.nextLine();

            comiteController.updateComite(comiteToUpdate, newObjective, newName);
        } else {
            System.out.println("Comite not found!");
        }
    }

    private static Comite createComiteFromUserInput(Scanner scanner) {
        System.out.print("Enter Comite Name: ");
        String name = scanner.next();

        System.out.print("Enter Comite Objective: ");
        String objective = scanner.next();

        Persona leader = new Persona("Leader", "LastName", 123456789L, new Date(), "Location", 30, "Leader", "Active");
        List<Persona> members = new ArrayList<>();

        return new Comite(name, members, objective, leader);
    }
    private static Donante createDonanteFromUserInput(Scanner scanner) {
        System.out.print("Enter Donante Name: ");
        String name = scanner.next();

        System.out.print("Enter Donante Last Name: ");
        String lastName = scanner.next();

        System.out.print("Enter Donante DNI: ");
        Long DNI = scanner.nextLong();

        System.out.print("Enter Donante Birthdate (yyyy-MM-dd): ");
        String dateString = scanner.next();
        Date birthdate = parseDate(dateString);

        System.out.print("Enter Donante Location: ");
        String location = scanner.next();

        System.out.print("Enter Donante Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Donante Profession: ");
        String profession = scanner.next();

        System.out.print("Enter Donante Status: ");
        String status = scanner.next();

        System.out.print("Enter Donante Amount Donation: ");
        double amountDonation = scanner.nextDouble();

        return new Donante(name, lastName, DNI, birthdate, location, age, profession, status, amountDonation);
    }

    private static Date parseDate(String dateString) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void donanteMenu(Scanner scanner, DonanteController donanteController) {
        boolean back = false;

        while (!back) {
            printDonanteMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    donanteController.createDonante(createDonanteFromUserInput(scanner));
                    break;
                case 2:
                    donanteController.listDonantes();
                    break;
                case 3:
                    filterDonantesByAmount(scanner, donanteController);
                    break;
                case 4:
                    deleteDonante(scanner, donanteController);
                    break;
                case 5:
                    updateDonante(scanner, donanteController);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printDonanteMenu() {
        System.out.println("+-------------------------------+");
        System.out.println("|        Menú de Donantes       |");
        System.out.println("+-------------------------------+");
        System.out.println("| 1. Crear Donante             |");
        System.out.println("| 2. Listar Donantes           |");
        System.out.println("| 3. Filtrar por Monto Donación |");
        System.out.println("| 4. Eliminar Donante          |");
        System.out.println("| 5. Actualizar Donante        |");
        System.out.println("| 0. Volver                    |");
        System.out.println("+-------------------------------+");
    }

    private static void filterDonantesByAmount(Scanner scanner, DonanteController donanteController) {
        System.out.print("Enter minimum amount donation to filter by: ");
        double minAmount = scanner.nextDouble();
        donanteController.filterDonantesByAmount(minAmount);
    }

    private static void deleteDonante(Scanner scanner, DonanteController donanteController) {
        System.out.print("Enter Donante Name to delete: ");
        String nameToDelete = scanner.next();
        donanteController.deleteDonante(donanteController.findDonanteByName(nameToDelete));
    }

    private static void updateDonante(Scanner scanner, DonanteController donanteController) {
        donanteController.listDonantes();
        System.out.print("\nEnter Donante Name to update: ");
        scanner.nextLine(); // Consume the newline character
        String nameToUpdate = scanner.nextLine();
        Donante donanteToUpdate = donanteController.findDonanteByName(nameToUpdate);
        if (donanteToUpdate != null) {
            System.out.print("Enter new Amount Donation: ");
            double newAmountDonation = scanner.nextDouble();
            donanteController.updateDonante(donanteToUpdate, newAmountDonation);
        } else {
            System.out.println("Donante not found!");
        }
    }

    private static void encuestaSatisfaccionMenu(Scanner scanner, EncuestaSatisfaccionController controller) {
        boolean back = false;

        while (!back) {
            System.out.println("+------------------------------------------+");
            System.out.println("|    Menú de Encuestas de Satisfacción     |");
            System.out.println("+------------------------------------------+");
            System.out.println("| 1. Crear Encuesta de Satisfacción        |");
            System.out.println("| 2. Listar Encuestas de Satisfacción      |");
            System.out.println("| 3. Filtrar por Porcentaje de Satisfacción|");
            System.out.println("| 4. Eliminar una Encuesta de Satisfacción |");
            System.out.println("| 0. Volver                                |");
            System.out.println("+------------------------------------------+");

            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    controller.createEncuestaSatisfaccion(createEncuestaSatisfaccionFromUserInput(scanner));
                    break;
                case 2:
                    controller.listEncuestasSatisfaccion();
                    break;
                case 3:
                    System.out.print("| Ingrese el porcentaje mínimo de satisfacción para filtrar: ");
                    int minSatisfaction = scanner.nextInt();
                    controller.filterEncuestasSatisfaccionByPercentage(minSatisfaction);
                    break;
                case 4:
                    // Mostrar la lista de encuestas en un cuadro enumerado
                    System.out.println("+------------------------------------------+");
                    System.out.println("| Lista de Encuestas de Satisfacción       |");
                    System.out.println("+------------------------------------------+");

                    for (int i = 0; i < controller.encuestas.size(); i++) {
                        System.out.println("| " + (i + 1) + ". " + controller.encuestas.get(i).getComment());
                    }

                    // Solicitar al usuario que elija el número de la encuesta a eliminar
                    System.out.print("| Ingrese el número de la encuesta de satisfacción a eliminar: ");
                    int encuestaIndexToDelete = scanner.nextInt();

                    // Verificar si el número es válido
                    if (encuestaIndexToDelete > 0 && encuestaIndexToDelete <= controller.encuestas.size()) {
                        EncuestaSatisfaccion encuestaToDelete = controller.encuestas.get(encuestaIndexToDelete - 1);
                        controller.deleteEncuestaSatisfaccion(encuestaToDelete);
                        System.out.println("| Encuesta de satisfacción eliminada con éxito.");
                    } else {
                        System.out.println("| Número de encuesta no válido.");
                    }

                    System.out.println("+------------------------------------------+");
                    break;


                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("| Opción no válida. Por favor, inténtelo de nuevo. |");
            }
        }
    }



    private static EncuestaSatisfaccion createEncuestaSatisfaccionFromUserInput(Scanner scanner) {
        System.out.print("Enter Satisfaction Percentage: ");
        int satisfaction = scanner.nextInt();

        System.out.print("Enter Comment: ");
        String comment = scanner.next();

        return new EncuestaSatisfaccion(satisfaction, comment);
    }

    private static void partidoPoliticoMenu(Scanner scanner, PartidoPoliticoController controller) {
        boolean back = false;

        while (!back) {
            System.out.println("+-------------------------------+");
            System.out.println("|   Partido Politico Menu:      |");
            System.out.println("+-------------------------------+");
            System.out.println("| 1. Crear Partido Politico     |");
            System.out.println("| 2. Listar Partidos Politicos  |");
            System.out.println("| 3. Filtrar por Fondos         |");
            System.out.println("| 4. Eliminar Partido Politico  |");
            System.out.println("| 5. Actualizar Partido Politico|");
            System.out.println("| 0. Volver                     |");
            System.out.println("+-------------------------------+");

            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    controller.createPartidoPolitico(createPartidoPoliticoFromUserInput(scanner));
                    break;
                case 2:
                    controller.listPartidosPoliticos();
                    break;
                case 3:
                    System.out.print("Ingrese el monto mínimo de fondos para filtrar: ");
                    double minFund = scanner.nextDouble();
                    controller.filterPartidosPoliticosByFondos(minFund);
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del Partido Politico a eliminar: ");
                    String nameToDelete = scanner.next();
                    controller.deletePartidoPolitico(controller.findPartidoPoliticoByName(nameToDelete));
                    break;
                case 5:
                    controller.listPartidosPoliticos();
                    System.out.print("\nIngrese el nombre del Partido Politico a actualizar: ");
                    scanner.nextLine(); // Consume el carácter de nueva línea
                    String nameToUpdate = scanner.nextLine();
                    PartidoPolitico partidoToUpdate = controller.findPartidoPoliticoByName(nameToUpdate);
                    if (partidoToUpdate != null) {
                        System.out.print("Ingrese el nuevo monto de fondos: ");
                        double newFund = scanner.nextDouble();
                        controller.updatePartidoPolitico(partidoToUpdate, newFund);
                    } else {
                        System.out.println("¡Partido Politico no encontrado!");
                    }
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, inténtelo de nuevo.");
            }
        }
    }

    private static PartidoPolitico createPartidoPoliticoFromUserInput(Scanner scanner) {
        System.out.println("+----------------------------------------+");
        System.out.println("|     Ingrese los datos del Partido      |");
        System.out.println("+----------------------------------------+");

        System.out.print("| Nombre del Partido Politico: ");
        String name = scanner.next();

        System.out.print("| Fecha de Fundación (yyyy-MM-dd): ");
        String dateString = scanner.next();
        Date foundationDate = parseDate(dateString);

        System.out.print("| Fondos del Partido Politico: ");
        double fund = 0;
        try {
            fund = Double.parseDouble(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println("| Error: Ingrese un número válido para los fondos. |");
            System.out.println("+----------------------------------------+");
            return null;
        }

        PartidoPolitico partidoPolitico = new PartidoPolitico(name, fund);

        // Opciones para asignar listas y mapas
        System.out.print("| ¿Desea agregar Donantes? (yes/no): ");
        if (scanner.next().equalsIgnoreCase("yes")) {
            partidoPolitico.setDonantes(createDonantesListFromUserInput(scanner));
        }

        System.out.print("| ¿Desea agregar Encuestas? (yes/no): ");
        if (scanner.next().equalsIgnoreCase("yes")) {
            partidoPolitico.setEncuestas(createEncuestasListFromUserInput(scanner));
        }

        System.out.print("| ¿Desea agregar Segmentación Demográfica? (yes/no): ");
        if (scanner.next().equalsIgnoreCase("yes")) {
            partidoPolitico.setSegmentacionDemográfica(createSegmentacionDemograficaMapFromUserInput(scanner));
        }

        System.out.print("| ¿Desea agregar Temas de Interés para Votantes? (yes/no): ");
        if (scanner.next().equalsIgnoreCase("yes")) {
            partidoPolitico.setTemasInteresVotantes(createTemasInteresVotantesMapFromUserInput(scanner));
        }

        System.out.print("| ¿Desea agregar Comités? (yes/no): ");
        if (scanner.next().equalsIgnoreCase("yes")) {
            partidoPolitico.setComites(createComitesListFromUserInput(scanner));
        }

        // Fondos Totales
        System.out.print("| Ingrese Fondos Totales: ");
        double fondosTotales = 0;
        try {
            fondosTotales = Double.parseDouble(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println("| Error: Ingrese un número válido para los Fondos Totales. |");
            System.out.println("+----------------------------------------+");
            return null;
        }
        partidoPolitico.setFondosTotales(fondosTotales);

        System.out.println("+----------------------------------------+");
        return partidoPolitico;
    }

    private static List<Donante> createDonantesListFromUserInput(Scanner scanner) {
        List<Donante> donantes = new ArrayList<>();
        System.out.print("| Ingrese la cantidad de Donantes: ");
        int numberOfDonantes = scanner.nextInt();
        for (int i = 0; i < numberOfDonantes; i++) {
            Donante donante = createDonanteFromUserInput(scanner);
            if (donante != null) {
                donantes.add(donante);
            }
        }
        return donantes;
    }


    private static List<EncuestaSatisfaccion> createEncuestasListFromUserInput(Scanner scanner) {
        List<EncuestaSatisfaccion> encuestas = new ArrayList<>();
        System.out.print("Enter the number of Encuestas: ");
        int numberOfEncuestas = scanner.nextInt();
        for (int i = 0; i < numberOfEncuestas; i++) {
            EncuestaSatisfaccion encuesta = createEncuestaSatisfaccionFromUserInput(scanner);
            if (encuesta != null) {
                encuestas.add(encuesta);
            }
        }
        return encuestas;
    }

    private static Map<String, List<String>> createSegmentacionDemograficaMapFromUserInput(Scanner scanner) {
        Map<String, List<String>> segmentacionDemografica = new HashMap<>();
        System.out.print("Enter the number of demographic segments: ");
        int numberOfSegments = scanner.nextInt();
        for (int i = 0; i < numberOfSegments; i++) {
            System.out.print("Enter segment name: ");
            String segmentName = scanner.next();
            System.out.print("Enter the number of values for this segment: ");
            int numberOfValues = scanner.nextInt();
            List<String> values = new ArrayList<>();
            for (int j = 0; j < numberOfValues; j++) {
                System.out.print("Enter value " + (j + 1) + ": ");
                values.add(scanner.next());
            }
            segmentacionDemografica.put(segmentName, values);
        }
        return segmentacionDemografica;
    }

    private static Map<String, List<String>> createTemasInteresVotantesMapFromUserInput(Scanner scanner) {
        Map<String, List<String>> temasInteresVotantes = new HashMap<>();
        System.out.print("Enter the number of voter interest topics: ");
        int numberOfTopics = scanner.nextInt();
        for (int i = 0; i < numberOfTopics; i++) {
            System.out.print("Enter topic name: ");
            String topicName = scanner.next();
            System.out.print("Enter the number of values for this topic: ");
            int numberOfValues = scanner.nextInt();
            List<String> values = new ArrayList<>();
            for (int j = 0; j < numberOfValues; j++) {
                System.out.print("Enter value " + (j + 1) + ": ");
                values.add(scanner.next());
            }
            temasInteresVotantes.put(topicName, values);
        }
        return temasInteresVotantes;
    }

    private static List<Comite> createComitesListFromUserInput(Scanner scanner) {
        List<Comite> comites = new ArrayList<>();
        System.out.print("Enter the number of Comites: ");
        int numberOfComites = scanner.nextInt();
        for (int i = 0; i < numberOfComites; i++) {
            Comite comite = createComiteFromUserInput(scanner);
            if (comite != null) {
                comites.add(comite);
            }
        }
        return comites;
    }



}
