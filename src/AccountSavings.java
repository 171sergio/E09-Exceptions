public class AccountSavings extends Account{


    public AccountSavings(Client owner, double balance, int ID, float limit, String agency) {
        super(owner, balance, ID, limit, agency);
    }

    public void setLimit(double newlimit){

        if(newlimit>1000){
            System.out.println("ERROR! O limite máximo é de R$1000");
        }
        else if(newlimit < 100){
            System.out.println("ERROR! O limite mínimo é de R$100");
        }
        else{
            limit = newlimit;;
        }

    }

    @Override
    public double calculateTax() {
        return 0;
    }
}