public class Casa<T> {
    T elemento;
    Casa anterior;
    Casa proximo;
    String tipo;

    public Casa(T elemento){
        this.anterior = null;
        this.proximo = null;
        this.tipo = tipo;
    }
}
