public class Venda {
    private String data;
    private Double codProduto;
    private Double qntdVendida;
    private Double valorTotal;
    private Double valor;
    private String dataRev;
    
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Venda(String data, Double codProduto, Double qntdVendida,Double valor, Double valorTotal) {
        this.data = data;
        this.codProduto = codProduto;
        this.qntdVendida = qntdVendida;
        this.valorTotal = valorTotal;
        this.valor = valor;
    }

    public Venda(Double qntdVendida){
        setQntdVendida(qntdVendida);
    }

    public Venda(String data){
        setData(data);
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
        this.dataRev = data.substring(3, 5) + data.substring(0, 2);
    }
    public String getDataRev() {
        return dataRev;
    }
    public Double getCodProduto() {
        return codProduto;
    }
    public void setCodProduto(Double codProduto) {
        this.codProduto = codProduto;
    }
    public Double getQntdVendida() {
        return qntdVendida;
    }
    public void setQntdVendida(Double qntdVendida) {
        this.qntdVendida = qntdVendida;
    }
    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}