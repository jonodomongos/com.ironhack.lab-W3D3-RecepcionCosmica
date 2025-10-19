import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    /*
    INSTRUCCIONES:
        1. Rellenar ArrayList y mostrar resultado:
            Crear un arraylist mediante un bucle con los números del 20 al 50.
            Mostrar después todo el contenido del arraylist final.
        2. Preguntar al usuario elementos típicos de la fiesta de Sant Jordi.
            Para acabar, escribir 'salir'. Al final, mostrar todos los elementos introducidos por el usuario.
        3. CRUD: recepción internacional... y universal!
            Te han encargado organizar la recepción oficial para el primer contacto extraterrestre, en la montaña de Montserrat.
            Solo unos pocos en el mundo pueden asistir. ¿A quién enviarías? De momento la lista sólo puede ser de cinco elegid@s.
            Pero dos de ellos, en los puestos 2 y 3, se asustan y se dan de baja, y entra entonces el personaje X (darle nombre) en el puesto 2.
            La persona que está en el último puesto, se pone enferma y te recomienda que pongas en su lugar al personaje Y (darle nombre). Ojo con saber qué índice es el último
            En el último momento, se añade el personaje Z (darle nombre) al puesto vacante (puesto 3).
            Ves mostrando a cada paso cómo va quedando la lista actualizada: los medios están muy interesados en seguir la noticia al minuto!
     */
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 1:");
        ejercicioArrayList20a50();

        System.out.println("\nEjercicio 2:");
        ejercicioSantJordi(sc);

        System.out.println("\nEjercicio 3:");
        ejercicioCRUD();

        sc.close();
    }

    // Ejercicio 1
    public static void ejercicioArrayList20a50() {
        List<Integer> numeros = new ArrayList<>();
        for (int i = 20; i <= 50; i++) {
            numeros.add(i);
        }

        for (int n : numeros) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // Ejercicio 2
    public static void ejercicioSantJordi(Scanner sc) {
        List<String> elementos = new ArrayList<>();

        System.out.println("Escribe elementos típicos de Sant Jordi (escribe 'salir' para terminar):");
        while (true) {
            System.out.print("• ");
            String entrada = sc.nextLine().trim();

            if (entrada.equalsIgnoreCase("salir")) break;

            if (entrada.isEmpty()) {
                System.out.println("No has escrito nada, prueba de nuevo.");
                continue;
            }
            elementos.add(entrada);
        }

        int numeroElementos = 1;

        System.out.println("\nElementos introducidos:");
        if (elementos.isEmpty()) {
            System.out.println("(ninguno)");
        } else {
            for (String e : elementos) {
                System.out.println(numeroElementos++ + ". " + e);
            }
        }
    }

    // Ejercicio 3
    public static void ejercicioCRUD() {
        // Creamos la lista vacía
        List<String> invitados = new ArrayList<>();

        // Añadimos los 5 invitados iniciales
        invitados.add("Elon Musk");
        invitados.add("Bill Gates");
        invitados.add("Sam Altman");
        invitados.add("Tim Cook");
        invitados.add("Sundar Pichai");

        titulo("PASO 1 — Lista inicial");
        imprimirLista(invitados);

        // PASO 2 — Bajas en los puestos 2 y 3
        invitados.set(1, "*******");
        invitados.set(2, "*******");

        titulo("PASO 2 — Bajas en los puestos 2 y 3");
        imprimirLista(invitados);

        // PASO 3 — Entra Mark Zuckerberg en el puesto 2
        invitados.set(1, "Mark Zuckerberg 🆕");

        titulo("PASO 3 — Entra Mark Zuckerberg en el puesto 2");
        imprimirLista(invitados);

        // PASO 4 — El último enferma y recomienda a Satya Nadella
        int indiceUltimo = invitados.size() - 1;
        invitados.set(indiceUltimo, "Satya Nadella 🆕");

        titulo("PASO 4 — El último enferma y recomienda a Satya Nadella");
        imprimirLista(invitados);

        // PASO 5 — Entra Jeff Bezos al puesto 3
        invitados.set(2, "Jeff Bezos 🆕");

        titulo("PASO 5 — Entra Jeff Bezos al puesto 3");
        imprimirLista(invitados);

        titulo("✅ LISTA FINAL CONFIRMADA");
        imprimirLista(invitados);
    }

    // Método propio para imprimir la lista de invitados
    private static void imprimirLista(List<String> lista) {
        System.out.println("LISTADO DE INVITADOS:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Invitado " + (i + 1) + " -> " + lista.get(i));
        }
        System.out.println(); // línea en blanco entre pasos
    }

    private static void titulo(String texto) {
        System.out.println("--------------------------------------------------");
        System.out.println(texto);
        System.out.println("--------------------------------------------------");
    }
}