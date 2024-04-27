package Igor.Banaszak;

public class ListDisjointSet {

    public ELementList makeSet() {
        return new ELementList();
    }


    public ELementList union(ELementList eLementFirst, ELementList eLementSecond) {

        if (eLementFirst.getRep() != eLementSecond.getRep()) {
            if (eLementFirst.getSize() < eLementSecond.getSize()) {
                ELementList memory = eLementFirst.getRep();
                eLementFirst = eLementSecond.getRep();
                eLementSecond = memory;
            } else {
                eLementFirst = eLementFirst.getRep();
                eLementSecond = eLementSecond.getRep();
            }
            eLementFirst.getLast().setNext(eLementSecond);
            eLementFirst.setLast(eLementSecond.getLast());

            while (eLementSecond.getNext() != null) {
                eLementSecond.setRep(eLementFirst);
                eLementSecond = eLementSecond.getNext();
            }

            eLementSecond.setRep(eLementFirst);
            eLementFirst.setSize(eLementSecond.getSize() + eLementFirst.getSize());
        }

        return eLementFirst;
    }

    public ELementList find(ELementList eLement){
        return eLement.getRep();
    }
}
