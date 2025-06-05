import java.util.ArrayList;

class Prato{ //Classe representando um prato de cada restaurante
    String nome; // Atributos (Características que serão atribuídos ao objeto)
    double preco;
    String descricao;
   
    public Prato(String nome, double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }
 
 
    public void mostrar(){ // Método (ações do objeto - exibe as informações)
        System.out.println(nome + " - R$ " + preco + ": " + descricao);
    }

 }
 

 class Restaurante{ // Classe representando um restaurante que tem cada prato
    String nome; // Atributos (Características que serão atribuídos ao objeto)
    String cnpj;
    Prato prato1;
    Prato prato2;
    Prato prato3;
 
    public Restaurante(String nome, String cnpj, Prato p1, Prato p2, Prato p3){ //Construtor com parâmetro(metodo que cria e inicializa o objeto)
        this.nome = nome;
        this.cnpj = cnpj;
        this.prato1 = p1;
        this.prato2 = p2;
        this.prato3 = p3;
    }
 
    public void mostrarCardápio(){
        System.out.println("Restaurante: " + nome);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Cardápio: ");
        prato1.mostrar();
        prato2.mostrar();
        prato3.mostrar();
        System.out.println();
    }
 }


class Cliente{ // Classe representando um cliente
    String nome;
    String CPF;
    int Cliente;


    public Cliente(String nome, String CPF, int Cliente){ // Construtor com parâmetro
        this.nome = nome;
        this.CPF = CPF;
        this.Cliente = Cliente;
    }

    public void mostrarCliente(){ // Método para mostrar os dados do cliente
        System.out.println("Cliente " + Cliente);
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + CPF);
        System.out.println();
    }
}


class Pedido { // Classe representando o pedido
    Prato pratoPedido1;
    Prato pratoPedido2;
    Restaurante restaurante;
    Cliente cliente;
    String observacao;
    private static int totalPedidos = 0;
    private int idPedido;


    public Pedido(Cliente cliente, Prato p1, Prato p2, Restaurante r) { // Construtor com parâmetro
        this.cliente = cliente;
        this.pratoPedido1 = p1;
        this.pratoPedido2 = p2;
        this.restaurante = r;
        this.observacao = "Sem observações!";
        totalPedidos++;
        idPedido = totalPedidos;
    }

    public Pedido(Cliente cliente, Prato p1, Prato p2, Restaurante r, String ob) { // Sobrecarga, caso houverem observações
        this.cliente = cliente;
        this.pratoPedido1 = p1;
        this.pratoPedido2 = p2;
        this.restaurante = r;
        this.observacao = ob;
        totalPedidos++;
        idPedido = totalPedidos;
    }

    public static int getTotalPedidosCriados(){
        return totalPedidos;
    }


    public void mostrarPedido(){ // Método para mostrar o pedido
        System.out.println("Id do Pedido: " + idPedido);
        System.out.println("Pedido do cliente: " + cliente.nome);
        System.out.println("Restaurante escolhido: " + restaurante.nome);
        System.out.println("Pratos escolhidos: " + pratoPedido1.nome + " e " + pratoPedido2.nome);
        System.out.println("Observação: " + observacao);
        System.out.printf("Total do pedido: R$ %.2f\n", calcularTotal());
        System.out.println();
    }


//Calcular O Total Do Pedido
    public double calcularTotal() { // Método para calcular o total
        return pratoPedido1.preco + pratoPedido2.preco;
    }

