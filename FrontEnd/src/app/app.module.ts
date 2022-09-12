import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { HeaderComponent } from './components/header/header.component';
import { ExperienciaComponent } from './components/experiencia-estudios/experiencia-estudios.component';
import { HardYSoftComponent } from './components/hard-ysoft/hard-ysoft.component';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { ProyectosComponent } from './components/proyectos/proyectos.component';
import { FooterComponent } from './components/footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NewExperienciaComponent } from './components/experiencia-estudios/new-experiencia.component';
import { EditExperienciaComponent } from './components/experiencia-estudios/edit-experiencia.component';
import { EditHeaderComponent } from './components/header/edit-header.component';
import { NewEducacionComponent } from './components/experiencia-estudios/new-educacion.component';
import { EditEducacionComponent } from './components/experiencia-estudios/edit-educacion.component';
import { NewProyectosComponent } from './components/proyectos/new-proyectos.component';
import { EditProyectosComponent } from './components/proyectos/edit-proyectos.component';
import { NewSkillComponent } from './components/hard-ysoft/new-skill.component';
import { EditSkillComponent } from './components/hard-ysoft/edit-skill.component';


@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    HeaderComponent,
    ExperienciaComponent,
    HardYSoftComponent,
    ProyectosComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    NewExperienciaComponent,
    EditExperienciaComponent,
    EditHeaderComponent,
    NewEducacionComponent,
    EditEducacionComponent,
    NewProyectosComponent,
    EditProyectosComponent,
    NewSkillComponent,
    EditSkillComponent,
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    NgCircleProgressModule.forRoot({
      radius: 100,
      titleColor: '#0e1f1f',
      subtitleColor: '#0e1f1f',
      showUnits: false,
      showSubtitle: false,
      titleFontSize: '1.8em',
      subtitleFontSize: '1.6em',
      outerStrokeWidth: 10,
      innerStrokeWidth: 5,
      outerStrokeColor: '#59c4c4',
      innerStrokeColor: 'darkgrey',
      animation: true,
      animationDuration: 400     
    }),
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
