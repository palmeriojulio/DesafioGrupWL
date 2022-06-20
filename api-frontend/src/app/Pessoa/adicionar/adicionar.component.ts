import { Pessoa } from 'src/app/Model/Pessoa';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-adicionar',
  templateUrl: './adicionar.component.html',
  styleUrls: ['./adicionar.component.css']
})
export class AdicionarComponent implements OnInit {

  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit(): void {
  }

  Salvar(pessoa: any) {
     this.service.createPessoa(pessoa)
     .subscribe(data=>{
       alert("Pessoa salva com sucesso!");
       this.router.navigate(["listar"]);
     })
  }

}
