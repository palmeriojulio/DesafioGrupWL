import { Pessoa } from './../Model/Pessoa';
import { Injectable } from '@angular/core';
import { HttpClient  } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) {}

  Url='http://localhost:8080/pessoa';

  getPessoas(){
    return this.http.get<Pessoa[]>(this.Url)
  }

  createPessoa(pessoa: Pessoa){
    return this.http.post<Pessoa>(this.Url,pessoa);
  }
}
