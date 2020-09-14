import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TableScoredService {

  API_URL = 'http://localhost:8080/v1/calculator/scored';
  constructor(private http: HttpClient) { }

  calculateScored(data: Object){
    return this.http.post(this.API_URL,data);
  }
}
