package com.ramonvicente.upwords.v1.Controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ramonvicente.upwords.v1.Model.Notepad;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class NotepadControllerTests {

	@Autowired
  private MockMvc mockMvc;

  @Test
	void shouldReturnOkWhenPassAValidInfo() throws Exception {
		var notepad = new Notepad("Word Word Word word", "Word");

		mockMvc.perform( MockMvcRequestBuilders
			.post("/api/v1/notepad/findInfos")
			.contentType(MediaType.APPLICATION_JSON)
			.content(new ObjectMapper().writeValueAsString(notepad)))
			.andExpectAll(status().isOk());
	}
}
