public class Usuario {

    String nombre;
    String cedula;
    String telefono;
    NodoCompra cabezaCompras;

    public Usuario(String nombre, String cedula, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.cabezaCompras = null;
    }

    public void agregarCompra(double valor){
        NodoCompra nuevaCompra = new NodoCompra(valor);
        nuevaCompra.siguiente=cabezaCompras;
        cabezaCompras = nuevaCompra;
    }

    public double obtenerPromedioCompras(){
        if(cabezaCompras == null)return 0.0;
        double suma =0;
        int contador =0;
        NodoCompra actual = cabezaCompras;
        while (actual !=null){
            suma += actual.valorPagado;
            contador ++;
            actual=actual.siguiente;
        }
        return suma/contador;
    }
}
