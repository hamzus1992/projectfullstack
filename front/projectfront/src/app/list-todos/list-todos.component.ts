import { Component, OnInit } from '@angular/core';
import { TodoDataService } from '../service/data/todo-data.service';
import { HardcodedAuthenticationService } from '../service/hardcoded-authentication.service';
import { ActivatedRoute, Router } from '@angular/router';

export class Todo {
  constructor(
    public id : number,
    public username:string,
    public description : string,
    public targetDate : Date,
    public active :boolean
  ){

  }

}


@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {

  todos :Todo[]
  message = ''

  constructor(private todoDataService : TodoDataService,
    private router :Router
    ) { }
  refreshTodos() {
    this.todoDataService.findAll('hamzus1992').subscribe(
      response => this.handleSuccessfulResponse(response),
      error => this.handleErrorResponse(error)
    )
  }

  ngOnInit() {
    this.refreshTodos()
    }

  deleteTodo(id) {
    this.todoDataService.delete('hamzus1992',id).subscribe(
      response => {
        this.refreshTodos();
      }
    )
  }
  updateTodo(id) {
    this.router.navigate(['todos',id]);
  }
  addTodo() {
    this.router.navigate(['todos',-1]);
  }

  handleSuccessfulResponse(response){
    this.todos =response
  }
  handleErrorResponse(error){
    this.message = error.error.message
  }

}
