package test.testRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import model.Ocorrencia;
import repository.OcorrenciaRepository;;

public class TesteRepositoryOcorrencia {
    private final OcorrenciaRepository or = new OcorrenciaRepository();

    @Test
    public void listaUsuariosUsuariosCadastrados(){
        List<Ocorrencia> listaRetornada = or.listarOcorrencias();

        assertNotNull(listaRetornada);
        assertFalse(listaRetornada.isEmpty());

        Ocorrencia ocorrenciaRetornada = null;
        for(Ocorrencia ocorrencia : listaRetornada){if(ocorrencia.getId().equals("1c54d5c0-b366-4e7c-a089-1c1120f3a541")){ocorrenciaRetornada = ocorrencia;}};

        assertNotNull(ocorrenciaRetornada);
        assertEquals("2aaf8cde-1db9-40f5-bbfd-12c110842b64", ocorrenciaRetornada.getIdMorador());
        assertEquals("ocorrencia do acompanhamento", ocorrenciaRetornada.getDescricao());
    }
}
