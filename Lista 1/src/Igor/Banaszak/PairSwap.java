package Igor.Banaszak;

import java.util.List;

public class PairSwap {

    public void pairSwap(String text) {

        if (text == null || text.equals("")) {

        } else {

            List<String> list;

            int identy1;

            list = List.of(text.split(" "));



            for (int i = 0; i < list.size(); i++) {

                String[] tabIdentyfikator = list.get(i).split("=");



                if (tabIdentyfikator.length == 2 && !list.get(i).endsWith("=")) {

                    if (czyIdentyfikator(tabIdentyfikator[0]) == true && czyIdentyfikator(tabIdentyfikator[1]) == true) {

                            System.out.print(tabIdentyfikator[1] + "=" + tabIdentyfikator[0]);

                    } else {
                        System.out.print(list.get(i));
                    }
                } else {
                    System.out.print(list.get(i));
                }

                System.out.print(" ");
            }
            System.out.println();
        }
    }




    public boolean czyIdentyfikator(String identyfikator) {

        char[] chars = identyfikator.toCharArray();

        if ((chars[0] > 64 && chars[0] < 91) || (chars[0] > 96 && chars[0] < 123) || chars[0] == 95) {

            for (int i = 1;i < chars.length;i++) {

                if (chars[i] < 48 || (chars[i] > 57 && chars[i] < 65) || (chars[i] > 90 && chars[i] < 97) || chars[i] > 122) {

                    return false;
                }
            }

        } else {
            return false;
        }

        return true;
    }
}
