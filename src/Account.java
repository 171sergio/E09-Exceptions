import java.util.ArrayList;
import java.util.Collections;

public abstract class Account implements ITaxa{

    protected Client owner;
    private double balance;
    private int ID;
    protected double limit;
    private String agency;


    protected ArrayList<Operation> operations = new ArrayList<Operation>();

    public static int totAccounts=0;

    public Account(Client owner, double balance, int ID, double limit, String agency) {
        this.owner = owner;
        this.balance = balance;
        this.ID = ID;
        this.limit = limit;
        this.agency = agency;
        totAccounts++;
    }


    boolean deposit(float value) throws NegativeValueException {

            if(value<0.0){ throw new NegativeValueException("ERRO: Depósito com valor negativo.");}

            this.balance += value;
            operations.add(new OperationDeposit(value));
            return true;

    }


    boolean withdraw(float value) throws NegativeValueException, AccountLimitExceededException{
            if (value < 0.0){ throw new NegativeValueException("ERRO: Saque com valor negativo."); }
            if(value > this.balance){ throw new AccountLimitExceededException("ERRO: Valor desejado é maior que o saldo."); }
            this.balance -= value;
            operations.add(new OperationWithdraw(value));
            return true;
    }


    boolean transfer(Account destineAccount, float value) throws NegativeValueException, AccountLimitExceededException{
        boolean withdrawMade = this.withdraw(value);
        if (withdrawMade) {
            boolean deposit = destineAccount.deposit(value);
            return deposit;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
		String accountStr = " Nome do dono da conta: " + this.owner.name+ "\n" +
     " Número da conta: " + this.ID+ "\n" +
     " Saldo atual: " + this.balance+ "\n" +
     " Limite: " + this.limit + "\n\n" ;

		return accountStr;
	}
    @Override
    public boolean equals(Object obj){
        Account actcomp = (Account) obj;
        return actcomp.ID == this.ID;
    }

    void printStatemant(int order) {
            ArrayList<Operation> operacoes = new ArrayList<Operation>(this.operations);
            switch (order) {
                case 0: break;
                case 1: Collections.sort(operacoes); break;
                default: System.out.println("\nERRO! Algum Número deve ser digitado.\n"); return;
            }

            for (Operation operacao : operacoes) { System.out.print(operacao.toString()); }
    }

    public void printFeeStatement(){
        double totalFee = this.calculateTax();
        System.out.printf("=== Extrato de Taxas ===\nManutenção da conta: %.2f\n\n", this.calculateTax() );
        System.out.println("Operações:\n");
        for(int i = 0; i < operations.size(); i++){
            totalFee += this.operations.get(i).calculateTax();
            if(operations.get(i).type == 's' && operations.get(i).calculateTax() != 0){
                System.out.printf("Saque: %.2f\n", operations.get(i).calculateTax());
            }
        }
        System.out.printf("\nTotal: %.2f\n", totalFee);
    }


    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) { this.owner = owner; }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getBalance() {
        return balance;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public abstract void setLimit(double newlimit);

    public ArrayList<Operation> getOperations() { return operations; }
}