public class QueueImpl<E> implements Queue<E> { /** Per què posem <E>?? Mai abans haviem declarat classe amb tipus de variable */

    E[] data;
    //int[] proba;
    int p;

    public QueueImpl<E> (int length){
        this.data = (E[])new Object[length];
        //this.proba = new int[length]; /**per què amb un vector d'enters ho deixa fer així pero amb "E" no? */
        this.p = 0;
    }

    public void push(E e){
        this.data[p] = e;
        this.p++;
    }

    public E pop(){
        this.p--; /** Resto 1 a la long. per evitar que intenti moure quelcom fora del vector */
        for (int i = 0; i < this.p; i++){ /**d'aquesta forma, l'última posició del vector quedarà sempre plena, ens és igual?*/
            this.data[i] = this.data[i + 1];
        }
        return this.data[0];
    }
}
