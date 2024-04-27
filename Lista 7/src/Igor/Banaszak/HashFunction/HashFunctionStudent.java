package Igor.Banaszak.HashFunction;

import Igor.Banaszak.Student;

public class HashFunctionStudent implements HashFunction<Student> {

    public int hashCode(Student object) {

        int hashCode = 0;


        hashCode ^= object.getNazwisko().hashCode();
        hashCode ^= object.getImie().hashCode();
        hashCode ^= object.getWiek();

        return hashCode;
    }
}