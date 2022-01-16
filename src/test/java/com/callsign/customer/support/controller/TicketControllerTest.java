package com.callsign.customer.support.controller;

import com.callsign.customer.support.model.Delivery;
import com.callsign.customer.support.model.Ticket;
import com.callsign.customer.support.model.TicketPriority;
import com.callsign.customer.support.model.TicketStatus;
import com.callsign.customer.support.service.TicketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class TicketControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TicketService ticketService;

    @Test
    public void findAllTicketsOk() throws Exception {
        Ticket ticket = createTicket();
        when(ticketService.findAllTickets()).thenReturn(Arrays.asList(ticket));

        MvcResult result = mockMvc.perform(get("/api/tickets")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        String expected = "[{\"id\":1,\"priority\":\"HIGH\",\"status\":\"OPEN\",\"description\":\"description\"," +
                "\"resolution\":\"resolution\",\"delivery\":{\"deliveryId\":1,\"customerType\":null," +
                "\"deliveryStatus\":null,\"expectedDeliveryTime\":null,\"distanceFromDestination\":0," +
                "\"timeToReachDestination\":0,\"riderRating\":0,\"timeToPrepareFood\":0,\"monitored\":false}}]";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void findTicketDetailsOk() throws Exception {
        Ticket ticket = createTicket();
        when(ticketService.findTicket(anyLong())).thenReturn(ticket);

        MvcResult result = mockMvc.perform(get("/api/tickets/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        String expected = "{\"id\":1,\"priority\":\"HIGH\",\"status\":\"OPEN\",\"description\":\"description\"," +
                "\"resolution\":\"resolution\",\"delivery\":{\"deliveryId\":1,\"customerType\":null," +
                "\"deliveryStatus\":null,\"expectedDeliveryTime\":null,\"distanceFromDestination\":0," +
                "\"timeToReachDestination\":0,\"riderRating\":0,\"timeToPrepareFood\":0,\"monitored\":false}}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    private Ticket createTicket() {
        return Ticket.builder()
                .id(1L)
                .priority(TicketPriority.HIGH)
                .status(TicketStatus.OPEN)
                .description("description")
                .resolution("resolution")
                .delivery(createDelivery())
                .build();
    }

    private Delivery createDelivery() {
        return Delivery.builder().deliveryId(1).build();
    }

}