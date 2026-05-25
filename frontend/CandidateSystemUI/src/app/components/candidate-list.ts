import { Component, OnInit } from '@angular/core';
import { Candidate } from '../interface/candidate';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CandidateService } from '../services/candidate-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-candidate-list',
  templateUrl: './candidate-list.html',
  styleUrls: ['./candidate-list.css'],
  imports: [CommonModule, FormsModule]
})
export class CandidateList implements OnInit {

  constructor(private service: CandidateService, private router:Router) {}

  searchText: string = '';

  candidates: Candidate[] = [];
  filteredCandidates: Candidate[] = [];

  ngOnInit(): void {
    this.loadCandidates();
  }

  loadCandidates(): void {
    this.service.getCandidateList().subscribe(data => {
      this.candidates = data;
     this.filteredCandidates = data;
    });
  }

  onSearch(): void {
    const search = this.searchText.trim().toLowerCase();

    if (!search) {
      this.filteredCandidates = [...this.candidates];
      return;
    }

    this.filteredCandidates = this.candidates.filter(c =>
      c.name.toLowerCase().includes(search) ||
      c.email.toLowerCase().includes(search) ||
      c.cell.toString().includes(search) ||
      c.primarySkills.toLowerCase().includes(search)
    );
  }

  editCandidate(candidate: Candidate): void {
    console.log('Edit:', candidate);
    
  }

  deleteCandidate(id: number): void {

    const confirmDelete = confirm('Are you sure you want to delete this candidate?');

    if (confirmDelete) {
      this.service.deleteCandidate(id).subscribe(() => {
        this.loadCandidates(); 
      });
    }
  }

openAddCandidate(): void {

  this.router.navigate(['/candidates/add']);

}

openImportCSV(): void {

  console.log('Import CSV clicked');

}

onFileSelected(event: any): void {

  const file = event.target.files[0];

  if (!file) {
    return;
  }

  this.service.importCSV(file).subscribe({

    next: (response) => {

      console.log('CSV Upload Success', response);

      alert(
        `Imported Successfully: ${response.successCount}
Failed Rows: ${response.failedCount}`
      );

      this.loadCandidates();
    },

    error: (err) => {

      console.error('CSV Upload Failed', err);

      alert('CSV upload failed');
    }

  });
}



}