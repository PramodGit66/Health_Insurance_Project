package com.crtl.ies.service;

import java.util.List;

import com.crtl.ies.dto.ClientDto;

public interface ClientService {
	
	/**
	 * 
	 * @param client: this is provide all information about client like name email address password extra
	 * @return : return type client info also this is return saved information in database.
	 * first came client info and this client info save in database and return this.
	 */
	ClientDto addClient(ClientDto client);
	
	/**
	 * 
	 * @param id: this para is client id in client we are first check this client id able in database or not 
	 * if client id not able in database then throw a particular exception. if able then fetch all about client
	 * about information
	 * @return: after fetch all info return the same info in this method.
	 */
	ClientDto findById(Integer id);
	
	
	/**
	 * 
	 * @param email: this para is client email in client we are first check this client email able in database or not 
	 * if client email not able in database then throw a particular exception. if able then fetch all about client
	 * about information
	 * @return: after fetch all info return the same info in this method.
	 */
	ClientDto findByEmail(String email);
	
	/**
	 * 
	 * @return: in this method return all Client information in a list.
	 */
	List<ClientDto>  findAllClient();
	
	
	/**
	 * @param clientID: this para is client id in client we are first check this client id able in database or not 
	 * if client id not able in database then throw a particular exception. if able then fetch all about client
	 * about information
	 * @param client: this is provide all information about client like name email address password extra
	 * 			after fetch about client info in database we are swap both client info and update in database
	 * @return : after updating data about client we are return client data
	 */
	ClientDto updateClientInfo(ClientDto client, Integer clientId);
	
	/**
	 * 
	 * @param idthis para is client id in client we are first check this client id able in database or not 
	 * if client id not able in database then throw a particular exception. if able then fetch all about client
	 * about information
	 * 
	 * after fetch all info delete data in database 
	 * 
	 * @return :String type return is one type msg send like data delete successfully.
	 */
	String deleteClient(Integer id);
	

}
