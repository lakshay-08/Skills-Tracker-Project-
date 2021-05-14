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
    return this.http.get(`${this.baseUrl}/associateId/${associateId}`);
  }

  createAssociate(associate: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/create`, associate);
  }

  createSkill(skill: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/skill`, skill);
  }

  updateAssociate(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/update/${id}`, value);
  }

  deleteAssociate(associateId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${associateId}`, { responseType: 'text' });
  }

  getAssociatesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/get`);
  }

  getSkills(): Observable<any> {
    return this.http.get(`${this.baseUrl}/skills`);
  }

  getAssociatesByName(associateName: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/associateName/${associateName}`);
  }

}
