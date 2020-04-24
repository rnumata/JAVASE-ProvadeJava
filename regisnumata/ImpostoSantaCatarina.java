/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regisnumata;

/**
 * Representa imposto Santa Catarina
 * @author regisnumata
 */
public class ImpostoSantaCatarina extends Imposto {
    
    private final Double aliquotaSC = 0.1;

    public ImpostoSantaCatarina(Double valor) {
        super(valor);
    }
    
    /**
     * /**
     * Metodo que aplica a aliquota do imposto estadual ao valor da NF
     * @return 
     */
    @Override
    public Double calcularImpostoEstadual() {
        return this.valor * aliquotaSC;
    }

    @Override
    public Double calcularImpostoTotal() {
        return super.calcularImpostoFederal() + calcularImpostoEstadual(); 
    }
    
    
    
    
    
    
    
} // fim classe
