package com.api.restfull.apirestfullspringboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CadastroPessoasTeste {

    @Test
    @DisplayName("Deve criar o cadastro de pessoas")
    public void deveCriarCadastroDePessoas() {

        CadastroPessoas cadastro = new CadastroPessoas();

        Assertions.assertThat(cadastro.getPessoas()).isEmpty();
    }

    @Test
    @DisplayName("Deve adicionar uma pessoa")
    public void deveAdicionarUmaPessoa() {
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Wilson");

        cadastroPessoas.adicionar(pessoa);

        Assertions.assertThat(cadastroPessoas.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);
    }

    @Test
    @DisplayName("Não deve adicionar pessoa com nome vazio")
    public void naoDeveAdicionarPessoaComNomeVazio() {
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        org.junit.jupiter.api.Assertions.assertThrows(PessoaSemNomeNotException.class, () ->
                cadastroPessoas.adicionar(pessoa));

    }

    @Test
    @DisplayName("Deve remover uma pessoa")
    public void deveRemoverUmaPessoa() {

        CadastroPessoas cadastroPessoas = new CadastroPessoas();

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Wilson");
        cadastroPessoas.adicionar(pessoa);
        cadastroPessoas.remover(pessoa);


        Assertions.assertThat(cadastroPessoas.getPessoas()
                .isEmpty());
    }

    @Test
    @DisplayName("Deve lançar erro ao tentar remover pessoa inexistente")
    public void deveLancarErroAoTentarRemoverPessoaInexistente() {

        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        org.junit.jupiter.api.Assertions.assertThrows(CadastroVazioException.class, () ->
                cadastroPessoas.remover(pessoa));

    }
}
