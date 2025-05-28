package test.testModel;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;

import model.AreaReservada;

public class TesteModelAreaReservada {
    private final AreaReservada ar = new AreaReservada( "id","idCondominio", "idMorador", LocalDate.parse("2025-05-28"), LocalTime.parse("01:20"), "1");

    @Test
    public void testeGetId(){
        assertEquals("id", ar.getId());
    }

    @Test
    public void testeGetIdCondominio(){
        assertEquals("idCondominio", ar.getIdCondominio());
    }

    @Test
    public void testeGetDataReserva(){
        LocalDate ld = LocalDate.parse("2025-05-28");
        assertEquals(ld , ar.getDataReserva());
    }

    @Test
    public void testeGetHorarioReservado(){
        LocalTime lt = LocalTime.parse("01:20");
        assertEquals(lt, ar.getHorarioReservado());
    }

    @Test
    public void testeGetStatus(){
        assertEquals("1", ar.getStatus());
    }

    @Test
    public void testeSetIdCondominio(){
        ar.setIdCondominio("teste1");
        assertEquals("teste1", ar.getIdCondominio());
    }

    @Test
    public void testeSetIdMorador(){
        ar.setIdMorador("teste2");
        assertEquals("teste2", ar.getIdMorador());
    }

    @Test
    public void testeSetDataReserva(){
        LocalDate ld = LocalDate.parse("2025-12-31");
        ar.setDataReserva(ld);
        assertEquals(ld, ar.getDataReserva());
    }

    @Test
    public void testeSetHorarioReservado(){
        LocalTime lt = LocalTime.parse("23:59");
        ar.setHorarioReservado(lt);
        assertEquals(lt, ar.getHorarioReservado());
    }

    @Test
    public void testeSetStatus(){
        ar.setStatus("teste3");
        assertEquals("teste3", ar.getStatus());
    }

}
