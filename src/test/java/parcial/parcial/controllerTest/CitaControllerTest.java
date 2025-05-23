package parcial.parcial.controllerTest;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.test.web.servlet.MvcResult;
import parcial.parcial.controller.CitaController;
import parcial.parcial.model.Cita;
import parcial.parcial.service.ServiceCita;

@WebMvcTest(CitaController.class)
public class CitaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceCita serviceCita;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldGetCitaByIdNotFound() throws Exception {
        when(serviceCita.getCitaById("1")).thenReturn(Optional.empty());

        mockMvc.perform(get("/Cita/getCita/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldDeleteCitaById() throws Exception {
        doNothing().when(serviceCita).deleteCitaById("1");

        mockMvc.perform(delete("/Cita/deleteCita/1"))
                .andExpect(status().isNoContent());

        verify(serviceCita, times(1)).deleteCitaById("1");
    }

    @Test
    public void shouldDeleteAllCitas() throws Exception {
        doNothing().when(serviceCita).deleteCitas();

        mockMvc.perform(delete("/Cita/deleteAll"))
                .andExpect(status().isNoContent());

        verify(serviceCita, times(1)).deleteCitas();
    }
}
