package com.navitas.rfad.controller;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import com.navitas.rfad.bean.TipsFraudReport;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.UUID;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TipsControllerTest {
  private MockMvc mockMvc;
  private HttpMessageConverter mappingJackson2HttpMessageConverter;
  private MediaType contentType =
      new MediaType(MediaType.APPLICATION_JSON.getType(), "hal+json", Charset.forName("utf8"));

  @Inject private WebApplicationContext webApplicationContext;

  @Inject
  void setConverters(HttpMessageConverter<?>[] converters) {

    this.mappingJackson2HttpMessageConverter =
        Arrays.asList(converters)
            .stream()
            .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
            .findAny()
            .orElse(null);

    assertNotNull(
        "the JSON message converter must not be null", this.mappingJackson2HttpMessageConverter);
  }

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void testUpdateReport() throws Exception {
    final TipsFraudReport report = new TipsFraudReport();
    final UUID id = UUID.randomUUID();
    report.setId(id);
    final String str = toJson(report);

    this.mockMvc
        .perform(put("/api/tips/" + id).contentType(contentType).content(str))
        .andExpect(status().is4xxClientError())
    //        .andExpect(content().contentType(contentType))
    //        .andExpect(jsonPath("$.id", is(id.toString())))
    ;
  }

  @SuppressWarnings("unchecked")
  private String toJson(final Object o) throws IOException {
    final MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
    this.mappingJackson2HttpMessageConverter.write(
        o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
    return mockHttpOutputMessage.getBodyAsString();
  }
}