    @Override
    public String toString(){
        return "Pedido {" + cliente.nome + ": "+ pratoPedido1.nome + ", "+ pratoPedido2.nome + ", " + "Restaurante: " + restaurante.nome + " OBS: " + observacao + "}";
    }
}


 public class Main{ // Classe com funçao main (pro codigo ser executado)
    public static void main(String[] args) {
 
 
        Prato p1 = new Prato ("Pizza (G) de Calabresa", 40.0, "Molho, Queijo Mussarela, Clabresa e oregano"); //Objeto (ocorrência da classe prato)
        Prato p2 = new Prato ("Pizza (G) de Frango C/ Catupiry", 42.0, "Molho, Queijo Mussarela, Frango e Catupiry");
        Prato p3 = new Prato ("Pizza (P) de Chocolate", 25.0, "Queijo Mussarela e chocolate ao leite.");
 
        Prato p4 = new Prato ("Carne na Brasa (700g)", 35.0, "Acompanha Arroz, Farofa e Vinagrete");
        Prato p5 = new Prato ("Frango na Brasa (700g)", 30.0, "Acompanha Arroz, Farofa e Vinagrete");
        Prato p6 = new Prato ("Mistao (Serve 3 pessoas)", 60.0, "Carne, Frango e Linguica acompanhados de Arroz, Farofa, Vinagrete e Pirao de queijo");
   
        Prato p7 = new Prato ("Natal O84", 22.0, "Hamburguer artesanal, Queijo Mussarela, bacon, cebola caramelizada, salada e molho especial");
        Prato p8 = new Prato( "SGA 084", 20.0, "Frango Cremoso, Queijo Mussarela, Salada, Batata Palha e molho especial");
        Prato p9 = new Prato ("Macaiba 084", 25.0, "Hamburguer artesanal, Queijo Chedar, Farofa de Bacon e Geleia de Pimenta");
     
        Restaurante r1 = new Restaurante("Pizzaria 084", "13.267.588/0001-05", p1, p2, p3); //Objeto (ocorrência da classe Restaurante)
        Restaurante r2 = new Restaurante("Churrascaria 084", "15.190.340/0001-33", p4, p5, p6);
        Restaurante r3 = new Restaurante("Hamburgueria 084", "18.333.406/0001-12", p7, p8, p9);
 
 
        Cliente c1 = new Cliente("Pedro","123.456.789-10", 1); // Objeto(ocorrência da classe Cliente)
        Cliente c2 = new Cliente("Leonardo", "109.876.543-21", 2);
        Cliente c3 = new Cliente("Daniel", "321.654.987-01", 3);


        Pedido pedido1 = new Pedido(c1, p2, p3, r1, "Sem queijo mussarela na pizza de chocolate"); // Objeto(ocorrência da classe Pedido)
        Pedido pedido2 = new Pedido(c2, p5 , p6, r2);
        Pedido pedido3 = new Pedido(c3, p8, p9, r3, "Sem alfaces na salada");


        r1.mostrarCardápio();
        r2.mostrarCardápio();
        r3.mostrarCardápio();


        c1.mostrarCliente();
        c2.mostrarCliente();
        c3.mostrarCliente();
       
    ArrayList<Pedido> listaPedidos = new ArrayList<>();
    listaPedidos.add(pedido1);
    listaPedidos.add(pedido2);
    listaPedidos.add(pedido3);


    listarPedidosPorCliente("Pedro", listaPedidos);
    listarPedidosPorCliente("Leonardo", listaPedidos);
    listarPedidosPorCliente("Daniel", listaPedidos);


    listarPedidosPorRestaurante("Pizzaria 084", listaPedidos);
    listarPedidosPorRestaurante("Churrascaria 084", listaPedidos);
    listarPedidosPorRestaurante("Hamburgueria 084", listaPedidos);
    
    System.out.println("Total de Pedidos: " + Pedido.getTotalPedidosCriados());
    System.out.println("Descrição: " + pedido1.toString());
    System.out.println("Descrição: " + pedido2.toString());
    System.out.println("Descrição: " + pedido3.toString());
    System.out.println();
}


    // Listar pedidos por cliente e por restaurante.
    public static void listarPedidosPorCliente(String nomeCliente, ArrayList<Pedido> pedidos) {
        for (Pedido p : pedidos) {
            if (p.cliente.nome.equalsIgnoreCase(nomeCliente)) {
            p.mostrarPedido();
            }
        }
    }


    public static void listarPedidosPorRestaurante(String nomeRestaurante, ArrayList<Pedido> pedidos) {
        System.out.println("Pedidos do restaurante: " + nomeRestaurante);
            for (Pedido p : pedidos) {
                if (p.restaurante.nome.equalsIgnoreCase(nomeRestaurante)) {
                p.mostrarPedido();
                }
            }
    }
}