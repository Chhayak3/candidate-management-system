import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Candidate } from '../interface/candidate';

@Injectable({
  providedIn: 'root',
})
export class CandidateService {
  
  private baseUrl ="http://localhost:8080/api/v1/candidates"
  constructor(private http:HttpClient){
   
  }

  getCandidateList():Observable<Candidate[]>{
    return this.http.get<Candidate[]>(`${this.baseUrl}`)
  }

  

}
