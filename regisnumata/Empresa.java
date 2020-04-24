/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regisnumata;

import java.util.ArrayList;

/**
 * Representa uma empresa
 * @author regisnumata
 */
public class Empresa {
    
    private String nome;
    private String cnpj;
    private ArrayList<NotaFiscal> notasFiscais = new ArrayList();

    public Empresa(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public ArrayList<NotaFiscal> getNotasFiscais() {
        return notasFiscais;
    }

    public void setNotasFiscais(ArrayList<NotaFiscal> notasFiscais) {
        this.notasFiscais.addAll(notasFiscais);
    }

    
    /**
     * Metodo que seleciona as NFs validadas do ArrayList notasFiscais
     * @return 
     */
    public ArrayList<NotaFiscal> getNostasFiscaisValidadas(){
        return null;
    }
    
    /**
     * Metodo que seleciona as NFs canceladas do ArrayList notasFiscais
     * @return 
     */
    public ArrayList<NotaFiscal> getNotasFisvaisCanceladas(){
        return null;
    }
    
    
    @Override
    public String toString() {
        return "Empresa: " + "Nome= " + nome + "| cnpj= " + cnpj + "\n" + "| notasFiscais= " + notasFiscais;
    }
    
    
    
} //fim classe
