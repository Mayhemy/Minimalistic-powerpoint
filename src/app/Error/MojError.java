package app.Error;

public abstract class MojError {
    String ime;
    String text;

    public MojError(String ime, String text) {
        this.ime = ime;
        this.text = text;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
