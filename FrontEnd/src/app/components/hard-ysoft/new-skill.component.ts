import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Skills } from 'src/app/model/skills';
import { SkillsService } from 'src/app/service/skills.service';

@Component({
  selector: 'app-new-skill',
  templateUrl: './new-skill.component.html',
  styleUrls: ['./new-skill.component.css']
})
export class NewSkillComponent implements OnInit {
  nombreS: string = "";
  percent: number = null;

  constructor(private skillService: SkillsService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const expe = new Skills(this.nombreS, this.percent);
    this.skillService.save(expe).subscribe(
      data => {
        alert("Habilidad añadida");
        this.router.navigate(['']);
      }, err => {
        alert("Fallo inesperado");
        this.router.navigate(['']);
      })
  }
}
