import { Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {errorRoute} from "./navigation/error/error.route";

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    title: 'home.title',
  },
  {
    path: 'todos',
    loadChildren: () => import(`./todo/todo.route`),
  },
  ...errorRoute,
];

export default routes;
