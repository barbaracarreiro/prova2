import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AppProva {
    public static void main(String[] args) throws InterruptedException, IOException {
        int opcao;
        Scanner in = new Scanner(System.in);
        List <Produto> produtos = new ArrayList<>();
        List <Venda> vendas = new ArrayList<>();
        
        do {

            System.out.println("\n----\nMENU\n----\n");
            System.out.println("1 - Incluir produto");
            System.out.println("2 - Consultar produto");
            System.out.println("3 - Listagem de produtos");
            System.out.println("4 - Relatorio de vendas - detalhadas");
            System.out.println("5 - Realizar venda");
            System.out.println("0 - Sair");
            System.out.println("Selecione uma opção: ");

            opcao = in.nextInt();
            in.nextLine();

            if (opcao == 1) {

                System.out.println("Informe o nome do produto: ");
                    String nome = in.nextLine();
                    System.out.println("Informe o codigo do produto: ");
                    int codigo = in.nextInt();
                    System.out.println("Informe o valor do produto");
                    Double valor = in.nextDouble();
                    System.out.println("Informe a quantidade em estoque: ");
                    int Quantidade = in.nextInt();
                    
                    for (int i = 0; i < produtos.size(); i++) {
                        if (produtos.get(i).getCodigo() == codigo) {
                            produtos.remove(i);
                        } 
                    }
                        produtos.add(new Produto(codigo, nome, valor, Quantidade));

                    in.nextLine();

                    voltarMenu(in);
            } else if (opcao == 2) {

                if (produtos.isEmpty()){
                    System.out.println("Não há produtos cadastrados para exibir. ");
                } else {

                System.out.println("Digite o codigo do produto : ");
                int codigo = in.nextInt();

                for (int i = 0; i < produtos.size(); i++) {
                    if (produtos.get(i).getCodigo() == codigo) {
                        
                        System.out.println("======================PRODUTO " + produtos.get(i).getNome() +"=============================");
                        System.out.println("Codigo : " +  produtos.get(i).getCodigo());
                        System.out.println("Nome  : " + produtos.get(i).getNome());
                        System.out.println("Valor : " + produtos.get(i).getValor());
                        System.out.println("Quantidade em estoque : " +  produtos.get(i).getQuantidade());
                    } 
                }
            }
                in.nextLine();

                voltarMenu(in);
            } else if (opcao == 3) {

                Double maior = Double.MIN_VALUE, medio = 0.0, menor = Double.MAX_VALUE;

                for (int i = 0; i < produtos.size(); i++) {
                
                    if (produtos.get(i).getValor() > maior) {
                        maior = produtos.get(i).getValor();
                    }
                    
                    if (produtos.get(i).getValor() < menor) {
                        menor = produtos.get(i).getValor();
                    }

                    medio = produtos.stream().collect(Collectors.averagingDouble(Produto::getValor));

                }
                
                ComparadorPreco comparador = new ComparadorPreco(maior, medio, menor);

                if (produtos.isEmpty()){
                    System.out.println("Não há produtos cadastrados para exibir.");
                } else {


                System.out.println("\nProdutos:");
                for (Produto p: produtos){
                   
                    
                    System.out.println("Codigo : " + p.getCodigo());
                    System.out.println("Nome  : " + p.getNome());
                    System.out.println("Valor : " +  p.getValor());
                    System.out.println("Quantidade em estoque : " + p.getQuantidade());
                }

                System.out.print(comparador.toString());
            }
                voltarMenu(in);
            }
            else if (opcao == 4) {
                if (vendas.isEmpty()) {
                    System.out.println("\nNão há produtos cadastrados para exibir.");
                } else {
                
                    Double maior = Double.MIN_VALUE, medio = 0.0, menor = Double.MAX_VALUE;
                    for (int i = 0; i < vendas.size(); i++) {
                
                        if (vendas.get(i).getValor() > maior) {
                            maior = vendas.get(i).getValor();
                        }
                        
                        if (vendas.get(i).getValor() < menor) {
                            menor = vendas.get(i).getValor();
                        }
    
                        medio = vendas.stream().collect(Collectors.averagingDouble(Venda::getValor));
    
                    }
                    
                    ComparadorPreco comparador = new ComparadorPreco(maior, medio, menor);

                    vendas.sort(new ComparadorData());
                    String dia = vendas.get(0).getData();
                    String mes = vendas.get(vendas.size() -1).getData();
                    System.out.printf("\nVendas || %s - %s:" , dia, mes);
                    
                    for (Venda p : vendas){
                        for (int i=0; i < produtos.size(); i++) {
                                            
                            System.out.println("Data:"+ p.getData());
                            System.out.println("Codigo : " + produtos.get(i).getCodigo());
                            System.out.println("Nome  : " + produtos.get(i).getNome());
                            System.out.println("Valor : " +  produtos.get(i).getValor());
                            System.out.println("Quantidade em estoque : " + produtos.get(i).getQuantidade());
                            System.out.println("Valor Total: " + p.getValorTotal());
                        }
                    }
                            System.out.print(comparador.toString());
                }
                    
                         voltarMenu(in);   
            } 

                  else if (opcao == 5) {

                boolean verificar = false;

                if (produtos.isEmpty()){
                    System.out.println("Não há produtos cadastrados para efetuar a venda.");
                
            voltarMenu(in);
                } else {

                    System.out.println("\nInforme a data da venda.");
                    String data = in.nextLine();
                    Venda venda = new Venda(data, null, null, null, null);
                    
                    while (venda.getData() == "ERRO") {
                        System.out.println("Pressione enter para reiniciar");

                        in.nextLine();
                     System.out.println("\nInforme a data da venda.");
                     data = in.nextLine();
                     venda = new Venda(data, null, null, null, null);
                    }
                    System.out.println("informe o codigo do produto: ");
                    int produto = in.nextInt();
                    System.out.println("informe a quantidade do produto: ");
                    int Quantidade = in.nextInt();

                    for (int i = 0; i < produtos.size(); i++) {
                        if (produtos.get(i).getCodigo() == produto) {
                            verificar = true;
                            if (produtos.get(i).getQuantidade() < Quantidade || Quantidade == 0){
                                System.out.println("Quantidade não disponivel em estoque! ");
                            } else{
                                produtos.get(i).setQuantidade(produtos.get(i).getQuantidade()- Quantidade);
                                Double valor = Quantidade * produtos.get(i).getValor();
                                vendas.add(new Venda(data, valor, valor, valor, valor));
                                
                                System.out.println("Venda concluida!");
                                
                            }
                        }
                  
                    }
                }
                if (verificar == false){
                    System.out.println("Não há produtos cadastrados com este codigo!");
               
                    in.nextLine();
               voltarMenu(in);

                }

              }
            else if (opcao != 0) {  
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}      