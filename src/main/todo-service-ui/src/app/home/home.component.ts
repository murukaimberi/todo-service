import {Component, inject, OnInit} from '@angular/core';
import {RouterModule, RouterOutlet} from "@angular/router";
import {NavBarComponent} from "../navigation/nav-bar/nav-bar.component";
import {FooterComponent} from "../navigation/footer/footer.component";
import {MaterialModule} from "../shared/material.module";
import {TodoService} from "../todo/service/todo.service";
import {ITodo} from "../todo/todo.model";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    RouterModule,
    NavBarComponent,
    FooterComponent,
    MaterialModule,
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {
  todos?: ITodo[] | null;
  title = 'Todo Service'
  protected todoService = inject(TodoService);
  ngOnInit() {
    this.todoService.getTodos()
      .subscribe(res => this.todos = res.body);
  }
}
