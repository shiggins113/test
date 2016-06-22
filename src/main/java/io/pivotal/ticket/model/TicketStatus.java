package io.pivotal.ticket.model;

import org.springframework.data.cassandra.mapping.Column;

//POJO for Zendesk Ticket Status

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;


@Table(value = "ticketstatus")
public class TicketStatus {
  
	 	@PrimaryKey("ticketid")
	    private String ticketId; //id of the ticket
	 	
	 	@Column("timeelapsed")
	    private int timeElapsed; //Time since ticket opened
	 	@Column("status")
	    private String status; // new, open, pending, on-hold
	 	@Column("engineer")
	    private String engineer; //Engineer assigned
	 	@Column("messagesent")
	    private String messageSent; //Last message sent (Slack, Email)


		public String getTicketId() {
			return ticketId;
		}


		public void setTicketId(String ticketId) {
			this.ticketId = ticketId;
		}


		public int getTimeElapsed() {
			return timeElapsed;
		}
		public void setTimeElapsed(int timeElapsed) {
			this.timeElapsed = timeElapsed;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}

		public String getEngineer() {
			return engineer;
		}

		public void setEngineer(String engineer) {
			this.engineer = engineer;
		}

		public String getMessageSent() {
			return messageSent;
		}
		public void setMessageSent(String messageSent) {
			this.messageSent = messageSent;
		}
	  
	    
		
	    
}
