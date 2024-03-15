package com.ind.lms;


import com.ind.lms.entity.Student;
import com.ind.lms.restcontroller.StudentRestController;
import com.ind.lms.services.interfaces.IStudentApplicationService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentRestController.class)
public class StudentRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IStudentApplicationService studentApplicationService;


    @Test
    void testWhenGetStudentByIdApi_204() throws Exception {

        BDDMockito.given(studentApplicationService.getStudentById(2))
                .willReturn(null);


        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/student/2")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is("Student not found with Id - 2")));

    }

    @Test
    void testWhenGetStudentByIdApi_returns_Student() throws Exception {

        BDDMockito.given(studentApplicationService.getStudentById(2)).willReturn(new Student());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/student/2").accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

}
