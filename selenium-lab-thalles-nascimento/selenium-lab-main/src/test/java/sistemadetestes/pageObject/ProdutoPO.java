package sistemadetestes.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO{

    @FindBy(id = "btn-adicionar")
    public WebElement btnCriar;

    @FindBy(className = "modal-content")
    public WebElement modal;

    @FindBy(css = "div.modal-header>button")
    public WebElement btnFecharModal;

    @FindBy(id = "btn-salvar")
    public WebElement btnSalvarProduto;

    @FindBy(id = "btn-sair")
    public WebElement btnSair;

    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "quantidade")
    public WebElement inputQtde;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    @FindBy(id = "mensagem")
    public WebElement mensagemErro;

    public String obterMensagem(){
        return this.mensagemErro.getText();
    }

    /**
     * Construtor base para a criação da fábrica de elementos (PageFactory)
     *
     * @param driver (Driver do navegador atual)
     */
    public ProdutoPO(WebDriver driver) {
        super(driver);
    }


}
