import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatTableModule } from '@angular/material/table';

import { PessoasRoutingModule } from './pessoas-routing.module';
import { PessoasComponent } from './pessoas/pessoas.component';



@NgModule({
  declarations: [
    PessoasComponent
  ],
  imports: [
    CommonModule,
    PessoasRoutingModule,
    MatTableModule
  ]
})
export class PessoasModule { }
