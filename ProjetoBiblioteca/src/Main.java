import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Main extends Application {
    //Tabela contendo: ISBN, Livro, Autor e Detalhes
    private TableView<Livro> table = new TableView<Livro>();
    private final ObservableList<Livro> data = FXCollections.observableArrayList(
        new Livro("978-8576082675", "Código limpo: Habilidades práticas do Agile Software", "Robert C. Martin",
                  "\n\t\t\t• Editora: Alta Books; 1ª edição (8 setembro 2009)" +
                  "\n\t\t\t• Idioma: Português" +
                  "\n\t\t\t• Capa comum: 425 páginas" +
                  "\n\t\t\t• ISBN-10: 8576082675" +
                  "\n\t\t\t• ISBN-13: 978-8576082675" +
                  "\n\t\t\t• Dimensões: 24 x 17 x 2.2 cm",
                  "https://m.media-amazon.com/images/P/B085Q2K632.01._SCLZZZZZZZ_SX500_.jpg"),

        new Livro("978-8550804606", "Arquitetura limpa: O guia do artesão para estrutura e design de software", "Robert C. Martin",
                  "\n\t\t\t• Editora: Alta Books; 1ª edição (23 abril 2019)" +
                  "\n\t\t\t• Idioma: Português" +
                  "\n\t\t\t• Capa comum: 432 páginas" +
                  "\n\t\t\t• ISBN-10: 8550804606" +
                  "\n\t\t\t• ISBN-13: 978-8550804606" +
                  "\n\t\t\t• Dimensões: 23.8 x 17.2 x 2.2 cm",
                  "https://m.media-amazon.com/images/P/B085PP6Y8P.01._SCLZZZZZZZ_SX500_.jpg"),

        new Livro("978-8575227244", "Refatoração: Aperfeiçoando o Design de Códigos Existentes", "Martin Fowler", 
                  "\n\t\t\t• Editora: Novatec Editora; 2ª edição (30 abril 2020)" +
                  "\n\t\t\t• Idioma: Português" +
                  "\n\t\t\t• Capa comum: 456 páginas" +
                  "\n\t\t\t• ISBN-10: 8575227246" +
                  "\n\t\t\t• ISBN-13: 978-8575227244" +
                  "\n\t\t\t• Dimensões: 23.4 x 17 x 2.6 cm",
                  "https://m.media-amazon.com/images/P/B087N8LKYB.01._SCLZZZZZZZ_SX500_.jpg"),

        new Livro("978-8576089520", "Implementando Domain-Driven Design", "Vaughn Vernon",
                  "\n\t\t\t• Editora: Alta Books; 1ª edição (28 março 2016)" +
                  "\n\t\t\t• Idioma: Português" +
                  "\n\t\t\t• Capa comum: 672 páginas" +
                  "\n\t\t\t• ISBN-10: 8576089521" +
                  "\n\t\t\t• ISBN-13: 978-8576089520" +
                  "\n\t\t\t• Dimensões: 24.2 x 17.6 x 3.4 cm",
                  "https://images-na.ssl-images-amazon.com/images/I/518mHAD6ZKL._SX323_.jpg"),

        new Livro("978-8575228241", "Kubernetes Básico: Mergulhe no Futuro da Infraestrutura", "Brendan Burns",
                  "\n\t\t\t• Editora: Novatec Editora; 1ª edição (28 janeiro 2020)" +
                  "\n\t\t\t• Idioma: Português" +
                  "\n\t\t\t• Capa comum: 288 páginas" +
                  "\n\t\t\t• ISBN-10: 8575228242" +
                  "\n\t\t\t• ISBN-13: 978-8575228241" +
                  "\n\t\t\t• Dimensões: 23.2 x 17.2 x 1.4 cm",
                  "https://m.media-amazon.com/images/P/B08455LHMY.01._SCLZZZZZZZ_SX500_.jpg")
    );

    //Todos os detalhes do livro
    private void addButtonDetalhes() {
        TableColumn<Livro, Void> detalheButton = new TableColumn("Detalhes");

        Callback<TableColumn<Livro, Void>, TableCell<Livro, Void>> cellFactory = new Callback<TableColumn<Livro, Void>, TableCell<Livro, Void>>() {
            @Override
            public TableCell<Livro, Void> call(final TableColumn<Livro, Void> param) {
                final TableCell<Livro, Void> cell = new TableCell<Livro, Void>() {

                    private final Button btnDetalhe = new Button("Detalhes");
                    {
                        btnDetalhe.setOnAction((ActionEvent event) -> {
                            Livro livro = getTableView().getItems().get(getIndex());
                            Alert alerta = new Alert(AlertType.INFORMATION);
                            alerta.setTitle("Detalhes do Livro -> " + livro.getLivroNome());
                            alerta.setHeaderText("Verificando todos os detalhes do livro: ''" + livro.getLivroNome() + "''\n" +
                                                 "\n[ISBN-13]:   \t"    + livro.getLivroIsbn()      +
                                                 "\n[LIVRO]:     \t"    + livro.getLivroNome()      +
                                                 "\n[AUTOR]:     \t"    + livro.getLivroAutor()     +
                                                 "\n[DETALHES]:  \t"    + livro.getLivroDetalhes()
                                                );

                            Image imageLivro = new Image(livro.getLivroImagem());
                            ImageView imageViewLivro = new ImageView(imageLivro);
                            alerta.setGraphic(imageViewLivro);
                            alerta.showAndWait();
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if(empty) {
                            setGraphic(null);
                        } else {
                            btnDetalhe.setText(btnDetalhe.getText());
                            setGraphic(btnDetalhe);
                        }
                    }
                };
                return cell;
            }
        };
        detalheButton.setCellFactory(cellFactory);
        table.getColumns().add(detalheButton);
    }

    @Override
    public void start(Stage primeiroStage) throws Exception {
        //Cena Principal
        Scene cena = new Scene(new Group());
        primeiroStage.setTitle("Sistema de Biblioteca v1.0 (Por: Lincoln Figueredo & Grieza Lacerda)");
        primeiroStage.setWidth(720);
        primeiroStage.setHeight(490);

        final Label label = new Label("Biblioteca de Livros");
        label.setFont(new Font("Arial", 22));

        table.setEditable(true);

        //Tabela-Coluna ISBN
        TableColumn colunaLivroIsbn = new TableColumn("ISBN");
        colunaLivroIsbn.setMinWidth(100);
        colunaLivroIsbn.setCellValueFactory(new PropertyValueFactory<Livro, Integer>("livroIsbn"));

        //Tabela-Coluna Livro
        TableColumn colunaLivroNome = new TableColumn("Livro");
        colunaLivroNome.setMinWidth(300);
        colunaLivroNome.setCellValueFactory(new PropertyValueFactory<Livro, String>("livroNome"));

        //Tabela-Coluna Autor
        TableColumn colunaLivroAutor = new TableColumn("Autor");
        colunaLivroAutor.setMinWidth(200);
        colunaLivroAutor.setCellValueFactory(new PropertyValueFactory<Livro, String>("livroAutor"));

        table.setItems(data);
        table.getColumns().addAll(colunaLivroIsbn, colunaLivroNome, colunaLivroAutor);
        addButtonDetalhes();

        final VBox caixaVBox = new VBox();
        caixaVBox.setSpacing(5);
        caixaVBox.setPadding(new Insets(10, 0, 0, 10));
        caixaVBox.getChildren().addAll(label, table);

        ((Group) cena.getRoot()).getChildren().addAll(caixaVBox);

        primeiroStage.setScene(cena);
        primeiroStage.show();

        //Botão Ajuda
        Button buttonAjuda = new Button("Ajuda");
        ((Group) cena.getRoot()).getChildren().add(buttonAjuda);
        buttonAjuda.setLayoutX(640);
        buttonAjuda.setLayoutY(10);
        buttonAjuda.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label labelAjuda = new Label("Como utilizar o Sistema de Biblioteca:\n\n" +
                                             "1. Verifique o livro desejado;\n" +
                                             "2. Clique no botão [Detalhes], para obter os dados completos do livro."
                );

                StackPane layoutAjuda = new StackPane();
                layoutAjuda.getChildren().add(labelAjuda);

                Scene sceneAjuda = new Scene(layoutAjuda, 400, 200);
                
                Image imgAjuda = new Image("https://www.macbarbosa.com.br/wp-content/uploads/2015/12/duvida.png");
                ImageView imgViewAjuda = new ImageView();
                imgViewAjuda.setTranslateX(150);
                imgViewAjuda.setTranslateY(-25);
                imgViewAjuda.setImage(imgAjuda);
                imgViewAjuda.setFitWidth(40);
                imgViewAjuda.setPreserveRatio(true);
                layoutAjuda.getChildren().add(imgViewAjuda);
                
                Stage stageAjuda = new Stage();
                stageAjuda.setTitle("Ajuda do Sistema de Biblioteca");
                stageAjuda.setScene(sceneAjuda);
                stageAjuda.setX(400);
                stageAjuda.setY(200);
                stageAjuda.show();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
