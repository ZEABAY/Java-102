public class MyList<T> {
    private int capacity;
    private T[] list;
    private int size;

    public MyList() {
        this.capacity = 10;
        list = (T[]) new Object[this.getCapacity()];
        this.setSize(0);
    }

    public MyList(int capacity) {
        this.capacity = capacity;
        list = (T[]) new Object[this.getCapacity()];
        this.setSize(0);
    }


    public void add(T data) {
        if (size == getCapacity()) {
            setCapacity(getCapacity() * 2);
            T[] newList = (T[]) new Object[getCapacity()];
            System.arraycopy(this.getList(), 0, newList, 0, size);
            this.setList(newList);
        }
        this.getList()[size++] = data;
    }


    public T get(int i) {
        return this.getList()[i];
    }


    public void remove(int i) {
        if (!(i < 0 || i >= this.size())) {

            for (int j = i; j <= this.size(); j++) {
                this.getList()[j] = this.getList()[j + 1];
            }

        }
        this.getList()[i] = null;
        this.setSize(this.size() - 1);
    }


    public void set(int i, T data) {
        if (!(i < 0 || i >= this.size())) {
            this.getList()[i] = data;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (this.size == 0) {
            sb.append("[]");
            return sb.toString();
        }
        sb.append("[");
        for (int i = 0; i < this.size() - 1; i++) {
            sb.append(this.getList()[i]);
            sb.append(", ");
        }
        sb.append(this.getList()[this.size() - 1]);
        sb.append("]");
        return sb.toString();
    }

    public boolean isEmpty() {
        return !(this.size() > 0);
    }

    public int indexOf(T data) {
        for (int i = 0; i < this.size(); i++) {
            if (this.getList()[i] == data) {
                return i;
            }
        }

        return -1;
    }


    public int lastIndexOf(T data) {
        for (int i = size; i >= 0; i--) {
            if (this.getList()[i] == data) {
                return i;
            }
        }

        return -1;
    }

    public T[] toArray() {
        T[] newArray = (T[]) new Object[size];
        System.arraycopy(this.getList(), 0, newArray, 0, size);
        return newArray;
    }


    public MyList<T> subList(int start, int finish) {

        MyList<T> subList = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            subList.add(this.getList()[i]);
        }

        return subList;
    }


    public boolean contains(T data) {
        for (T element : this.getList()) {
            if (element == data) {
                return true;
            }
        }


        return false;
    }

    public void clear() {
        this.setCapacity(10);
        T[] cleanList = (T[]) new Object[this.getCapacity()];
        this.setSize(0);

        this.list = cleanList;
    }
    ///////


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public T[] getList() {
        return list;
    }

    public void setList(T[] list) {
        this.list = list;
    }

    public int size() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
