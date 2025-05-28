package test.testModel;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.Ocorrencia;

public class TesteModelOcorrencia {
    List<String> anexos = new ArrayList<>();
    private final Ocorrencia ocorrencia = new Ocorrencia( "id","idMorador", LocalDate.parse("2025-05-28"), "descricao", "status", anexos);

    @Test
    public void testeGetId(){
        assertEquals("id", ocorrencia.getId());
    }

    @Test
    public void testeGetIdMorador(){
        assertEquals("idMorador", ocorrencia.getIdMorador());
    }

    @Test
    public void testeGetDataregistro(){
        LocalDate ld = LocalDate.parse("2025-05-28");
        assertEquals(ld , ocorrencia.getDataRegistro());
    }

    @Test
    public void testeGetDescricao(){
        assertEquals("descricao", ocorrencia.getDescricao());
    }

    @Test
    public void testeGetStatus(){
        assertEquals("status", ocorrencia.getStatus());
    }

    @Test
    public void testeSetIdMorador(){
        ocorrencia.setIdMorador("teste1");
        assertEquals("teste1", ocorrencia.getIdMorador());
    }

    @Test
    public void testeSetIdMorado(){
        LocalDate ld = LocalDate.parse("2025-05-23");
        ocorrencia.setDataRegistro(ld);
        assertEquals(ld , ocorrencia.getDataRegistro());
    }

    @Test
    public void testeSetDescricao(){
        ocorrencia.setDescricao("teste2");
        assertEquals("teste2", ocorrencia.getDescricao());
    }

    @Test
    public void testeSetStatus(){
        ocorrencia.setStatus("teste2");
        assertEquals("teste2", ocorrencia.getStatus());
    }

    @Test
    public void testeSetAnexos(){
        List<String> teste3 = new ArrayList<>();
        ocorrencia.setAnexos(teste3);
        assertEquals(teste3, ocorrencia.getAnexos());
    }
}
