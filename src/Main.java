public class Main {

    public static void main(String[] args) {

        Client client = new ClientIndividual("Rua Exemplo, 123", "Ana", 21, 'F', "12345678901");

        // Criação de uma conta universitária
        Account account = new AccountUniversity(client, 1000.0, 1, 200.0, 100.0, "Agência 123");

        try {
            // Tentativa de definir um limite maior que o máximo permitido
            account.setLimit(10);
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());  // Corrigido para exibir a mensagem
        }
    }
}
