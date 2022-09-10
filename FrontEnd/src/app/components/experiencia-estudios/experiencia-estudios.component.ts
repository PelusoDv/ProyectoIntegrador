import { Component, OnInit } from '@angular/core';
import { Educacion } from 'src/app/model/educacion';
import { Experiencia } from 'src/app/model/experiencia';
import { EducacionService } from 'src/app/service/educacion.service';
import { ExperienciaService } from 'src/app/service/experiencia.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-experiencia-estudios',
  templateUrl: './experiencia-estudios.component.html',
  styleUrls: ['./experiencia-estudios.component.css']
})
export class ExperienciaComponent implements OnInit {
  expe: Experiencia[] = [];
  edu: Educacion[] = [];

  constructor(private experienciaService: ExperienciaService,
    private educacionService: EducacionService,
    private tokenService: TokenService) { }
  isLogged = false;

  ngOnInit(): void {
    this.cargarExperiencia();
    this.cargarEducacion();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarExperiencia(): void {
    this.experienciaService.list().subscribe(data => { this.expe = data; })
  }

  cargarEducacion(): void {
    this.educacionService.list().subscribe(data => { this.edu = data; })
  }

  deleteExp(id?: number): void {
    if(id != undefined){
      this.experienciaService.delete(id).subscribe(
        data => {
          this.cargarExperiencia();
        }, err => {
          alert("No se pudo borrar");
        }
      )
    }
  }

  deleteEdu(id?: number): void {
    if(id != undefined){
      this.educacionService.delete(id).subscribe(
        data => {
          this.cargarEducacion();
        }, err => {
          alert("no se pudo borrar");
        }
      )
    }
  }
}