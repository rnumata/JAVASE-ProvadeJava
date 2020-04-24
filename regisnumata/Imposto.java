/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regisnumata;

/**
 * Representa o imposto a ser calculado
 * @author regisnumata
 */
public abstract class Imposto {
    
    private final Double aliquotaFederal = 0.12;
    protected Double valor;

    public Imposto(Double valor) {
        this.valor = valor;
    }
    
    public Double calcularImpostoTotal(){
        return null;
    }
    
    /**
     * Metodo que aplica a aliquota do imposto federal ao valor da NF
     * @return 
     */
    public Double calcularImpostoFederal(){
        return this.valor * aliquotaFederal;
    }
    
    
    public abstract Double calcularImpostoEstadual();
    
    
    
    
}// fim classe
