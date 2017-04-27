import { Component }  from '@angular/core';
import { Auth }       from './auth.service';

@Component({
  selector: 'home',
  templateUrl: 'app/app.home.html'
})

export class HomeComponent {
  constructor(private auth: Auth) {}
};
