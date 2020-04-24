/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regisnumata;

/**
 * Representa uma nota fiscal
 * @author regisnumata
 */
public class NotaFiscal {
    
    private String numero;
    private String descricao;
    private String dataEmissao;
    private Imposto imposto;
    private Double valor;
    private Double valorComImposto;
    private String estado; //
    private Boolean cancelada;

    // construtor em teste
    public NotaFiscal(String numero, String descricao, String dataEmissao, Double valor, String estado) {
        this.numero = numero;
        this.descricao = descricao;
        this.dataEmissao = dataEmissao;
        this.valor = valor;
        this.estado = estado;
        this.cancelada = false;
    }
    

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Imposto getImposto() {
        return imposto;
    }

    public void setImposto(Imposto imposto) {
        this.imposto = imposto;
    }
    
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    
    public Double getValorComImposto() {
        return valorComImposto;
    }

    public void setValorComImposto(Double valorComImposto) {
        this.valorComImposto = valorComImposto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public Boolean getCancelada() {
        return cancelada;
    }

    public void setCancelada(Boolean cancelada) {
        this.cancelada = cancelada;
    }
    
    
    // public compareTo

    @Override
    public String toString() {
        return "\n" + "| Numero= " + numero + "| Descricao= " + descricao + "| DataEmissao= " + dataEmissao + "| Valor= " + valor + "| valorComImposto= " + valorComImposto + "| estado= " + estado + "| Cancelada= " + cancelada;
    }

    
    
    
    
    
    
    
    
}
