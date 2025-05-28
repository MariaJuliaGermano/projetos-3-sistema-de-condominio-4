package test.testRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import java.util.List;
import model.AreaReservada;
import repository.AreaReservadaRepository;

public class TesteRepositoryAreaReservada {
    private final AreaReservadaRepository ars = new AreaReservadaRepository();

    @Test
    public void listaUsuariosUsuariosCadastrados(){
        List<AreaReservada> listaRetornada = ars.listarAreaReservadas();

        assertNotNull(listaRetornada);
        assertFalse(listaRetornada.isEmpty());

        AreaReservada reservaRetornada = null;
        for(AreaReservada reserva : listaRetornada){if(reserva.getId().equals("f89224d7-7ec2-41ff-8cef-60e5e3190c54")){reservaRetornada = reserva;}}

        assertNotNull(reservaRetornada);
        assertEquals("idCondominio", reservaRetornada.getIdCondominio());
        assertEquals("2aaf8cde-1db9-40f5-bbfd-12c110842b64", reservaRetornada.getIdMorador());
    }
}
