package sistemadetestes.test;

import org.junit.*;
import org.junit.runners.MethodSorters;
import sistemadetestes.pageObject.ProdutoPO;

import static org.junit.Assert.assertEquals;

/**
 * Classe que cria os testes
 * Herdando da BaseTest
 * */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTest{
    private static ProdutoPO produtoPO;

    /**
     * Método para preparar os testes
     * @Driver driver
     * */

    @BeforeClass
    public static void prepararTestes() {
        produtoPO = new ProdutoPO(driver);
        produtoPO.btnCriar.click();
        produtoPO.btnCriar.click();
    }

//    @Before
//    public void logarEClicarCriar(){
//        produtoPO.btnCriar.click();
//        produtoPO.btnCriar.click();
//    }

    /**
     * Limpar os campos após realizar um teste
     * */

    @After
    public void limpar(){
        produtoPO.inputCodigo.clear();
        produtoPO.inputNome.clear();
        produtoPO.inputQtde.clear();
        produtoPO.inputValor.clear();
        produtoPO.inputData.clear();
    }


    /**
     * Teste que verificar se haverá a mensagem de erro caso tenha algum campo vázio
     * */

    @Test
    public void teste06_mensagemErro(){
        produtoPO.inputCodigo.sendKeys("1330");
        produtoPO.inputNome.sendKeys("");
        produtoPO.inputQtde.sendKeys("25");
        produtoPO.inputValor.sendKeys("1500");
        produtoPO.inputData.sendKeys("22/12/2024");

        produtoPO.btnSalvarProduto.click();

        String mensagem = produtoPO.obterMensagem();
        assertEquals(mensagem,"Todos os campos são obrigatórios para o cadastro!");

    }

    /**
     * Teste que verificar se será possível cadastrar dois códigos iguais
     * */

    @Test
    public void teste07_negarCodigosIguais(){
        produtoPO.inputCodigo.sendKeys("123");
        produtoPO.inputNome.sendKeys("Samsung");
        produtoPO.inputQtde.sendKeys("25");
        produtoPO.inputValor.sendKeys("1500");
        produtoPO.inputData.sendKeys("22/12/2024");

        produtoPO.inputCodigo.clear();
        produtoPO.inputNome.clear();
        produtoPO.inputQtde.clear();
        produtoPO.inputValor.clear();
        produtoPO.inputData.clear();

        produtoPO.inputCodigo.sendKeys("123");
        produtoPO.inputNome.sendKeys("Samsung");
        produtoPO.inputQtde.sendKeys("25");
        produtoPO.inputValor.sendKeys("1500");
        produtoPO.inputData.sendKeys("22/12/2024");


        produtoPO.btnSalvarProduto.click();
        String mensagem = produtoPO.obterMensagem();
        assertEquals(mensagem,"Código já existe!");

    }

    /**
     * Teste que verificar se será possível cadastrar letras nos campos de número e números em campo de texto
     * */

    @Test
    public void teste08_naoAceitarLetraENumerosNosCamposInverso(){
        produtoPO.inputCodigo.sendKeys("dell");
        produtoPO.inputNome.sendKeys("1330");
        produtoPO.inputQtde.sendKeys("lenovo");
        produtoPO.inputValor.sendKeys("thalles");
        produtoPO.inputData.sendKeys("22/12/2024");

        produtoPO.btnSalvarProduto.click();

        String mensagem = produtoPO.obterMensagem();
        assertEquals(mensagem,"Campos inválidos!");
    }

}

