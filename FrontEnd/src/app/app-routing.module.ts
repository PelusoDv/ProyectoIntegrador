import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditEducacionComponent } from './components/experiencia-estudios/edit-educacion.component';
import { EditExperienciaComponent } from './components/experiencia-estudios/edit-experiencia.component';
import { NewEducacionComponent } from './components/experiencia-estudios/new-educacion.component';
import { NewExperienciaComponent } from './components/experiencia-estudios/new-experiencia.component';
import { EditHeaderComponent } from './components/header/edit-header.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { EditProyectosComponent } from './components/proyectos/edit-proyectos.component';
import { NewProyectosComponent } from './components/proyectos/new-proyectos.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'nuevaExp', component: NewExperienciaComponent},
  {path:'editExp/:id', component: EditExperienciaComponent},
  {path:'editPerfil/:id', component: EditHeaderComponent},
  {path:'nuevaEdu', component: NewEducacionComponent},
  {path:'editEdu/:id', component: EditEducacionComponent},
  {path:'nuevoProy', component: NewProyectosComponent},
  {path:'editProy/:id', component: EditProyectosComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
