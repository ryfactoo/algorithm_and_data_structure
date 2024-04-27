package Igor.Banaszak.Generator;

public class GeneratorString <E> implements SeriesGenerator<String> {


    public String generate(int n) {

        if (n>=0) {
            String result = "";


            for (int i = 1; i <= n; i++) {
                result = result + "a";
            }

            return  result;

        } else {

            return null;
        }
    }
}
