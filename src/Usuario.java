public class Usuario {

    private String nombre;
    private String cedula;
    private String telefono;
    private ListaDoble<Compra> compras;

    // constructor
    public Usuario(String nombre, String cedula, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.compras = new ListaDoble<>();
    }

    //getters y seters
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ListaDoble<Compra> getCompras() {
        return this.compras;
    }


    public double calcularPromedioCompras() {
        if (compras.isEmpty()) {
            return 0.0;
        }

        double suma = 0.0;
        int cantidad = 0;

        NodoDoble<Compra> actual = compras.first();
        while (actual != null) {
            suma += actual.getData().getValorPagado();
            cantidad++;
            actual = actual.getNext();
        }

        return suma / cantidad;
    }
}