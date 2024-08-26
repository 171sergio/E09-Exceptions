public class LimitExceededException extends IllegalArgumentException{
    public LimitExceededException(){
        super();
    }

    public LimitExceededException(String msg){
        super(msg);
    }

}