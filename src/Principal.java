// Clase Principal para manejar el menú y la lógica principal
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    private static ArrayList<Materia> materias = new ArrayList<>();
    private static ArrayList<Maestro> maestros = new ArrayList<>();
    private static ArrayList<Alumno> alumnos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- SIIT ---");
            System.out.print("Seleccione una opción: ");
            System.out.println("1. Materias");
            System.out.println("2. Maestros");
            System.out.println("3. Alumnos");
            System.out.println("4. Salir");

            opcion = leerEntero(scanner);

            switch (opcion) {
                case 1:
                    menuMaterias(scanner);
                    break;
                case 2:
                    menuMaestros(scanner);
                    break;
                case 3:
                    menuAlumnos(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void menuMaterias(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Materias ---");
            System.out.println("1. Registrar Materia");
            System.out.println("2. Listar Materias");
            System.out.println("3. Eliminar Materia");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = leerEntero(scanner);

            switch (opcion) {
                case 1:
                    registrarMateria(scanner);
                    break;
                case 2:
                    listarMaterias();
                    break;
                case 3:
                    eliminarMateria(scanner);
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
    }

    private static void menuMaestros(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Maestros ---");
            System.out.println("1. Registrar Maestro");
            System.out.println("2. Listar Maestros");
            System.out.println("3. Modificar Maestro");
            System.out.println("4. Eliminar Maestro");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = leerEntero(scanner);

            switch (opcion) {
                case 1:
                    registrarMaestro(scanner);
                    break;
                case 2:
                    listarMaestros();
                    break;
                case 3:
                    modificarMaestro(scanner);
                    break;
                case 4:
                    eliminarMaestro(scanner);
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private static void menuAlumnos(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Alumnos ---");
            System.out.println("1. Registrar Alumno");
            System.out.println("2. Capturar Calificaciones");
            System.out.println("3. Listar Alumnos");
            System.out.println("4. Eliminar Alumno");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = leerEntero(scanner);

            switch (opcion) {
                case 1:
                    registrarAlumno(scanner);
                    break;
                case 2:
                    capturarCalificaciones(scanner);
                    break;
                case 3:
                    listarAlumnos();
                    break;
                case 4:
                    eliminarAlumno(scanner);
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private static void registrarMateria(Scanner scanner) {
        System.out.print("Ingrese la clave de la materia: ");
        String clave = scanner.nextLine();
        System.out.print("Ingrese el nombre de la materia: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el número de unidades: ");
        int unidades = leerEntero(scanner);

        materias.add(new Materia(clave, nombre, unidades));
        System.out.println("Materia registrada.");
    }

    private static void registrarMaestro(Scanner scanner) {
        System.out.print("Ingrese el nombre del maestro: ");
        String nombreCompleto = scanner.nextLine();
        System.out.print("Ingrese el número de tarjeta del maestro: ");
        String numeroTarjeta = scanner.nextLine();

        maestros.add(new Maestro(nombreCompleto, numeroTarjeta));
        System.out.println("Maestro registrado exitosamente.");
    }

    private static void registrarAlumno(Scanner scanner) {
        System.out.print("Ingrese el nombre del alumno: ");
        String nombreCompleto = scanner.nextLine();
        System.out.print("Ingrese el semestre que cursa: ");
        int semestre = leerEntero(scanner);

        if (materias.isEmpty()) {
            System.out.println("No hay materias registradas. Registre una materia primero.");
            return;
        }

        System.out.println("Materias disponibles:");
        for (Materia materia : materias) {
            System.out.println(materia);
        }
        System.out.print("Ingrese el número de unidades de la materia: ");
        int unidades = leerEntero(scanner);

        alumnos.add(new Alumno(nombreCompleto, semestre, unidades));
        System.out.println("Alumno registrado exitosamente.");
    }

    private static void capturarCalificaciones(Scanner scanner) {
        System.out.print("Ingrese el ID del alumno: ");
        int idAlumno = leerEntero(scanner);
        Alumno alumno = alumnos.stream().filter(a -> a.getId() == idAlumno).findFirst().orElse(null);

        if (alumno == null) {
            System.out.println("Alumno no encontrado.");
            return;
        }

        System.out.println("Capturando calificaciones de: " + alumno.getNombreCompleto());
        Double[] calificaciones = new Double[alumno.getCalificaciones().length];

        for (int i = 0; i < calificaciones.length; i++) {
            System.out.print("Ingrese la calificación para la unidad " + (i + 1) + ": ");
            calificaciones[i] = leerDouble(scanner);
        }

        alumno.setCalificaciones(calificaciones);
        System.out.println("Calificaciones registradas exitosamente.");
        System.out.println(alumno);
    }

    private static void listarMaterias() {
        if (materias.isEmpty()) {
            System.out.println("No hay registros.");
        } else {
            System.out.println("\nMaterias registradas:");
            for (Materia materia : materias) {
                System.out.println(materia);
            }
        }
    }

    private static void listarMaestros() {
        if (maestros.isEmpty()) {
            System.out.println("No hay registros.");
        } else {
            System.out.println("\nMaestros registrados:");
            for (Maestro maestro : maestros) {
                System.out.println(maestro);
            }
        }
    }

    private static void listarAlumnos() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            System.out.println("\nAlumnos registrados:");
            for (Alumno alumno : alumnos) {
                System.out.println(alumno);
            }
        }
    }

    private static void eliminarMateria(Scanner scanner) {
        System.out.print("Ingrese el ID de la materia a eliminar: ");
        int id = leerEntero(scanner);
        materias.removeIf(m -> m.getId() == id);
        System.out.println("Materia eliminada exitosamente.");
    }

    private static void eliminarMaestro(Scanner scanner) {
        System.out.print("Ingrese el ID del maestro a eliminar: ");
        int id = leerEntero(scanner);
        maestros.removeIf(m -> m.getId() == id);
        System.out.println("Maestro eliminado exitosamente.\n");
    }

    private static void eliminarAlumno(Scanner scanner) {
        System.out.print("Ingrese el ID del alumno a eliminar: ");
        int id = leerEntero(scanner);
        alumnos.removeIf(a -> a.getId() == id);
        System.out.println("Alumno eliminado exitosamente.\n");
    }

    private static void modificarMaestro(Scanner scanner) {
        System.out.print("Ingrese el ID del maestro a modificar: ");
        int id = leerEntero(scanner);
        Maestro maestro = maestros.stream().filter(m -> m.getId() == id).findFirst().orElse(null);

        if (maestro == null) {
            System.out.println("Maestro no encontrado.");
            return;
        }

        System.out.print("Ingrese el nuevo nombre del maestro: ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Ingrese el nuevo número de tarjeta: ");
        String nuevaTarjeta = scanner.nextLine();

        maestro.setNombreCompleto(nuevoNombre);
        maestro.setNumeroTarjeta(nuevaTarjeta);
        System.out.println("Maestro modificado exitosamente.");
    }

    private static int leerEntero(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Valor incorrecto. Intente nuevamente: ");
            }
        }
    }

    private static double leerDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Valor incorrecto. Intente nuevamente: ");
            }
        }
    }
}
