package Igor.Banaszak.Comparator;

import Igor.Banaszak.Student;
import java.util.Comparator;

public class ComparatorStudent implements Comparator<Student> {



    public int compare(Student o1, Student o2) {

        if (o1.getNazwisko().compareTo(o2.getNazwisko()) == 0) {
            if (o1.getImie().compareTo(o2.getImie()) == 0) {
                if ((o1.getWiek() - o2.getWiek()) == 0) {
                    if ((o1.getListaOcen().size() - o2.getListaOcen().size()) == 0) {
                        for (int i = 0 ; i < o1.getListaOcen().size() ; i++ ) {

                            if ((int)o1.getListaOcen().get(i) - (int)o2.getListaOcen().get(i) != 0) {
                                return (int)o1.getListaOcen().get(i) - (int)o2.getListaOcen().get(i);
                            }

                        }

                        return 0;
                    }
                    return o1.getListaOcen().size() - o2.getListaOcen().size();
                }
                return o1.getWiek() - o2.getWiek();
            }
            return o1.getImie().compareTo(o2.getImie());
        }
        return o1.getNazwisko().compareTo(o2.getNazwisko());
    }
}
