import { Injectable }      from '@angular/core';
import { tokenNotExpired } from 'angular2-jwt';
import { myConfig }        from './auth.config';

// Avoid name not found warnings
declare var Auth0Lock: any;

@Injectable()
export class Auth {
  // Configure Auth0
  lock = new Auth0Lock(  myConfig.clientID, myConfig.domain, {
        allowedConnections: ["Username-Password-Authentication","google-oauth2","facebook","twitter"],
        rememberLastLogin: true,
        socialButtonStyle: "big",
        languageDictionary: {"title":"G5 Carreiras"},
        language: "pt-br",
        theme: {"logo":"http://ap.imagensbrasil.org/images/2017/04/26/g5carreiras.png","primaryColor":"#3A99D8"}
      } );



  constructor() {
    // Add callback for lock `authenticated` event
    this.lock.on('authenticated', (authResult) => {
      localStorage.setItem('id_token', authResult.idToken);
    });
  }

  public login() {
    this.lock.show();
  };

  public authenticated() {
    // Check if there's an unexpired JWT
    // It searches for an item in localStorage with key == 'id_token'
    return tokenNotExpired();
  };

  public logout() {
    // Remove token from localStorage
    localStorage.removeItem('id_token');
  };
}
