package br.com.alura.leilao.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.Objects.requireNonNull;

public abstract class PageObject {
    
    protected WebDriver browser;
    
    public PageObject() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        this.browser = new ChromeDriver();
    }
    
    public PageObject(WebDriver browser) {
        this.browser = requireNonNull(browser);
    }
    
    public final void fechar() {
        this.browser.quit();
    }
}