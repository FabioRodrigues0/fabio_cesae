import { Component } from '@angular/core';

@Component({
  selector: 'app-meu-componente',
  standalone: true,
  imports: [],
  templateUrl: './meu-componente.component.html',
  styleUrl: './meu-componente.component.scss'
})
export class MeuComponenteComponent {
	meuNome: string = 'Fábio'
	messagem: string = 'Eu gosto de Animais';
	idade: number = 30;
}
