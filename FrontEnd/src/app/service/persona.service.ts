import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../model/persona.model';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  URL = 'http://localhost:8080/persona';

  constructor(private http: HttpClient) { }

  public getPersona(): Observable<persona> {
    return this.http.get<persona>(this.URL+'/show/perfil');
  }

  public edit(id: number, persona: persona): Observable<any> {
    return this.http.put<any>(this.URL + `/edit/${id}`, persona);
  }
}
