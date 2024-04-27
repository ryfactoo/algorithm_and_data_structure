package Igor.Banaszak;

public class ForestDisjointSet {


    public ElelmentTree makeSet(){
        return new ElelmentTree();
    }


    public ElelmentTree union(ElelmentTree eLementFirst, ElelmentTree eLementSecond){

        if (eLementFirst == null || eLementSecond == null){
            throw new IllegalArgumentException();
        }

        if ((eLementFirst = find(eLementFirst)) != (eLementSecond = find(eLementSecond)) ) {
            eLementSecond.setParent(eLementFirst);
        }

        return eLementFirst;
    }

    public ElelmentTree find(ElelmentTree element){

        if (element == null){
            throw new IllegalArgumentException();
        }

        if (element == element.getParent()){

            return element;

        }else {
            element.setParent(find(element.getParent()));
        }

        return element.getParent();
    }

}
