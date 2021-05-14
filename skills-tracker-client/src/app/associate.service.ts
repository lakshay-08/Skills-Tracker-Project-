import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AssociateService {
  private baseUrl = 'http://localhost:9090/springboot-crud-rest/api/associates';

  constructor(private http: HttpClient) { }

  getAssociate(associateId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${associateId}`);
  }

  createAssociate(associate: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, associate);
  }

  createSkill(skill: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/skill`, skill);
  }

  updateAssociate(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteAssociate(associateId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${associateId}`, { responseType: 'text' });
  }

  getAssociatesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getSkills(): Observable<any> {
    return this.http.get(`${this.baseUrl}/skills`);
  }

}
