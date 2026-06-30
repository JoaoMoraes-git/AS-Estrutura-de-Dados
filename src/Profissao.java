public class Profissao {
    private String titulo;
    private double multSalario;
    private double multiImposto;
    private double multiAluguelPago;
    private double multiAluguelRecebido;

    public Profissao(String titulo, double multSalario, double multiImposto, double multiAluguelPago, double multiAluguelRecebido) {
        this.titulo = titulo;
        this.multSalario = multSalario;
        this.multiImposto = multiImposto;
        this.multiAluguelPago = multiAluguelPago;
        this.multiAluguelRecebido = multiAluguelRecebido;
    }

    public Profissao(){
        this.titulo = "Título padrão";
        this.multSalario = 1.0;
        this.multiImposto = 1.0;
        this.multiAluguelPago = 1.0;
        this.multiAluguelRecebido = 1.0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getMultSalario() {
        return multSalario;
    }

    public void setMultSalario(double multSalario) {
        this.multSalario = multSalario;
    }

    public double getMultiImposto() {
        return multiImposto;
    }

    public void setMultiImposto(double multiImposto) {
        this.multiImposto = multiImposto;
    }

    public double getMultiAluguelPago() {
        return multiAluguelPago;
    }

    public void setMultiAluguelPago(double multiAluguelPago) {
        this.multiAluguelPago = multiAluguelPago;
    }

    public double getMultiAluguelRecebido() {
        return multiAluguelRecebido;
    }

    public void setMultiAluguelRecebido(double multiAluguelRecebido) {
        this.multiAluguelRecebido = multiAluguelRecebido;
    }
}
