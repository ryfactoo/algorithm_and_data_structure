package Igor.Banaszak;

public class ElelmentTree {

    private ElelmentTree parent;

    public ElelmentTree(){
        this.parent = this;
    }

    public ElelmentTree getParent() {
        return parent;
    }

    public void setParent(ElelmentTree parent) {
        this.parent = parent;
    }
}
