package parcial.parcial.controllerTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import parcial.parcial.controller.EspecialidadController;
import parcial.parcial.model.Especialidad;
import parcial.parcial.service.ServiceEspecialidad;

public class EspecialidadControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private EspecialidadController EspecialidadController;

    @Mock
    private ServiceEspecialidad serviceEspecialidad;

    private Especialidad Especialidad1;
    private Especialidad Especialidad2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(EspecialidadController).build();
        Especialidad1 = new Especialidad("1", "e1");
        Especialidad2 = new Especialidad("2", "e2");
    }

    @Test
    void shouldCreateEspecialidad() throws Exception {
        when(serviceEspecialidad.createEspecialidad(any(Especialidad.class))).thenReturn(Especialidad1);

        mockMvc.perform(put("/Especialidad/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(Especialidad1)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.descripcion").value("e1"));

        verify(serviceEspecialidad, times(1)).createEspecialidad(any(Especialidad.class));
    }

    @Test
    void shouldGetAllEspecialidad() throws Exception {
        List<Especialidad> Especialidads = Arrays.asList(Especialidad1, Especialidad2);
        when(serviceEspecialidad.getAllEspecialidad()).thenReturn(Especialidads);

        mockMvc.perform(get("/Especialidad/getAll"))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.size()").value(2));

        verify(serviceEspecialidad, times(1)).getAllEspecialidad();
    }

    @Test
    void shouldGetEspecialidadByIdFound() throws Exception {
        when(serviceEspecialidad.getEspecialidadById("1")).thenReturn(Optional.of(Especialidad1));

        mockMvc.perform(get("/Especialidad/getEspecialidad/1"))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.descripcion").value("e1"));

        verify(serviceEspecialidad, times(1)).getEspecialidadById("1");
    }

    @Test
    void shouldGetEspecialidadByIdNotFound() throws Exception {
        when(serviceEspecialidad.getEspecialidadById("1")).thenReturn(Optional.empty());

        mockMvc.perform(get("/Especialidad/getEspecialidad/1"))
                .andExpect(status().isNotFound());

        verify(serviceEspecialidad, times(1)).getEspecialidadById("1");
    }

    @Test
    void shouldDeleteEspecialidadByIdSuccess() throws Exception {
        doNothing().when(serviceEspecialidad).deleteEspecialidadById("1");

        mockMvc.perform(delete("/Especialidad/deleteEspecialidad/1"))
                .andExpect(status().isAccepted());

        verify(serviceEspecialidad, times(1)).deleteEspecialidadById("1");
    }

    @Test
    void shouldDeleteEspecialidadByIdNotFound() throws Exception {
        doThrow(new RuntimeException("Especialidado no encontrado con ID: 1")).when(serviceEspecialidad).deleteEspecialidadById("1");

        mockMvc.perform(delete("/Especialidad/deleteEspecialidad/1"))
                .andExpect(status().isNotFound());

        verify(serviceEspecialidad, times(1)).deleteEspecialidadById("1");
    }

    @Test
    void shouldDeleteAllEspecialidads() throws Exception {
        doNothing().when(serviceEspecialidad).deleteEspecialidads();

        mockMvc.perform(delete("/Especialidad/deleteAll"))
                .andExpect(status().isAccepted());

        verify(serviceEspecialidad, times(1)).deleteEspecialidads();
    }
}
