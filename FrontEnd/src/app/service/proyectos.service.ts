import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Proyectos } from '../model/proyectos';

@Injectable({
  providedIn: 'root'
})
export class ProyectosService {
  URL = 'https://portfoliobackend-7dlj.onrender.com/proy';

  constructor(private http: HttpClient) { }

  public list(): Observable<Proyectos[]> {
    return this.http.get<Proyectos[]>(this.URL+'/lista');
  }

  public detail(id: number): Observable<Proyectos> {
    return this.http.get<Proyectos>(this.URL+`/detail/${id}`);
  }

  public save(educacion: Proyectos): Observable<Proyectos> {
    return this.http.post<any>(this.URL+'/create', educacion);
  }

  public update(id: number, educacion: Proyectos): Observable<any> {
    return this.http.put<any>(this.URL + `/update/${id}`, educacion);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete<any>(this.URL + `/delete/${id}`);
  }
}
