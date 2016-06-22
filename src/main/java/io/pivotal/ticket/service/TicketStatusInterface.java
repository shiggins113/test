package io.pivotal.ticket.service;

import io.pivotal.ticket.model.TicketStatus;

public interface TicketStatusInterface {
	
	public TicketStatus save(TicketStatus ticketStatus);
	
	public TicketStatus getById(String id);
	
	public void deleteById(TicketStatus ticketStatus);
	
	public TicketStatus findByStatus(String status);
	
//	public TicketStatus findByEngineer(String engineer);

//	public TicketStatus findByMessageSent(String messageSent);
	
}
