import {Routes} from "@angular/router";
import {ListComponent} from "./list/list.component";
import {ASC} from "../config/navigation.constants";
import {DetailComponent} from "./detail/detail.component";
import {UpdateComponent} from "./update/update.component";
import TodoResolver from "./route-resolver/todo.resolver";

const todoRoute: Routes = [
  {
    path: '',
    component: ListComponent,
    data: {
      defaultSort: 'id,' + ASC,
    },
    // canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: DetailComponent,
    resolve: {
      country: TodoResolver,
    },
    // canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: UpdateComponent,
    resolve: {
      country: TodoResolver,
    },
    // canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: UpdateComponent,
    resolve: {
      country: TodoResolver,
    },
    // canActivate: [UserRouteAccessService],
  },
];

export default todoRoute;
