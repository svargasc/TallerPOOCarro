import javax.swing.*;
import java.util.ArrayList;


public class Principal {
    private static ArrayList<Carro> listaCarros = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = mostrarMenu();
            switch (opcion) {
                case 1:
                    crearCarro();
                    break;
                case 2:
                    consultarCarroIndividual();
                    break;
                case 3:
                    consultarListaCarros();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        } while (opcion != 4);
    }

    private static int mostrarMenu() {
        String menu = "Menú:\n" +
                      "1. Crear carro\n" +
                      "2. Consultar carro individual\n" +
                      "3. Consultar lista de carros\n" +
                      "4. Salir\n" +
                      "Ingrese el número de la opción deseada:";
        return Integer.parseInt(JOptionPane.showInputDialog(null, menu));
    }

    private static void crearCarro() {
        String marca = JOptionPane.showInputDialog("Ingrese la marca del carro:");
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo del carro:");
        int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año del carro:"));
        String color = JOptionPane.showInputDialog("Ingrese el color del carro:");

        Carro nuevoCarro = new Carro(marca, modelo, anio, color);
        listaCarros.add(nuevoCarro);
        JOptionPane.showMessageDialog(null, "Carro creado exitosamente.");
    }

    private static void consultarCarroIndividual() {
        if (listaCarros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay carros registrados.");
            return;
        }

        int indice = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el índice del carro a consultar (0-" + (listaCarros.size() - 1) + "):"));
        if (indice < 0 || indice >= listaCarros.size()) {
            JOptionPane.showMessageDialog(null, "Índice inválido.");
            return;
        }

        Carro carroConsultado = listaCarros.get(indice);
        JOptionPane.showMessageDialog(null, carroConsultado.obtenerInformacion(), "Información del carro", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void consultarListaCarros() {
        if (listaCarros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay carros registrados.");
            return;
        }

        String lista = "Lista de carros registrados:\n";
        for (int i = 0; i < listaCarros.size(); i++) {
            Carro carro = listaCarros.get(i);
            lista+="\nCarro "+i+"\n"+
            carro.obtenerInformacion()+"\n";
        }

        JOptionPane.showMessageDialog(null, lista.toString());
    }
}
