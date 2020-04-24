/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regisnumata;

/**
 * Representa o imposto SaoPaulo
 * @author regisnumata
 */
public class ImpostoSaoPaulo extends Imposto {
    
    private final Double aliquotaSP = 0.23;
    
    public ImpostoSaoPaulo(Double valor) {
        super(valor);
    }

    /**
     * Metodo que aplica a aliquota do imposto estadual ao valor da NF
     * @return 
     */
    @Override
    public Double calcularImpostoEstadual() {
        return this.valor * aliquotaSP;
    }

    @Override
    public Double calcularImpostoTotal() {
        return super.calcularImpostoFederal() + calcularImpostoEstadual(); 
    }
    
    
    
    
    
    
    
}// fim classe
