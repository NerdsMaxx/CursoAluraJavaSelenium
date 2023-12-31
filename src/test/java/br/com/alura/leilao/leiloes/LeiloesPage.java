package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.pageobject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeiloesPage extends PageObject {
    public static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
    public static final String URL_LEILOES = "http://localhost:8080/leiloes";
    
    public LeiloesPage(WebDriver browser) {
        super(browser);
    }
    
    public CadastroLeilaoPage carregarFormulario() {
        this.browser.navigate().to(URL_CADASTRO_LEILAO);
        return new CadastroLeilaoPage(browser);
    }
    
    public boolean isLeilaoCadastrado(String nome, String valorInicial, String dataAbertura) {
        final WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
        
        final WebElement coluneNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        final WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        final WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
        
        return coluneNome.getText().equals(nome) &&
               colunaDataAbertura.getText().equals(dataAbertura) &&
               colunaValorInicial.getText().equals(valorInicial);
    }
    
    public boolean isPaginaAtual() {
        return this.browser.getCurrentUrl().equals(URL_LEILOES);
    }
}