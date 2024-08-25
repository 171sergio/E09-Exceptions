public class Main {

    public static void main(String[] args) {
        Client pessoa1 = new ClientIndividual("Rua Santa Quitéria 388", "Sergio", 16, 'm', "12345678910");
        Client empresa1 = new ClientJP("Rua Santa Quitéria 388", "Serralheria Marinheiro", "Serralheria", 1, "12345678910");
        Client pessoa2 = new ClientIndividual("Rua Santa Quitéria 388", "Sergio", 16, 'm', "12345678910");
        Client empresa2 = new ClientJP("Rua Santa Quitéria 388", "Serralheria Marinheiro", "Serralheria", 1, "12345678910");
        Account contapj = new AccountCurrent(empresa1, 1000, 1, 10000, "Banco do Brasil");
        Account contapf = new AccountCurrent(pessoa1, 1000, 1, 10000, "Banco do Brasil");
        Account contapoup = new AccountSavings(pessoa1, 1000, 1, 10000, "Banco do Brasil");
        Account contauni = new AccountUniversity(pessoa1, 1000, 1, 10000, "Banco do Brasil");

        System.out.println("ContaPJ");
        contapj.deposit(10000);
        contapj.withdraw(10);
        contapj.withdraw(1);
        contapj.withdraw(900);

        try {
            Thread.sleep(5000); // pausa de 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        contapj.deposit(20);
        contapj.withdraw(20);
        System.out.println("Ordenado por tipo de operação");
        contapj.printStatemant(1);
        System.out.println("Ordenado por data");
        contapj.printStatemant(0);
        System.out.println("Exemplo de caso de flag inválido");
        contapj.printStatemant(10);
    }
}
