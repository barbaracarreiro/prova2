public class Produto { 
    private int codigo;
    private String nome;
    private Double valor;
    private int Quantidade;
    private Double qntdVendida;

    public Double getQntdVendida() {
        return qntdVendida;
    }

    public void setQntdVendida(Double qntdVendida) {
        this.qntdVendida = qntdVendida;
    }

    public Produto (int codigo, String nome, Double valor, int Quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.Quantidade = Quantidade;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public int getQuantidade() {
        return Quantidade;
    }
    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }
}