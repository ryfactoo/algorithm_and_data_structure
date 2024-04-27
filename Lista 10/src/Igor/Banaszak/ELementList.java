package Igor.Banaszak;

public class ELementList {

    private ELementList rep;
    private ELementList next =null;
    private ELementList last;
    private int size;

    public ELementList(){
        this.rep = this;
        this.last = this;
        this.size = 1;
    }

    public ELementList getRep() {
        return rep;
    }

    public ELementList getNext() {
        return next;
    }

    public ELementList getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }

    public void setRep(ELementList rep) {
        this.rep = rep;
    }

    public void setNext(ELementList next) {
        this.next = next;
    }

    public void setLast(ELementList last) {
        this.last = last;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
