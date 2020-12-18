package ar.edu.arqSoft.ticketService.baseService.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import ar.edu.arqSoft.ticketService.baseService.dto.TaskRequestDto;
import ar.edu.arqSoft.ticketService.baseService.dto.TaskResponseDto;
import ar.edu.arqSoft.ticketService.baseService.services.TaskService;
import ar.edu.arqSoft.ticketService.common.exception.BadRequestException;
import ar.edu.arqSoft.ticketService.common.exception.EntityNotFoundException;

@Controller
@RequestMapping("/task")
public class TaskController{
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code= HttpStatus.CREATED)
		public @ResponseBody TaskResponseDto register(@RequestBody TaskRequestDto request) {
					try {
							TaskResponseDto dto = (TaskResponseDto) taskService.insertTask(request);
							return dto;
					} catch (EntityNotFoundException e) {
							throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task Not Found", e);
					} catch (BadRequestException e) {
							throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request - ID = 0 o negativo", e);
					}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code= HttpStatus.CREATED)
	public @ResponseBody TaskResponseDto changeState(@RequestBody TaskRequestDto request, @PathVariable("id") Long id){
			try {
				TaskResponseDto dto =(TaskResponseDto) taskService.changeState(request,id);		
				return dto;
			} catch (EntityNotFoundException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task Not Found", e);
			} catch (BadRequestException e) { 
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request - ID = 0 o negativo", e);
			}
	}
	
	@RequestMapping(value="/addUser/{id]}", method=RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code= HttpStatus.CREATED)
	public @ResponseBody TaskResponseDto addUser(@RequestBody TaskRequestDto request, @PathVariable("id") Long id){
			try {
				TaskResponseDto dto =(TaskResponseDto) taskService.addUser(request);		
				return dto;
			} catch (EntityNotFoundException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task Not Found", e);
			} catch (BadRequestException e) { 
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request - ID = 0 o negativo", e);
			}
	}
	
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<TaskResponseDto> getAllTask() {
		return taskService.getAllTask();
	}
}