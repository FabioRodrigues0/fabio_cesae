import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {MeuComponenteComponent} from './components/meu-componente/meu-componente.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MeuComponenteComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'nome-da-minha-app';
}
