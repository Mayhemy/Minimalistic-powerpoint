package app.Error;

public class ErrorWrongColorValue extends MojError{
    public ErrorWrongColorValue() {
        super("ErrorWrongColorValue", "pogresna vrednost za bar jedno od polja za vrednost boja(0,255) ili pogresna vrednost za dash(pozitivni brojeve) ili width(pozitivni brojevi)");
    }
}
