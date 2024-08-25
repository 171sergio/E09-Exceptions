public class OperationWithdraw extends Operation implements ITaxa{
    public OperationWithdraw(float amount) {
        super('s', amount);
    }

    @Override
    public double calculateTax() {
        return 0.05;
    }
}
