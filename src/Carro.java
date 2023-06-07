
public class Carro {
    private String marca;
    private String modelo;
    private int anio;
    private String color;
    private double velocidad;

    public Carro(String marca, String modelo, int anio, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.velocidad = 0.0;
    }

    public void acelerar(double incremento) {
        velocidad += incremento;
    }

    public void frenar(double decremento) {
        velocidad -= decremento;
        if (velocidad < 0.0) {
            velocidad = 0.0;
        }
    }

    public String obtenerInformacion() {
        return "Marca: " + marca + "\n" +
               "Modelo: " + modelo + "\n" +
               "Año: " + anio + "\n" +
               "Color: " + color + "\n" +
               "Velocidad: " + velocidad + " km/h";
    }
}

