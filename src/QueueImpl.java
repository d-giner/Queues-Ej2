public class QueueImpl<E> implements Queue<E> {

    E[] data;
    /**int[] proba; */
    int p;
    boolean plena;
    boolean buida;

    public QueueImpl(int length){
        this.data = (E[])new Object[length];
        /**this.proba = new int[length]; /**per què amb un vector d'enters ho deixa fer així pero amb "E" no? */
        this.p = 0;
    }

    public void push(E e) throws QueueFullException {
        cuaPlena();
        if (this.plena)
            throw new QueueFullException();
        else {
            this.data[p] = e;
            this.p++;
        }
    }

    public E pop() throws QueueEmptyException {
        cuaBuida();
        if(this.buida)
            throw new QueueEmptyException();
        else {
            E aux = data[0];
            this.p--;
            for (int i = 0; i < this.p; i++) { /**d'aquesta forma, l'última posició del vector quedarà sempre plena, ens és igual?*/
                this.data[i] = this.data[i + 1];
            }
            return aux;
        }
    }

    public int getSize() {
        return this.data.length;
    }

    public int getElementsCua(){
        return this.p;
    }

    /** Booleans per fer saltar les excepcions */
    public void cuaPlena() {
        if (this.p >= this.data.length){
            this.plena = true;
        }
    }

    public void cuaBuida(){
        if (this.p == 0)
            this.buida = true;
        else
            this.buida = false;
    }
}
