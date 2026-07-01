public class Casa<T> {
    T elemento;
    Casa<T> anterior;
    Casa<T> proximo;
    String tipo;
    public Casa(T elemento){
        this.elemento = elemento;
    }
}
