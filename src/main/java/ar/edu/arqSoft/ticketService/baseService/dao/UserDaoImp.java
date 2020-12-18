package ar.edu.arqSoft.ticketService.baseService.dao;


import org.springframework.stereotype.Repository;

import ar.edu.arqSoft.ticketService.baseService.model.User;
import ar.edu.arqSoft.ticketService.common.dao.*;

@Repository 
public class UserDaoImp extends GenericDaoImp<User, Long > implements UserDao{
	
}
