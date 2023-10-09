package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.pageobject.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.stream.Stream;

public class CadastroLeilaoPage extends PageObject {
    public static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
    
    public CadastroLeilaoPage(WebDriver browser) {
        super(browser);
    }
    
    public LeiloesPage cadastrarLeilao(String nome, String valorInicial, String dataAbertura) {
        this.browser.findElement(By.id("nome")).sendKeys(nome);
        this.browser.findElement(By.id("valorInicial")).sendKeys(valorInicial);
        this.browser.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
        
        this.browser.findElement(By.id("button-submit")).submit();
        
        return new LeiloesPage(browser);
    }
    
    public void cadastrarLeilaoSemNada() {
        cadastrarLeilao("", "", "");
    }
    
    public boolean isPaginaAtual() {
        return browser.getCurrentUrl().equals(URL_CADASTRO_LEILAO);
    }
    
    public boolean isMensagensDeValidacoesVisiveis() {
        final String pageSource = this.browser.getPageSource();
  
        return pageSource.contains("minimo 3 caracteres") &&
               pageSource.contains("não deve estar em branco") &&
               pageSource.contains("deve ser um valor maior de 0.1") &&
               pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
        
//        return Stream.of("minimo 3 caracteres",
//                         "não deve estar em branco",
//                         "deve ser um valor maior de 0.1",
//                         "deve ser uma data no formato dd/MM/yyyy")
//                     .allMatch(pageSource::contains);
    }
}