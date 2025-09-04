public abstract class Armazem<T> implements Armazenavel<T> {
    public abstract void adicionar(T item);
    public abstract T obter(String nome);
}
