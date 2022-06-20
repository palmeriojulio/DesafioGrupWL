import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Pessoa } from './../model/pessoa';
import { first, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PessoasService {

  private readonly API = '/pessoa';

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Pessoa[]>(this.API)
    .pipe(
      first(),
      tap(pessoas => console.log(pessoas))
    );
  }
}
