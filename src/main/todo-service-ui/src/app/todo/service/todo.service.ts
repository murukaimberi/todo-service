import { Injectable } from '@angular/core';
import {ITodo, NewTodo} from "../todo.model";
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";

export type EntityArrayResponseType = HttpResponse<ITodo[]>;
export type EntityResponseType = HttpResponse<ITodo>;

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  protected baseUrl = 'api/todos'
  constructor(protected http: HttpClient) { }

  getTodos(req?: any): Observable<EntityArrayResponseType> {
    return this.http.get<ITodo[]>(`${this.baseUrl}`, { params: req, observe: 'response' });
  }

  createTodo(todo: NewTodo): Observable<EntityResponseType> {
    return this.http.post<ITodo>(`${this.baseUrl}`, todo,  { observe: 'response' });
  }

  updateTodo(todo: ITodo): Observable<EntityResponseType> {
    return this.http.put<ITodo>(`${this.baseUrl}`, todo, { observe: 'response' });
  }

  findById(id: number): Observable<EntityResponseType> {
    return this.http
      .get<ITodo>(`${this.baseUrl}/${id}`, { observe: 'response' });
  }
}
