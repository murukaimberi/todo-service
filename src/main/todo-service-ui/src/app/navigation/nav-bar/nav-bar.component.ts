import { Component } from '@angular/core';
import {MaterialModule} from "../../shared/material.module";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-nav-bar',
  standalone: true,
  imports: [MaterialModule, CommonModule],
  templateUrl: './nav-bar.component.html',
  styleUrl: './nav-bar.component.css'
})
export class NavBarComponent {

}
