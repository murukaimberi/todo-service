import {ActivatedRouteSnapshot, ResolveFn, Router} from '@angular/router';
import {EMPTY, mergeMap, Observable, of} from "rxjs";
import {TodoService} from "../service/todo.service";
import {inject} from "@angular/core";
import {HttpResponse} from "@angular/common/http";
import {ITodo} from "../todo.model";

export const todoResolver = (route: ActivatedRouteSnapshot): Observable<null | ITodo> => {
  const id = route.params['id'];
  if (id) {
    return inject(TodoService)
      .findById(id)
      .pipe(
        mergeMap((todo: HttpResponse<ITodo>) => {
          if (todo.body) {
            return of(todo.body);
          } else {
            inject(Router).navigate(['404']);
            return EMPTY;
          }
        })
      )
  }
  return of(null);
};

export default todoResolver;
