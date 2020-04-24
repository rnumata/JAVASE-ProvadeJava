
package regisnumata;

import java.util.ArrayList;

/**
 * 
 * @author regisnumata
 */
public class RegisNumata {

  
    public static ArrayList<Empresa> empresas = new ArrayList();
    public static ArrayList<NotaFiscal> notasFiscais = new ArrayList();
    public static Empresa empresa;
    public static NotaFiscal notafiscal;
    public static Imposto imposto;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        String[] opcoes = {
            "Criar Empresa",
            "Listar Empresas",
            "Excluir Empresa",
            "Cancelar NF"
        };
        
        boolean continuar  = true;
        
        do {
            System.out.println("\n");
            int opcao = regisnumata.Console.mostrarMenu(opcoes, "Lista :");
            System.out.println("Opçao => " + opcao);
            
            switch(opcao){
                
                case 1:
                    try{
                        // Criação do objeto Empresa
                        String nome = Console.recuperaTexto("Informe nome da empresa: ");
                        String cnpj = Console.recuperaTexto("Informe o CNPJ: ");
                        checarCnpj(cnpj);
                        empresa = new Empresa(nome, cnpj);
                        empresas.add(empresa);
                        
                            // Cadastro da notafiscal
                            String nf = Console.recuperaTexto("Deseja cadastrar NF? S/N");
                            while(nf.equalsIgnoreCase("s")){
                                
                                // recupera inputs, cria objeto NotaFiscal e o adiciona no ArrayList estatico notasFiscais. Posteriormente ele será adicionado no ArrayList de notas da empresa  
                                String numero = Console.recuperaTexto("Informe Numero: ");
                                String descricao = Console.recuperaTexto("Informe descricao: ");
                                String dataEmissao = Console.recuperaTexto("Informe data: ");
                                Double valor = Console.recuperaDecimal("Informe valor: ");
                                String estado = Console.recuperaTexto("Informe estado: ");
                                notafiscal = new NotaFiscal(numero, descricao, dataEmissao, valor, estado);
                                notasFiscais.add(notafiscal); 
                                
                                // Conforme o Estado é gerado um objeto do respectivo imposto(para calcular o imposto total) e é atualizado a variavel ValorComImposto do objeto notafiscal
                                if (estado.equalsIgnoreCase("pr")) {
                                    imposto = new ImpostoParana(notafiscal.getValor());
                                    Double valorcomimposto = notafiscal.getValor() + imposto.calcularImpostoTotal();
                                    notafiscal.setValorComImposto(valorcomimposto);
                                } else if (estado.equalsIgnoreCase("sc")) {
                                    imposto = new ImpostoSantaCatarina(notafiscal.getValor());
                                    Double valorcomimposto = notafiscal.getValor() + imposto.calcularImpostoTotal();
                                    notafiscal.setValorComImposto(valorcomimposto);
                                } else if (estado.equalsIgnoreCase("sp")) {
                                    imposto = new ImpostoSaoPaulo(notafiscal.getValor());
                                    Double valorcomimposto = notafiscal.getValor() + imposto.calcularImpostoTotal();
                                    notafiscal.setValorComImposto(valorcomimposto);
                                }
                                
                                // decisão se volta para o while        
                                nf = Console.recuperaTexto("Deseja cadastrar NF? S/N");
                            }
                            
                            empresa.setNotasFiscais(notasFiscais);              //Adiciona as nostasfiscais no ArrayList da empresa
                            notasFiscais.clear();                               //Limpa ArrayList estatico para preenchimento de NFs da próxima empresa
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                case 2:
                    for(Empresa valor : empresas){
                        System.out.println(valor);
                    }
                    break;
                    
                case 3:
                    try{
                        String emp = Console.recuperaTexto("Informe a empresa para excluir: ");
                        excluirEmpresa(emp);
                        empresas.remove(empresa);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
   
                case 4:
                    String emp = Console.recuperaTexto("Informe a empresa: ");
                    String numero = Console.recuperaTexto("Informe o numero da NF: ");
                    cancelarNotaFiscal(emp, numero);
                    break;  
                
                case -1:
                    System.out.println("FIM DE EXECUÇÃO");
                    continuar = false;
                    break;    
            }  
        } while (continuar);
        
        
        
        
        
    } // fim main

    
    
    /**
     * Metodo que confere se CNPJ já está cadastrado no ArrayList de empresas
     * @param cnpj
     * @throws Exception 
     */
    public static void checarCnpj(String cnpj) throws Exception {
        for(Empresa checarEmpresa : empresas){
            if (checarEmpresa.getCnpj().equalsIgnoreCase(cnpj)) {
                throw new Exception("CNPJ já cadastrado !");
            }
        }
    }

    
    /**
     * Metodo que confere se a empresa informada tem NFs validas.Ou seja, se a variavel cancelada é = false.
     * @param empresa
     * @throws Exception 
     */
    public static void excluirEmpresa(String empresa) throws Exception {
        for(Empresa aserexcluida : empresas){
            if (aserexcluida.getNome().equalsIgnoreCase(empresa)) {           // verifica se a empresa escolhida é a do loop do for
                for(NotaFiscal cancelada : aserexcluida.getNotasFiscais()){   // faz um loop no objeto NF da empresa escolhida
                    if(cancelada.getCancelada().equals(false)){                 // Se tiver NF com cancelada = false dispara a exceção
                        throw new Exception("Não é possível excluir a empresa pois possui NF(s) válida(s) !!");
                    }
                }
            }
        }
        
    }
    

    /**
     * Metodo que altera a variavel cancelada da NotaFiscal escolhida em true.
     * @param empresa
     * @param numero 
     */
    public static void cancelarNotaFiscal(String empresa, String numero) {
        for(Empresa aexcluirNota : empresas){
            if (aexcluirNota.getNome().equalsIgnoreCase(empresa)) {
                for(NotaFiscal acancelar : aexcluirNota.getNotasFiscais()){
                    if (acancelar.getNumero().equalsIgnoreCase(numero)) {
                        acancelar.setCancelada(true);
                    }
                }
            }
        }
    }

    
   
    
    

    
    
    
    
    
} // fim classe
