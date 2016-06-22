package io.pivotal.ticket.service;

import org.springframework.beans.factory.annotation.Autowired;

import io.pivotal.ticket.dao.TicketStatusDAO;
import io.pivotal.ticket.model.TicketStatus;

public class TicketStatusDaoImpl implements TicketStatusInterface{

	private TicketStatusDAO ticketStatusDAO;
	
	@Autowired
	public void setTicketStatusDAO(TicketStatusDAO ticketStatusDAO)
	{
		this.ticketStatusDAO = ticketStatusDAO;
	}
	
	public TicketStatus save(TicketStatus ticketStatus) {
		  return ticketStatusDAO.save(ticketStatus);
	}
	
	public TicketStatus getById(String id) {
		return ticketStatusDAO.findOne(id);
	}
	
	public void deleteById(TicketStatus ticketStatus) {
		ticketStatusDAO.delete(ticketStatus);
	}
	
	public TicketStatus findByStatus(String status) {
		return ticketStatusDAO.findByStatus(status);
	}
	
	/*public TicketStatus findByEngineer(String engineer) {
		return ticketStatusDAO.findByEngineer(engineer);
	}
	
	public TicketStatus findByMessageSent(String messageSent) {
		return ticketStatusDAO.findByMessageSent(messageSent);
	}*/
	
}