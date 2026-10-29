public class NodoUsuario {

    Usuario usuario;
    NodoUsuario anterior;
    NodoUsuario siguiente;

    public NodoUsuario(Usuario usuario){
        this.usuario =usuario;
        this.anterior =null;
        this.siguiente=null;
    }
}
