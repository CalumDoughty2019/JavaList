import java.util.NoSuchElementException;

public class DynamicJavaArrayList<E> implements ListADT<E>{

    public static final int CAPACITY = 5;
    private E[] list;
    private int size;


    public DynamicJavaArrayList(int capacity){
        list = (E[]) new Object[capacity];
        size = 0;
    }

    public DynamicJavaArrayList(){
        this(CAPACITY);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) {
        if(isEmpty()){
            throw new NoSuchElementException("List is empty");
        }
        return list[i];
    }

    @Override
    public E set(int i, E e) {
        checkIndex(i, size);
        E temp = list[i];
        list[i] = e;
        return temp;
    }

    private void checkIndex(int i, int CAPACITY) {
        if(i < 0 || i >= CAPACITY){
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }

    @Override
    public void add(int i, E e) {
        checkIndex(i, size + 1);

        if(size == list.length){
            resize(2 * list.length);
        }
        for(int k = size()-1; k >= i; k--){
            list[k+1] = list[k];
        }
        size++;
    }

    private void resize(int cap) {
        E[] temp = (E[]) new Object[cap];
        for(int k = 0; k < size; k++){
            temp[k] = list[k];
        }
        list = temp;
    }

    @Override
    public E remove(int i) {
        checkIndex(i, size);
        E temp = list[i];
        for(int k = i; k<size()-1; k++){ //move all items down now that we have removed item at index i
            list[k] = list[k+1];
        }
        list[size-1] = null; //remove empty index at end, as everything has been moved down
        size--;
        return temp;
    }
}
