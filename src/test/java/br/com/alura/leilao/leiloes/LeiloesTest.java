package br.com.alura.leilao.leiloes;

import br.com.alura.leilao.login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeiloesTest {
    
    private LeiloesPage paginaDeLeiloes;
    private CadastroLeilaoPage paginaDeCadastro;
    
    @BeforeEach
    public void inicializar() {
        final LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
        this.paginaDeLeiloes = paginaDeLogin.efetuaLogin();
        this.paginaDeCadastro = paginaDeLeiloes.carregarFormulario();
    }
    
    @AfterEach
    public void finalizar() {
        this.paginaDeLeiloes.fechar();
    }
    
    @Test
    public void deveriaCadastrarLeilao() {
        final String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilao do dia " + hoje;
        String valor = "500.00";
        
        this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome, valor, hoje);
        
        Assertions.assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, hoje));
    }
    
    @Test
    public void deveriaValidarCadastroDeLeilao() {
        this.paginaDeCadastro.cadastrarLeilaoSemNada();
        
        Assertions.assertTrue(this.paginaDeLeiloes.isPaginaAtual());
        
        Assertions.assertFalse(this.paginaDeCadastro.isPaginaAtual());
        Assertions.assertTrue(this.paginaDeCadastro.isMensagensDeValidacoesVisiveis());
    }
    
}