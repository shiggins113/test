package io.pivotal.ticket.dao;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import io.pivotal.ticket.model.TicketStatus;

public interface TicketStatusDAO extends CrudRepository<TicketStatus, String>{
	
    @Query("select * from ticketstatus where status = ?0")
	public TicketStatus findByStatus(String status);
	//public TicketStatus findByEngineer(String engineer);
	//public TicketStatus findByMessageSent(String messageSent);

		
}