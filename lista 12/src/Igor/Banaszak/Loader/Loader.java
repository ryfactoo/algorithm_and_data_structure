package Igor.Banaszak.Loader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class  Loader {

//    private int loadSize(Scanner scanner){
//
//    }

    protected Scanner loadPath(String path){

        try{
            Scanner scanner = new Scanner(new File(path));
            return scanner;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        throw new IllegalArgumentException();
    }

//    private loadLine(){}
}
