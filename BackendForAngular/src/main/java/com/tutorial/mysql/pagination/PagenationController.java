package com.tutorial.mysql.pagination;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.mysql.todos.TodoRepository;
import com.tutorial.mysql.todos.Todos;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PagenationController {

	@Autowired
	private TodoRepository todoRepository;
	
	@GetMapping("/page/show")
	public Page<Todos> allTodos(@RequestParam(defaultValue = "0") int page,int size){
//		return todoRepository.findAll(new PageRequest(page, 4));
		return todoRepository.findAll(PageRequest.of(page, size));
	}
}
