/**
 * Clase que muestra el funcionamiento de Excepciones.
 * @author Kevin Torres
 * @version 1.0
*/

import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

/**
 * Enum para representar el resultado de la dirección
 * de la prueba de orientación entre tres puntos p, q, r.
 */
enum Direction {
    COLLINEAR, CLOCKWISE, COUNTERCLOCKWISE
}


/**
 * Clase utilizada para representar un Punto.
 */
class Point {
    String id;
    double x, y;

    /**
     * Constructor para un punto.
     * @param id Identificador del punto.
     * @param x coordenada x del punto.
     * @param y coordenada y del punto.
     */
    public Point(String id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    /**
     * Método toString para devolver el identificador del punto.
     */
    @Override
    public String toString() {
        return id;
    }
}

/**
 * Clase donde se desarrollará el algoritmo proporcionado.
 */
public class Practica14 {

    /**
     * Método para leer los puntos desde un archivo y convertirlos en un arreglo de puntos
     * @param filename Nombre del archivo que contiene los puntos.
     * @return arreglo de puntos leídos del archivo, o nulo si hay un error.
     * @throws IOException Si hay un error al leer el archivo.
     */
    public static Point[] getPoints(String filename) {
        Point[] points = null;
        try {
            String content = Files.readString(Paths.get(filename), StandardCharsets.UTF_8);
            String[] entries = content.split(",");
            points = new Point[entries.length];

            for (int i = 0; i < entries.length; i++) {
                String[] data = entries[i].split(":");
                String id = data[0];
                double x = Double.parseDouble(data[1]);
                double y = Double.parseDouble(data[2]);
                points[i] = new Point(id, x, y);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return points;
    }

    /**
     * Test de Orientación
     * Calcula la orientación de tres puntos p, q y r.
     * @param p Primer punto.
     * @param q Segundo punto.
     * @param r Tercer punto.
     * @return Direction indica la orientación (Collinear, Clockwise, or Counter-clockwise).
     */
    public static Direction orientation(Point p, Point q, Point r) {
        double valor = (r.y - p.y) * (q.x - p.x) - (q.y - p.y) * (r.x - p.x);
        if (valor == 0) {
            return Direction.COLLINEAR;
        } else if (valor > 0) {
            return Direction.COUNTERCLOCKWISE;
        } else {
            return Direction.CLOCKWISE;
        }
    }

    /**
     * Comprueba si un punto está dentro de un triángulo formado por otros tres puntos.
     * @param p Primer punto del triangulo.
     * @param q Segundo punto del triangulo.
     * @param r Tercer punto del triangulo.
     * @param actual punto para comprobar si está dentro del triángulo.
     * @return true si el punto está dentro del triángulo, false en caso contrario.
     */
    public static boolean isPointInsideTriangle(Point p, Point q, Point r, Point actual) {
        Direction orient1 = orientation(p, q, actual);
        Direction orient2 = orientation(q, r, actual);
        Direction orient3 = orientation(r, p, actual);

        return (orient1 == Direction.CLOCKWISE && orient2 == Direction.CLOCKWISE && orient3 == Direction.CLOCKWISE) ||
               (orient1 == Direction.COUNTERCLOCKWISE && orient2 == Direction.COUNTERCLOCKWISE && orient3 == Direction.COUNTERCLOCKWISE);
    }

    /**
     * Implementación del algoritmo cubiertaPoligonal.
     * @param points Un arreglo de puntos que representan los vértices del polígono.
     * @return Un arreglo de puntos que forman la cubierta poligonal del conjunto de entrada.
     */
    public static Point[] cubiertaPoligonal(Point[] points) {
        //Aqui va su codigo.
    }

    // Método principal
    /**
     * Método principal para ejecutar su algoritmo.
     * @param args
     */
    public static void main(String[] args) {
        // Leer puntos desde el archivo "points.txt", utilicen el metodo getPoints.
        //Aqui va su codigo.


        // Calcular la cubierta poligonal
        // Aqui va su codigo.


        // Crear el resultado en formato de texto
        StringBuilder sb = new StringBuilder();
        for (Point p : //cubierta poligonal ) {
            sb.append(p.toString()).append("\n");

        // Imprimir la solución en consola
        //Aqui va su codigo.


        // Guardar la solución en un archivo "solucion.txt"
        //Aqui va su codigo
        try {
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
