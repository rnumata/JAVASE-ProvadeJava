/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regisnumata;

/**
 * Representa o imposto Parana
 * @author regisnumata
 */
public class ImpostoParana extends Imposto {
    
    private final Double aliquotaPR = 0.07;
   

    public ImpostoParana(Double valor) {
        super(valor);
    }
    
    /**
     * Metodo que aplica a aliquota do imposto estadual ao valor da NF
     * @return 
     */
    @Override
    public Double calcularImpostoEstadual() {
        return this.valor * aliquotaPR;
    }

    @Override
    public Double calcularImpostoTotal() {
        return super.calcularImpostoFederal() + calcularImpostoEstadual(); 
    }

    
    
    
    
    
    
}// fim classe
