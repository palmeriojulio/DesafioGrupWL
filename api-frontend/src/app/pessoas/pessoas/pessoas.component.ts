import { PessoasService } from './../services/pessoas.service';
import { Pessoa } from './../model/pessoa';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-pessoas',
  templateUrl: './pessoas.component.html',
  styleUrls: ['./pessoas.component.scss']
})
export class PessoasComponent implements OnInit {

  pessoas: Observable<Pessoa[]>;
  displayedColumns = ['nome','cpf','opcao'];

  //PessoasService: PessoasService;

  constructor(private PessoasService: PessoasService) {
    this.pessoas = this.PessoasService.list();
  }

  ngOnInit(): void {
  }

}
