import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Sistema {
    private ListaDoble<Usuario> listaUsuarios;

    public Sistema() {
        this.listaUsuarios = new ListaDoble<>();
    }


    public boolean agregarUsuario(String nombre, String cedula, String telefono) {
        if (buscarUsuarioPorCedula(cedula) != null) {
            return false;
        }
        Usuario nuevoUsuario = new Usuario(nombre, cedula, telefono);
        listaUsuarios.addLast(nuevoUsuario);
        return true;
    }

    public Usuario buscarUsuarioPorCedula(String cedula) {
        NodoDoble<Usuario> actual = listaUsuarios.first();
        while (actual != null) {
            if (actual.getData().getCedula().equals(cedula)) {
                return actual.getData();
            }
            actual = actual.getNext();
        }
        return null;
    }

    public boolean eliminarUsuario(String cedula) {
        NodoDoble<Usuario> actual = listaUsuarios.first();
        while (actual != null) {
            if (actual.getData().getCedula().equals(cedula)) {
                listaUsuarios.remove(actual);
                return true;
            }
            actual = actual.getNext();
        }
        return false;
    }


    public boolean agregarCompraAUsuario(String cedula, double valorPagado) {
        Usuario usuario = buscarUsuarioPorCedula(cedula);
        if (usuario != null) {
            Compra nuevaCompra = new Compra(valorPagado);
            usuario.getCompras().addLast(nuevaCompra);
            return true;
        }
        return false; // Usuario no encontrado
    }

    // parte de archivos
    public void guardarDatosEnArchivo(String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            NodoDoble<Usuario> actual = listaUsuarios.first();
            while (actual != null) {
                Usuario u = actual.getData();
                double promedio = u.calcularPromedioCompras();
                writer.println(u.getCedula() + ";" + u.getNombre() + ";" + u.getTelefono() + ";" + promedio);
                actual = actual.getNext();
            }
            System.out.println("Datos guardados exitosamente en '" + nombreArchivo + "'");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    // lee los datos desde un archivo de texto plano y los muestra en consola
    public void cargarDatosDesdeArchivo(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            System.out.println("\n--- CONTENIDO DEL ARCHIVO (" + nombreArchivo + ") ---");
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 4) {
                    System.out.println("Cédula: " + partes[0] +
                            " | Nombre: " + partes[1] +
                            " | Teléfono: " + partes[2] +
                            " | Promedio Compras: $" + partes[3]);
                }
            }
            System.out.println("-------------------------------------------------\n");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo (puede que aún no exista): " + e.getMessage());
        }
    }
}
