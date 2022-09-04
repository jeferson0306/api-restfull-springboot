package com.api.restfull.apirestfullspringboot;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class CadastroPessoasTeste {

    @Test
    public void deveCriarCadastroDePessoas() {

        CadastroPessoas cadastro = new CadastroPessoas();

        Assertions.assertThat(cadastro.getPessoas()).isEmpty();
    }

    @Test(expected = PessoaSemNomeNotException.class)
    public void deveAdicionarUmaPessoa() {
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        cadastroPessoas.adicionar(pessoa);

        Assertions.assertThat(cadastroPessoas.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);
    }

    @Test(expected = PessoaSemNomeNotException.class)
    public void naoDeveAdicionarPessoaComNomeVazio() {
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        cadastroPessoas.adicionar(pessoa);
    }

    @Test
    public void deveRemoverUmaPessoa() {

        CadastroPessoas cadastroPessoas = new CadastroPessoas();

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Wilson");
        cadastroPessoas.adicionar(pessoa);
        cadastroPessoas.remover(pessoa);

        Assertions.assertThat(cadastroPessoas.getPessoas()
                .isEmpty());
    }

    @Test(expected = CadastroVazioException.class)
    public void deveLancarErroAoTentarRemoverPessoaInexistente() {

        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        cadastroPessoas.remover(pessoa);
    }
}
