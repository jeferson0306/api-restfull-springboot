package com.api.restfull.apirestfullspringboot;

import java.util.ArrayList;
import java.util.List;

public class CadastroPessoas {

    private List<Pessoa> pessoas;

    public CadastroPessoas() {
        this.pessoas = new ArrayList<>();
    }
    public List<Pessoa> getPessoas() {
        return this.pessoas;
    }

    public void adicionar(Pessoa pessoa) throws PessoaSemNomeNotException {
        if (pessoa.getNome() == null) {
            throw new PessoaSemNomeNotException();
        }
        this.pessoas.add(pessoa);
    }

    public void remover(Pessoa pessoa) {
        if (this.pessoas.isEmpty()) {
            throw new CadastroVazioException();
        }
        this.pessoas.remove(pessoa);
    }
}
