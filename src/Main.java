public class Main {

    public static void main(String[] args) {

        Client pessoa1 = new ClientIndividual("Rua Santa Quitéria 388", "Sergio", 16, 'm', "12345678910");
        Account contapf = new AccountCurrent(pessoa1, 1000, 1, 1, "Banco do Brasil");

        try {
            contapf.withdraw(1001);
        } catch (NegativeValueException | AccountLimitExceededException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("x");
    }
}