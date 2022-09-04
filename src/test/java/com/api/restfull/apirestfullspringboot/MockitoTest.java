package com.api.restfull.apirestfullspringboot;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

//1- Para rodar o código quando o atributo for settado
//@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    //2- Para inicializar o atributo
    //@Mock
    List<String> lista;

    @Test
    public void primeiroTesteMockito() {

//        int size = 0;
//        if (1 == 1) {
//            size = lista.size()
//        }

        List<String> lista = Mockito.mock(ArrayList.class);

        Mockito.when(lista.size()).thenReturn(20);

        int size = lista.size();

//        Assertions.assertThat(size).isEqualTo(20);
//        Mockito.verify(lista).size();
    }
}
