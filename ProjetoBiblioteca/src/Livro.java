import javafx.beans.property.SimpleStringProperty;

public class Livro {
    private final SimpleStringProperty livroIsbn;
    private final SimpleStringProperty livroNome;
    private final SimpleStringProperty livroAutor;
    private final SimpleStringProperty livroDetalhes;
    private final SimpleStringProperty livroImagem;

    Livro(String lIsbn, String lNome, String lAutor, String lDetalhes, String lImagem) {
        this.livroIsbn = new SimpleStringProperty(lIsbn);
        this.livroNome = new SimpleStringProperty(lNome);
        this.livroAutor = new SimpleStringProperty(lAutor);
        this.livroDetalhes = new SimpleStringProperty(lDetalhes);
        this.livroImagem = new SimpleStringProperty(lImagem);
    }

    public String getLivroIsbn() {
        return livroIsbn.get();
    }
    public void setLivroIsbn(String lIsbn) {
        livroIsbn.set(lIsbn);
    }

    public String getLivroNome() {
        return livroNome.get();
    }
    public void setLivroNome(String lNome) {
        livroNome.set(lNome);
    }

    public String getLivroAutor() {
        return livroAutor.get();
    }
    public void setLivroAutor(String lAutor) {
        livroAutor.set(lAutor);
    }

    public String getLivroDetalhes() {
        return livroDetalhes.get();
    }
    public void setLivroDetalhes(String lDetalhes) {
        livroDetalhes.set(lDetalhes);
    }

    public String getLivroImagem() {
        return livroImagem.get();
    }
    public void setLivroImagem(String lImagem) {
        livroImagem.set(lImagem);
    }
}
