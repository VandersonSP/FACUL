# Autenticação com Tokens G5 Carreiras
   
Tokens são uma forma de se identificar com a aplicação, nada mais que isso.
Num mundo virtual cada token representa uma sessão/identificação.
Um token pode conter N informações como nível de acesso,
 data de expiração e outras coisas não muito recomendadas como ID do usuário normalmente encriptado com 128 bits (128-bit AES).

Quando falamos de tokens, temos que ter uma maneira simples de criar um padrão de tokens inteligentes, e toda essa magia por traz disso é composta por algumas especificações do Json Object Signing and Encryption (JOSE) que é um conjunto de definições dos padrões para a criação de tokens inteligentes (RFC 7519).

JOSE divide a ordem lógica de criação e composição de tokens em 5 padrões: JWT, JWA, JWS, JWK e JWE.

## JWT

Json Web Token (`JWT`) é um padrão (RFC 7165) que define como transmitir de forma 
segura objetos JSON compactos entre aplicações. Neste artigo vamos nos focar nele.

No caso nós vamos utilizar otipo JWT SSO,que é composto por 3 elementos:

1.Headers

`Headers são objetos JSON que normalmente definem duas partes: O tipo do token (typ) que é JWT, e o algorítimo (alg) de encriptação que será utilizado, como HMAC SHA256 ou RSA;`
Exemplo:
```bash
{
  "alg": "HS256",
  "typ": "JWT"
}
```

2.Payload (Claims)

`Payloads são objetos JSON que contem os chamados claims, que pode definição são os atributos sobre a entidade tratada (normalmente o usuário). Existem 3 tipos de claims em payloads:`
 
Exemplo:
```bash
{
  "iss": "https://api.g5carreiras.com",
  "exp": 1300819380,
  "user": "rafaell-lycan",
  "admin": true
}
```

3.Signature

`Onde a magia acontece, é a terceira e ultima parte do nosso JWT feita a partir do hash (Base64Url) do header e do payload e uma chave definida em nossa aplicação e assinar isso.`
Exemplo utilizando o algoritimo HMAC SHA256:
```bash
var encodedString = base64UrlEncode(header) + "." + base64UrlEncode(payload);

HMACSHA256(encodedString, 'secret');

//Isso ira gerar um token com essa estrutura:

eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJodHRwczovL2FwaS5naXRodWIuY29tIiwiZXhwIjoxMzAwODE5MzgwLCJ1c2VyIjoicmFmYWVsbC1seWNhbiIsImFkbWluIjp0cnVlLCJpYXQiOjE0NjQxOTQzNTh9.CcXOdvwL1baDNzhEjds9u59oHVrqG97hj9oVdZMzpaI
```
 
Atualmente o [Auth0](auth0.com) é o melhor lugar para gerenciar e utilizar um serviço de autenticação usando tokens.
 
##  Documentação Tecnica para implementação
 
O diagrama a baixo mostra o processo:
 
  [diagrama](https://cdn.auth0.com/content/jwt/jwt-diagram.png) 
  
Este Documento mostra como adicionar ***Login/SignUp***  à sua aplicação usando o  `Lock` widget.

Você pode ler um quickstart oficial no [site](https://auth0.com/docs/quickstart/spa/angular2/01-login) tambem. 

basicamente implementar o codigo na aplicação e criar os metodos .
 

```typescript
/* ===== app/auth.service.ts ===== */
@Injectable()
export class Auth {
  // Configure Auth0
  lock = new Auth0Lock('YOUR_CLIENT_ID', 'YOUR_DOMAIN', {});

  constructor() {
    
    this.lock.on('authenticated', (authResult) => {
      localStorage.setItem('id_token', authResult.idToken);
    });
  }

  public login() {
  };
  
  public logout() {
  };
  
  public authenticated() {
  };
  ...
}
```

Auth0 é um requisito do sistema de autenticação para ajudar a:

* Adicionar autenticação com [várias fontes de autenticação](https://docs.auth0.com/identityproviders), seja social como **Google, Facebook, Microsoft Account, LinkedIn, GitHub, Twitter, Box, Salesforce, among others**,
 Ou sistemas de identidade corporativos como **Windows Azure AD, Google Apps, Active Directory, ADFS or any SAML Identity Provider**.
* Adicionar autenticação através de mais tradicionais **[username/password databases](https://docs.auth0.com/mysql-connection-tutorial)**.
* Adicionar suporte para  **[vinculando diferentes contas de usuário](https://docs.auth0.com/link-accounts)**.
* Suporte para gerar assinado [JSON Web Tokens](https://docs.auth0.com/jwt) para chamar suas APIs e **fluxo de identidade do usuário** com segurança.
* Analítica de como, quando e onde os usuários estão logon.
* Extrair dados de outras fontes e adicioná-lo ao perfil do usuário, por meio de [JavaScript rules](https://docs.auth0.com/rules).
 
