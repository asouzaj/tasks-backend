package br.ce.wcaquino.taskbackend.controller;

import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;

public class TaskControllerTest {
	//chama o mock do mockito e cria um mock da classe TaskRepo
	@Mock
	private TaskRepo taskrepo;
	
	//injeta o mock no TaskController 
	@InjectMocks
	private TaskController controller;
	
	//chama o mockado antes de usar no metodo
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	
	@Test
	public void naoDeveSalvarTarefaSemDescricao()  {
		Task todo = new Task();
		todo.setDueDate(LocalDate.now());
		
		// sem o mock desbloqueia TaskController controller = new TaskController();
		
		try {
			controller.save(todo);
			Assert.fail("Nao deveria chrgar neste ponto!!!");
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("Fill the task description", e.getMessage());
			
		}
		
		
	}
	
	@Test
	public void naoDeveSalvarTarefaSemData() {
		Task todo = new Task();
		todo.setTask("Tarefa teste!!");
		
		// sem o mock desbloqueia TaskController controller = new TaskController();
		
		try {
			controller.save(todo);
			Assert.fail("Nao deveria chrgar neste ponto!!!");
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("Fill the due date", e.getMessage());
			
		}
		
		
	}
	
	@Test
	public void naoDeveSalvarTarefaComDataPassada() {
		Task todo = new Task();
		todo.setTask("Tarefa teste!!");
		todo.setDueDate(LocalDate.of(2000,01,01));
		
		// sem o mock desbloqueia TaskController controller = new TaskController();
		
		try {
			controller.save(todo);
			Assert.fail("Nao deveria chrgar neste ponto!!!");
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("Due date must not be in past", e.getMessage());
			
		}
	}
	
	@Test
	public void DeveSalvarTarefaComSucesso() throws ValidationException {
		Task todo = new Task();
		todo.setDueDate(LocalDate.now());
		todo.setTask("tarefa de teste!!!");
		
		// sem o mock desbloqueia TaskController controller = new TaskController();
		
		
			controller.save(todo);
		
			
			
			
		
	}
}
