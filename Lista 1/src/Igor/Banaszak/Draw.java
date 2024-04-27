package Igor.Banaszak;

public class Draw {

    public void drawPyramid(int n,int h) {

        if (n>= 0 && h>0) {


            long lengthSpace = h - 1;
            long lengthX = 2 * n + 1;
            for (int i = 1; i <= h; i++) {
                drawPyramidLine(lengthX, lengthSpace);
                lengthSpace--;
                lengthX += 2;
            }
        }
    }


    public void drawAFigure(int n) {

        if (n>0) {

            for (int i = 1; i <= n; i++) {
                for (int j = i; j <= n; j++) {
                    drawPyramidLine(j * 2L - 1, n - j);
                }
            }
        }
    }

    private void drawPyramidLine(long xLine,long spaceLine) {

        StringBuilder space = new StringBuilder();
        StringBuilder x = new StringBuilder();


        for (int i = 0; i<xLine || i<spaceLine ; i++) {

            if (i < spaceLine) {
                space.append(" ");
            }

            if (i < xLine) {
                x.append("X");
            }
        }

        System.out.println(space+ x.toString() +space);
    }


    public void drawJoinedTriangles(int n) {

        int spaceBetween = n-3;
        int howManyTime = 0;


        if(n > 0 && n<724) {

            drawPyramidLine(n*2+1,0);

            if (n > 2) {


                for (int i = 0; i < (n - 1) / 2; i++) {

                    howManyTime = i;
                    drawJoinedTrianglesLine(i, spaceBetween);
                    spaceBetween -= 2;
                }
            }


            if (n%2 == 0) {

                StringBuilder spaceBuilder = new StringBuilder();


                for (int j = 0 ; j<(n-1)/2 ; j++) {

                    spaceBuilder.append(" ");
                }

                System.out.println(" " + spaceBuilder + "X" + spaceBuilder + " " + spaceBuilder + "X" + spaceBuilder);
            }

            if (n > 2) {

                for (int k = howManyTime; k >= 0; k--) {

                    spaceBetween += 2;
                    drawJoinedTrianglesLine(k, spaceBetween);

                }
            }


                drawPyramidLine(n * 2 + 1, 0);

        } else if (n == 0) {
            System.out.println("X");


        } else if (n >= 724) {
            System.out.println("liczba za duża, figura bylaby narysowana w niewlasciwy sposob");
        }
        System.out.println();
    }




    private void drawJoinedTrianglesLine (int space1 , int spaceBetweenX) {

        StringBuilder spaceBuilder = new StringBuilder();
        StringBuilder spaceBetweenXBuilder = new StringBuilder();


        for (int i = 0; i<space1 || i<spaceBetweenX ; i++) {

            if (i < space1) {
                spaceBuilder.append(" ");
            }

            if (i < spaceBetweenX) {
                spaceBetweenXBuilder.append(" ");
            }
        }

        System.out.println(" " + spaceBuilder + "X" + spaceBetweenXBuilder + "X" + spaceBuilder + " " + spaceBuilder + "X" + spaceBetweenXBuilder + "X" + spaceBuilder + " ");
    }

}
