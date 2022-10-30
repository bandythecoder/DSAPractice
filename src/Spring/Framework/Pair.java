package Spring.Framework;

public class Pair<T, T1> {
    public Pair(T i, T1 i1) {
        key = i;
        value = i1;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public T1 getValue() {
        return value;
    }

    public void setValue(T1 value) {
        this.value = value;
    }

    T key;

    T1 value;
}
