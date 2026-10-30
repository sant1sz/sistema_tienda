public class NodoDoble <T> {

    private T data;
    private NodoDoble<T> next;
    private NodoDoble<T> prev;

    //constructor y constructor sobreescrito
    public NodoDoble() {
        this.data = null;
        this.next = null;
        this.prev = null;
    }

    public NodoDoble(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    //getters y setters

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodoDoble getNext() {
        return this.next;
    }

    public void setNext(NodoDoble next) {
        this.next = next;
    }

    public NodoDoble getPrev() {
        return this.prev;
    }

    public void setPrev(NodoDoble prev) {
        this.prev = prev;
    }
}
