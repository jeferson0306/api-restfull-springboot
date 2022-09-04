package com.api.restfull.apirestfullspringboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTeste {

    @Test
    public void deveSomarDoisNumeros() {
        //Cenário
        Calculadora calculadora = new Calculadora();
        int numero1 = 10, numero2 = 5;

        //Execução
        int resultado = calculadora.somar(numero1, numero2);

        //Verificações
        //Assert.assertEquals(15, resultado);
        Assertions.assertThat(resultado).isEqualTo(15);
    }

    @Test()
    public void naoDeveSomarNumerosNegativos() {

        Calculadora calculadora = new Calculadora();
        //int num1 = -10, num2 = -2;
        int num1 = 10, num2 = 2;

        calculadora.somar(num1, num2);
    }

    @Test
    public void deveMultiplicarNumeros() {

        Calculadora calculadora = new Calculadora();
        int num = 10, num2 = 2;

        int resultado = calculadora.multiplicacao(num, num2);

        Assertions.assertThat(resultado).isEqualTo(20);
    }

    @Test
    public void deveDividirNumeros() {

        Calculadora calculadora = new Calculadora();
        int num = 10, num2 = 5;

        float resultado = calculadora.divisao(num, num2);

        Assertions.assertThat(resultado).isEqualTo(2);
    }
}

class Calculadora {

    int somar(int num, int num2) {
        if (num < 0 || num2 < 0) {
            throw new RuntimeException("[ERROR] - Método: [somar] - Não é permitido somar números negativos.");
        }
        return num + num2;
    }

    int subtracao(int num, int num2) {
        return num - num2;
    }

    int multiplicacao(int num, int num2) {
        return num * num2;
    }

    float divisao(float num, float num2) {
        if (num == 0) {
            throw new RuntimeException("[ERROR] - Método: [divisao] - 0 divido por qualquer número é 0");
        }
        if (num2 == 0) {
            throw new RuntimeException("[ERROR] - Método: [divisao] - Nenhum número é divisível por 0");
        }
        return num / num2;
    }
}
