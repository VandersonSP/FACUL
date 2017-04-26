import { Component }  from '@angular/core';
import { Auth }       from './auth.service';

@Component({
  selector: 'home',
  template: `
    <h4 *ngIf="auth.authenticated()">Você está logado</h4>
    <h4 *ngIf="!auth.authenticated()">Você não está logado, tente novamente.</h4>
  `
})

export class HomeComponent {
  constructor(private auth: Auth) {}
};
