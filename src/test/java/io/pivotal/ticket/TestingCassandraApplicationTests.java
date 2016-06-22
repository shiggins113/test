package io.pivotal.ticket;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.pivotal.ticket.dao.TicketStatusDAO;
import io.pivotal.ticket.model.TicketStatus;

import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TicketStatusConfiguration.class)
public class TestingCassandraApplicationTests {

	
	@Autowired 
	TicketStatusDAO repository;
	
	TicketStatus ticketStatus,ticketStatus1;
	
	
	@Before
	public void setUp() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("TicketStatus.xml");
		ticketStatus = ctx.getBean("TicketStatus", TicketStatus.class);
		ticketStatus1 = ctx.getBean("TicketStatus1", TicketStatus.class);
	}

	
	@Test
	public void saveTicketStatus() {
		repository.save(ticketStatus);
		repository.save(ticketStatus1);		
	}
	
	@Test
	public void findAll(){
		List<TicketStatus> ticketStatusList = (List<TicketStatus>) repository.findAll();	
		assertEquals(ticketStatus.getTicketId(),ticketStatusList.get(1).getTicketId());
		assertEquals(ticketStatus.getStatus(),ticketStatusList.get(1).getStatus());
		assertEquals(ticketStatus.getMessageSent(),ticketStatusList.get(1).getMessageSent());
		assertEquals(ticketStatus.getEngineer(),ticketStatusList.get(1).getEngineer());
		assertEquals(ticketStatus.getTimeElapsed(),ticketStatusList.get(1).getTimeElapsed());

		assertEquals(ticketStatus1.getTicketId(),ticketStatusList.get(0).getTicketId());
		assertEquals(ticketStatus1.getStatus(),ticketStatusList.get(0).getStatus());
		assertEquals(ticketStatus1.getMessageSent(),ticketStatusList.get(0).getMessageSent());
		assertEquals(ticketStatus1.getEngineer(),ticketStatusList.get(0).getEngineer());
		assertEquals(ticketStatus1.getTimeElapsed(),ticketStatusList.get(0).getTimeElapsed());

	}
	
	
	@Test
	public void updateTicketStatus() {
		ticketStatus1.setEngineer("Paul");
		repository.save(ticketStatus1);		
	}
	
	@Test
	public void deleteTicketStatus() {
		repository.delete("1");
		repository.delete("2");
	}
	
	
	/*@Test
	public void findSavedTicketById() {
		TicketStatus ticketStatus3 = repository.findOne("4");
		assertEquals(ticketStatus3.getTicketId(), ticketStatus.getTicketId());
		assertEquals(ticketStatus3.getTimeElapsed(), ticketStatus.getTimeElapsed());
		assertEquals(ticketStatus3.getStatus(), ticketStatus.getStatus());
		assertEquals(ticketStatus3.getMessageSent(), ticketStatus.getMessageSent());
		assertEquals(ticketStatus3.getEngineer(), ticketStatus.getEngineer());	
	}
*/

}
