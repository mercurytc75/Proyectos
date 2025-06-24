package github;
import java.util.*;

class Alumno {
    private String nombre;
    private Map<String, Double> materias;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.materias = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarMateria(String materia, double calificacion) {
        materia = materia.toLowerCase();
        if (materias.containsKey(materia)) {
            System.out.println("Materia ya existe para el alumno");
        } else {
            materias.put(materia, calificacion);
        }
    }

    public Map<String, Double> getMaterias() {
        return materias;
    }
}

class Escuela {
    private  List<Alumno> alumnos;

    public Escuela() {
        this.alumnos = new ArrayList<>();
    }

    public void agregarAlumno(String nombre) {
        nombre = nombre.toLowerCase();
        if (buscarAlumno(nombre) != null) {
            System.out.println("Alumno ya existe");
        } else {
            alumnos.add(new Alumno(nombre));
        }
    }

    public Alumno buscarAlumno(String nombre) {
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equals(nombre)) {
                return alumno;
            }
        }
        return null;
    }

    public void agregarMateria(String nombreAlumno, String materia, double calificacion) {
        nombreAlumno = nombreAlumno.toLowerCase();
        Alumno alumno = buscarAlumno(nombreAlumno);
        if (alumno != null) {
            alumno.agregarMateria(materia, calificacion);
        } else {
            System.out.println("Alumno no encontrado");
        }
    }

    public void mostrarAlumnos() {
        for (Alumno alumno : alumnos) {
            System.out.println("Alumno: " + alumno.getNombre());
            for (Map.Entry<String, Double> entry : alumno.getMaterias().entrySet()) {
                System.out.println("  Materia: " + entry.getKey() + ", Calificación: " + entry.getValue());
            }
        }
    }
    public void eliminarAlumno(String nombre){
        nombre= nombre.toLowerCase();
        Alumno alumno = buscarAlumno(nombre);
        if (alumno != null) {
            alumnos.remove(alumno);
            System.out.println(alumno.getNombre() +" eliminado");
        } else {
            System.out.println("Alumno no encontrado");
        }
    }

    public void iniciar() {
        try (Scanner sc = new Scanner(System.in)) {
            OUTER:
            while (true) {
                System.out.println("\n1. Agregar alumno\n2. Agregar materia\n3. Mostrar alumnos\n4. Eliminar alumno\n5. Salir");
                System.out.print("Elige una opción: ");
                int opcion = -1;
                try {
                    opcion = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, ingresa un número válido.");
                    sc.nextLine();
                    continue;
                }
                sc.nextLine();
                switch (opcion) {
                    case 1 -> {
                        System.out.print("Nombre del alumno: ");
                        String nombre = sc.nextLine();
                        agregarAlumno(nombre);
                    }
                    case 2 -> {
                        System.out.print("Nombre del alumno: ");
                        String nombre = sc.nextLine();
                        System.out.print("Nombre de la materia: ");
                        String materia = sc.nextLine();
                        System.out.print("Calificación: ");
                        double calificacion = sc.nextDouble();
                        sc.nextLine(); // limpiar buffer
                        agregarMateria(nombre, materia, calificacion);
                    }
                    case 3 -> mostrarAlumnos();
                    case 4 ->{
                        System.out.print("nomnbre del alumno a eliminar: ");
                        String nombre = sc.nextLine();
                        eliminarAlumno(nombre);
                    }
                    case 5 -> {
                        System.out.println("Saliendo...");
                        break OUTER;
                    }
                    default -> System.out.println("Opción no válida");
                }
            }
        }
    }
}

public class Problema4 {
    public static void main(String[] args) {
        Escuela escuela = new Escuela();
        escuela.iniciar();
    }
}
