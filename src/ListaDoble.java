public class ListaDoble <T> {

    private NodoDoble<T> head;
    private NodoDoble<T> tail;
    private int size;

    public ListaDoble() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public NodoDoble<T> first() {
        return head;
    }

    public NodoDoble<T> last() {
        return tail;
    }

    public void addFirst(T data)
    {
        NodoDoble<T> n = new NodoDoble<>(data);

        if(this.isEmpty())
        {
            this.head = n;
            this.tail = n;
        }
        else
        {
            n.setNext(this.head);
            this.head.setPrev(n);
            this.head = n;
        }

        this.size +=1;
    }

    public void addLast(T data)
    {
        NodoDoble<T> n = new NodoDoble<>(data);

        if(this.isEmpty())
        {
            this.head = n;
            this.tail = n;
        }
        else
        {
            this.tail.setNext(n);
            n.setPrev(this.tail);
            this.tail = n;
        }

        this.size +=1;
    }

    public T removeFirst()
    {
        if(!this.isEmpty())
        {
            T data_temp = this.head.getData();

            if(this.size == 1)
            {
                this.head = null;
                this.tail = null;
            }
            else
            {
                NodoDoble<T> temp = this.head.getNext();
                this.head.setNext(null);
                temp.setPrev(null);
                this.head = temp;

            }
            this.size-=1;
            return data_temp;
        }
        else
        {
            return null;
        }
    }

    public T removeLast()
    {
        if(!this.isEmpty())
        {
            T data_temp = this.tail.getData();

            if(this.size == 1)
            {
                this.head = null;
                this.tail = null;
            }
            else
            {
                NodoDoble<T> temp = this.tail.getPrev();

                this.tail.setPrev(null);
                temp.setNext(null);
                this.tail = temp;

            }
            this.size-=1;
            return data_temp;
        }
        else
        {
            return null;
        }

    }

    public T remove(NodoDoble<T> n)
    {
        if(n == this.head)
        {
            return this.removeFirst();
        }
        else if(n == this.tail)
        {
            return this.removeLast();
        }
        else
        {
            T temp_data = n.getData();

            NodoDoble<T> temp_prev = n.getPrev();
            NodoDoble<T> temp_next = n.getNext();

            temp_prev.setNext(temp_next);
            temp_next.setPrev(temp_prev);

            n.setNext(null);
            n.setPrev(null);

            this.size-=1;

            return temp_data;
        }

    }

    public void addAfter(NodoDoble<T> n, T data)
    {
        if(n == this.tail)
        {
            this.addLast(data);
        }
        else
        {
            NodoDoble<T> m = new NodoDoble<>(data);
            NodoDoble<T> temp = n.getNext();

            n.setNext(m);
            m.setPrev(n);

            m.setNext(temp);
            temp.setPrev(m);

            this.size+=1;
        }
    }

    public void addBefore(NodoDoble<T> n, T data)
    {
        if(n == this.head)
        {
            this.addFirst(data);
        }
        else
        {
            NodoDoble<T> m = new NodoDoble<>(data);
            NodoDoble<T> temp = n.getPrev();

            temp.setNext(m);
            m.setPrev(temp);

            m.setNext(n);
            n.setPrev(m);

            this.size+=1;
        }
    }


}
