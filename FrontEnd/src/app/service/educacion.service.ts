import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Educacion } from '../model/educacion';

@Injectable({
  providedIn: 'root'
})
export class EducacionService {
  URL = 'https://portfoliobackend-7dlj.onrender.com/educ';

  constructor(private http: HttpClient) { }

  public list(): Observable<Educacion[]> {
    return this.http.get<Educacion[]>(this.URL+'/lista');
  }

  public detail(id: number): Observable<Educacion> {
    return this.http.get<Educacion>(this.URL+`/detail/${id}`);
  }

  public save(educacion: Educacion): Observable<Educacion> {
    return this.http.post<any>(this.URL+'/create', educacion);
  }

  public update(id: number, educacion: Educacion): Observable<any> {
    return this.http.put<any>(this.URL + `/update/${id}`, educacion);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete<any>(this.URL + `/delete/${id}`);
  }
}
