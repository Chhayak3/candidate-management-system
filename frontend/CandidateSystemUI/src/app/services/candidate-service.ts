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

  addCandidate(candidate:Candidate):Observable<Candidate>{
    return this.http.post<Candidate>(this.baseUrl,candidate);
  }
  
  updateCandidate(id:number,candidate:Candidate):Observable<Candidate>{
    return this.http.put<Candidate>(`${this.baseUrl}/${id}`,candidate);
  }

  deleteCandidate(id:number):Observable<void>
{
  return this.http.delete<void>(`${this.baseUrl}/${id}`);
}

importCSV(file:File):Observable<any>{
  const formData = new FormData();
  formData.append('file',file);

  return this.http.post(
    `${this.baseUrl}/import`, formData
    );
}
}
