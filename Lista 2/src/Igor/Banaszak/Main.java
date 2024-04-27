package Igor.Banaszak;

import Igor.Banaszak.Generator.*;

public class Main {

    public static void main(String[] args) throws IndexOutOfBoundsException {

        SeriesGenerator generator = new GeneratorString();
        SeriesIterator seriesIterator = new SeriesIterator(generator);




//        System.out.println("test");
//        Series series = new Series(generator);
//        for (Object i : series){
//            System.out.println(i);
//        }







//        System.out.println("test z wyrazem n-tym rownym zero");
//        FiniteSeries series = new FiniteSeries(generator,0);
//        for (Object i : series){
//            System.out.println(i);
//        }
//
//
//        System.out.println("test z wyrazem n-tym ujemnym");
//        series = new FiniteSeries(generator,-1);
//        for (Object i : series){
//            System.out.println(i);
//        }
//
//
//        System.out.println("test z wyrazem n-tym rownym jeden");
//        series = new FiniteSeries(generator,1);
//        for (Object i : series){
//            System.out.println(i);
//        }
//
//
//
//        System.out.println("test z wyrazem n-tym rownym (prowadzący podaje)");
//         series = new FiniteSeries(generator,10);
//        for (Object i : series){
//            System.out.println(i);
//        }








//        for (int i = 0;i < 10;i++) {
//            seriesIterator.next();
//        }
//        System.out.println(seriesIterator.next());











    }
}
