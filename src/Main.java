public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        String archivoPrueba = "historial_compras.txt";


        sistema.agregarUsuario("Samuel Mejia", "10123456", "3001112233");
        sistema.agregarUsuario("Santiago Sanchez", "10987654", "3104445566");
        sistema.agregarUsuario("Tomas Garcia", "10555444", "3207778899");

        // compras samuel
        sistema.agregarCompraAUsuario("10123456", 150000.0);
        sistema.agregarCompraAUsuario("10123456", 250000.0);

        // compras santiago
        sistema.agregarCompraAUsuario("10987654", 80000.0);
        sistema.agregarCompraAUsuario("10987654", 120000.0);
        sistema.agregarCompraAUsuario("10987654", 100000.0);

        // compras tomas
        sistema.agregarCompraAUsuario("10555444", 500000.0);


        System.out.println("\n--- PROMEDIOS DE COMPRA CALCULADOS ---");
        Usuario u1 = sistema.buscarUsuarioPorCedula("10123456");
        if (u1 != null) {
            System.out.println("Usuario: " + u1.getNombre() + " | Promedio: $" + u1.calcularPromedioCompras());
        }

        Usuario u2 = sistema.buscarUsuarioPorCedula("10987654");
        if (u2 != null) {
            System.out.println("Usuario: " + u2.getNombre() + " | Promedio: $" + u2.calcularPromedioCompras());
        }

        // se guarda la info en el archivo plano
        System.out.println();
        sistema.guardarDatosEnArchivo(archivoPrueba);

        // se lee y se muestra la info desde el archivo
        sistema.cargarDatosDesdeArchivo(archivoPrueba);


        System.out.println("Eliminando al usuario santiago (10987654)...");
        sistema.eliminarUsuario("10987654");

        // se guarda otra vez para ver q santiago ya no esté
        sistema.guardarDatosEnArchivo(archivoPrueba);
        sistema.cargarDatosDesdeArchivo(archivoPrueba);
    }
}