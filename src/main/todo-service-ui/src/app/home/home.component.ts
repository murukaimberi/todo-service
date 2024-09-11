import { Component } from '@angular/core';
import {RouterOutlet} from "@angular/router";
import {NavBarComponent} from "../navigation/nav-bar/nav-bar.component";
import {FooterComponent} from "../navigation/footer/footer.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    RouterOutlet,
    NavBarComponent,
    FooterComponent
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  title = 'Todo Service'
}
