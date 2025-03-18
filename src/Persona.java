import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Persona {
    private String nombre;
    private String apellido;
    private String genero;
    private int edad;

    public Persona(String nombre, String apellido, String genero, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public int getEdad() {
        return edad;
    }
}

class ProgramaPersonas {

    public static List<String> capturarNombreGenero() {
        Scanner scanner = new Scanner(System.in);
        List<String> nombreGeneroList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.println("\nIngrese la información de la persona " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Género (M/F): ");
            String genero = scanner.nextLine().toUpperCase();
            nombreGeneroList.add("Nombre: " + nombre + ", Género: " + genero);
        }
        return nombreGeneroList;
    }

    public static double calcularPromedioEdades(List<Persona> personas) {
        if (personas.isEmpty()) {
            return 0;
        }
        int sumaEdades = 0;
        for (Persona persona : personas) {
            sumaEdades += persona.getEdad();
        }
        return (double) sumaEdades / personas.size();
    }

    public static int contarGenero(List<Persona> personas, String genero) {
        int contador = 0;
        for (Persona persona : personas) {
            if (persona.getGenero().equals(genero)) {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Persona> listaPersonas = new ArrayList<>();

        System.out.println("Captura de datos para crear objetos Persona:");
        for (int i = 0; i < 5; i++) {
            System.out.println("\nIngrese los datos de la persona " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Género (M/F): ");
            String genero = scanner.nextLine().toUpperCase();
            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de nextInt()

            Persona persona = new Persona(nombre, apellido, genero, edad);
            listaPersonas.add(persona);
        }

        List<String> infoCapturada = capturarNombreGenero();
        System.out.println("\nInformación de las personas capturada:");
        for (String info : infoCapturada) {
            System.out.println(info);
        }

        double promedioEdades = calcularPromedioEdades(listaPersonas);
        System.out.println("\nPromedio de las edades capturadas: " + String.format("%.2f", promedioEdades));

        int cantidadMasculino = contarGenero(listaPersonas, "M");
        System.out.println("Cantidad de personas con género Masculino: " + cantidadMasculino);

        int cantidadFemenino = contarGenero(listaPersonas, "F");
        System.out.println("Cantidad de personas con género Femenino: " + cantidadFemenino);

        scanner.close();
    }
}