import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Skills } from '../model/skills';

@Injectable({
  providedIn: 'root'
})
export class SkillsService {
  URL = 'http://localhost:8080/skill';

  constructor(private http: HttpClient) { }

  public list(): Observable<Skills[]> {
    return this.http.get<Skills[]>(this.URL+'/lista');
  }

  public detail(id: number): Observable<Skills> {
    return this.http.get<Skills>(this.URL+`/detail/${id}`);
  }

  public save(experiencia: Skills): Observable<any> {
    return this.http.post<any>(this.URL+'/create', experiencia);
  }

  public update(id: number, experiencia: Skills): Observable<any> {
    return this.http.put<any>(this.URL + `/update/${id}`, experiencia);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete<any>(this.URL + `/delete/${id}`);
  }
}
