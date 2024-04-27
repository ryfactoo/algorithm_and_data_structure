package Igor.Banaszak.Loader;

public class MalformedGraphDescriptionException extends Exception {

    public MalformedGraphDescriptionException(int line,String errorMessage,String expect) {
        super("line error " + line + "\t" +"given : "+ errorMessage + "\t" + " expect : " + expect);
    }
}
