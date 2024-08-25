public class AccountUniversity extends Account{

    public AccountUniversity(Client owner, double balance, int ID, double limit, String agency) {
        super(owner, balance, ID, limit, agency);
    }

    public void setLimit(double newlimit){

            if(newlimit>500){
                System.out.println("ERROR! O limite máximo é de R$500");
            }
            else if(newlimit < 0){
                System.out.println("ERROR! O limite mínimo é de R$0");
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


