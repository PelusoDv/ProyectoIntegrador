import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExperienciaEstudiosComponent } from './experiencia-estudios.component';

describe('ExperienciaEstudiosComponent', () => {
  let component: ExperienciaEstudiosComponent;
  let fixture: ComponentFixture<ExperienciaEstudiosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExperienciaEstudiosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExperienciaEstudiosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
