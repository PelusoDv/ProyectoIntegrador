import { Component, OnInit } from '@angular/core';
import { Skills } from 'src/app/model/skills';
import { SkillsService } from 'src/app/service/skills.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-hard-ysoft',
  templateUrl: './hard-ysoft.component.html',
  styleUrls: ['./hard-ysoft.component.css']
})
export class HardYSoftComponent implements OnInit {
  skill: Skills[] = [];

  constructor(private skillService: SkillsService, private tokenService: TokenService) { }
  isLogged = false;

  ngOnInit(): void {
    this.cargarSkills();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarSkills(): void {
    this.skillService.list().subscribe(data => { this.skill = data; })
  }

  deleteSkill(id?: number): void {
    if(id != undefined){
      this.skillService.delete(id).subscribe(
        data => {
          this.cargarSkills();
        }, err => {
          alert("No se pudo borrar");
        }
      )
    }
  }
}
