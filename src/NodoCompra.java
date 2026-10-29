public class NodoCompra {
    double valorPagado;
    NodoCompra siguiente;

    public NodoCompra(double valorPagado){
        this.valorPagado = valorPagado;
        this.siguiente = null;
    }
}
