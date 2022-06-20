import { Pessoa } from 'src/app/Model/Pessoa';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  pessoas: Pessoa[] = [];
  constructor(private service:ServiceService, private router:Router) { }

  ngOnInit(): void {
    this.service.getPessoas()
    .subscribe(data=>{
      this.pessoas=data;
    })
  }

}
