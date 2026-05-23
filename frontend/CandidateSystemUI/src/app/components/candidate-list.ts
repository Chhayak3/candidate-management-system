import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Candidate } from '../interface/candidate';
import { CommonModule } from '@angular/common';
import { CandidateService } from '../services/candidate-service';

@Component({
  selector: 'app-candidate-list',
  imports: [CommonModule],
  templateUrl: './candidate-list.html',
  styleUrl: './candidate-list.css',
})
export class CandidateList implements OnInit{
candidates:Candidate[]=[];

  constructor(private candidateService:CandidateService ,private cdRef:ChangeDetectorRef){

  }
  ngOnInit(): void {
    
   this.getCandidates();
  }

  private getCandidates(){
    this.candidateService.getCandidateList().subscribe(data => {
      console.log("API RESPONSE:", data);
      this.candidates=data;
      console.log(this.candidates);
      this.cdRef.detectChanges();
    })
  }
}
