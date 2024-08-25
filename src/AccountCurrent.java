public class  AccountCurrent extends Account{

    public AccountCurrent(Client owner, double balance, int ID, double limit, String agency) {
        super(owner, balance, ID, limit, agency);
    }

    public void setLimit(double newlimit){

        if(newlimit<-100){
            System.out.println("ERRO!  O limite minimo é de R$ -100,00");
        }
        else {
            limit = newlimit;
        }

    }

    @Override
    public double calculateTax() {
        if(this.owner instanceof ClientIndividual){
            return 10;
        }
        else{
            return 20;
        }
    }



}

