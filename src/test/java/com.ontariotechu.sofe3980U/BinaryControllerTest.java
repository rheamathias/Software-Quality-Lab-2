package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.beans.Transient;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getDefault() throws Exception {
        this.mvc.perform(get("/"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", ""))
                .andExpect(model().attribute("operand1Focused", false));
    }

    @Test
    public void getParameter() throws Exception {
        this.mvc.perform(get("/").param("operand1", "111"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "111"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postParameter() throws Exception {
        this.mvc.perform(post("/").param("operand1", "111").param("operator", "+").param("operand2", "111"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1110"))
                .andExpect(model().attribute("operand1", "111"));
    }

    // add test 1
    @Test
    public void checkParameter() throws Exception {
        this.mvc.perform(post("/").param("operand1", "000").param("operator", "+").param("operand2", "000"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "000"));

    }

    // add test 2
    @Test
    public void checkParameter2() throws Exception {
        this.mvc.perform(post("/").param("operand1", "001").param("operator", "+").param("operand2", "001"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "10"))
                .andExpect(model().attribute("operand1", "001"));

    }

    // add test 3
    @Test
    public void checkParameter3() throws Exception {
        this.mvc.perform(post("/").param("operand1", "010").param("operator", "+").param("operand2", "010"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "100"))
                .andExpect(model().attribute("operand1", "010"));

    }

    // mul test 1
    @Test
    public void checkmulParameter1() throws Exception {
        this.mvc.perform(post("/").param("operand1", "000").param("operator", "*").param("operand2", "000"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "000"));

    }

    // mul test 2
    @Test
    public void checkmulParameter2() throws Exception {
        this.mvc.perform(post("/").param("operand1", "101").param("operator", "*").param("operand2", "101"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "100"))
                .andExpect(model().attribute("operand1", "101"));

    }

    // mul test 3
    @Test
    public void checkmulParameter3() throws Exception {
        this.mvc.perform(post("/").param("operand1", "111").param("operator", "*").param("operand2", "111"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1001"))
                .andExpect(model().attribute("operand1", "111"));

    }

    // or test 1
    @Test
    public void checkorParameter1() throws Exception {
        this.mvc.perform(post("/").param("operand1", "000").param("operator", "|").param("operand2", "000"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "000"));

    }

    // or test 2
    @Test
    public void checkorParameter2() throws Exception {
        this.mvc.perform(post("/").param("operand1", "111").param("operator", "|").param("operand2", "111"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "111"))
                .andExpect(model().attribute("operand1", "111"));

    }

    // or test 3
    @Test
    public void checkorParameter3() throws Exception {
        this.mvc.perform(post("/").param("operand1", "111").param("operator", "|").param("operand2", "101"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "111"))
                .andExpect(model().attribute("operand1", "111"));

    }

    // and test 1
    @Test
    public void checkandParameter1() throws Exception {
        this.mvc.perform(post("/").param("operand1", "111").param("operator", "&").param("operand2", "111"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "111"))
                .andExpect(model().attribute("operand1", "111"));

    }

    // and test 2
    @Test
    public void checkandParameter2() throws Exception {
        this.mvc.perform(post("/").param("operand1", "000").param("operator", "&").param("operand2", "000"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "000"));

    }

    // and test 3
    @Test
    public void checkandParameter3() throws Exception {
        this.mvc.perform(post("/").param("operand1", "111").param("operator", "&").param("operand2", "101"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "101"))
                .andExpect(model().attribute("operand1", "111"));

    }

}