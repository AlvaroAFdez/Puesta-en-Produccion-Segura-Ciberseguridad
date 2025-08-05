public class SaludoPersonalizado {
    private String nombre;

    // Constructor que acepta un nombre
    public SaludoPersonalizado(String nombre) {
        this.nombre = nombre;
    }

    // Método para obtener el saludo personalizado
    public String getSaludo() {
        return "¡Hola, " + nombre + "!";
    }
}
